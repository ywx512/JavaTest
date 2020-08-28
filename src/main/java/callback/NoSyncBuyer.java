package callback;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * @author: yuweixiong
 * @Date: 2020-07-08 21:51:49
 * @Description:
 */
public class NoSyncBuyer implements OrderResult {
    private Store store;

    private String buyerName;

    private String goodsName;

    /**
     * @param store
     * @param buyerName
     * @param goodsName
     */
    public NoSyncBuyer(Store store, String buyerName, String goodsName) {
        super();
        this.store = store;
        this.buyerName = buyerName;
        this.goodsName = goodsName;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String orderGoods() {
        String goodsState = "---";
        MyRunnable myRunnable = new MyRunnable();
        Thread myThread = new Thread(myRunnable);
        myThread.start();

        System.out.println(goodsState);
        goodsState = myRunnable.getResult();
        myFeeling();
        return goodsState;
    }

    // 开启另一个线程, 但是没有返回值, 怎么回事
    // 调试的时候, 等待一会儿, 还是可以取到值, 但不是立即取到, 在print显示的时候, 却是null, 需要注意?
    private class MyRunnable implements Runnable {
        private String result;

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(10000);
                result = store.returnOrderGoodsInfo(NoSyncBuyer.this);// 匿名函数的时候, 无法return 返回值
            } catch (InterruptedException e) {
                System.out.println("出大事了, 异步回调有问题了");
            }
        }
    }

    public class MyRunnable2 implements Callable<String> {

        private String result;

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        @Override
        public String call() throws Exception {
            try {
                Thread.sleep(2000);
                result = store.returnOrderGoodsInfo(NoSyncBuyer.this);// 匿名函数的时候, 无法return 返回值
            } catch (InterruptedException e) {
                System.out.println("出大事了, 异步回调有问题了");
            }
            return result;
        }

    }

    public void myFeeling() {
        String[] s = {"有点小激动", "很期待!", "希望是个好货!"};
        Random random = new Random();
        int temp = random.nextInt(3);
        System.out.println("我是" + this.getBuyerName() + ", 我现在的感觉: " + s[temp]);
    }

    @Override
    public String getOrderResult(String state) {
        return "store: " + this.getStore().getName() + ", goodsName: " + this.getGoodsName() + ", state: " + state;
    }
}
