package annotations.database;

/**
 * @author: yuweixiong
 * @Date: 2020/7/13 0:23
 * @Description:
 */
@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30)
    String firstName;

    //    @SQLString(30)
//    @Constrains(primaryKey = true)
    @SQLString(value = 30, constrains = @Constrains(primaryKey = true))
    String handle;
}
