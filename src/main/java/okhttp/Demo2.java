package okhttp;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author yuweixiong
 * @date 2020/08/27 17:26
 * @Description
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {
        OkHttpClient httpClient = new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build();
        JSONObject requestData = new JSONObject();
        requestData.put("userName", "user3");
        MediaType MediaType_JSON = MediaType.parse("application/json; charset=utf-8");
        String address = "http://192.168.128.157:19010";
        String url = "/sunmi/user/checkUserNameIsExist";
        RequestBody requestBody = RequestBody.create(requestData.toJSONString(), MediaType_JSON);
        Request request = new Request.Builder().post(requestBody).url(address+url).build();
        try(Response response = httpClient.newCall(request).execute()){
            String result = response.body().string();
            System.out.println(result);
        }
    }
}
