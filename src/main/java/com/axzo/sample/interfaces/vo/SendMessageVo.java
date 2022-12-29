package com.axzo.sample.interfaces.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yinwenbin
 * Created on 2021/7/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendMessageVo {
    private long messageId;
    private int catId;
    private int sender;
    private int receiver;
    private String content;
}
