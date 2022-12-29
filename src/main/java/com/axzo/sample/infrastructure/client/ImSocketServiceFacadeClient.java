package com.axzo.sample.infrastructure.client;

import com.axzo.sample.domain.shared.facade.ImSocketServiceFacade;
import com.axzo.sample.domain.aggregate.notice.entity.valueobject.SocketMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author yinwenbin
 * Created on 2022/7/27
 */
@Component
@Slf4j
public class ImSocketServiceFacadeClient implements ImSocketServiceFacade {

    @Override
    public void publish(SocketMessage socketMessage) {
        log.info(socketMessage.toString());
    }
}