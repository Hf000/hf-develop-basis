package com.hufei.ws.controller;

import com.hufei.cp.utils.SpringBeanUtil;
import com.hufei.ss.service.HtTestService;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>  </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/10 17:17
 */
@Slf4j
public class SpringBeanTest {

    private HtTestService htTestService3 = (HtTestService) SpringBeanUtil.getBean("htTestServiceImpl");

    public void test() {
        log.info("测试SpringBeanUtil");
        htTestService3.testMethod();
    }

}
