package reflect.object;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yuweixiong
 * @date 2021/01/12 11:06
 * @description
 */
public class Demo2 {

    public static void main(String[] args) throws IllegalAccessException {
        List<String> list = new ArrayList<>();
        Field[] fields = QueryCmdType.class.getFields();
        for(Field field : fields){
            System.out.println(field.getName());
            list.add((String) field.get(QueryCmdType.class));
        }

        System.out.println("list: ");
        for(String element : list){
            System.out.println(element);
        }
    }

    private class QueryCmdType{
        //模式
        public static final String mode = "0002";
        //剩余时间
        public static final String time = "0102";
        //设置的速度
        public static final String speed = "0202";
        //设置的温度
        public static final String setTemp = "0302";
        //设备是否开启工作
        public static final String deviceStartStatus = "0502";
        //实际温度
        public static final String actTemp = "0802";
        //开盖状态
        public static final String isCover = "0902";
        //菜谱信息
        public static final String recipeInfo = "0A02";
        //故障码
        public static final String errorCode = "0B02";
    }
}
