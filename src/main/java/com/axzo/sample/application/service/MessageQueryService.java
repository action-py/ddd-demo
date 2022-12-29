package com.axzo.sample.application.service;

import com.axzo.sample.domain.aggregate.message.entity.Message;

import java.util.List;

/**
 * @ClassName MessageQueryService
 * @Description TODO
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
public interface MessageQueryService {

    /**
     * 获取未读消息的数量
     * @param userId
     * @return
     */
    int getUnreadMessageTotal(int userId);

    /**
     * 获取往来消息列表
     * @param userId
     * @param contactId
     * @param size
     * @return
     */
    List<Message> getContactMessageList(int userId,int contactId,int size);
}