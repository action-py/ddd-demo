package com.axzo.sample.infrastructure.client;

import com.axzo.sample.domain.shared.facade.HuaweiServiceFacade;
import com.axzo.sample.domain.aggregate.notice.entity.valueobject.AppMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author yinwenbin
 * Created on 2022/7/27
 */
@Component
@Slf4j
public class HuaweiServiceFacadeClient implements HuaweiServiceFacade {
    @Override
    public void publish(AppMessage appMessage) {
        log.info(appMessage.toString());
    }
}
