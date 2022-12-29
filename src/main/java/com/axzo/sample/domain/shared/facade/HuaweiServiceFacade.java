package com.axzo.sample.domain.shared.facade;

import com.axzo.sample.domain.aggregate.notice.entity.valueobject.AppMessage;
/**
 * @ClassName
 * @Description
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
public interface HuaweiServiceFacade {
    /**
     * 发布消息到华为推送平台
     *
     * @param appMessage
     */
    void publish(AppMessage appMessage);
}
