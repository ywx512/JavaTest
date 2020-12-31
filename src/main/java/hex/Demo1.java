package hex;

import cn.hutool.core.util.HexUtil;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;

/**
 * @author yuweixiong
 * @date 2020/12/29 11:10
 * @description 大小端转换
 */
public class Demo1 {
    private final static char[] mChars = "0123456789ABCDEF".toCharArray();

    /**
     * bytes转换成十六进制字符串
     *
     * @param bytes byte[] byte数组
     * @return String 每个Byte值之间空格分隔
     */
    public static String bytesToHexStr(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(mChars[(b & 0xFF) >> 4]);
            sb.append(mChars[b & 0x0F]);
        }
        return sb.toString().trim().toUpperCase(Locale.US);
    }

    /**
     * bytes字符串转换为Byte值
     *
     * @param src String Byte字符串，每个Byte之间没有分隔符(字符范围:0-9 A-F)
     * @return byte[]
     */
    public static byte[] hexStrToBytes(String src) {
        src = src.trim().replace(" ", "").toUpperCase(Locale.US);

        int m = 0, n = 0;
        int iLen = src.length() / 2;
        byte[] ret = new byte[iLen];

        for (int i = 0; i < iLen; i++) {
            m = i * 2 + 1;
            n = m + 1;
            ret[i] = (byte) (Integer.decode("0x" + src.substring(i * 2, m) + src.substring(m, n)) & 0xFF);
        }
        return ret;
    }

    /**
     * 获取字节位信息,1为true,0为false
     *
     * @param msg
     * @param index: byte从右数起的第index位
     * @return
     */
    public static boolean getBit(byte msg, int index) {
        byte bit = (byte) ((msg >> index) & (byte) 0x01);
        if (bit == 1) {
            return true;
        }
        return false;
    }

    /**
     * 单个byte的十六进制字符串转byte
     *
     * @param hex
     * @return
     */
    public static byte hexStrToOneByte(String hex) {
        return (byte) (Integer.decode(hex) & 0xFF);
    }

    /**
     * 单个byte转成十六进制字符串
     *
     * @param num
     * @return
     */
    public static String oneByteToHexStr(byte num) {
        StringBuilder sb = new StringBuilder();
        sb.append("0X");
        sb.append(mChars[(num & 0xFF) >> 4]);
        sb.append(mChars[num & 0x0F]);
        return sb.toString().toUpperCase(Locale.US);
    }

    /**
     * 从右边算起，截取byte指定区间位，转成十进制输出 最左位为7位，最右位为0位,第7位为高位，第0位为低位
     * startIndex从最右边数起，到endIndex结束
     *
     * @param msg
     * @param startIndex：区间从startIndex算起，包含该位
     * @param endIndex：区间从endIndex结束，包含该位
     * @return
     */
    public static int getBitValueBaseRight(byte msg, int startIndex, int endIndex) {
        int len = endIndex - startIndex + 1;
        return (msg >> startIndex) & (0xff >> (8 - len));
    }

    /**
     * 从左边算起，截取byte指定区间位，转成十进制输出 最左位为7位，最右位为0位，第7位为高位，第0位为低位
     * startIndex从最左边数起，到endIndex结束
     *
     * @param msg
     * @param startIndex：区间从startIndex算起，包含该位,           startIndex取值：0到7
     * @param endIndex：区间从endIndex结束，包含该位，endIndex取值：0到7
     * @return
     */
    public static int getBitValueBaseLeft(byte msg, int startIndex, int endIndex) {
        return (msg >> (7 - endIndex)) & (0xff >> (7 - endIndex + startIndex));
    }

    /**
     * 将byte数组转成int，支持数组长度为1-4
     *
     * @param bytes，数组必须索引值越小，位数越高，bytes[0]为最高位，bytes[len-1]为最低位
     * @return
     */
    public static int byteToInt(byte[] bytes) {
        int result = 0;
        int len = bytes.length;

        for (int i = 0; i < len; i++) {
            result = (result << 8) | bytes[i] & 0xFF;
        }
        return result;
    }

    /**
     * int转成指定长度的byte数组，数组索引值越小，位数越高，bytes[0]为最高位，bytes[len-1]为最低位
     *
     * @param num
     * @param bytesLen 指定生成byte的数量，范围：1-4
     * @return
     */
    public static byte[] intToByteBaseByteNum(int num, int bytesLen) {
        byte[] bytes = new byte[bytesLen];
        for (int i = 0; i < bytesLen; i++) {
            bytes[i] = (byte) (num >> ((bytesLen - i - 1) * 8));
        }
        return bytes;
    }

    /**
     * int转成指定长度的byte数组，数组索引值越大，位数越高，bytes[len-1]为最高位，bytes[0]为最低位
     * @param num
     * @param bytesLen
     * @return
     */
    public static byte[] intToByteBaseByteNumForLittleEndian(int num, int bytesLen){
        byte[] bytes = new byte[bytesLen];
        for (int i = 0; i < bytesLen; i++) {
            bytes[bytesLen - i -1] = (byte) (num >> ((bytesLen - i - 1) * 8));
        }
        return bytes;
    }

    /**
     * 将byte数组转成int，支持数组长度为1-4
     *
     * @param bytes，数组必须索引值越大，位数越高，bytes[len-1]为最高位，bytes[0]为最低位
     * @return
     */
    public static int byteToIntForLittleEndian(byte[] bytes) {
        int result = 0;
        int len = bytes.length;

        for (int i = 0; i < len; i++) {
            result = result + ((bytes[i] & 0xFF) << (8 * i));
        }
        return result;
    }

    static public String ByteToHex(Byte inByte) {
        return String.format("%02x", inByte).toUpperCase();
    }

    static public String ByteArrToHex(byte[] inBytArr) {
        StringBuilder strBuilder = new StringBuilder();
        int j = inBytArr.length;
        for (int i = 0; i < j; i++) {
            strBuilder.append(ByteToHex(inBytArr[i]));
            // strBuilder.append(" ");
        }
        return strBuilder.toString();
    }

    public static void main(String[] args){
        byte[] b1 = new byte[]{0x01, 0x2C};
        String s1 = bytesToHexStr(b1);
        System.out.println("s1: " + s1);
        int i1 = byteToInt(b1);
        System.out.println("i1: " + i1);
        byte[] b2 = intToByteBaseByteNum(i1, 2);
        System.out.println("b2: " + bytesToHexStr(b2));
        byte[] b22 = intToByteBaseByteNumForLittleEndian(i1, 2);
        System.out.println("b22: " + bytesToHexStr(b22));
        int i3 = ByteBuffer.wrap(b1).order(ByteOrder.BIG_ENDIAN).getShort();
        System.out.println("i3: " + i3);

//        byte[] b3 = new byte[]{0x2C, 0x01};
        byte[] b3 = new byte[]{(byte) 0xFE, (byte) 0xFF};
        byte[] b33 = new byte[]{(byte) 0xFE, (byte) 0xFF,0x00, 0x00};
        int short1 = ByteBuffer.wrap(b3).order(ByteOrder.LITTLE_ENDIAN).getShort();
        System.out.println("short1: " + short1);
        int short2 = ByteBuffer.wrap(b33).order(ByteOrder.LITTLE_ENDIAN).getInt();
        System.out.println("short2: " + short2);
        System.out.println("int 3: " + byteToIntForLittleEndian(b3));

        int test1 = 257;
        byte test2 = (byte) (test1 & 0xFF);
        System.out.println("test2: " + test2);

        byte[] b4 = new byte[]{0x5A , (byte) 0xA5, (byte) 0xA1,0x10 ,0x13 ,0x0E ,0x00 ,0x03 ,0x00 ,0x02 ,0x01 ,0x01 ,
                0x01 ,0x02 ,0x02 ,0x5A ,0x00,0x02 ,0x02 ,0x02};
        String b4Str = ByteArrToHex(b4);
        System.out.println("b4Str: " + b4Str);
    }

    public static class CommandType {
        //模式
        public static final String mode = "mode";
        public static final String speed = "speed";
        public static final String time = "time";
        public static final String temp = "temp";
        //设备是否开启工作
        public static final String deviceStartStatus = "deviceStartStatus";
        //电子秤称重清零
        public static final String scaleClear = "scaleClear";
    }

    //下发指令序列号
    static int seqId = 0;

    /**
     * 下发指令
     * @param key 下发指令类型 {@link CommandType}
     * @param value 指令对应值
     * @param otherSetting 部分指令需要多个参数，如温度的温度单位设置、速度的正反转设置
     */
    public static byte[] writeCommand(String key ,int value, int... otherSetting){
        byte[] data = new byte[12];

        //固定头
        data[0] = (byte)0x5A;
        data[1] = (byte)0xA5;
        //校验位
        data[2] = (byte)0x00;
        //下发指令固定值
        data[3] = (byte)0x00;

        seqId++;
        if(seqId>255){
            seqId = 1;
        }
        //序列号
        data[4] = (byte) seqId;

        if(key.equals(CommandType.mode)){
            //消息体长度
            data[5] = 0x04;
            data[6] = 0x00;
            //消息体成员数
            data[7] = 0x01;

            data[8] = 0x00;
            data[9] = 0x02;
            data[10] = 0x01;
            data[11] = (byte)value;
        }

        if(key.equals(CommandType.deviceStartStatus)){
            data[5] = 0x04;
            data[6] = 0x00;
            data[7] = 0x01;

            data[8] = 0x05;
            data[9] = 0x02;
            data[10] = 0x01;
            data[11] = (byte)value;
        }

        if(key.equals(CommandType.scaleClear)){
            data[5] = 0x04;
            data[6] = 0x00;
            data[7] = 0x01;

            data[8] = 0x06;
            data[9] = 0x02;
            data[10] = 0x01;
            data[11] = (byte)value;
        }

        if(key.equals(CommandType.time)){
            data[5] = 0x05;
            data[6] = 0x00;
            data[7] = 0x01;

            data[8] = 0x01;
            data[9] = 0x02;
            data[10] = 0x02;

            byte[] newData = new byte[13];
            System.arraycopy(data, 0, newData, 0, 12);
            byte[] timeBytes = intToByteBaseByteNumForLittleEndian(value, 2);
            newData[11] = timeBytes[0];
            newData[12] = timeBytes[1];

            data = newData;
        }

        if(key.equals(CommandType.speed)){
            data[5] = 0x05;
            data[6] = 0x00;
            data[7] = 0x01;

            data[8] = 0x02;
            data[9] = 0x02;
            data[10] = 0x02;

            byte[] newData = new byte[13];
            System.arraycopy(data, 0, newData, 0, 12);
            //正反转
            newData[11] = (byte) otherSetting[0];
            //速度挡位
            newData[12] = (byte) value;

            data = newData;
        }

        if(key.equals(CommandType.temp)){
            data[5] = 0x05;
            data[6] = 0x00;
            data[7] = 0x01;

            data[8] = 0x03;
            data[9] = 0x02;
            data[10] = 0x02;

            byte[] newData = new byte[13];
            System.arraycopy(data, 0, newData, 0, 12);
            //温度单位，华氏度或者摄氏度
            newData[11] = (byte) otherSetting[0];
            //温度值
            newData[12] = (byte) value;

            data = newData;
        }


        //计算校验位
        int check = 0;
        for(int i = 2; i < data.length; i++){
            check += data[i];
        }
        data[2] = (byte) (check & 0xFF);

        //烤
//        data = new byte[]{0x5a, (byte) 0xa5, 0x0b,0x00 ,0x01 ,0x04 ,0x00 ,0x01 ,0x00 ,0x02 ,0x01 ,0x02};
        //揉面
//        data = new byte[]{0x5a, (byte) 0xa5, 0x0A,0x00 ,0x01 ,0x04 ,0x00 ,0x01 ,0x00 ,0x02 ,0x01 ,0x01};
//        data = new byte[]{0x5A , (byte) 0xA5,0x19 ,0x00 ,0x01 ,0x08 ,0x00 ,0x02 ,0x00 ,0x02 ,0x01 ,0x02 ,0x05 ,0x02 ,0x01 ,0x01};
        return data;
    }

//    public static void main(String[] args){
//        byte[] a = writeCommand(CommandType.mode, 1);
//        System.out.println("a: " + bytesToHexStr(a));
//    }
}
