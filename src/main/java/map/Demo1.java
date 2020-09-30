package map;

import java.util.HashMap;

/**
 * @author yuweixiong
 * @date 2020/09/24 11:12
 * @description
 */
public class Demo1 {
    public static void main(String[] args){
        HashMap<String, String> map = new HashMap<String, String>(){
            @Override
            public boolean equals(Object o) {
                return super.equals(o);
            }
        };
        map.put("a", "a");
        map.put("c", "c");
        map.put("b", "b");
        System.out.println(map.toString());
    }
}
