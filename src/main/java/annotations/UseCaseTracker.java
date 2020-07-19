package annotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: yuweixiong
 * @Date: 2020/7/12 23:54
 * @Description: 注解处理器
 */
public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCases, Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            UseCase uc = method.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("found Use case: " + uc.id() + ", " + uc.description());
                useCases.remove(new Integer((uc.id())));
            }
        }

        for (int i : useCases) {
            System.out.println("Warning: missing use case: " + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 1, 2, 3, 4);
        trackUseCases(useCases, PasswordUtils.class);
    }
}
