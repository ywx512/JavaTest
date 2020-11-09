package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yuweixiong
 * @date 2020/11/05 10:43
 * @description
 */
public class CountDownLatchDemo {

    private static int num = 10;
    public static CountDownLatch begin = new CountDownLatch(1);
    public static CountDownLatch end = new CountDownLatch(num);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(num);

        for (int i = 0; i < num; i++) {
            final int NO = i + 1;
            Runnable runnable = () -> {
                try {
                    begin.await();
                    Thread.sleep((long) (Math.random() * 10000));
                    System.out.println("No." + NO + " arrived");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    end.countDown();
                }
            };
            executorService.submit(runnable);
        }

        System.out.println("Game Start ...");
        begin.countDown();
        end.await();
        System.out.println("Game Over.");

        executorService.shutdown();
    }
}
