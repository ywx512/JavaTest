package zip;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileMode;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.util.ZipUtil;

import java.io.File;
import java.util.Date;

/**
 * @author yuweixiong
 * @date 2020/11/16 15:09
 * @description
 */
public class Demo1 {
    public static void main(String[] args){
        Date now = new Date();
        String fileName = "aaa.txt";
        FileUtil.createRandomAccessFile(new File(fileName), FileMode.rw);
        FileWriter fileWriter = FileWriter.create(new File(fileName));
        fileWriter.write("{\n" +
                "\t\"recipes\": [{\n" +
                "\t\t\"ope_id\": \"null\",\n" +
                "\t\t\"recipes_id:\": \"null\",\n" +
                "\t\t\"recipescata_id:\": \"null\",\n" +
                "\t\t\"ope_deal\": \"add\",\n" +
                "\t\t\"ope_oldsource\": [null],\n" +
                "\t\t\"ope_zipname\": \"null\"\n" +
                "\t}]\n" +
                "}");

        ZipUtil.zip(fileName);
    }
}
