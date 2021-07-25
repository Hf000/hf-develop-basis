package com.hufei.ueh.cusexception;

import com.hufei.ueh.enums.ExceptionStates;
import com.hufei.ueh.interfs.ExceptionCode;

import java.util.List;

/**
 * <p> 自定义web层异常父类 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/7/25 18:33
 */
public class WebException extends RuntimeException implements ExceptionCode {

    private String code;
    private String msg;
    private List<?> dataList;

    protected WebException(String code, String msg, List<?> dataList) {
        this.code = code;
        this.msg = msg;
        this.dataList = dataList;
    }

    protected WebException(ExceptionCode exceptionCode, List<?> dataList) {
        this.code = exceptionCode.getCode();
        this.msg = exceptionCode.getMsg();
        this.dataList = dataList;
    }

    protected WebException(String msg, List<?> dataList) {
        this.code = ExceptionStates.SYSTEMERROR.getCode();
        this.msg = msg;
        this.dataList = dataList;
    }

    protected WebException(ExceptionCode exceptionCode, String msg, List<?> dataList) {
        this.code = exceptionCode.getCode();
        this.msg = msg;
        this.dataList = dataList;
    }

    protected WebException() {
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

    public List<?> getDataList() { return this.dataList; }

}
