package sort;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author yuweixiong
 * @date 2020/09/24 11:28
 * @description
 */
public class Demo1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("a");
        System.out.println(list.toString());
//        list.sort(String::compareTo);
        list.sort(new ItemComparator());
        System.out.println(list.toString());
    }

    private static class ItemComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }
}
