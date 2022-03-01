package com.hufei.ss.service.impl;

import com.hufei.cfg.annotation.CustomBeanReplace;
import com.hufei.ss.service.HtTestService;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>  </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/10 15:44
 */
@Slf4j
@CustomBeanReplace(value = "htTestServiceImpl")
//@Service
public class ExtHtTestServiceImpl implements HtTestService {
    @Override
    public void testMethod() {
        log.info("替换的测试类");
    }
}
