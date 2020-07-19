///**
// * 
// */
//package fastjson;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import com.alibaba.fastjson.JSONObject;
//
//import entity.Device;
//
///**  
//* @author ywx
//* @Date 2020年1月11日 下午5:29:40
//*/
//
//public class Demo2 {
//	public static void main(String[] args) {
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
//		String userString = JSONObject.toJSONString(user);
//		System.out.println("java对象转json字符串: " + userString);
//
//		// java对象转json对象
//		JSONObject userJsonObject = JSONObject.parseObject(JSONObject.toJSONString(user));
//		System.out.println("java对象转json对象: " + userJsonObject);
//
//		// json字符串转java对象
////		Device user2 = JSONObject.toJavaObject(JSONObject.parseObject(userString), Device.class);
////		System.out.println("json字符串转java对象: " + user2);
//
//		// json字符串转json对象
//		JSONObject userJsonObject2 = JSONObject.parseObject(userString);
//		System.out.println("json字符串转json对象: " + userJsonObject2);
//
//		// json对象转json字符串
//		String userString2 = userJsonObject.toJSONString();
//		System.out.println("json对象转json字符串: " + userString2);
//
//		// json对象转java对象
////		Device user3 = JSONObject.toJavaObject(userJsonObject, Device.class);
////		System.out.println("json对象转java对象: " + user3);
//	}
//}
