package list;

import java.util.*;

/**
 * @author yuweixiong
 * @date 2021/03/01 15:58
 * @description
 */
public class Demo1 {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    static void test1() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString());
                System.out.println(list);
            }).start();
        }
    }

    static void test2() {
        List<Object> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString());
                synchronized (list) {
                    Iterator iterator = list.iterator();
                    while (iterator.hasNext()) {
                        String str = (String) iterator.next();
                        System.out.println(str);
                    }
                }
            }).start();
        }
    }
}
