package callback;

import java.util.Random;

/**
 * @author: yuweixiong
 * @Date: 2020-07-08 21:40:32
 * @Description:
 */
public class Store {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     */
    public Store() {
        super();
    }

    /**
     * @param name
     */
    public Store(String name) {
        super();
        this.name = name;
    }

    /* 回调函数 */
    public String returnOrderGoodsInfo(OrderResult order) {
        String[] s = {"订购中...", "订购失败", "即将发货!", "运输途中...", "已在投递"};
        Random random = new Random();
        int temp = random.nextInt(5);
        String s1 = s[temp];
        return order.getOrderResult(s1);
    }
}
