/**
 *
 */
package jackson;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import entity.Car;
import entity.SimpleUser;
import entity.User;

/**
 * @author ywx
 * @Date 2020年6月9日 下午10:34:00
 */

/**
 * @Description:测试
 */
public class Demo {

    public static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        String json = "{ \"f1\" : \"v1\" } ";

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readTree(json);

        System.out.println(jsonNode.get("f1").asText());
    }

    public static void main2(String[] args) throws JsonProcessingException {
        SimpleUser simpleUser = SimpleUser.builder().withId(1).withName("simpleUser").build();

        /**
         * java对象转json字符串
         */
        String simpleUserJsonStr = objectMapper.writeValueAsString(simpleUser);
        System.out.println("simpleUserJsonStr: " + simpleUserJsonStr);

        /**
         * json字符串转java对象 第一种方式
         */
        SimpleUser simpleUser2 = objectMapper.readValue(simpleUserJsonStr, SimpleUser.class);
        System.out.println(simpleUser2.toString());

        /**
         * json字符串转java对象 第二种方式 <br>
         * jackson中json对象就是一个个node
         */
        ObjectNode objectNode = objectMapper.readValue(simpleUserJsonStr, ObjectNode.class);

        /**
         * 查找node和值得几种方式区别 <br>
         * 1.findValue 从当前节点开始查询子孙节点，只要有匹配的节点就返回该节点否则返回null<br>
         * 2.get 仅查询当前节点是否有匹配的节点<br>
         * 3.with 仅查询当前节点是否有匹配的节点，若有，则该节点必须是ObjectNode，若无，则自动创建一个<br>
         * 4.withArray 仅查询当前节点是否有匹配的节点，若有，则该节点必须是ArrayNode，若无，则自动创建一个<br>
         */
        System.out.println("JsonNode: name: " + objectNode.findValue("name").asText());
        System.out.println("JsonNode id: " + objectNode.get("id").asInt());

        objectNode.put("age", 1);
        objectNode.put("version", "1.0");

        System.out.println("JsonNode new objectNode" + objectNode.toString());

        ObjectNode newNode = objectNode.with("newNode");
        newNode.put("param1", "param1");

        ArrayNode newArrayNode = objectNode.withArray("newArrayNode");
        newArrayNode.addPOJO(simpleUser);
        newArrayNode.addPOJO(simpleUser2);

        System.out.println("JsonNode addNode: " + objectNode);

        HashMap<String, String> hashMap1 = new HashMap<String, String>();
        hashMap1.put("part1", "part1");
        hashMap1.put("part2", "part2");

        Car car1 = Car.builder().withId(1).withName("car1").withPartMap(hashMap1).build();
        Car car2 = Car.builder().withId(2).withName("car2").withPartMap(hashMap1).build();

        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(car1);
        cars.add(car2);

        User user1 = User.builder().withAge(1).withName("user1").withCarList(cars).build();

        System.out.println("user: " + user1.toString());

        /*
         * 为了使JSON视觉上的可读性，增加一行如下代码，注意，在生产中不需要这样，因为这样会增大Json的内容
         */
//		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        /**
         * 当反序列化json时，未知属性会引起的反序列化被打断，这里我们禁用未知属性打断反序列化功能，<br>
         * 因为，例如json里有10个属性，而我们的bean中只定义了2个属性，其它8个属性将被忽略
         */
//		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        /**
         * 配置mapper忽略空属性
         */
        objectMapper.setSerializationInclusion(Include.NON_EMPTY);

        String user1JsonStr = objectMapper.writeValueAsString(user1);
        System.out.println("user1JsonStr: " + user1JsonStr);
        System.out.println("userJsonStr to user: " + objectMapper.readValue(user1JsonStr, User.class).toString());
    }

    public void test() {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("param1", "param1");
        objectNode.put("param2", "param2");
        System.out.println(objectNode.toString());
    }
}
