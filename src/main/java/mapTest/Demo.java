/**
 *
 */
package mapTest;

import java.util.HashMap;
import java.util.Map;

import entity.Car;

/**
 * @author ywx
 * @Date 2020年3月11日 下午10:01:16
 */
public class Demo {

    public static void main(String[] args) {
        carTest();
    }

    public static void carTest() {
        String carName = "carName";
        Integer carId = 1;
        Map<String, String> partMap = new HashMap<String, String>();
        partMap.put("part1", "part1");
        partMap.put("part2", "part2");

        Car car = new Car(carName, carId, partMap);

        System.out.println("car: " + car.toString());

        Map<String, Object> testMap = new HashMap<String, Object>();

        testMap.put("name", carName);
        testMap.put("id", carId);
        testMap.put("partMap", partMap);

        System.out.println("testMap:" + testMap);
    }
}
