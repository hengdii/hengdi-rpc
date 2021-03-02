package github.javahengdi.exception;

import github.javahengdi.enums.RpcErrorMessageEnum;

/**
 * @program: hengdi-rpc
 * @description: rpc异常
 * @author: Jiaty
 * @create: 2021-03-01 10:20
 **/

public class RpcException extends RuntimeException {

    public RpcException(RpcErrorMessageEnum rpcErrorMessageEnum, String detail) {
        super(rpcErrorMessageEnum.getMessage() + ":" + detail);
    }

    public RpcException(RpcErrorMessageEnum rpcErrorMessageEnum) {
        super(rpcErrorMessageEnum.getMessage());
    }
}