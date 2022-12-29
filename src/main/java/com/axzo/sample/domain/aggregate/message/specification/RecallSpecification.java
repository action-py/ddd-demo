package com.axzo.sample.domain.aggregate.message.specification;
import com.axzo.sample.domain.aggregate.message.entity.Message;
import com.axzo.sample.domain.shared.specification.AbstractSpecification;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ClassName RecallSpecification
 * @Description   消息撤销逻辑
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
@Component
public class RecallSpecification extends AbstractSpecification<Message> {
    /**
     * @param message
     * @return
     */
    @Override
    public boolean isSatisfiedBy(Message message) {
        //已经撤回了，不能二次撤回
        if(message.isSenderDeleted() && message.isReceiverDeleted()){
            return false;
        }
        //只允许撤销，5分钟内的消息
        Date fiveMinutesAgo = new Date(System.currentTimeMillis() - 60 * 5 * 1000);
        return message.getSendTime().after(fiveMinutesAgo);
    }
}
