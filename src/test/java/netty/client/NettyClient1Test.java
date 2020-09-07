package netty.client;

import org.junit.jupiter.api.Test;

public class NettyClient1Test {

    @Test
    public void Client() {
        NettyClient nettyClient = new NettyClient("127.0.0.1", 8090);
        nettyClient.start();
    }
}