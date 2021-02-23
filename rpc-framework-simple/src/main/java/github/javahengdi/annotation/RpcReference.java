package github.javahengdi.annotation;

import java.lang.annotation.*;

/**
 * @program: hengdi-rpc
 * @description: Rpc注解
 * @author: Jiaty
 * @create: 2021-02-22 22:31
 **/


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Inherited
public @interface RpcReference {

    String version() default "";

    String group() default "";


}