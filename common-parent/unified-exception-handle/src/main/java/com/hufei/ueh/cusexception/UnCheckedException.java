package com.hufei.ueh.cusexception;

import com.hufei.ueh.enums.ExceptionStates;
import com.hufei.ueh.interfs.ExceptionCode;

/**
 * <p> 自定义运行时异常父类 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/7/25 18:33
 */
public class UnCheckedException extends RuntimeException implements ExceptionCode {

    private String code;
    private String msg;

    protected UnCheckedException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    protected UnCheckedException(ExceptionCode exceptionCode) {
        this.code = exceptionCode.getCode();
        this.msg = exceptionCode.getMsg();
    }

    protected UnCheckedException(String msg) {
        this.code = ExceptionStates.SYSTEMERROR.getCode();
        this.msg = msg;
    }

    protected UnCheckedException(ExceptionCode exceptionCode, String msg) {
        this.code = exceptionCode.getCode();
        this.msg = msg;
    }

    protected UnCheckedException() {
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
