package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yuweixiong
 * @date 2021/01/19 14:59
 * @description
 */
public class Demo3 {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 100, 1, TimeUnit.MINUTES,
             new LinkedBlockingQueue<>(1000));

    public static void main(String[] args){
        test();
    }

    public static void test2(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    public static void test() {
        while (true) {
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    String dateString = simpleDateFormat.format(new Date());
                    try {
                        Date parseDate = simpleDateFormat.parse(dateString);
                        String dateString2 = simpleDateFormat.format(parseDate);
                        System.out.println(dateString.equals(dateString2));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
