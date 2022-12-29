package com.axzo.sample.interfaces.facade.impl;

import com.axzo.sample.application.service.MessageCommandService;
import com.axzo.sample.application.service.MessageQueryService;
import com.axzo.sample.shared.Result;
import com.axzo.sample.interfaces.facade.MessageServiceFacade;
import com.axzo.sample.interfaces.vo.SendMessageVo;
import com.axzo.sample.interfaces.assembler.MessageDTOAssembler;
import com.axzo.sample.interfaces.dto.MessageDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yinwenbin
 * Created on 2021/7/22
 */
@Service
public class MessageServiceFacadeImpl implements MessageServiceFacade {
    private final MessageCommandService messageCommandService;
    private final MessageQueryService messageQueryService;

    public MessageServiceFacadeImpl(MessageCommandService messageCommandService,MessageQueryService messageQueryService) {
        this.messageCommandService = messageCommandService;
        this.messageQueryService = messageQueryService;
    }

    @Override
    public void sendMessage(SendMessageVo cmd) {
        this.messageCommandService.createMessage(
                cmd.getMessageId(),
                cmd.getCatId(),
                cmd.getSender(),
                cmd.getReceiver(),
                cmd.getContent()
        );
    }

    @Override
    public Result<Void> recallMessage(int userId, long messageId) {
        return this.messageCommandService.recallMessage(userId,messageId);
    }

    @Override
    public int getUnreadMessageTotal(int userId) {
        return this.messageQueryService.getUnreadMessageTotal(userId);
    }

    @Override
    public List<MessageDTO> getContactMessageList(int userId, int contactId, int size) {
        return this.messageQueryService.getContactMessageList(userId,contactId,size)
                .stream()
                .map(MessageDTOAssembler::toDTO)
                .collect(Collectors.toList());
    }
}