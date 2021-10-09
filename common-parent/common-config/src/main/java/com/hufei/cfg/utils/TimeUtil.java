package com.hufei.cfg.utils;

import cn.hutool.core.date.DateUtil;
import com.hufei.cfg.constants.CfgConstant;

/**
 * <p> 计算时间工具类 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/9 16:40
 */
public class TimeUtil {

    private long time;

    public TimeUtil() {
        time = DateUtil.current();
    }

    public long getStartTime() {
        return time;
    }

    public long getDeltaTime() {
        long delta = DateUtil.current() - time;
        time = DateUtil.current();
        return delta;
    }

    public String getDeltaTimeText() {
        return getDeltaTime() + "ms";
    }

    public String getDeltaSecondText() {
        return getDeltaTime() / CfgConstant.ONE_THOUSAND + "s";
    }

}