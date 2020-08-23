package genericity;

/**
 * @author: yuweixiong
 * @Date: 2020/8/9 23:18
 * @Description:
 */
public class TupleDemo1Test {
    static TupleDemo1<String, Integer> f() {
        return new TupleDemo1<>("a", 1);
    }

    public static void main(String[] args) {
        System.out.println(f());
    }
}
