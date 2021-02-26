package classinfo;

/**
 * @author yuweixiong
 * @date 2021/01/18 18:24
 * @description 获取调用者的Class类信息
 */
public class ClassInfoDemo1 {
    public static void main(String[] args) throws InterruptedException {
        test1();
        test2();

        Thread thread1 = new Thread(Thread.currentThread().getStackTrace()[1].getClassName() + "thread-1") {
            @Override
            public void run() {
                test1();
                test2();
            }
        };

        Thread thread2 = new Thread(Thread.currentThread().getStackTrace()[1].getClassName() + "thread-2") {
            @Override
            public void run() {
                test1();
                test2();
            }
        };

        System.out.println("start thread1");
        thread1.start();

        Thread.sleep(2000);
        System.out.println("start thread2");

        thread2.start();
    }

    public static void test1() {
//        System.out.println("ClassInfoDemo1 for sysout start");
//        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//        for (int i = 0; i < stackTraceElements.length; i++) {
//            System.out.println("i: " + i + ", " + stackTraceElements[i].toString());
//        }
//        System.out.println("ClassInfoDemo11 for sysout end");
//        String className = new Exception().getStackTrace()[1].getClassName();
//        System.out.println("ClassInfoDemo1 test1 class name: " + className);
//
//        StackTraceElement[] stackTraceElements1 = (new Exception()).getStackTrace();
//        for (int i = 0; i < stackTraceElements1.length; i++) {
//            System.out.println("ClassInfoDemo1 i: " + i + ", " + stackTraceElements1[i].toString());
//        }

        ClassInfoDemo11.test2();
    }

    public static void test2() {
//        System.out.println("ClassInfoDemo1 for sysout start");
//        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//        for (int i = 0; i < stackTraceElements.length; i++) {
//            System.out.println("i: " + i + ", " + stackTraceElements[i].toString());
//        }
//        System.out.println("ClassInfoDemo11 for sysout end");
//        String className = new Exception().getStackTrace()[1].getClassName();
//        System.out.println("ClassInfoDemo1 test2 class name: " + className);

        ClassInfoDemo12.test1();
        ClassInfoDemo12.test2();
    }
}
