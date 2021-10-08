package com.hufei.ueh.cusexception;

import com.hufei.cp.interfs.StatusCode;
import com.hufei.ueh.enums.ExceptionStates;

/**
 * <p> 自定义运行时异常父类 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/7/25 18:33
 */
public class UnCheckedException extends RuntimeException {

    private String code;
    private String msg;

    protected UnCheckedException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    protected UnCheckedException(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }

    protected UnCheckedException(String msg) {
        this.code = ExceptionStates.SYSTEMERROR.getCode();
        this.msg = msg;
    }

    protected UnCheckedException(StatusCode statusCode, String msg) {
        this.code = statusCode.getCode();
        this.msg = msg;
    }

    protected UnCheckedException() {
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
