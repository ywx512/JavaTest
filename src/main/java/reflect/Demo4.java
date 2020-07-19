package reflect;

/**
 * @author: yuweixiong
 * @Date: 2020-07-11 17:06:05
 * @Description:
 */
public class Demo4 {
	public static void main(String[] args) {
		Class intClazz = int.class;
		Class<? extends Number> intClazz2 = int.class;
		System.out.println(intClazz2 == int.class);
		intClazz2 = double.class;
		System.out.println(intClazz2 == double.class);
	}
}
