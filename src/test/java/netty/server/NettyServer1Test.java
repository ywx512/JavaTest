package netty.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author yuweixiong
 * @date 2020/09/08 20:02
 * @description
 */
public class NettyServer1Test {
    public static void main(String[] args) throws InterruptedException, IOException {
        NettyServer nettyServer = new NettyServer("127.0.0.1", 8090);
        nettyServer.start();

        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String cmd = br.readLine();
            if ("exit".equals(cmd)) {
                break;
            }
        }
    }
}
