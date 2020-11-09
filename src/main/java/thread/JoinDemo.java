package thread;

/**
 * @author yuweixiong
 * @date 2020/11/05 10:55
 * @description
 */
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        // 创建child对象，此时child表示的线程处于NEW状态
        Child child = new Child();
        // child表示的线程转换为RUNNABLE状态
        child.start();
        System.out.println("child start");

        // 等待child线程运行完再继续运行
        child.join();

        System.out.println("child end");
    }

    private static class Child extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
