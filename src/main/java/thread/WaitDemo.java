package thread;

/**
 * @author yuweixiong
 * @date 2020/11/05 10:59
 * @description
 */
public class WaitDemo {
    public static Object publicLock = WaitDemo.class;
    public static boolean netOk = false;

    private static class PublicLockControl extends Thread {
        @Override
        public void run() {
            synchronized (publicLock) {
                try {
                    System.out.println("PublicLockControl 启动");
                    Thread.sleep(3000);
                    netOk = true;
                    publicLock.notifyAll();
                    System.out.println("PublicLockControl 唤醒其他线程");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class T1 extends Thread {
        public void run() {
            synchronized (publicLock) {
                System.out.println(System.currentTimeMillis() + " :T1 启动!");
                try {
                    System.out.println(System.currentTimeMillis() + " :T1等待publicLock锁。。。。。");
                    if (!netOk) {
                        publicLock.wait();
                    }
                    System.out.println("T1被唤醒。。。");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + " T1 end");
            }
        }
    }

    private static class T2 extends Thread {
        public void run() {
            synchronized (publicLock) {
                System.out.println(System.currentTimeMillis() + " :T2 启动!");
                try {
                    System.out.println(System.currentTimeMillis() + " :T2等待publicLock锁。。。。。");
                    if (!netOk) {
                        publicLock.wait();
                    }
                    System.out.println("T2被唤醒。。。");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + " T2 end");
            }
        }
    }

    public static void main(String[] args) {
        PublicLockControl publicLockControl = new PublicLockControl();
        Thread t1 = new T1();
        Thread t2 = new T2();
        publicLockControl.start();
        t1.start();
        t2.start();
    }
}
