package com.hufei.ws.controller;

import com.hufei.cfg.event.EventPublisher;
import com.hufei.cp.response.ResponseVO;
import com.hufei.cp.utils.ResponseUtil;
import com.hufei.ss.beans.pojo.EventEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p> 事件处理 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/12 17:13
 */
@RestController
@RequestMapping("event")
public class EventController {

    @Autowired
    private EventPublisher eventPublisher;

    @GetMapping("test")
    public ResponseVO<Void> test() {
        EventEntity entity = new EventEntity();
        entity.setId(123);
        entity.setAction("测试流程");
        entity.setEventName("hf测试");
        eventPublisher.publish(entity);
        return ResponseUtil.success();
    }

}
