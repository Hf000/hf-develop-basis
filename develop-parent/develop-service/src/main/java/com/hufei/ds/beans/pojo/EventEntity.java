package com.hufei.ds.beans.pojo;

import com.hufei.cfg.event.EventBaseAbstract;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p> 事件实体 </p>
 * 如果不需要默认逻辑, 可以直接实现EventBase接口
 * @author hufei
 * @version 1.0.0
 * @date 2021/10/12 17:14
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EventEntity extends EventBaseAbstract {

    private Integer id;

    private String action;

    private String eventName;

}
