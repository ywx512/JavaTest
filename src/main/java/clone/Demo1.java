package clone;

import entity.SimpleUser;

/**
 * @author yuweixiong
 * @date 2020/9/21 23:09
 * @description
 */
public class Demo1 {
    public static void main(String[] args) throws CloneNotSupportedException {
        SimpleUser user = new SimpleUser();
        user.setId(1);
        user.setName("test");

        Object user1 = user.clone();
        System.out.println(user);
        System.out.println(user1);
    }
}
