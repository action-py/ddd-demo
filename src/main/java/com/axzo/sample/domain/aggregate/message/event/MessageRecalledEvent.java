package com.axzo.sample.domain.aggregate.message.event;

import com.axzo.sample.domain.aggregate.message.entity.Message;
import com.axzo.sample.domain.shared.event.AbstractEvent;


/**
 * @ClassName MessageRecalledEvent
 * @Description TODO
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
public class MessageRecalledEvent extends AbstractEvent<Message> {
    public MessageRecalledEvent(Message message) {
        super(message);
    }
}
