package com.axzo.sample.infrastructure.client;

import com.axzo.sample.domain.shared.facade.ApnsServiceFacade;
import com.axzo.sample.domain.aggregate.notice.entity.valueobject.AppMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author yinwenbin
 * Created on 2022/7/27
 */
@Component
@Slf4j
public class ApnsServiceFacadeClient implements ApnsServiceFacade {

    @Override
    public void publish(AppMessage appMessage) {
        //调用apns接口发布消息
        log.info(appMessage.toString());
    }
}
