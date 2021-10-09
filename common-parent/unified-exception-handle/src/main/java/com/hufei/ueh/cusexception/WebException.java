package com.hufei.ueh.cusexception;

import com.hufei.cp.interfs.StatusCode;
import com.hufei.ueh.enums.ExceptionStates;

import java.util.List;

/**
 * <p> 自定义web层异常父类 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/7/25 18:33
 */
public class WebException extends RuntimeException  {

    private static final long serialVersionUID = -5098852202248205572L;
    protected String code;
    protected String msg;
    protected List<?> dataList;

    protected WebException(String code, String msg, List<?> dataList) {
        this.code = code;
        this.msg = msg;
        this.dataList = dataList;
    }

    protected WebException(StatusCode statusCode, List<?> dataList) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.dataList = dataList;
    }

    protected WebException(String msg, List<?> dataList) {
        this.code = ExceptionStates.SYSTEMERROR.getCode();
        this.msg = msg;
        this.dataList = dataList;
    }

    protected WebException(StatusCode statusCode, String msg, List<?> dataList) {
        this.code = statusCode.getCode();
        this.msg = msg;
        this.dataList = dataList;
    }

    protected WebException() {
        this.code = ExceptionStates.SYSTEMERROR.getCode();
        this.msg = ExceptionStates.SYSTEMERROR.getMsg();
    }

    protected WebException(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }

    protected WebException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public List<?> getDataList() { return this.dataList; }

}
