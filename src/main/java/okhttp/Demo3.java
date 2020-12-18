package okhttp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import okhttp3.*;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.TimeUnit;

/**
 * @author yuweixiong
 * @date 2020/12/18 13:43
 * @description
 */
public class Demo3 {
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private final static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .callTimeout(30, TimeUnit.SECONDS)
            .connectionPool(new ConnectionPool(5, 5, TimeUnit.MINUTES))
            .build();

    public static void main(String[] args) {
        String url = "http://test.api.sunmitech.com/sunmi/file/device/apk/download";
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("deviceType", "SPM168");
        objectNode.put("version", "122");
        objectNode.put("deviceUUID", "1AE980400C12B8CB44408D9E92A65D5A");
        downloadFile(url, "122.apk", objectNode.toString());
        downloadFile2(url, "122(2).apk", objectNode.toString());
    }

    /**
     * Channel下载
     * @param url
     * @param filePath
     * @param json
     */
    public static void downloadFile(String url, String filePath, String json) {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url).post(body).build();
        long start = 0;
        try (Response response = client.newCall(request).execute();
             ReadableByteChannel channel = Channels.newChannel(response.body().byteStream());
             FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
             FileChannel fileChannel = fileOutputStream.getChannel();) {
            start = System.currentTimeMillis();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (channel.read(byteBuffer) > 0) {
                byteBuffer.flip();
                fileChannel.write(byteBuffer);
                byteBuffer.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }
    }

    /**
     * IO流下载
     * @param url
     * @param filePath
     * @param json
     */
    public static void downloadFile2(String url, String filePath, String json) {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url).post(body).build();
        long start = 0;
        try (Response response = client.newCall(request).execute();
             BufferedReader reader = new BufferedReader(new InputStreamReader(response.body().byteStream()));
             FileWriter writer = new FileWriter(new File(filePath))) {

            start = System.currentTimeMillis();
            String content;
            while ((content = reader.readLine()) != null) {
                writer.write(content);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }
    }
}
