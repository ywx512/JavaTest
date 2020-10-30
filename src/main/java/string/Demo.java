package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author yuweixiong
 * @date 2020/09/21 15:41
 * @description
 */
public class Demo {
    public static void main(String[] args) {
        String a = "30_DEV";
        String b = "20_INTERNAL_TEST";
        String c = "10_USER";

        ArrayList<String> list = new ArrayList<>();
        list.add(b);
        list.add(a);
        list.add(c);

        System.out.println(list.toString());

        list.sort(String::compareTo);

        System.out.println(list.toString());

        System.out.println(a.compareTo(b));
        System.out.println(b.compareTo(a));
        System.out.println(c.compareTo(b));
    }
}
