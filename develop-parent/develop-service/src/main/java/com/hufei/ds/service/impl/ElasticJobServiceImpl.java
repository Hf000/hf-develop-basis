package com.hufei.ds.service.impl;

import cn.hutool.core.util.ReflectUtil;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.internal.config.LiteJobConfigurationGsonFactory;
import com.dangdang.ddframe.job.lite.internal.storage.JobNodePath;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hufei.cfg.custom.job.ElasticJobProperties;
import com.hufei.ds.beans.bo.ElasticJobBO;
import com.hufei.ds.constants.SsConstant;
import com.hufei.ds.enums.ExceptionStates;
import com.hufei.ds.exception.BusinessException;
import com.hufei.ds.service.ElasticJobService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.util.*;

/**
 * <p> 定时任务支持接口实现 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/10 9:16
 */
@Slf4j
@Service
public class ElasticJobServiceImpl implements ElasticJobService {

    private static final Map<String, ElasticJobBO> JOB_INFO = Maps.newConcurrentMap();

    private final ZookeeperRegistryCenter zookeeperRegistryCenter;

    /**
     * 获取zookeeper的注册中心连接
     * @param elasticJobProperties zk连接配置项
     */
    public ElasticJobServiceImpl(ElasticJobProperties elasticJobProperties) {
        // 初始化zookeeper配置
        ZookeeperConfiguration zookeeperConfiguration = new ZookeeperConfiguration(elasticJobProperties.getAddress(), elasticJobProperties.getNamespace());
        if (elasticJobProperties.isFlag()) {
            zookeeperConfiguration.setBaseSleepTimeMilliseconds(elasticJobProperties.getBaseSleepTimeMilliseconds());
            zookeeperConfiguration.setMaxSleepTimeMilliseconds(elasticJobProperties.getMaxSleepTimeMilliseconds());
            zookeeperConfiguration.setMaxRetries(elasticJobProperties.getMaxRetries());
        }
        // 初始注册中心,建立连接
        zookeeperRegistryCenter = new ZookeeperRegistryCenter(zookeeperConfiguration);
        zookeeperRegistryCenter.init();
    }

    /**
     * 初始化获取注册中心的所有定时任务
     */
    @PostConstruct
    public void init() {
        JOB_INFO.clear();
        // 获取根目录下的所有定时任务名称
        List<String> jobNames = zookeeperRegistryCenter.getChildrenKeys("/");
        jobNames.forEach(jobName -> {
            LiteJobConfiguration liteJobConfiguration = getLiteJobConfiguration(jobName);
            Optional.ofNullable(liteJobConfiguration).ifPresent(jobConfig -> {
                ElasticJobBO elasticJobBO = new ElasticJobBO();
                elasticJobBO.setJobName(jobName);
                elasticJobBO.setCron(liteJobConfiguration.getTypeConfig().getCoreConfig().getCron());
                JOB_INFO.put(jobName, elasticJobBO);
            });
        });
    }

    /**
     * 获取指定任务的具体信息
     * @param jobName 任务名称
     * @return 返回任务信息
     */
    private LiteJobConfiguration getLiteJobConfiguration(String jobName) {
        if (StringUtils.isBlank(jobName)) {
            return null;
        }
        JobNodePath jobNodePath = new JobNodePath(jobName);
        String liteJobConfigJson = zookeeperRegistryCenter.get(jobNodePath.getConfigNodePath());
        if (Objects.isNull(liteJobConfigJson)) {
            return null;
        }
        return LiteJobConfigurationGsonFactory.fromJson(liteJobConfigJson);
    }

    @Override
    public List<ElasticJobBO> findElasticJobList() {
        return Lists.newArrayList(JOB_INFO.values());
    }

    @Override
    public void executeTask(String jobName) {
        ElasticJobBO elasticJobBO = JOB_INFO.get(jobName);
        if (Objects.isNull(elasticJobBO)) {
            throw new BusinessException(ExceptionStates.EXECUTE_JOB_ERROR);
        }
        JobNodePath jobNodePath = new JobNodePath(jobName);
        for (String childrenKey : zookeeperRegistryCenter.getChildrenKeys(jobNodePath.getInstancesNodePath())) {
            zookeeperRegistryCenter.persist(jobNodePath.getInstanceNodePath(childrenKey), SsConstant.JOB_TRIGGER);
        }
    }

    @Override
    public void rescheduleJob(String jobName, String cron) {
        ElasticJobBO elasticJobBO = JOB_INFO.get(jobName);
        if (Objects.isNull(elasticJobBO)) {
            throw new BusinessException(ExceptionStates.EXECUTE_JOB_ERROR);
        }
        if (!checkCronExpression(cron)) {
            throw new BusinessException(ExceptionStates.JOB_CRON_ERROR);
        }
        LiteJobConfiguration liteJobConfiguration = getLiteJobConfiguration(jobName);
        Optional.ofNullable(liteJobConfiguration).ifPresent(jobConfig -> {
            ReflectUtil.setFieldValue(jobConfig.getTypeConfig().getCoreConfig(), SsConstant.CRON, cron);
            JobNodePath jobNodePath = new JobNodePath(jobName);
            zookeeperRegistryCenter.update(jobNodePath.getConfigNodePath(), LiteJobConfigurationGsonFactory.toJsonForObject(jobConfig));
            elasticJobBO.setCron(cron);
        });
    }

    /**
     * 校验cron表达式是否正确
     * @param param cron表达式
     * @return 返回
     */
    protected boolean checkCronExpression(String param) {
        if (StringUtils.isBlank(param)) {
            return false;
        }
        CronTriggerImpl cronTrigger = new CronTriggerImpl();
        try {
            cronTrigger.setCronExpression(param);
            Date date = cronTrigger.computeFirstFireTime(null);
            return date != null && date.after(new Date());
        } catch (ParseException e) {
            log.error("cron表达式格式错误", e);
        }
        return false;
    }

}
