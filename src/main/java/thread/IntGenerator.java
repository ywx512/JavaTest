package thread;

/**
 * @author: yuweixiong
 * @Date: 2020/7/13 22:32
 * @Description:
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
