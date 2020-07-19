package reflect;

/**
 * @author: yuweixiong
 * @Date: 2020-07-11 15:54:36
 * @Description:
 */
public class Demo2 {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Class c = null;
		try {
			c = Class.forName("reflect.Demo22");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		printInfo(c);

		System.out.println("start for");
		for (Class clazz : c.getInterfaces()) {
			printInfo(clazz);
		}
		System.out.println("end for");

		Class up = c.getSuperclass();

		Demo21 obj = null;
		try {
			obj = (Demo21) up.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}


		if(obj instanceof Demo22) {
			System.out.println("instanceOf demo2");
		}else {			
			System.out.println("not instanceOf demo2");
		}
		
		printInfo(obj.getClass());
		obj.print();
		
		/**
		 * 正确的写法生成对应类的父类的实例
		 */
		Class<Demo22> demo22Clazz = Demo22.class;
		Demo22 demo22 = demo22Clazz.newInstance();
		Class<? super Demo22> up2 = demo22Clazz.getSuperclass();
		Object obj2 = up2.newInstance();


		/**
		 * 不建议使用该方式，请使用上面的方式
		 */
		@SuppressWarnings("unchecked")
		Class<Demo21> demo21 = (Class<Demo21>) demo22Clazz.getSuperclass();
	}

	static void printInfo(Class clazz) {
		System.out.println("Class name: " + clazz.getName());
		System.out.println("is interface: " + clazz.isInterface());
		System.out.println("SimpleName: " + clazz.getSimpleName());
		System.out.println("Canonical Name: " + clazz.getCanonicalName());
	}
}

class Demo22 extends Demo21 implements interface1, interface2 {

	/** 
	 * 
	 */
	public Demo22() {
		System.out.println("print Demo22 constructor");
	}

	@Override
	void print() {
		System.out.println("print Demo22");
	}

}

class Demo21 {
	/** 
	 * 
	 */
	public Demo21() {
		System.out.println("print Demo21 constructor");
	}

	void print() {
		System.out.println("print Demo21");
	};
}

interface interface1 {

}

interface interface2 {

}
