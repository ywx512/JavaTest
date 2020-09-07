package concurrent.wait;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

/**
 * @author yuweixiong
 * @date 2020/09/03 09:52
 * @Description
 */
public class Demo1 {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1("t1");
        System.out.println("t1:" + t1);
        synchronized (t1) {
            try {
                //启动线程
                System.out.println(Thread.currentThread().getName() + " start t1");
                t1.start();
                //主线程等待t1通过notify唤醒。
                System.out.println(Thread.currentThread().getName() + " wait()" + new Date());
                t1.wait();// 不是使t1线程等待，而是当前执行wait的线程等待
                System.out.println(Thread.currentThread().getName() + " continue" + new Date());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread1 extends Thread {

    public Thread1(@NotNull String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("this:" + this);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " call notify()");
            this.notify();
        }
    }
}
