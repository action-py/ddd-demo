package com.axzo.sample.domain.shared.specification;


import java.util.function.Consumer;


/**
 * @ClassName
 * @Description
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
public interface InteractiveSpecification<T,R> extends Specification<T>{
    /**
     * 当验证结果不满意时，调用 handle 进行处理
     * @param t
     * @param handle
     */
    void notSatisfiedHandleBy(T t , Consumer<R> handle);
}
