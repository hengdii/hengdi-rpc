package github.javahengdi.remoting.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @program: hengdi-rpc
 * @description:
 * @author: Jiaty
 * @create: 2021-03-10 13:47
 **/

@Data
@Builder
public class RpcMessage {

    /**
     * rpc message type
     */
    private byte messageType;
    /**
     * codec
     */
    private byte codec;
    /**
     * compress
     */
    private byte compress;
    /**
     * request id
     */
    private int requestId;
    /**
     * request data
     */
    private Object data;

}