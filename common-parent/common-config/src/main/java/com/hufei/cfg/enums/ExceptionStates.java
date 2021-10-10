package com.hufei.cfg.enums;

import com.hufei.cp.interfs.StatusCode;

/**
 * <p> 响应枚举类 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/7/25 19:44
 */
public enum ExceptionStates implements StatusCode {
    /**
     * 响应枚举类
     */
    CRON_ERROR("400001","cron表达式异常"),
    ;

    private ExceptionStates(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private final String code;
    private final String msg;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
