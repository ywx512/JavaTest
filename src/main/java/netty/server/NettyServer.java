package netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

/**
 * @author yuweixiong
 * @date 2020/09/08 19:59
 * @description
 */
public class NettyServer {
    private static final Logger log = LoggerFactory.getLogger(NettyServer.class);

    private final EventLoopGroup bossGroup = new NioEventLoopGroup(1);
    //从线程组，主线程组会把任务转给从线程组进行处理
    private final EventLoopGroup workGroup = new NioEventLoopGroup(1);

    private Channel channel;

    private final String hostName;

    private final Integer port;

    public NettyServer(String hostName, Integer port) {
        this.hostName = hostName;
        this.port = port;
    }

    public ChannelFuture start() throws InterruptedException {
        //主线程组，用于接收客户端的链接，但不做任何处理
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //从线程组，主线程组会把任务转给从线程组进行处理
        EventLoopGroup workGroup = new NioEventLoopGroup(10);

        //服务启动类，任务分配自动处理
        ServerBootstrap serverBootstrap = new ServerBootstrap().group(bossGroup, workGroup)
                //设置NIO的双向通道
                .channel(NioServerSocketChannel.class)
                /**
                 * 子处理器，用于处理workerGroup
                 * 设置chanel初始化器
                 * 每一个chanel由多个handler共同组成管道(pipeline)
                 */
                .childHandler(new NettyServerChannelInitializer())
                .localAddress(new InetSocketAddress(hostName, port))
                //设置队列大小
                .option(ChannelOption.SO_BACKLOG, 1024)
                // 两小时内没有数据的通信时,TCP会自动发送一个活动探测数据报文
                .childOption(ChannelOption.SO_KEEPALIVE, true);

        /**
         * 绑定端口，并设置为同步方式，是一个异步的chanel
         */
        ChannelFuture future = serverBootstrap.bind().sync();
        log.info("服务器启动开始监听端口: {}:{}", hostName, port);
        channel = future.channel();
        return future;
    }

    /**
     * 停止服务
     */
    public void destroy() {
        log.info("Shutdown Netty Server...");
        if (channel != null) {
            channel.close();
        }
        workGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
        log.info("Shutdown Netty Server Success!");
    }
}
