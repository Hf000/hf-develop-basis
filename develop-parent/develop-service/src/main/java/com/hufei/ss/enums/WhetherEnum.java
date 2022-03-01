package com.hufei.ss.enums;

import com.hufei.cfg.annotation.JavaEnum;
import com.hufei.cfg.config.enumerate.NameIntegerValueEnum;
import com.hufei.ss.constants.SsEnumGroupConstant;

/**
 * <p> 是否枚举 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/14 14:53
 */
@JavaEnum(value = SsEnumGroupConstant.WHETHER_ENUM)
public enum WhetherEnum implements NameIntegerValueEnum {
    /**
     * 否
     */
    N(0, "否"),
    /**
     * 是
     */
    Y(1, "是");

    private final Integer value;
    private final String label;

    WhetherEnum(Integer value, String label) {
        this.value = value;
        this.label = label;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getName() {
        return label;
    }
}
