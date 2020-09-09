package exception;

import java.io.IOException;

/**
 * @author yuweixiong
 * @date 2020/09/09 16:23
 * @description
 */
public class Demo {
    public static void main(String[] args) {
        try {
            throw new IOException(new Throwable("1", new Throwable("2")));
        } catch (IOException e) {
            System.out.println(e.getClass().getName());

            System.out.println(e.getCause().getClass().getName());
            System.out.println(e.getCause().getMessage());

            System.out.println(e.getCause().getCause().getClass().getName());
            System.out.println(e.getCause().getCause().getMessage());
        }
    }
}
