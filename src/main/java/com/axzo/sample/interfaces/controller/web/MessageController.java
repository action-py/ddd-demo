package com.axzo.sample.interfaces.controller.web;

import com.axzo.sample.interfaces.facade.MessageServiceFacade;
import com.axzo.sample.interfaces.vo.SendMessageVo;
import com.axzo.sample.interfaces.dto.MessageDTO;
import com.axzo.sample.shared.Result;
import com.axzo.sample.shared.controller.Response;
import com.axzo.sample.domain.aggregate.message.MessageIdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * @author yinwenbin
 * Created on 2021/7/22
 */
@RestController
@RequiredArgsConstructor
public class MessageController {
    private final MessageServiceFacade messageServiceFacade;
    private final MessageIdGenerator messageIdGenerator;

    /**
     * 发送消息
     *
     * @param cmd {@link SendMessageVo
     * @return 消息ID
     */
    @PostMapping("/message")
    public Response<Long> sendMessage(@Validated @RequestBody SendMessageVo cmd) {
        long messageId = messageIdGenerator.generate();
        cmd.setMessageId(messageId);
        messageServiceFacade.sendMessage(cmd);
        return Response.ok(messageId);
    }

    /**
     * 撤回消息
     *
     * @param messageId
     * @param request
     * @return
     */
    @PostMapping("/message/{messageId}/recall")
    public Response<Void> recallMessage(@PathVariable long messageId , HttpServletRequest request){
        int userId = Integer.parseInt(request.getHeader("mock-user-id"));
        Result<Void> result = this.messageServiceFacade.recallMessage(userId,messageId);
        if (result.isSuccess()){
            return Response.ok(result.getData());
        }
        return Response.failed(result.getError().getMsg());
    }

    @GetMapping("/unreadMessageTotal")
    public Response<Integer> getUnreadMessageTotal(HttpServletRequest request){
        int userId = Integer.parseInt(request.getHeader("mock-user-id"));
        return Response.ok(messageServiceFacade.getUnreadMessageTotal(userId));
    }

    @GetMapping("/contact/{contactId}/messages")
    public Response<List<MessageDTO>> getContactMessageList(@PathVariable int contactId , Integer size, HttpServletRequest request){
        int userId = Integer.parseInt(request.getHeader("mock-user-id"));
        List<MessageDTO> data = messageServiceFacade.getContactMessageList(userId,contactId, Optional.ofNullable(size).orElse(10));
        return Response.ok(data);
    }
}
