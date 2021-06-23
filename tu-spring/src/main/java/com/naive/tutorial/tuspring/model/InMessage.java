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
@NoArgsConstructor
@AllArgsConstructor
public class InMessage {
    private String from;
    private String to;
    private String content;
    private Date time;
}
