package lock;

/**
 * @author yuweixiong
 * @date 2020/12/23 16:37
 * @description
 */
public class Demo1 {

    public static void main(String[] args) {
        int a = 1;

        while (true) {
            if (a < 3) {
                a++;
                System.out.println("a: " + a);
                continue;
            } else {
                System.out.println("end");
                break;
            }

        }


//        Thread thread1 = new Thread(){
//            @Override
//            public void run() {
//                try {
//                    test1();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        Thread thread2 = new Thread(){
//            @Override
//            public void run() {
//                try {
//                    test2();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        thread1.start();
//        thread2.start();
    }

    public static void test1() throws InterruptedException {
        synchronized (Demo1.class) {
            System.out.println("test1 start");
            Thread.sleep(3000);
            System.out.println("test1 end");
        }
    }

    public static void test2() throws InterruptedException {
        synchronized (Demo1.class) {
            System.out.println("test2 start");
            Thread.sleep(3000);
            System.out.println("test2 end");
        }
    }
}
