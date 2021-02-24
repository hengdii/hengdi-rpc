package github.javahengdi.registry;

import github.javahengdi.extension.SPI;

import java.net.InetSocketAddress;

/**
 * @program: hengdi-rpc
 * @description: 服务注册
 * @author: Jiaty
 * @create: 2021-02-24 17:23
 **/

@SPI
public interface ServiceRegistry {
    /**
     * 注册服务
     *
     * @param rpcServiceName    rpc服务名
     * @param inetSocketAddress 服务地址
     */
    void registerService(String rpcServiceName, InetSocketAddress inetSocketAddress);


}
