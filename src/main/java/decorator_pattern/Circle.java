package decorator_pattern;

/**
 * @author yuweixiong
 * @date 2020/12/02 17:13
 * @description
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
