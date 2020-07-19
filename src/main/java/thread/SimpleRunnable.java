package thread;

/**
 * @author: yuweixiong
 * @Date: 2020/7/13 22:12
 * @Description:
 */
public class SimpleRunnable implements Runnable {
    protected int count = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public SimpleRunnable() {
    }

    public SimpleRunnable(int count) {
        this.count = count;
    }

    public String status() {
        return "#" + id;
    }

    @Override
    public void run() {
        while (count-- > 0) {
            System.out.println(status());
        }
    }
}
