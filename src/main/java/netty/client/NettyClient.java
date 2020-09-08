package netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;

/**
 * @author yuweixiong
 * @date 2020/09/07 10:56
 * @description
 */
public class NettyClient {
    private static final Logger log = LoggerFactory.getLogger(NettyClient.class);

    private final String host;

    private final int port;

    private EventLoopGroup group = new NioEventLoopGroup();

    private ChannelFuture channelFuture;

    public NettyClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() {
//        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap()
                .group(group)
                .channel(NioSocketChannel.class)
                .remoteAddress(new InetSocketAddress(host, port))
                //该参数的作用就是禁止使用Nagle算法，使用于小数据即时传输
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new NettyClientInitializer());

        try {
            channelFuture = bootstrap.connect().sync();
            log.info("客户端成功....");
        } catch (InterruptedException e) {
            log.error("中断异常", e);
        }
    }

    public void send(String msg) {
        log.info("send: " + msg);
        channelFuture.channel().writeAndFlush(msg);
    }

    public void close() {
        log.info("close");
        group.shutdownGracefully();
    }
}
