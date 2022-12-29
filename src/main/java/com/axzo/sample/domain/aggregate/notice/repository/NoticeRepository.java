package com.axzo.sample.domain.aggregate.notice.repository;

import com.axzo.sample.domain.aggregate.notice.entity.Notice;

/**
 * @author yinwenbin
 * Created on 2022/7/27
 */
public interface NoticeRepository {
    /**
     * 保存消息
     *
     * @param notice
     */
    void save(Notice notice);
}
