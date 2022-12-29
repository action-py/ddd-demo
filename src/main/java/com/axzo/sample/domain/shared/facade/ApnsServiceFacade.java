package com.axzo.sample.domain.shared.facade;

import com.axzo.sample.domain.aggregate.notice.entity.valueobject.AppMessage;


/**
 * @ClassName
 * @Description
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
public interface ApnsServiceFacade {
    /**
     * 发布消息到Apns
     *
     * @param appMessage
     */
    void publish(AppMessage appMessage);
}