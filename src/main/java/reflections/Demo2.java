package reflections;

import reflections.annotation.Action;

import java.util.List;
import java.util.Set;

/**
 * @author: yuweixiong
 * @Date: 2020/7/14 0:06
 * @Description:
 */
public class Demo2 {

    public static void main(String[] args) throws Exception {
        System.out.println(Demo2.class.getResource(""));
        System.out.println(Demo2.class.getResource("/"));
        System.out.println(Demo2.class.getClassLoader().getResource(""));
        System.out.println(Demo2.class.getClassLoader().getResource("/"));
        System.out.println(Demo2.class.getName());
        System.out.println(Demo2.class.getSimpleName());
        System.out.println(Demo2.class.getCanonicalName());

        Set<Class<?>> entityNames = new ScannerDemo().scanAnnotationClasses("reflections", Action.class);
        System.out.println("entityNames: " + entityNames.size());
        for (Class clazz : entityNames) {
            System.out.println("end: " + clazz.getSimpleName());
        }
    }
}
