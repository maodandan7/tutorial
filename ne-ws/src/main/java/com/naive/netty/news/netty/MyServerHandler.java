package com.naive.netty.news.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/3/20
 * Description:
 */
@Component
public class MyServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame textWebSocketFrame) throws Exception {
        System.out.println("客户端消息：" + textWebSocketFrame.text());
        ctx.channel().writeAndFlush(new TextWebSocketFrame("服务器时间" + LocalDate.now() + textWebSocketFrame.text()));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("出现异常");
    }
}
