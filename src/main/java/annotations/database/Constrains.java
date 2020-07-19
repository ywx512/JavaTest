package annotations.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: yuweixiong
 * @Date: 2020/7/13 0:13
 * @Description:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constrains {
    boolean primaryKey() default false;

    boolean allowNull() default true;

    boolean unique() default false;
}
