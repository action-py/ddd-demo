package com.axzo.sample.application.service.impl;

import com.axzo.sample.application.service.NoticeCommandService;
import com.axzo.sample.domain.shared.event.DomainEventPublisher;
import com.google.common.eventbus.Subscribe;
import com.axzo.sample.domain.aggregate.message.event.MessageCreatedEvent;
import com.axzo.sample.domain.aggregate.notice.AppMessagePublisher;
import com.axzo.sample.domain.aggregate.notice.SocketMessagePublisher;
import com.axzo.sample.domain.aggregate.notice.entity.Notice;
import com.axzo.sample.domain.aggregate.notice.repository.NoticeRepository;
import org.springframework.stereotype.Service;
/**
 * @ClassName NoticeServiceImpl
 * @Description TODO
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
@Service
public class NoticeServiceImpl implements NoticeCommandService {
    private final AppMessagePublisher appMessagePublisher;
    private final SocketMessagePublisher socketMessagePublisher;
    private final NoticeRepository noticeRepository;

    public NoticeServiceImpl(
            DomainEventPublisher domainEventPublisher,
            AppMessagePublisher appMessagePublisher,
            SocketMessagePublisher socketMessagePublisher,
            NoticeRepository noticeRepository
    ) {
        this.appMessagePublisher = appMessagePublisher;
        this.socketMessagePublisher = socketMessagePublisher;
        this.noticeRepository = noticeRepository;
        domainEventPublisher.register(this);
    }

    @Override
    @Subscribe
    public void createNotice(MessageCreatedEvent messageCreatedEvent) {
        Notice notice = new Notice(messageCreatedEvent.getData());
        notice.createImMessage()
                .forEach(socketMessagePublisher::publish);
        notice.createAppMessages()
                .forEach(appMessagePublisher::publish);
        noticeRepository.save(notice);
    }
}
