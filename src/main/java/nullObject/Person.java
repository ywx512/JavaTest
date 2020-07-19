package nullObject;

/**
 * @author: yuweixiong
 * @Date: 2020/7/12 23:07
 * @Description: 空对象
 */
public class Person {
    public final String first;
    public final String last;
    public final String address;
    public static final Person NULL = new NullPerson();

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class NullPerson extends Person implements Null {
        public NullPerson() {
            super("none", "none", "none");
        }

        public String toString() {
            return "NullPerson";
        }
    }
}
