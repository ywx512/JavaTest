package reflect;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yuweixiong
 * @Date: 2020-07-12 15:32:46
 * @Description:
 */
public class TypeCounter extends HashMap<Class<?>, Integer> {
    private Class<?> baseType;

    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        for (Pet pet : Pet.createArray(10)) {
            System.out.println(pet.getClass().getSimpleName());
            counter.count(pet);
        }

        System.out.println(counter);
    }

    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    public void count(Object obj) {
        Class<?> type = obj.getClass();
        if (!baseType.isAssignableFrom(type)) {
            throw new RuntimeException(obj + " incorrect type: " + type + ", should be type or subtype of " + baseType);
        }
        countClass(type);
    }

    private void countClass(Class<?> type) {
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : quantity + 1);
        Class<?> superClass = type.getSuperclass();
        if (superClass != null && baseType.isAssignableFrom(superClass)) {
            countClass(superClass);
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Class<?>, Integer> pair : entrySet()) {
            result.append(pair.getKey().getSimpleName());
            result.append("=");
            result.append(pair.getValue());
            result.append(",");
        }
        result.delete(result.length() - 1, result.length());
        return result.toString();
    }
}
