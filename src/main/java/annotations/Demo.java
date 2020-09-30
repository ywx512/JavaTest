package annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author yuweixiong
 * @date 2020/09/21 17:25
 * @description
 */
public class Demo {
    public static void main(String[] args){
        System.out.println(test(Test.class));
    }

    public static String test(Class<? extends Annotation> clazz){
        Method[] methods = clazz.getMethods();
        methods[0].getAnnotation(clazz);
        return clazz.getName();
    }
}
