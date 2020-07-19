package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: yuweixiong
 * @Date: 2020/7/13 23:05
 * @Description:
 */
public class Demo {
    public volatile static int id = 0;

    public static AtomicInteger atomicInter = new AtomicInteger(0);

    public static void main(String[] args) {
//        ThreadDemo1 threadDemo1 = new ThreadDemo1();
//        ThreadDemo2 threadDemo2 = new ThreadDemo2();
//        threadDemo1.start();
//        threadDemo2.start();
        ThreadDemo3 threadDemo3 = new ThreadDemo3();
        ThreadDemo4 threadDemo4 = new ThreadDemo4();
        threadDemo3.start();
        threadDemo4.start();
    }
}

class ThreadDemo1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("thread: " + getName() + "(start)" + ", " + Demo.id);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread: " + getName() + "(end)" + ", " + Demo.id);
        }
    }
}

class ThreadDemo2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("thread: " + getName() + ", " + Demo.id++);
        }
    }
}

class ThreadDemo3 extends Thread {
    private int threadNum = 0;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("thread: " + getName() + "(start)" + ", " + Demo.atomicInter.get());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread: " + getName() + "(end)" + ", " + Demo.atomicInter.get());
        }
    }
}

class ThreadDemo4 extends Thread {
    private int threadNum = 0;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("thread: " + getName() + ", " + Demo.atomicInter.incrementAndGet());
        }
    }
}
