package string;

/**
 * @author yuweixiong
 * @date 2021/01/18 14:15
 * @description
 */
public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder(100);
        builder.append("123456");
        System.out.println(builder.length());
        System.out.println(builder.capacity());
        System.out.println(builder.toString());
        builder.delete(0, builder.length());
        System.out.println(builder.length());
        System.out.println(builder.capacity());
        System.out.println(builder.toString());
        builder.append("abc");
        System.out.println(builder.length());
        System.out.println(builder.capacity());
        System.out.println(builder.toString());
    }
}
