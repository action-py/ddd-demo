package com.axzo.sample.domain.aggregate.message.specification;

import com.axzo.sample.domain.aggregate.message.entity.Message;
import com.axzo.sample.domain.shared.enums.MessageStatus;
import com.axzo.sample.domain.shared.specification.AndInteractiveSpecification;
import org.springframework.stereotype.Component;

/**
 * @ClassName MessageStatusSpecification
 * @Description   消息状态业务逻辑
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
@Component
public class MessageStatusSpecification extends AndInteractiveSpecification<Message, MessageStatus> {
    public MessageStatusSpecification(StopWordSpecification stopWordSpecification,BlockedSpecification blockedSpecification,SafetySpecification safetySpecification){
        super(stopWordSpecification,blockedSpecification,safetySpecification);
    }
}
