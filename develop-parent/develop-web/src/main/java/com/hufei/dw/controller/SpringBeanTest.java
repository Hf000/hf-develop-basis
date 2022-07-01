package com.hufei.dw.controller;

import com.hufei.cp.utils.SpringBeanUtil;
import com.hufei.ds.service.HtTestService;
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

    private final HtTestService htTestService3 = (HtTestService) SpringBeanUtil.getBean("htTestServiceImpl");

    public void test() {
        log.info("测试SpringBeanUtil");
        assert htTestService3 != null;
        htTestService3.testMethod();
    }

}
