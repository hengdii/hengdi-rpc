package github.javahengdi.loadbalance;

import java.util.List;

/**
 * @program: hengdi-rpc
 * @description: 负载均衡服务代理
 * @author: Jiaty
 * @create: 2021-02-23 22:39
 **/

public abstract class AbstractLoadBalance implements LoadBalance {

    @Override
    public String selectServiceAddress(List<String> serviceAddress, String rpcServiceName) {
        if (serviceAddress == null || serviceAddress.size() == 0) {
            return null;
        }
        if (serviceAddress.size() == 1) {
            return serviceAddress.get(0);
        }
        return doSelect(serviceAddress, rpcServiceName);
    }

    /**
     * 选择策略
     *
     * @param rpcServiceName
     * @param serviceAddresses
     * @return
     */
    protected abstract String doSelect(List<String> serviceAddresses, String rpcServiceName);
}