package com.naive.tutorial.tuspring.controller;

import com.naive.tutorial.tuspring.model.OutMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/3/19
 * Description:
 */
@Controller
public class IndexController {

    @MessageMapping("v1/chat")
    @SendTo("/topic/chat")
    public OutMessage out(String message) {
        return new OutMessage(message);
    }

}
