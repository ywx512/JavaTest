package thread.lock;

import java.util.concurrent.CountDownLatch;

/**
 * @author yuweixiong
 * @date 2021/01/07 16:56
 * @description
 */
public class Demo {
    private static CountDownLatch countDownLatch = new CountDownLatch(0);

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            while (true) {
                System.out.println("thread1 start");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println("thread1 end");
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                System.out.println("thread2 start");
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 run");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                countDownLatch = new CountDownLatch(1);
                System.out.println("thread2 end");
            }
        });

        thread1.start();
        thread2.start();
    }

}
