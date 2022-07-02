package com.hufei.dw.controller;

import com.hufei.cfg.custom.expression.CustomParamAnnotation;
import com.hufei.cfg.custom.expression.CustomParamsAnnotation;
import com.hufei.cp.enums.ResponseStates;
import com.hufei.cp.response.ResponseVO;
import com.hufei.cp.utils.ExpressionResolverUtil;
import com.hufei.cp.utils.ResponseUtil;
import com.hufei.ds.service.HtTestService;
import com.hufei.dw.exception.CustomException;
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
@RequestMapping("test")
public class HfTestController {

    @Autowired
    private HtTestService htTestService;

    @GetMapping("testA")
    public ResponseVO<Void> testA(@RequestParam("number") Integer number) throws Exception {
        if (number == 1) {
            throw new Exception();
        } else if (number == 2) {
            throw new CustomException(ResponseStates.FAIL);
        }
        return ResponseUtil.success();
    }

    @PostMapping("testB")
    public ResponseVO<Void> testB(Integer number, String age) throws Exception {
        if (number == 1) {
            throw new Exception();
        } else if (number == 2) {
            throw new CustomException(ResponseStates.FAIL);
        }
        return ResponseUtil.success();
    }

    @GetMapping("testC")
    public ResponseVO<Void> testC(Integer number, String age) {
        htTestService.testMethod();
        SpringBeanTest test = new SpringBeanTest();
        test.test();
        return ResponseUtil.success();
    }

    @GetMapping("testD")
    public ResponseVO<String> testD() {
        String propertiesValue = "";
        // 解析properties配置文件获取key对应的值
//        propertiesValue = PropertiesUtil.init().getPropertiesValue("ej.cron");
        // 使用ExpressionResolverUtil解析表达式
        Object object = ExpressionResolverUtil.expressionAnalysis("${ej.cron}");
        if (object != null) {
            propertiesValue = object.toString();
        }
        return ResponseUtil.success(propertiesValue);
    }

    @GetMapping("testE")
    @CustomParamsAnnotation(value = {"#a", "#b"})
    public ResponseVO<Void> testE(@RequestParam("a") String a, @RequestParam("b") String b) {
        return ResponseUtil.success();
    }

    @GetMapping("testF")
    @CustomParamAnnotation(value = "#a")
    public ResponseVO<Void> testF(@RequestParam("a") String a) {
        return ResponseUtil.success();
    }

}
