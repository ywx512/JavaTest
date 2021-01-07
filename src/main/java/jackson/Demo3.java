package jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author yuweixiong
 * @date 2020/11/13 14:03
 * @description
 */
public class Demo3 {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        String userStr1 = "{ \"name\" : \"aa\", \"age\":11 } ";

        /**
         * json字符串转json对象
         */
        ObjectNode nodes1 = objectMapper.readValue(userStr1, ObjectNode.class);

        System.out.println("jsonStr --> jsonObj: " + nodes1.toString());

        /**
         * json字符串转java对象
         */
        User user1 = objectMapper.readValue(userStr1, User.class);

        System.out.println("jsonStr --> java: " + user1);

        User user11 = objectMapper.readValue(userStr1, new TypeReference<User>() {});

        System.out.println("jsonStr ---> java 11: " + user11);

        /**
         * json对象转json字符串
         */
        String userStr2 = objectMapper.writeValueAsString(nodes1);

        System.out.println("jsonObj --> jsonStr: " + userStr2);

        /**
         * json对象转java对象
         */
        User user2 = objectMapper.readerFor(User.class).readValue(nodes1);

        System.out.println("jsonObj --> java: " + user2);

        /**
         * java对象转json对象
         */
        ObjectNode nodes2 = objectMapper.readValue(objectMapper.writeValueAsString(user2), ObjectNode.class);

        System.out.println("java --> jsonObj: " + nodes2.toString());

        /**
         * java对象转json字符串
         */
        String userStr3 = objectMapper.writeValueAsString(user2);

        System.out.println("java --> jsonStr: " + userStr3);

        ArrayList<User> array1 = new ArrayList<>();
        array1.add(user1);
        array1.add(user2);
        array1.add(user1);

        String array1JsonStr = objectMapper.writeValueAsString(array1);

        System.out.println("array1JsonStr : " + array1JsonStr);

        ArrayNode arrayNode1 = objectMapper.readValue(array1JsonStr, ArrayNode.class);

        System.out.println("arrayNode1 : " + arrayNode1.toString());


    }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class User {
    private String name;
    private Integer age;
}
