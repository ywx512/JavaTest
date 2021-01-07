package generic;

/**
 * @author yuweixiong
 * @date 2021/01/07 14:58
 * @description
 */
public class ClassTypeCapture<T> {
    Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<String> ctt1 = new ClassTypeCapture<>(String.class);
        System.out.println(ctt1.f(new String()));
        System.out.println(ctt1.f(new Integer(1)));
        ClassTypeCapture<Integer> ctt2 = new ClassTypeCapture<>(Integer.class);
        System.out.println(ctt2.f(new String()));
        System.out.println(ctt2.f(new Integer(1)));
    }
}
