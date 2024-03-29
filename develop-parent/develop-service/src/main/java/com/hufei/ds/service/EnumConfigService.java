package com.hufei.ds.service;

import com.hufei.ds.beans.bo.EnumInfoBO;
import com.hufei.ds.beans.bo.EnumQueryBO;

import java.util.List;
import java.util.Map;

/**
 * <p> 枚举类service接口 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/14 14:07
 */
public interface EnumConfigService {

    /**
     * 根据条件查询枚举类信息
     * @param enumQueryBO 入参
     * @return 集合
     */
    Map<String, List<EnumInfoBO>> getEnumByGroups(EnumQueryBO enumQueryBO);

}
