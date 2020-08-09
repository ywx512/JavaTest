package callback;

/**
 * @author: yuweixiong
 * @Date: 2020-07-08 21:49:08
 * @Description:
 */
public class TestCallback {

	public static void main(String[] args) {
		Store store = new Store("store_1");
		SyncBuyer syncBuyer = new SyncBuyer(store, "buyerName_1", "goodsName_1");
		System.out.println(syncBuyer.orderGoods());

//		Store store2 = new Store("store_2");
//		NoSyncBuyer noSyncBuyer = new NoSyncBuyer(store2, "buyerName_1", "goodsName_1");
//		System.out.println(noSyncBuyer.orderGoods());
	}
}
