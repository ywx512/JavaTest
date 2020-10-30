package pattern;

import java.util.regex.Pattern;

/**
 * @author yuweixiong
 * @date 2020/10/14 18:41
 * @description
 */
public class Demo2 {
    public static void main(String[] args){
        boolean test = Pattern.matches("CC1AC44EEA1DC622BEF6F55224554C7C|7C4D019C3A660DD6FCE5504C4B48EF90",
                "7C4D019C3A660DD6FCE5504C4B48EF90");
        System.out.println(test);
    }
}
