package scheduleTime;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author yuweixiong
 * @date 2020/09/02 15:21
 * @Description
 */
public class ScheduleTime {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("111");
            }
        }, 0, 1, TimeUnit.SECONDS);

        Thread.sleep(3000);
        scheduledExecutorService.shutdown();
    }
}
