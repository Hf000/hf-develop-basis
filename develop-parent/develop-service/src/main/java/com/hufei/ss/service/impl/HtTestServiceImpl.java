package com.hufei.ss.service.impl;

import com.hufei.ss.service.HtTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>  </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/10 15:44
 */
@Slf4j
@Service
public class HtTestServiceImpl implements HtTestService {
    @Override
    public void testMethod() {
        log.info("原有的测试类");
    }
}
