package com.naive.netty.news.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/3/20
 * Description:
 */
@Component
public class NettyServer {

    public void serverStart() {
        StopWatch watch = new StopWatch();
        watch.start();
    }

    public static void main(String[] args) {
        // 主线程组 接收连接请求
//        bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        //创建工作线程组，处理主线程组分配下来的io操作，即客户端的读写
//        workerGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        // 创建netty引导类，配置和串联系列组件（设置线程模型，设置通道类型，设置客户端处理器handler，设置绑定端口号）
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            // 设置主从线程组
            serverBootstrap.group(bossGroup, workerGroup)
                    .localAddress(8765)
//                    .channel(NioServerSocketChannel.class)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            // websocket协议本身是基于http协议的，所以这边也要使用http解编码器
                            socketChannel.pipeline().addLast(new HttpServerCodec());
                            // 以块的方式来写的handler，支持写大数据流
                            socketChannel.pipeline().addLast(new ChunkedWriteHandler());
                            // 解码成FullHttpRequest
                            socketChannel.pipeline().addLast(new HttpObjectAggregator(1024*62));
                            // websocket支持，设置路由
                            socketChannel.pipeline().addLast(new WebSocketServerProtocolHandler("/ws","WebSocket",
                                    true,65536*10));
//                            socketChannel.pipeline().addLast()
                            // 自定义业务处理
                            socketChannel.pipeline().addLast(new MyServerHandler());
                        }
                    });
            // 异步绑定端口号，需要阻塞住直到端口号绑定成功
            ChannelFuture channelFuture = serverBootstrap.bind().sync();
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
