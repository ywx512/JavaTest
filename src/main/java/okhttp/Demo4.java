package okhttp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * @author yuweixiong
 * @date 2020/12/18 17:23
 * @description
 */
public class Demo4 {
    private final static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .callTimeout(30, TimeUnit.SECONDS)
            .connectionPool(new ConnectionPool(5, 5, TimeUnit.MINUTES))
            .build();

    public static void main(String[] args) throws JsonProcessingException {
        String url = "http://192.168.128.208:19005/sunmi/file/recipes/uploadRecipesImg";
//        postFile(url, new File("image1.png"));


        String url2 = "http://192.168.128.208:19014/sunmi/file/device/apk/upload";
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("deviceType", "SPM198");
        objectNode.put("versionCode", "118");

        postFile(url2, new File("image1.png"), objectNode.toString());
    }

    public static void postFile(String url, File file) {
        RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);

        MultipartBody multipartBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(), fileBody)
                .build();

        Request request = new Request.Builder().url(url).post(multipartBody).build();
        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string());
        } catch (IOException e) {
        }
    }

    public static void postFile(String url, File file, String reqParam) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode nodes = objectMapper.readValue(reqParam, ObjectNode.class);

        RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(), fileBody);

        Iterator<String> elements = nodes.fieldNames();
        while (elements.hasNext()) {
            String name = elements.next();
            String value = nodes.get(name).asText();
            builder.addFormDataPart(name, value);
        }

        MultipartBody multipartBody = builder.build();

        Request request = new Request.Builder().url(url).post(multipartBody).build();
        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string());
        } catch (IOException e) {
        }
    }
}
