package github.javahengdi.annotation;

import java.lang.annotation.*;

/**
 * @program: hengdi-rpc
 * @description: 扫描注解
 * @author: Jiaty
 * @create: 2021-02-22 22:37
 **/

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RpcScan {

    String[] basePackage();
}