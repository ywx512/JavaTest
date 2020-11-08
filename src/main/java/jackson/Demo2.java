package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * @author yuweixiong
 * @date 2020/09/16 15:14
 * @description
 */
public class Demo2 {
    public static void main(String[] args) throws JsonProcessingException {
        String jsonStr1 = "{\"token\":\"87e95d70-cdb3-4f61-a2a2-216f9a0850c3\",\"recipesId\":19}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode1 = objectMapper.readTree(jsonStr1);
        ObjectNode objectNode1 = objectMapper.createObjectNode();
        objectNode1.setAll((ObjectNode) jsonNode1);
        objectNode1.put("aa","aa");
        System.out.println(objectNode1.toString());

        ObjectNode objectNode = objectMapper.readValue(jsonStr1, ObjectNode.class);

        System.out.println(objectNode.toString());
    }
}
