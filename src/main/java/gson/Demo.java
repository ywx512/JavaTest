/**
 * 
 */
package gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
        userTest();
//        deviceTest();
    }

    public static void userTest() {
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

        Gson gson = new Gson();

        // java对象转json字符串
        String jsonString = gson.toJson(user);
        System.out.println("java对象转json字符串: " + jsonString);

        // java对象转json对象
        JsonObject userJsonObject = gson.toJsonTree(user).getAsJsonObject();
        System.out.println("java对象转json对象: " + userJsonObject);

        // json字符串转java对象
        User user2 = gson.fromJson(jsonString, User.class);
        System.out.println("json字符串转java对象: " + user2);

        // json字符串转json对象
        JsonObject userJsonObject2 = gson.toJsonTree(user2, User.class).getAsJsonObject();
        System.out.println("json字符串转json对象: " + userJsonObject2);

        // json对象转json字符串
        String userString2 = gson.toJson(userJsonObject);
        System.out.println("json对象转json字符串: " + userString2);

        // json对象转java对象
        User user3 = gson.fromJson(userJsonObject, User.class);
        System.out.println("json对象转java对象: " + user3);
    }

    public static void deviceTest() {

    }
}
