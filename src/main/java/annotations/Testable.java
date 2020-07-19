package annotations;

/**
 * @author: yuweixiong
 * @Date: 2020/7/12 23:46
 * @Description:
 */
public class Testable {
    public void execute(){
        System.out.println("Executing...");
    }

    @Test
    void testExecute(){execute();}
}
