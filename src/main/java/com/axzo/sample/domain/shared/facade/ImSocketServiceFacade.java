package com.axzo.sample.domain.shared.facade;

import com.axzo.sample.domain.aggregate.notice.entity.valueobject.SocketMessage;


/**
 * @ClassName
 * @Description
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
public interface ImSocketServiceFacade {

    /**
     * 发布消息到Im推送渠道
     *
     * @param socketMessage
     */
    void publish(SocketMessage socketMessage);
}
