package com.hufei.dw.controller;

import com.hufei.cp.response.ResponseVO;
import com.hufei.cp.utils.ResponseUtil;
import com.hufei.ds.beans.bo.EnumInfoBO;
import com.hufei.ds.beans.bo.EnumQueryBO;
import com.hufei.ds.service.EnumConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p> 枚举类Controller </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/14 14:06
 */
@Slf4j
@RestController
@RequestMapping(value = "support/enum")
public class EnumController {

    @Autowired
    private EnumConfigService enumConfigService;

    @GetMapping("/list")
    public ResponseVO<Map<String, List<EnumInfoBO>>> queryEnumList(EnumQueryBO enumQueryBO) {
        Map<String, List<EnumInfoBO>> enumByGroups = enumConfigService.getEnumByGroups(enumQueryBO);
        return ResponseUtil.success(enumByGroups);
    }

}
