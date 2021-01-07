package process;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author yuweixiong
 * @date 2021/01/05 11:27
 * @description ping demo
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        test();
        boolean ping = ping("www.baidu.com");
        System.out.println("ping: " + ping);
    }

    public static void test(){
        Runtime runtime = Runtime.getRuntime();
        try {
            long start = System.currentTimeMillis();
            System.out.println("start");
            Process p = runtime.exec("ping www.baidu.com");
            int ret = p.waitFor();
            long end = System.currentTimeMillis();
            System.out.println("time: " + (end - start));
            System.out.println("ret: " + ret);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean ping(String ipAddress) throws IOException {
        int  timeOut =  3000 ;
        boolean status = InetAddress.getByName(ipAddress).isReachable(timeOut);
        return status;
    }
}
