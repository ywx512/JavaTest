package classinfo;

/**
 * @author yuweixiong
 * @date 2021/01/18 18:26
 * @description
 */
public class ClassInfoDemo11 {
    public static void test1() {
        System.out.println("ClassInfoDemo11 test1 for sysout start");
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTraceElements.length; i++) {
            System.out.println("i: " + i + ", " + stackTraceElements[i].toString());
        }
        System.out.println("ClassInfoDemo11 test1 for sysout end");

        System.out.println("ClassInfoDemo11 test1 currentThread: " + Thread.currentThread().getName());

        String className = new Exception().getStackTrace()[1].getClassName();
        System.out.println("ClassInfoDemo11 test1 class name: " + className);

        StackTraceElement[] stackTraceElements1 = (new Exception()).getStackTrace();
        for (int i = 0; i < stackTraceElements1.length; i++) {
            System.out.println("ClassInfoDemo11 test1 i: " + i + ", " + stackTraceElements1[i].toString());
        }
    }

    public static void test2() {
        System.out.println("ClassInfoDemo11 test2 for sysout start");
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTraceElements.length; i++) {
            System.out.println("i: " + i + ", " + stackTraceElements[i].toString());
        }
        System.out.println("ClassInfoDemo11 test2 for sysout end");
        String className = new Exception().getStackTrace()[1].getClassName();
        System.out.println("ClassInfoDemo11 test2 class name: " + className);

        StackTraceElement[] stackTraceElements1 = (new Exception()).getStackTrace();
        for (int i = 0; i < stackTraceElements1.length; i++) {
            System.out.println("ClassInfoDemo11 test2 i: " + i + ", " + stackTraceElements1[i].toString());
        }
    }
}
