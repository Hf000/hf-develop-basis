package com.hufei.cp.response;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import com.hufei.cp.enums.ResponseStates;

import java.io.Serializable;

/**
 * <p> 返回结果类 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/7/25 19:37
 */
public class ResponseVO<T> implements Serializable {

    private static final long serialVersionUID = -2073005438844022460L;

    private String responseCode;
    private String responseMsg;
    private String requestId;
    private Long timestamp;
    private T Data;

    public ResponseVO() {
        this.setResponseCode(ResponseStates.SUCCESS.getCode());
        this.setResponseMsg(ResponseStates.SUCCESS.getMsg());
        this.setTimestamp(DateUtil.current());
    }

    public ResponseVO(String responseCode, String responseMsg) {
        this.setResponseCode(responseCode);
        this.setResponseMsg(responseMsg);
        this.setTimestamp(DateUtil.current());
    }

    public ResponseVO(ResponseStates responseStates) {
        this.setResponseCode(responseStates.getCode());
        this.setResponseMsg(responseStates.getMsg());
        this.setTimestamp(DateUtil.current());
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
