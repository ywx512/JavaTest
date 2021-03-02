package jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuweixiong
 * @date 2021/03/02 10:15
 * @description
 */
public class Demo5 {
    public static ObjectMapper mapper = new ObjectMapper();
    public static ObjectMapper mapper1 = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        List<Person> listPerson = new ArrayList<>();
        listPerson.add(new Person("张三1"));
        listPerson.add(new Person("张三2"));
        String jsonPerson = mapper.writeValueAsString(listPerson);
        // [{"name":"张三1"},{"name":"张三2"}]
        System.out.println(jsonPerson);
        // 现在我要用jsonPerson还原
        List<Person> getlistPerson = mapper1.readValue(jsonPerson, new TypeReference<List<Person>>() {});
        System.out.println(getlistPerson.get(0).name);
    }

}

class Person {
    public Person() {
    }

    public String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
