package com.axzo.sample.domain.service;

import com.axzo.sample.domain.aggregate.message.entity.Message;
import com.axzo.sample.domain.shared.enums.MessageCategory;
import com.axzo.sample.shared.Result;


/**
 * @ClassName MessageDomainService
 * @Description TODO
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
public interface MessageDomainService {
    /**
     * 创建消息
     *
     * @param messageId
     * @param senderId
     * @param receiverId
     * @param content
     * @return
     */
    Message createMessage(long messageId, MessageCategory category, int senderId, int receiverId, String content);

    /**
     * 撤销消息
     * @param message
     */
    Result<Void> recall(Message message);
}
