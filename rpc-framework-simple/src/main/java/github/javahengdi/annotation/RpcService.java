package github.javahengdi.annotation;

import java.lang.annotation.*;

/**
 * @program: hengdi-rpc
 * @description: rpc 注解的实现
 * @author: Jiaty
 * @create: 2021-02-23 22:24
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
public @interface RpcService {

    String version() default "";

    String group() default "";

}