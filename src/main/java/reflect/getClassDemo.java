package reflect;

/**
 * @author: yuweixiong
 * @Date: 2020-07-11 15:22:11
 * @Description: 获取class类
 */
public class getClassDemo {

    private static class Test {
        void print() {
            System.out.println("test");
        }
    }

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        Test test = new Test();

        Class c1 = test.getClass();

        Class c2 = Test.class;

        Class c3 = null;

        try {
            c3 = Class.forName("reflect.Test");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(c1 == c2);
        System.out.println(c2 == c3);

        try {
            Test test2 = (Test) c1.newInstance();
            test2.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

