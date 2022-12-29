package com.axzo.sample.application.service;

import com.axzo.sample.shared.Result;

/**
 * @ClassName MessageCommandService
 * @Description TODO
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
public interface MessageCommandService {
    /**
     * 创建消息
     * @param messageId
     * @param catId
     * @param sender
     * @param receiver
     * @param content
     */
    void createMessage(long messageId, int catId, int sender, int receiver, String content);

    /**
     * 撤回消息
     * @param userId
     * @param messageId
     */
    Result<Void> recallMessage(int userId , long messageId);
}
