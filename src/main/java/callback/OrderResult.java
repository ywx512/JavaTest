package callback;

/**
 * @author: yuweixiong
 * @Date: 2020-07-08 21:30:00
 * @Description:
 */
public interface OrderResult {

    /**
     * @param state
     * @return
     * @Description:订购货物的状态
     */
    String getOrderResult(String state);
}
