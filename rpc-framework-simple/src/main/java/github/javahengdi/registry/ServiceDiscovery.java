package github.javahengdi.registry;

import github.javahengdi.extension.SPI;

import java.net.InetSocketAddress;

/**
 * @program: hengdi-rpc
 * @description: 服务发现
 * @author: Jiaty
 * @create: 2021-02-27 01:26
 **/
@SPI
public interface ServiceDiscovery {
    /**
     * 通过服务名来寻找服务地址
     *
     * @param rpcServiceName
     * @return
     */
    InetSocketAddress lookupService(String rpcServiceName);


}