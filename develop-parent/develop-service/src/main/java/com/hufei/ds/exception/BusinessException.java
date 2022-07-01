package com.hufei.ds.exception;

import com.hufei.cp.interfs.StatusCode;
import com.hufei.ueh.cusexception.UnCheckedException;

/**
 * <p> 业务异常 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/10 12:17
 */
public class BusinessException extends UnCheckedException {

    private static final long serialVersionUID = -4983850736223849426L;

    public BusinessException(StatusCode statusCode) {
        super(statusCode);
    }

    public BusinessException(String code, String msg) {
        super(code, msg);
    }

}
