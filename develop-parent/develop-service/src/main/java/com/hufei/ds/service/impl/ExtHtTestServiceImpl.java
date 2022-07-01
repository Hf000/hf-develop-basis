package com.hufei.ds.service.impl;

import com.hufei.cfg.replacebean.CustomBeanReplace;
import com.hufei.ds.service.HtTestService;
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
