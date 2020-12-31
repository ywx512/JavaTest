package invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @author yuweixiong
 * @date 2020/12/28 14:12
 * @description MethodHandle Demo
 */
public class Demo1 {
    public static void main(String[] args) throws Throwable {
        Demo1 demo1 = new Demo1();
        MethodHandle methodHandle = getHandler();
        String result = (String) methodHandle.invokeExact(demo1, new Integer(123));
        System.out.println(result);
    }

    public static MethodHandle getHandler(){
        MethodType methodType = MethodType.methodType(String.class, Integer.class);
        MethodHandle methodHandle = null;
        try {
            methodHandle = MethodHandles.lookup().findVirtual(Demo1.class, "toString", methodType);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return methodHandle;
    }

    public String toString(Integer a) {
        return "Demo1{} + a: " + a;
    }
}
