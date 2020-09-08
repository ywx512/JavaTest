package netty.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

/**
 * @author yuweixiong
 * @date 2020/09/08 20:00
 * @description
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    private static final Logger log = LoggerFactory.getLogger(NettyServerHandler.class);

    /**
     * 客户端连接时触发
     *
     * @param ctx
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        InetSocketAddress socketAddress = (InetSocketAddress) ctx.channel().remoteAddress();
        log.info("客户端: {} 连接到服务器", socketAddress.getHostString());
    }

    /**
     * 客户端发消息时触发
     *
     * @param ctx
     * @param msg
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        log.info("服务端接收到消息:{}", msg.toString());
        ctx.write("服务端回应消息: " + msg.toString());
        ctx.flush();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        log.info("连接断开");
    }

    /**
     * 发生异常时触发
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error("发送异常", cause);
        ctx.close();
    }
}
