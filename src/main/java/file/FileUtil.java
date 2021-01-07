package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author yuweixiong
 * @date 2021/01/05 18:09
 * @description
 */
public class FileUtil {
    /**
     * 获取文件，如果文件不存在则创建该文件
     *
     * @param path
     * @return
     * @throws IOException
     */
    public static File getFile(String path) {
        File file = new File(path);
        File dir = file.getParentFile();

        if (dir != null && !dir.exists()) {
            dir.mkdirs();
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return file;
    }

    /**
     * 获取文件夹，如果文件夹不存在则创建该文件夹
     *
     * @param path
     * @return
     */
    public static File getFileDir(String path) {
        File dir = new File(path);
        File parentDir = dir.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        if (!dir.exists()) {
            dir.mkdir();
        }
        return dir;
    }

    /**
     * 读取文件
     *
     * @param path 绝对路径
     * @return
     * @throws IOException
     */
    public static String readFile(String path) throws IOException {
        FileChannel channel = new FileInputStream(path).getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        StringBuilder builder = new StringBuilder();

        while (channel.read(byteBuffer) > 0) {
            byteBuffer.flip();
            builder.append(new String(byteBuffer.array(), "UTF-8"));
            byteBuffer.clear();
        }
        channel.close();

        return builder.toString();
    }

//    public static String readFile2(String path) throws IOException {
//        String line;
//        StringBuilder stringBuilder = new StringBuilder();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
//        while ((line = bufferedReader.readLine()) != null) {
//            stringBuilder.append(line);
//        }
//        bufferedReader.close();
//        return stringBuilder.toString();
//    }

//    public static String readFile3(String path) throws IOException {
//        Charset charset = Charset.forName("utf-8");
//        FileChannel channel = new FileInputStream(path).getChannel();
//        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//        StringBuilder builder = new StringBuilder();
//
//        while (channel.read(byteBuffer) > 0) {
//            charset.decode(byteBuffer);
//            byteBuffer.flip();
//            CharBuffer charBuffer = charset.decode(byteBuffer);
//            builder.append(charBuffer.toString());
//            byteBuffer.clear();
//        }
//
//        channel.close();
//
//        return builder.toString();
//}

//    public static void writeFile2(String path, String content, boolean append) throws IOException {
//        File file = new File(path);
//        File dir = file.getParentFile();
//
//        if (dir != null && !dir.exists()) {
//            dir.mkdirs();
//        }
//
//        if (!file.exists()) {
//            file.createNewFile();
//        }
//
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, append)));
//        bufferedWriter.write(content);
//        bufferedWriter.close();
//    }

    /**
     * 写入文件，文件不存在则创建
     *
     * @param path    绝对路径
     * @param content 内容
     * @param append  是否从文件结尾开始写入
     * @throws IOException
     */
    public static void writeFile(String path, String content, boolean append) throws IOException {
        File file = new File(path);
        File dir = file.getParentFile();

        if (dir != null && !dir.exists()) {
            dir.mkdirs();
        }

        if (!file.exists()) {
            file.createNewFile();
        }

        FileChannel channel = new FileOutputStream(path, append).getChannel();

        channel.write(ByteBuffer.wrap(content.getBytes("UTF-8")));

        channel.close();
    }

    /**
     * 删除文件
     *
     * @param path 绝对路径
     * @return
     */
    public static boolean deleteFile(String path) {
        File file = new File(path);
        boolean result = false;

        if (file.exists()) {
            file.delete();
            result = true;
        }

        return result;
    }

    /**
     * 迭代删除文件夹
     *
     * @param path 绝对路径
     */
    public static void deleteDir(String path) {
        File file = new File(path);
        if (!file.isFile()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    deleteDir(files[i].getAbsolutePath());
                }
            }
        }
        file.delete();
    }

    public static void main(String[] args) throws IOException {
        String test = readFile("data.txt");
//        System.out.println("test: " + test);

        String bigFile = "data.txt";
//        String bigFile = "bigFile.txt";
//        String bigFile = "JavaTest.rar";
        long start1 = System.currentTimeMillis();
        String content = readFile(bigFile);
        System.out.println("c1: time: " + (System.currentTimeMillis() - start1));

        String outFile1 = "data4.txt";
        long start11 = System.currentTimeMillis();
        writeFile(outFile1, content, true);
        System.out.println("c11: time: " + (System.currentTimeMillis() - start11));
    }
}
