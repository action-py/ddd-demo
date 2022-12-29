package com.axzo.sample.domain.aggregate.message;

/**
 * @ClassName RecallSpecification
 * @Description   违禁词识别逻辑
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
public interface MessageIdGenerator {
    /**
     * 生成全局唯一的mesageId
     *
     * @return
     */
    long generate();
}
