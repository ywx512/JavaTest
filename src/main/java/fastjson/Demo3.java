package fastjson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/*
 * @author yuweixiong
 * @date 2020/03/27
 */
public class Demo3 {

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",
                "[{\"email\":\"string\",\"form\":0,\"ip\":\"string\",\"location\":\"string\",\"uPassword\":\"test2\",\"userName\":\"test2\"},{\"$ref\":\"$[0]\"},{\"$ref\":\"$[0]\"}]");

        JSONArray jsonArray = jsonObject.getJSONArray("data");
        System.out.println(jsonArray);
//        JSONObject jsonObject2 = jsonObject.getJSONObject("data");
//        System.out.println(jsonObject2);
    }
}
