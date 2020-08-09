package callback;

import java.util.Random;

/**
 * @author: yuweixiong
 * @Date: 2020-07-08 21:44:41
 * @Description:
 */
public class SyncBuyer implements OrderResult {
	private Store store;

	private String buyerName;

	private String goodsName;

	/**
	 * @param store
	 * @param buyerName
	 * @param goodsName
	 */
	public SyncBuyer(Store store, String buyerName, String goodsName) {
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
		String goodsState = store.returnOrderGoodsInfo(this);
		System.out.println(goodsState);
		myFeeling();
		return goodsState;
	}

	public void myFeeling() {
		String[] s = { "有点小激动", "很期待!", "希望是个好货!" };
		Random random = new Random();
		int temp = random.nextInt(3);
		System.out.println("我是" + this.getBuyerName() + ", 我现在的感觉: " + s[temp]);
	}

	@Override
	public String getOrderResult(String state) {
		return "store: " + this.getStore().getName() + ", goodsName: " + this.getGoodsName() + ", state: " + state;
	}
}
