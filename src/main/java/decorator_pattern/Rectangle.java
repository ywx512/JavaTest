package decorator_pattern;

/**
 * @author yuweixiong
 * @date 2020/12/02 17:12
 * @description
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
