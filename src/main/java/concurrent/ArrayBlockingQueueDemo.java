package concurrent;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author yuweixiong
 * @date 2021/03/05 16:56
 * @description
 */
@Slf4j
public class ArrayBlockingQueueDemo {
    private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(100);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            queue.add("i" + i);
        }

        test();

        while (true) {
            String take = queue.take();
            log.info("take: " + take);
        }
    }

    private static void test() throws InterruptedException {
        new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            queue.add("test1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            queue.add("test2");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            queue.add("test3");
        }).start();
    }
}
