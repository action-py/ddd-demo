package com.axzo.sample.domain.shared.event;

import com.axzo.sample.shared.utils.SnowflakeIdGenerator;


/**
 * @ClassName
 * @Description
 * @Author yinwenbin
 * @Date 3:30 PM 2022/7/25
 * @Version 1.0
 **/
public class EventIdProducer {

    private final static EventIdProducer INSTANCE = new EventIdProducer();

    /**
     * 数据中心
     */
    private final String datacenter = "datacenter";
    /**
     * 机器节点
     */
    private final String node = "node";

    private final SnowflakeIdGenerator snowflakeIdGenerator;

    private EventIdProducer() {
        this.snowflakeIdGenerator = new SnowflakeIdGenerator(0, 0);
    }

    public static EventIdProducer getInstance() {
        return INSTANCE;
    }

    /**
     * 获得下一个ID (该方法是线程安全的)
     *
     * @return 数据中心-机器节点-当前事件戳-号码内的序列号
     */
    public String generateId() {
        return this.datacenter + "-" + this.node + "-" + this.snowflakeIdGenerator.nextId();
    }
}
