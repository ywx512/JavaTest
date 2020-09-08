package netty.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * @author yuweixiong
 * @date 2020/09/08 20:00
 * @description
 */
public class NettyServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline channelPipeline = socketChannel.pipeline();
        channelPipeline.addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
        channelPipeline.addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
        channelPipeline.addLast(new NettyServerHandler());
    }
}
