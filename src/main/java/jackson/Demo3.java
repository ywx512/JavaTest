package jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

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
//        ObjectNode nodes2 = objectMapper.readValue(userStr2)


        /**
         * java对象转json字符串
         */
        String userStr3 = objectMapper.writeValueAsString(user2);

        System.out.println("java --> jsonStr: " + userStr3);
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
class User {
    private String name;
    private Integer age;
}
