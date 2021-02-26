package github.javahengdi.enums;

/**
 * @program: hengdi-rpc
 * @description:
 * @author: Jiaty
 * @create: 2021-01-12 15:09
 **/

public enum RpcConfigEnum {

    /**
     *
     */
    RPC_CONFIG_PATH("rpc.properties"),

    /**
     *
     */
    ZK_ADDRESS("rpc.zookeeper.address");

    RpcConfigEnum(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    private final String propertyValue;


}
