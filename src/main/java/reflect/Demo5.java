package reflect;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yuweixiong
 * @param <T>
 * @Date: 2020-07-11 17:12:08
 * @Description:
 */
public class Demo5<T> {
	private Class<T> type;

	public Demo5(Class<T> type) {
		this.type = type;
	}

	public List<T> create(int nElem) {
		List<T> result = new ArrayList<T>();
		try {
			for (int i = 0; i < nElem; i++) {
				result.add(type.newInstance());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		Demo5<Demo51> demoList = new Demo5<Demo51>(Demo51.class);
		System.out.println(demoList.create(5));
	}
}

class Demo51 {
	private static long count;
	private final long id = count++;

	public String toString() {
		return Long.toString(id);
	}
}