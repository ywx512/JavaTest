/**
 * 
 */
package fastjson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import entity.Car;
import entity.Recipe;
import entity.User;

/**  
* @author ywx
* @Date 2020年1月11日 下午2:55:01
*/

/**
 * @ClassName: Demo1
 * @author: Android_Robot
 * @date: 2020年1月11日 下午2:55:01
 */
public class Demo {

    public static void main(String[] args) {

        List<String> recipeStrList = new ArrayList<String>();
        recipeStrList.add("recipeStrList1");
        recipeStrList.add("recipeStrList2");
        Recipe recipe = new Recipe("recipeName", 1, recipeStrList);

        HashMap<String, String> parts = new HashMap<String, String>();
        parts.put("part1", "part1");
        parts.put("part2", "part2");
        Car car = new Car("carName", 2, parts);
        HashMap<String, String> parts2 = new HashMap<String, String>();
        parts.put("part3", "part3");
        parts.put("part4", "part4");
        Car car2 = new Car("carName", 2, parts2);
        List<Car> carList = new ArrayList<Car>();
        carList.add(car);
        carList.add(car2);

        User user = new User("aaa", 11, recipe, carList);
        System.out.println(user);

        // java对象转json字符串
        String userString = JSONObject.toJSONString(user);
        System.out.println("java对象转json字符串: " + userString);

        // java对象转json对象
        JSONObject userJsonObject = (JSONObject) JSON.toJSON(user);
        System.out.println("java对象转json对象: " + userJsonObject);

        // json字符串转java对象
        User user2 = JSONObject.parseObject(userString, User.class);
        System.out.println("json字符串转java对象: " + user2);

        // json字符串转json对象
        JSONObject userJsonObject2 = JSONObject.parseObject(userString);
        System.out.println("json字符串转json对象: " + userJsonObject2);

        // json对象转json字符串
        String userString2 = userJsonObject.toJSONString();
        System.out.println("json对象转json字符串: " + userString2);

        // json对象转java对象
        User user3 = JSONObject.parseObject(userString2, User.class);
        System.out.println("json对象转java对象: " + user3);

    }
}
