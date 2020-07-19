package thread;

/**
 * @author: yuweixiong
 * @Date: 2020/7/13 22:43
 * @Description: 递增不是原子操作
 */
public class EvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    @Override
    public int next() {
//        synchronized (EvenChecker.class) {
//            ++currentEvenValue;
//            ++currentEvenValue;
//            return currentEvenValue;
//        }

        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
