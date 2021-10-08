package com.hufei.ueh.cusexception;

import com.hufei.cp.interfs.StatusCode;
import com.hufei.ueh.enums.ExceptionStates;

/**
 * <p> 自定义可检查异常父类 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/7/25 18:33
 */
public class CheckedException extends Exception {

    private String code;
    private String msg;

    protected CheckedException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    protected CheckedException(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }

    protected CheckedException(String msg) {
        this.code = ExceptionStates.SYSTEMERROR.getCode();
        this.msg = msg;
    }

    protected CheckedException(StatusCode statusCode, String msg) {
        this.code = statusCode.getCode();
        this.msg = msg;
    }

    protected CheckedException() {
        this.code = ExceptionStates.SYSTEMERROR.getCode();
        this.msg = ExceptionStates.SYSTEMERROR.getMsg();
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

}
