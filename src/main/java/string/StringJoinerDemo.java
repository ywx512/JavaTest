package string;

import java.util.StringJoiner;

/**
 * @author yuweixiong
 * @date 2021/01/06 17:25
 * @description
 */
public class StringJoinerDemo {
    public static void main(String[] args){
        StringJoiner joiner = new StringJoiner(";", "[", "]");
        joiner.add("a").add("b").add("C");

        System.out.println(joiner.toString());
    }
}
