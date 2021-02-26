package classinfo;

/**
 * @author yuweixiong
 * @date 2021/01/18 18:26
 * @description
 */
public class ClassInfoDemo12 {
    public static void test1() {
        String className = new Exception().getStackTrace()[1].getClassName();
        System.out.println("ClassInfoDemo12 test1 class name: " + className);
        StackTraceElement element = Thread.currentThread().getStackTrace()[1];
        StackTraceElement element2 = Thread.currentThread().getStackTrace()[2];
        System.out.println("ClassInfoDemo12 test1 class all: " + element.toString());
        System.out.println("ClassInfoDemo12 test1 class all2: " + element2.toString());
        ClassInfoDemo11.test1();
    }

    public static void test2() {

        String className = new Exception().getStackTrace()[1].getClassName();
        System.out.println("ClassInfoDemo12 test2 class name: " + className);
    }
}
