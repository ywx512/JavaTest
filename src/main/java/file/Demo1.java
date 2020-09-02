package file;

import java.io.*;

/**
 * @author yuweixiong
 * @date 2020/09/01 14:20
 * @Description
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        File file = new File("data.txt");
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream("out.txt");
        int len = fis.available();
        System.out.println("len:"+len);
        int readLen = 2;
        boolean isEnd = false;
        int off = 0;
//        byte[] byteArray;
        while(!isEnd){
            byte[] byteArray = new byte[readLen];
            fis = new FileInputStream(file);
            fis.skip(off);
            int readNum = fis.read(byteArray, 0, readLen);
            if(readNum != -1){
                byte[] resultByte = new byte[readNum];
                System.arraycopy(byteArray, 0, resultByte, 0, readNum);
                fos.write(resultByte);
                if(readNum < readLen){
                    isEnd = true;
                }
            }else{
                isEnd = true;
            }
            off = off + readLen;
        }
    }
}
