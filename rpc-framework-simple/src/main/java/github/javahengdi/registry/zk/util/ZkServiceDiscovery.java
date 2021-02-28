package github.javahengdi.registry.zk.util;

import github.javahengdi.extension.ExtensionLoader;
import github.javahengdi.loadbalance.LoadBalance;
import github.javahengdi.registry.ServiceDiscovery;

import java.net.InetSocketAddress;

/**
 * @program: hengdi-rpc
 * @description: 服务发现
 * @author: Jiaty
 * @create: 2021-02-28 22:19
 **/

public class ZkServiceDiscovery implements ServiceDiscovery {

    private final LoadBalance loadBalance;

    public ZkServiceDiscovery(LoadBalance loadBalance) {
        this.loadBalance = ExtensionLoader.getExtensionLoader(LoadBalance.class).getExtension("loadBalance");
    }


    /**
     * 通过服务名来寻找服务地址
     *
     * @param rpcServiceName
     * @return
     */
    @Override
    public InetSocketAddress lookupService(String rpcServiceName) {
        return null;
    }
}