package netty.client;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author yuweixiong
 * @date 2020/09/07 14:03
 * @description
 */
public class NettyClient2Test {
    @Test
    public void Client() throws IOException, InterruptedException {
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
