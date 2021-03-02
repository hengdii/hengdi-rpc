package github.javahengdi.registry.zk.util;

import github.javahengdi.enums.RpcErrorMessageEnum;
import github.javahengdi.exception.RpcException;
import github.javahengdi.extension.ExtensionLoader;
import github.javahengdi.loadbalance.LoadBalance;
import github.javahengdi.registry.ServiceDiscovery;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * @program: hengdi-rpc
 * @description: 服务发现
 * @author: Jiaty
 * @create: 2021-02-28 22:19
 **/

@Slf4j
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
        CuratorFramework zkClient = CuratorUtils.getZkClient();
        List<String> serviceUrlLists = CuratorUtils.getChildrenNodes(zkClient, rpcServiceName);
        if (serviceUrlLists == null || serviceUrlLists.size() == 0) {
            throw new RpcException(RpcErrorMessageEnum.SERVICE_NOT_FOUND, rpcServiceName);
        }
        String targetServiceUrl = loadBalance.selectServiceAddress(serviceUrlLists, rpcServiceName);
        log.info("successfully found the service address:{}", targetServiceUrl);
        String[] socketAddressArray = targetServiceUrl.split(":");
        String host = socketAddressArray[0];
        int port = Integer.parseInt(socketAddressArray[1]);
        return new InetSocketAddress(host, port);

    }
}