package pattern;

import java.util.regex.Pattern;

/**
 * @author: yuweixiong
 * @Date: 2020/8/23 13:59
 * @Description:
 */
public class Demo1 {
    public static void main(String[] args) {
        String[] dateList = {"2020-02-02 20:20:20", "2020-02-02", "20:20:20"};

        String regex_date_time = "^([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-((" +
                "(0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-" +
                "(0[1-9]|[1][0-9]|2[0-8])))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
        String regex_date = "^([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-((" +
                "(0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-" +
                "(0[1-9]|[1][0-9]|2[0-8])))$";
        String regex_time = "^([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";

        for (String date : dateList) {
            boolean result1 = Pattern.matches(regex_date_time, date);
            System.out.println(date + ", date_time: " + result1);
            boolean result2 = Pattern.matches(regex_date, date);
            System.out.println(date + ", date: " + result2);
            boolean result3 = Pattern.matches(regex_time, date);
            System.out.println(date + ", time: " + result3);
        }

    }
}
