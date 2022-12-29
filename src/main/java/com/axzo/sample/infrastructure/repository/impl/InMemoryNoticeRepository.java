package com.axzo.sample.infrastructure.repository.impl;

import com.axzo.sample.domain.aggregate.notice.entity.Notice;
import com.axzo.sample.domain.aggregate.notice.repository.NoticeRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yinwenbin
 * Created on 2021/7/27
 */
@Repository
public class InMemoryNoticeRepository implements NoticeRepository {
    private final Map<Long, Notice> noticeRepositories = new ConcurrentHashMap<>();

    @Override
    public void save(Notice notice) {
        noticeRepositories.put(notice.getMessageId(), notice);
    }
}
