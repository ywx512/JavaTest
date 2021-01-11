package reflect.object;

import java.lang.reflect.Field;

/**
 * @author yuweixiong
 * @date 2021/01/11 15:01
 * @description 对象复制
 */
public class Demo1 {
    private static final User user = new User();

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        User user1 = new User();
        user1.setAge(1);
        copyProperties(user1, user);

        System.out.println("user1: " + user1);
        System.out.println("user: " + user);

        User user2 = new User();
        user2.setName("bbb");

        copyProperties(user2, user);
        System.out.println("user2: " + user2);
        System.out.println("user: " + user);
    }

    /**
     * 复制对象，将源对象的同名字段复制到目标对象
     * @param source
     * @param target
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    public static void copyProperties(Object source, Object target) throws NoSuchFieldException, IllegalAccessException {
        Class sourceClass = source.getClass();
        Field[] sourceFields = sourceClass.getDeclaredFields();

        Class targetClass = target.getClass();

        for (Field field : sourceFields) {
            field.setAccessible(true);
            Object value = field.get(source);
            if (value != null) {
                String fieldName = field.getName();
                Field targetField = targetClass.getDeclaredField(fieldName);
                targetField.setAccessible(true);
                targetField.set(target, value);
            }
        }
    }

    private static class User {
        private Integer age;
        private String name;
        private String password;

        public User() {
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return "User{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
}
