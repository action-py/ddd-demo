package com.axzo.sample.domain.shared;



/**
 * @ClassName
 * @Description 实体
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
public interface Entity<T> {

    /**
     * 实体通过唯一ID比较
     *
     * @param other 另一个实体
     * @return true 只要ID相同就返回ture，忽略属性
     */
    boolean sameIdentityAs(T other);
}