package com.axzo.sample.domain.shared.facade;

import com.axzo.sample.domain.aggregate.message.entity.valueobject.User;


/**
 * @ClassName
 * @Description
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
public interface UserServiceFacade {
    /**
     * 获取用户
     *
     * @param userId
     * @return
     */
    User getUser(int userId);
}
