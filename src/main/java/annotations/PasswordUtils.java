package annotations;

/**
 * @author: yuweixiong
 * @Date: 2020/7/12 23:50
 * @Description:
 */
public class PasswordUtils {
    @UseCase(id = 1, description = "Password must contain at least one numeric")
    public boolean validatePassword(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 2)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }
}
