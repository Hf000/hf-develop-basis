package com.hufei.dw.exception;

import com.hufei.cp.interfs.StatusCode;
import com.hufei.ueh.cusexception.WebException;

/**
 * <p> 自定义异常 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/9 10:28
 */
public class CustomException extends WebException {
    private static final long serialVersionUID = 6093873036324529919L;

    public CustomException(StatusCode statusCode) {
        super(statusCode);
    }

    public CustomException(String code, String msg) {
        super(code, msg);
    }

}
