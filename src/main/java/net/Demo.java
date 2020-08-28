package net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.*;

/**
 * @author yuweixiong
 * @date 2020/08/21 09:35
 * @Description
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        InetAddress newAddress = InetAddress.getByName("www.sp.sunmitech.com");
        System.out.println(newAddress.getHostName());
        System.out.println(newAddress.getHostAddress());

        InetAddress newAddress2 = InetAddress.getByName("www.image.sunmitech.com");
        System.out.println(newAddress2.getHostName());
        System.out.println(newAddress2.getHostAddress());

        Socket socket = new Socket();
        SocketAddress address = new InetSocketAddress("183.24.62.130", 10010);
        socket.connect(address, 5000);
        System.out.println(socket.isConnected());
        System.out.println(socket.isBound());
        System.out.println(socket.isClosed());
        System.out.println(socket.getPort());
        System.out.println(socket.getRemoteSocketAddress());
        socket.close();
    }
}
