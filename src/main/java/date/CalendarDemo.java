package date;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * @author yuweixiong
 * @date 2021/01/19 14:12
 * @description
 */
public class CalendarDemo {
    public static void main(String[] args) throws InterruptedException {
        TimeZone zone = TimeZone.getTimeZone("GMT+08:00");
        Calendar calendar = Calendar.getInstance(zone);
        test(calendar);
        Thread.sleep(2000);
        test(calendar);
    }

    private static void test(Calendar calendar){
        int i1 = calendar.get(Calendar.YEAR);
        int i2 = calendar.get(Calendar.MONTH) + 1;
        int i3 = calendar.get(Calendar.DAY_OF_MONTH);
        int i4 = calendar.get(Calendar.HOUR_OF_DAY);
        int i5 = calendar.get(Calendar.MINUTE);
        int i6 = calendar.get(Calendar.SECOND);
        System.out.println(i1 + "," + i2 + "," + i3 + "," + i4 + "," + i5 + "," + i6);
    }
}
