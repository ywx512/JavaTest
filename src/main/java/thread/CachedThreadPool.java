package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: yuweixiong
 * @Date: 2020/7/13 22:12
 * @Description:
 */
public class CachedThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new SimpleRunnable());
        }
        executorService.shutdown();

        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
    }
}
