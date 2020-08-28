package okhttp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author yuweixiong
 * @date 2020/08/27 11:26
 * @Description
 */
public class Demo1 {
    private static final String iotRouterUrl = "http://192.168.128.157:19003/getService";

    public static void main(String[] args) throws IOException {
        OkHttpClient httpClient = new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().url(iotRouterUrl).get().build();
        try (Response response = httpClient.newCall(request).execute()) {
            String result = response.body().string();
            System.out.println("result:" + result);
            JSONObject resultJson = JSON.parseObject(result);
            Integer port = resultJson.getInteger("port");
            String ip = resultJson.getString("ip");
            System.out.println("port:" + port + ",ip:" + ip);
        }
    }
}
