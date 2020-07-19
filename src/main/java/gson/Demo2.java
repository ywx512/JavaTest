///**
// * 
// */
//package gson;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//
//import entity.Device;
//
///**  
//* @author ywx
//* @Date 2020年1月11日 下午5:24:50
//*/
//public class Demo2 {
//	public static void main(String[] args) {
//
//		Gson gson = new Gson();
//
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("list1");
//		list.add("list2");
//		HashMap<String, String> hashMap = new HashMap<String, String>();
//		hashMap.put("map1", "map1");
//		hashMap.put("map2", "map2");
//
//		Device user = new Device("aaa", list, hashMap);
//		System.out.println(user);
//
//		// java对象转json字符串
//		String userString = gson.toJson(user);
//		System.out.println("java对象转json字符串: " + userString);
//
//		// java对象转json对象
////		JsonElement userJsonElement = gson.toJsonTree(user);
//		JsonObject userJsonElement = gson.toJsonTree(user).getAsJsonObject();
//		System.out.println("java对象转json对象: " + userJsonElement);
//		System.out.println(userJsonElement.get("name"));
//		System.out.println(userJsonElement.get("parts"));
//		System.out.println(userJsonElement.get("products"));
//
//		// json字符串转java对象
//		Device user2 = gson.fromJson(userString, Device.class);
//		System.out.println("json字符串转java对象: " + user2);
//
//		// json字符串转json对象
////		JsonElement userJsonObject = gson.toJsonTree(userString);
//		JsonObject userJsonObject = JsonParser.parseString(userString).getAsJsonObject();
//		System.out.println("json字符串转json对象: " + userJsonObject);
//
//		// json对象转json字符串
//		String userString2 = gson.toJson(userJsonObject);
//		System.out.println("json对象转json字符串: " + userString2);
//
//		// json对象转java对象
//		Device user3 = gson.fromJson(userJsonElement, Device.class);
//		System.out.println("json对象转java对象: " + user3);
//	}
//}
