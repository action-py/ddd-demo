package com.axzo.sample.domain.aggregate.notice;

import com.axzo.sample.domain.aggregate.notice.entity.valueobject.AppMessage;

/**
 * @author yinwenbin
 * Created on 2022/7/27
 */
public interface AppMessagePublisher {
    /**
     * 发送 {@link AppMessage}
     *
     * @param appMessage
     */
    void publish(AppMessage appMessage);
}
