package genericity;

/**
 * @author: yuweixiong
 * @Date: 2020/8/9 23:15
 * @Description: 元组
 */
public class TupleDemo1<A, B> {
    public final A first;
    public final B second;

    public TupleDemo1(A a, B b) {
        first = a;
        second = b;
    }

    @Override
    public String toString() {
        return "TupleDemo1{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
