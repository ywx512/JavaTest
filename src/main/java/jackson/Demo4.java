package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @author yuweixiong
 * @date 2021/01/07 15:13
 * @description
 */
public class Demo4 {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println("----------读集合类型------处理泛型擦除问题----");
        List<Long> list = objectMapper.readValue("[1,2,3]", new TypeReference<List<Long>>() {});

        Long id = list.get(0);
        System.out.println(id);

        test1();
    }

    /**
     * 泛型擦除问题
     * @throws JsonProcessingException
     */
    static void test1() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println("----------读集合类型------泛型擦除问题----");
        List<Long> list = objectMapper.readValue("[1,2,3]", List.class);

        Long id = list.get(0);
        System.out.println(id);
    }
}
