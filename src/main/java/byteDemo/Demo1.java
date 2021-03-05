package byteDemo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuweixiong
 * @date 2021/03/05 10:02
 * @description
 */
public class Demo1 {
    public static void main(String[] args){
        String str1 = "0x02";
        byte b1 = ByteUtil.hexStrToOneByte(str1);
        System.out.println(b1);
        String str2 = "0x0A";
        byte b2 = ByteUtil.hexStrToOneByte(str2);
        System.out.println(b2);
        String str3 = "020A";
        byte[] b3 = ByteUtil.hexStrToBytes(str3);
        for(byte b : b3){
            System.out.println(b);
        }
    }
}
