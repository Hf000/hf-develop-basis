package com.hufei.cfg.custom.job;

import com.hufei.cp.interfs.StatusCode;
import com.hufei.ueh.cusexception.UnCheckedException;

/**
 * <p> 定时任务自定义异常 </p>
 * 自定义封装elastic-job实现 - 4
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/9 21:53
 */
public class ElasticJobException extends UnCheckedException {
    private static final long serialVersionUID = -2058299577463933748L;

    public ElasticJobException(StatusCode statusCode) {
        super(statusCode);
    }

    public ElasticJobException(String code, String msg) {
        super(code, msg);
    }
}
