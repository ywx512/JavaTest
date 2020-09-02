package atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yuweixiong
 * @date 2020/09/02 09:51
 * @Description
 */
public class Demo1 {
    private static final int THREADS_COUNT = 5;

    public static int count = 0;
    public static volatile int countVolatile = 0;
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void increase() {
//        count++;
        increaseCount();
        countVolatile++;
        increaseAtomic();
    }

    public static synchronized void increaseCount(){
        count++;
    }

    public static synchronized void increaseAtomic(){
        int atomicResult = atomicInteger.incrementAndGet();
        if (atomicResult >= 100) {
            atomicInteger.set(0);
//            System.out.println("atomicResult:" + 0);
        } else {
//            System.out.println("atomicResult:" + atomicResult);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int i1 = 0; i1 < 1000; i1++) {
                    increase();
                }
                countDownLatch.countDown();
            });
            threads[i].start();
        }

        countDownLatch.await();

        System.out.println(count);
        System.out.println(countVolatile);
        System.out.println(atomicInteger.get());
    }
}
