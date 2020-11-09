package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuweixiong
 * @date 2020/11/05 11:41
 * @description
 */
public class ConditionDemo {
    private static Lock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static boolean isNetOk = false;

    private static class NetThread extends Thread {
        @Override
        public void run() {
            System.out.println("网络连接start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            connetNetSuccess();
            System.out.println("网络连接成功");
        }
    }

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            System.out.println("thread1 start");
            waitNetOk();
            System.out.println("thread1 end");
        }
    }

    private static class Thread2 extends Thread {
        @Override
        public void run() {
            System.out.println("thread2 start");
            waitNetOk();
            System.out.println("thread2 end");
        }
    }

    private static void connetNetSuccess() {
        lock.lock();
        isNetOk = true;
        condition1.signalAll();
        lock.unlock();
    }

    private static void waitNetOk() {
        lock.lock();
        try {
            if (!isNetOk) {
                condition1.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        NetThread netThread = new NetThread();
        netThread.start();
        thread1.start();
        thread2.start();
    }
}
