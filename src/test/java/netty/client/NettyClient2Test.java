package netty.client;

import org.junit.jupiter.api.Test;

/**
 * @author yuweixiong
 * @date 2020/09/07 14:03
 * @description
 */
public class NettyClient2Test {
    @Test
    public void Client() {
        NettyClient nettyClient = new NettyClient("127.0.0.1", 8090);
        nettyClient.start();
    }
}
