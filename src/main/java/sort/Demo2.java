package sort;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author yuweixiong
 * @date 2020/10/21 11:15
 * @description
 */
public class Demo2 {
    public static void main(String[] args) {
        String a = "102";
        String b = "100";
        String c = "101";

        ArrayList<String> list = new ArrayList<>();
        list.add(a);
        list.add(c);
        list.add(b);

        System.out.println(list.toString());
//        list.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return Integer.valueOf(o1) - Integer.valueOf(o2);
//            }
//        });
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list.toString());
    }
}
