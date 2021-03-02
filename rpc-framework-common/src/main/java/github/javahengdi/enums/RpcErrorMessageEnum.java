package github.javahengdi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @program: hengdi-rpc
 * @description: rpc异常枚举
 * @author: Jiaty
 * @create: 2021-03-01 10:22
 **/

@AllArgsConstructor
@Getter
@ToString
public enum RpcErrorMessageEnum {
    /**
     * 客户端连接服务端失败
     */
    CLIENT_CONNECT_SERVICE_FAILURE("客户端连接服务端失败"),
    /**
     * 服务调用失败
     */
    SERVICE_INVOCATION_FAILURE("服务调用失败"),
    /**
     * 找不到指定服务
     */
    SERVICE_NOT_FOUND("找不到指定服务"),
    /**
     * 注册的服务没有实现任何接口
     */
    SERVICE_NOT_IMPLEMENT_ANY_INTERFACE("注册的服务没有实现任何接口"),
    /**
     * 返回结果错误！请求和返回的相应不匹配
     */
    REQUEST_NOT_MATCH_RESPONSE("返回结果错误！请求和返回的相应不匹配");

    private final String message;
}
