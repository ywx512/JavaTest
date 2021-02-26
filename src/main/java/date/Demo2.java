package date;

import cn.hutool.core.date.DateUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author yuweixiong
 * @date 2020/11/16 15:36
 * @description
 */
public class Demo2 {
    public static void main(String[] args){
        Date date = new Date();
        String fileName = new StringBuilder(DateUtil.format(new Date(), "yyyyMMddHHmmss"))
                .toString();
        System.out.println(fileName);

        Date date2 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
    }
}
