package com.hufei.ws.controller;

import com.hufei.cp.enums.ResponseStates;
import com.hufei.cp.response.ResponseVO;
import com.hufei.cp.utils.ResponseUtil;
import com.hufei.ss.service.HtTestService;
import com.hufei.ws.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p> 异常控制层 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/9 10:07
 */
@Slf4j
@RestController
@RequestMapping("exception")
public class HfTestController {

    @Autowired
    private HtTestService htTestService;

    @GetMapping("test")
    public ResponseVO<Void> test(@RequestParam("number") Integer number) throws Exception {
        if (number == 1) {
            throw new Exception();
        } else if (number == 2) {
            throw new CustomException(ResponseStates.FAIL);
        }
        return ResponseUtil.success();
    }

    @PostMapping("testA")
    public ResponseVO<Void> testA(Integer number, String age) throws Exception {
        if (number == 1) {
            throw new Exception();
        } else if (number == 2) {
            throw new CustomException(ResponseStates.FAIL);
        }
        return ResponseUtil.success();
    }

    @GetMapping("testB")
    public ResponseVO<Void> testB(Integer number, String age) {
        htTestService.testMethod();
        SpringBeanTest test = new SpringBeanTest();
        test.test();
        return ResponseUtil.success();
    }



}
