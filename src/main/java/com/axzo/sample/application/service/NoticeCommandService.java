package com.axzo.sample.application.service;

import com.axzo.sample.domain.aggregate.message.event.MessageCreatedEvent;

/**
 * @ClassName NoticeCommandService
 * @Description TODO
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
public interface NoticeCommandService {
    /**
     * 创建消息通知
     *
     * @param messageCreatedEvent
     */
    void createNotice(MessageCreatedEvent messageCreatedEvent);
}
