package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author yuweixiong
 * @date 2020/10/19 09:14
 * @description
 */
public class Demo2 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(2);
        list1.add(3);
        list1.add(1);

        System.out.println(list1.toString());
//        list1.sort((o1, o2) -> o1 - o2);
        System.out.println(list1.toString());
        List<Integer> list2 = list1.stream().filter(integer -> integer <= 3).collect(Collectors.toList());
        System.out.println(list1);
        System.out.println(list2);
    }
}
