package com.hufei.ueh.cusexception;

import com.hufei.ueh.enums.ExceptionStates;
import com.hufei.ueh.interfs.ExceptionCode;

/**
 * <p> 自定义可检查异常父类 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/7/25 18:33
 */
public class CheckedException extends Exception implements ExceptionCode {

    private String code;
    private String msg;

    protected CheckedException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    protected CheckedException(ExceptionCode exceptionCode) {
        this.code = exceptionCode.getCode();
        this.msg = exceptionCode.getMsg();
    }

    protected CheckedException(String msg) {
        this.code = ExceptionStates.SYSTEMERROR.getCode();
        this.msg = msg;
    }

    protected CheckedException(ExceptionCode exceptionCode, String msg) {
        this.code = exceptionCode.getCode();
        this.msg = msg;
    }

    protected CheckedException() {
        this.code = ExceptionStates.SYSTEMERROR.getCode();
        this.msg = ExceptionStates.SYSTEMERROR.getMsg();
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

}
