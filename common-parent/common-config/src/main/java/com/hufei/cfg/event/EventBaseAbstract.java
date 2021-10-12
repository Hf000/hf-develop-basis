package com.hufei.cfg.event;

import org.apache.commons.lang.StringUtils;

import java.util.UUID;

/**
 * <p> 事件基类: 业务功能定义事件类需要继承此基类 </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/12 15:30
 */
public abstract class EventBaseAbstract implements EventBase {

    private String key;

    @Override
    public String getKey() {
        if (StringUtils.isBlank(this.key)) {
            this.key = UUID.randomUUID().toString().replaceAll("-", "");
        }
        return key;
    }

    /**
     * 设置事件唯一标识
     * @param key 唯一标识
     */
    public void setKey(String key) {
        this.key = key;
    }

}
