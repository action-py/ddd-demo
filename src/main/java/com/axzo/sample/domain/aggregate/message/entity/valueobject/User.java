package com.axzo.sample.domain.aggregate.message.entity.valueobject;

import com.axzo.sample.domain.shared.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * @ClassName User
 * @Description TODO
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements ValueObject<User> {
    /**
     * 用户ID
     */
    private int userId;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像ß
     */
    private String photo;

    @Override
    public boolean sameValueAs(User other) {
        return other != null && new EqualsBuilder().
                append(this.userId, other.userId).
                append(this.nickname, other.nickname).
                append(this.photo, other.photo).
                isEquals();
    }
}