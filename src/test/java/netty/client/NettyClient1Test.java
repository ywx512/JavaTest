package netty.client;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NettyClient1Test {
    private static final Logger log = LoggerFactory.getLogger(NettyClient1Test.class);

    @Test
    public void Client() throws IOException {
        NettyClient nettyClient = new NettyClient("127.0.0.1", 8090);
        nettyClient.start();

        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String msg = br.readLine();
            if ("exit".equals(msg)) {
                nettyClient.close();
                break;
            }
            nettyClient.send(msg);
        }
    }
}