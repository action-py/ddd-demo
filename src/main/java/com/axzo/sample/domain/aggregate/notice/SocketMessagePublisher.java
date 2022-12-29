package com.axzo.sample.domain.aggregate.notice;

import com.axzo.sample.domain.aggregate.notice.entity.valueobject.SocketMessage;

/**
 * @author yinwenbin
 * Created on 2022/7/27
 */
public interface SocketMessagePublisher {
    /**
     * 发送 {@link SocketMessage}
     *
     * @param socketMessage
     */
    void publish(SocketMessage socketMessage);
}
