package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: yuweixiong
 * @Date: 2020/7/13 21:51
 * @Description:
 */
public class Demo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Demo11.class;

        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.toString());
        }

        System.out.println("======================================");

        Method[] methods1 = clazz.getDeclaredMethods();
        for (Method method : methods1) {
            System.out.println(method.toString());
        }
        System.out.println("======================================");

        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        System.out.println("======================================");

        Field[] fields1 = clazz.getDeclaredFields();
        for (Field field : fields1) {
            System.out.println(field.getName());
        }

        System.out.println("======================================");

        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.toString());
        }

        System.out.println("======================================");
        Constructor[] constructors1 = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors1) {
            System.out.println(constructor.toString());
        }
    }
}

class Demo11 {
    private String str1;

    public String str2;

    private Integer num1;

    public Integer num2;

    public Demo11(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    private Demo11(String str2, Integer num1) {
        this.str2 = str2;
        this.num1 = num1;
    }

    private void print(String s1) {
        System.out.println(s1);
    }

    public void print(String s2, Integer num1) {
        System.out.println(s2);
    }
}
