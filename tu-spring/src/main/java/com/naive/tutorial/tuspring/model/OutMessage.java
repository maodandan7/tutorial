package com.naive.tutorial.tuspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/3/19
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutMessage {
    private String from;
    private String content;
    private Date time = new Date();

    public OutMessage(String message) {
        this.content = message;
    }
}
