package com.axzo.sample.infrastructure.client;

import com.axzo.sample.domain.shared.facade.UserServiceFacade;
import com.axzo.sample.domain.aggregate.message.entity.valueobject.User;
import org.springframework.stereotype.Component;

/**
 * @author yinwenbin
 * Created on 2022/7/8
 */
@Component
public class UserServiceFacadeClient implements UserServiceFacade {

    @Override
    public User getUser(int userId) {
        return new User(userId, "mock_nickname_" + userId, "mock_photo_" + userId);
    }

}
