package reflect;

import java.util.Random;

/**
 * @author: yuweixiong
 * @Date: 2020-07-11 16:30:41
 * @Description:
 */
public class Demo3 {
	public static Random random = new Random(40);
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class c1 = Test31.class;
		System.out.println("after create Test31 ref");
		System.out.println("Test31.num1:"+Test31.num1);
		System.out.println("Test31.num2:"+Test31.num2);
		
		/**
		 * 强制进行类的初始化
		 */
		System.out.println("Test32.num1:"+Test32.num1);
		
		/**
		 * 该方法会立即进行初始化
		 */
		Class c2 = Class.forName("reflect.Test33");
		System.out.println("after create Test33 ref");
		System.out.println("Test33.num1:"+Test33.num1);
	}
}

class Test31{
	/**
	 * 加了final，为编译期常量，会在获取类的引用时读取
	 */
	static final int num1 = 1;
	static final int num2 = Demo3.random.nextInt(10);
	static {
		System.out.println("init test31");
	}
}

class Test32{
	/**
	 * 没有final，对类的引用不会引发初始化
	 */
	static int num1 = 2;
	static {
		System.out.println("init test32");
	}
}

class Test33{
	static int num1 = 22;
	static {
		System.out.println("init test33");
	}
}
