package github.javahengdi.entity;

import lombok.*;

/**
 * @program: hengdi-rpc
 * @description:
 * @author: Jiaty
 * @create: 2021-01-12 15:02
 **/

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RpcServiceProperties {

    private String version;

    private String group;

    private String serviceName;


    public String toRpcServiceName() {
        return this.serviceName + this.group + this.version;
    }


}