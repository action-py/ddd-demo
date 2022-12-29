package com.axzo.sample.domain.aggregate.message.specification;
import com.axzo.sample.domain.aggregate.message.entity.Message;
import com.axzo.sample.domain.shared.specification.AbstractSpecification;
import org.springframework.stereotype.Component;

/**
 * @ClassName ReadSpecification
 * @Description   用户黑名单逻辑
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
@Component
public class ReadSpecification extends AbstractSpecification<Message> {
    /**
     * 返回 true 代表消息已读 , false 代表消息未读
     * @param message
     * @return
     */
    @Override
    public boolean isSatisfiedBy(Message message) {
        //todo 可以通过Im Socket判断，接受者与发送者正在对话，那么可以直接设置为已读
        //mock正在对话
        boolean isTalking = message.getReceiver().getUserId() % 3 == 0;
        if(message.getReceiver().getUserId() % 3 == 0){
            return true;
        }
        return false;
    }
}
