package date;

import cn.hutool.core.date.DateUtil;

import java.util.Date;

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
    }
}
