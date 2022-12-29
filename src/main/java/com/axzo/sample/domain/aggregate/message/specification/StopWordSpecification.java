package com.axzo.sample.domain.aggregate.message.specification;

import com.axzo.sample.domain.aggregate.message.entity.Message;
import com.axzo.sample.domain.shared.enums.MessageCategory;
import com.axzo.sample.domain.shared.enums.MessageStatus;
import com.axzo.sample.domain.shared.specification.AbstractSpecification;
import com.axzo.sample.domain.shared.specification.InteractiveSpecification;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @ClassName RecallSpecification
 * @Description   违禁词识别逻辑
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
@Component
public class StopWordSpecification extends AbstractSpecification<Message> implements InteractiveSpecification<Message, MessageStatus> {
    @Override
    public void notSatisfiedHandleBy(Message message, Consumer<MessageStatus> handle) {
        if (isSatisfiedBy(message)) {
            return;
        }
        handle.accept(MessageStatus.HAS_STOP_WORD);
    }
    @Override
    public boolean isSatisfiedBy(Message message) {
        //只验证聊天消息,系统消息不校验违禁
        if(!MessageCategory.CHAT.sameValueAs(message.getCategory())){
            return true;
        }
        String content = message.getContent().getContent();
        //todo 通过系统违禁词列表，匹配消息内容是否包含违禁词
        if(content.contains("线下交易")){
            return false;
        }
        return true;
    }
}