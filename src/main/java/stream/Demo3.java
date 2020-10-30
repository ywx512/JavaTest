package stream;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author yuweixiong
 * @date 2020/10/19 09:25
 * @description
 */
public class Demo3 {
    public static void main(String[] args){
        TreeMap<String, Integer> map1 = new TreeMap<>();
        map1.put("999_ADMIN", 5);
        map1.put("899_DEV", 1);
        map1.put("799_CUSTOM", 3);
        map1.put("599_INTERNAL_TEST", 2);
        map1.put("399_USER", 4);
        map1.put("389_USER", 4);
        map1.put("300_USER", 4);

        System.out.println(map1.toString());
        Map<String,Integer> map2 = map1.tailMap("799_CUSTOM", true);
        System.out.println(map2);
    }
}
