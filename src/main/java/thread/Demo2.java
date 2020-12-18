package thread;

/**
 * @author yuweixiong
 * @date 2020/12/01 16:17
 * @description
 */
public class Demo2 {
    public static void main(String[] args) {
        Demo2Thread thread = new Demo2Thread();
        thread.start();
        thread.start();
    }

    static class Demo2Thread extends Thread{
        @Override
        public void run() {
            super.run();
            System.out.println("test");
        }
    }
}
