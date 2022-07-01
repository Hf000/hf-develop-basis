package com.hufei.dw.convert;

import com.hufei.ds.beans.bo.ElasticJobBO;
import com.hufei.dw.beans.vo.ElasticJobVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * <p> 定时任务实体转换 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/10 11:49
 */
@Mapper(componentModel = "spring")
public interface ElasticJobBeansConvert {

    /**
     * 将List<ElasticJobBO>转换成List<ElasticJobVO>
     * @param elasticJobBos 入参
     * @return 返回
     */
    List<ElasticJobVO> elasticJobBoToVo(List<ElasticJobBO> elasticJobBos);
}