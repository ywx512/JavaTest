package jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yuweixiong
 * @date 2020/12/18 17:48
 * @description
 */
public class JsonUtil {
    /**
     * 默认日期时间格式
     */
    private static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();

        JsonDeserializer dateJsonDeserializer = new JsonDeserializer<Date>() {
            @Override
            public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String date = jsonParser.getText();
                SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT);
                try {
                    return format.parse(date);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        JsonSerializer dateJsonSerializer = new JsonSerializer<Date>() {
            @Override
            public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
                    throws IOException {
                SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT);
                String formattedDate = formatter.format(date);
                jsonGenerator.writeString(formattedDate);
            }
        };

        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Date.class, dateJsonSerializer);
        simpleModule.addDeserializer(Date.class, dateJsonDeserializer);
        objectMapper.registerModule(simpleModule);
    }

    /**
     * json字符串转Json对象，如果字符串为null，返回空的Json对象
     *
     * @param json
     * @return
     */
    public static ObjectNode toJson(String json) {
        if (json == null) {
            return objectMapper.createObjectNode();
        }

        try {
            return objectMapper.readValue(json, ObjectNode.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T toObject(String json, Class<T> clazz) {
        if (json == null) {
            return null;
        }

        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T toObject(String json, TypeReference<T> valueTypeRef) {
        if (json == null) {
            return null;
        }

        try {
            return objectMapper.readValue(json, valueTypeRef);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 对象转json字符串，如果对象为null，返回null
     *
     * @param o
     * @return
     */
    public static String toJsonString(Object o) {
        if (o == null) {
            return null;
        }

        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T toObject(ObjectNode objectNode, Class<T> clazz) {
        if (objectNode == null || clazz == null) {
            return null;
        }

        try {
            return objectMapper.treeToValue(objectNode, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 对象转json对象，如果对象为null，返回空的json对象
     *
     * @param o
     * @return
     */
    public static ObjectNode toJson(Object o) {
        if (o == null) {
            return objectMapper.createObjectNode();
        }

        return objectMapper.valueToTree(o);
    }

    /**
     * json字符串转json数组对象，如果字符串为null，返回空的json数组对象
     *
     * @param json
     * @return
     */
    public static ArrayNode toJsonArray(String json) {
        if (json == null) {
            return objectMapper.createArrayNode();
        }

        try {
            return objectMapper.readValue(json, ArrayNode.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
