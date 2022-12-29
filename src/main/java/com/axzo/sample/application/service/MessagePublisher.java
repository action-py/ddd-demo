package com.axzo.sample.application.service;

import com.axzo.sample.domain.shared.enums.Application;
import com.axzo.sample.domain.shared.facade.ApnsServiceFacade;
import com.axzo.sample.domain.shared.facade.HuaweiServiceFacade;
import com.axzo.sample.domain.shared.facade.ImSocketServiceFacade;
import com.axzo.sample.domain.aggregate.notice.AppMessagePublisher;
import com.axzo.sample.domain.aggregate.notice.SocketMessagePublisher;
import com.axzo.sample.domain.aggregate.notice.entity.valueobject.AppMessage;
import com.axzo.sample.domain.aggregate.notice.entity.valueobject.SocketMessage;
import org.springframework.stereotype.Component;
/**
 * @ClassName MessagePublisher
 * @Description TODO
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
@Component
public class MessagePublisher implements AppMessagePublisher, SocketMessagePublisher {
    private final ApnsServiceFacade apnsServiceFacade;
    private final HuaweiServiceFacade huaweiServiceFacade;
    private final ImSocketServiceFacade imSocketServiceFacade;

    public MessagePublisher(ApnsServiceFacade apnsServiceFacade, HuaweiServiceFacade huaweiServiceFacade, ImSocketServiceFacade imSocketServiceFacade) {
        this.apnsServiceFacade = apnsServiceFacade;
        this.huaweiServiceFacade = huaweiServiceFacade;
        this.imSocketServiceFacade = imSocketServiceFacade;
    }

    @Override
    public void publish(AppMessage appMessage) {
        //根据Application 选择推送的渠道，当application多了以后可以通过策略模式来优化
        if (Application.IOS_XXX.equals(appMessage.getApplication())) {
            apnsServiceFacade.publish(appMessage);
        } else if (Application.ANDROID_XXX.equals(appMessage.getApplication())) {
            huaweiServiceFacade.publish(appMessage);
        }
    }

    @Override
    public void publish(SocketMessage socketMessage) {
        imSocketServiceFacade.publish(socketMessage);
    }
}