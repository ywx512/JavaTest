package file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuweixiong
 * @date 2021/01/04 11:13
 * @description
 */
public class Demo3 {
    public static String[] list(){
        File file = new File("test");
        String[] fileNameList = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                System.out.println("name: " + name);
                System.out.println("dir: " + dir.getAbsolutePath());
                if(name.equalsIgnoreCase("test1.txt")){
                    return false;
                }
                return true;
            }
        });

        File[] fileList = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                System.out.println("name: " + name);
                System.out.println("dir: " + dir.getAbsolutePath());
                if(name.equalsIgnoreCase("test1.txt")){
                    return false;
                }
                return true;
            }
        });

        return fileNameList;
    }

    public static void main(String[] args) {
//        list();
        String[] fileList = list();

        List<String> fileList2 = Arrays.asList(fileList);
        System.out.println(fileList2);
    }
}
