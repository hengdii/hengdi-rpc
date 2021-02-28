package github.javahengdi.registry.zk;

import github.javahengdi.registry.ServiceRegistry;
import github.javahengdi.registry.zk.util.CuratorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;

import java.net.InetSocketAddress;

/**
 * @program: hengdi-rpc
 * @description: zk服务注册端
 * @author: Jiaty
 * @create: 2021-02-27 01:29
 **/

@Slf4j
public class ZkServiceRegistry implements ServiceRegistry {
    /**
     * 注册服务
     *
     * @param rpcServiceName    rpc服务名
     * @param inetSocketAddress 服务地址
     */
    @Override
    public void registerService(String rpcServiceName, InetSocketAddress inetSocketAddress) {
        String serviePath = CuratorUtils.ZK_REGISTER_ROOT_PATH + "/" + rpcServiceName + inetSocketAddress.toString();
        CuratorFramework zkClient = CuratorUtils.getZkClient();
        CuratorUtils.createPersistentNone(zkClient, serviePath);
    }




}