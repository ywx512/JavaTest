package reflect;

public class InstanceOfAndClass {
    static void test(Object object){
        System.out.println("Test type: " + object);
        System.out.println("obj instanceof Base: " + (object instanceof InstanceBase));
        System.out.println("obj instanceof Down: " + (object instanceof InstanceDown));
        System.out.println("Base.isInstance(): " + InstanceBase.class.isInstance(object));
        System.out.println("Down.isInstance(): " + InstanceDown.class.isInstance(object));
        System.out.println("obj.geClass == Base.class: " + (object.getClass() == InstanceBase.class));
        System.out.println("obj.geClass == Down.class: " + (object.getClass() == InstanceDown.class));
        System.out.println("obj.geClass equal Base.class: " + (object.getClass().equals(InstanceBase.class)));
        System.out.println("obj.geClass equal Down.class: " + (object.getClass().equals(InstanceDown.class)));
    }

    public static void main(String[] args) {
        test(new InstanceBase());
        test(new InstanceDown());
    }
}

class InstanceBase {}
class InstanceDown extends InstanceBase {}
