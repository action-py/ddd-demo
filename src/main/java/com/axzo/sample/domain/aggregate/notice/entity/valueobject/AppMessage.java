package com.axzo.sample.domain.aggregate.notice.entity.valueobject;

import com.axzo.sample.domain.shared.enums.Application;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 移动端 APP 消息
 *
 * @author yinwenbin
 * Created on 2022/7/23
 */
@Slf4j
@NoArgsConstructor
@Data
public class AppMessage {
    private Application application;
    private String deviceToken;
    private String title;
    private String body;
    private Map<String, String> attachData;

    public AppMessage(Application application, String deviceToken, String title, String body) {
        this.application = application;
        this.deviceToken = deviceToken;
        this.title = title;
        this.body = body;
    }
}
