package com.axzo.sample.domain.shared;

import java.io.Serializable;


/**
 * @ClassName
 * @Description 值对象
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
public interface ValueObject<T> extends Serializable {

    /**
     * 值对象通过属性比较，它们没有唯一ID
     *
     * @param other 另外的值对象
     * @return <code>true</code> 属性比较一致时返回true
     */
    boolean sameValueAs(T other);

}
