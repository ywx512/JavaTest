package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author yuweixiong
 * @date 2021/03/02 10:23
 * @description
 */
public class JsonUtilTest {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectA a1 = new ObjectA("a1", 1);
        ObjectA a2 = new ObjectA("a2", 2);
        ObjectA a3 = new ObjectA("a3", 3);

        List<ObjectA> objectAS = new ArrayList<>();
        objectAS.add(a1);
        objectAS.add(a2);
        objectAS.add(a3);

        HashMap<String, String> map = new HashMap<>();
        map.put("b1","b11");
        map.put("b2","b22");

        String mapJsonStr = JsonUtil.toJsonString(map);
        System.out.println("mapJsonStr: " + mapJsonStr);
        HashMap<String, String> map2 = JsonUtil.toObject(mapJsonStr, HashMap.class);
        System.out.println("mapJsonStr ---> java: " + map2);
        System.out.println(map2.get("b1"));

        ObjectB b1 = new ObjectB(objectAS, map);

        String jsonStr1 = JsonUtil.toJsonString(b1);
        System.out.println("java ---> jsonStr: " + jsonStr1);

        ObjectB b2 = JsonUtil.toObject(jsonStr1, ObjectB.class);
//        ObjectB b2 =JsonUtil.objectMapper.readValue(jsonStr1, new TypeReference<ObjectB>() {});

        System.out.println("jsonStr ---> java: " + b2);
        System.out.println(b2.getObjectAS().get(1).getAge());

        List<ObjectB> objectBS = new ArrayList<>();
        objectBS.add(b1);
        objectBS.add(b2);

        String jsonStr2 = JsonUtil.toJsonString(objectBS);
        System.out.println("java ---> jsonStr2: " + jsonStr2);

//        List<ObjectB> objectBS1 = JsonUtil.objectMapper.readValue(jsonStr2, new TypeReference<List<ObjectB>>() {});
        List<ObjectB> objectBS1 = JsonUtil.toObject(jsonStr2, new TypeReference<List<ObjectB>>(){});
        System.out.println("objectB list2: " + objectBS1);
        System.out.println("objectB list2: " + objectBS1.get(1).getObjectAS());
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class ObjectA{
    private String name;
    private Integer age;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class ObjectB{
    private List<ObjectA> objectAS;
    private HashMap<String ,String> map;
}
