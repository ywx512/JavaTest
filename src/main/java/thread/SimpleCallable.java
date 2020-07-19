package thread;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author: yuweixiong
 * @Date: 2020/7/13 22:22
 * @Description:
 */
public class SimpleCallable implements Callable<String> {
    private int id;

    public SimpleCallable(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result" + id;
    }
}

class CallableDemo{
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(executorService.submit(new SimpleCallable(i)));
        }

        for(Future<String > future : results){
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                executorService.shutdown();
            }
        }
    }
}
