package github.javahengdi.loadbalance.loadbalancer;

import github.javahengdi.loadbalance.AbstractLoadBalance;

import java.util.List;
import java.util.Random;

/**
 * @program: hengdi-rpc
 * @description: 随机策略
 * @author: Jiaty
 * @create: 2021-02-23 22:42
 **/

public class RandomLoadBalance extends AbstractLoadBalance {
    @Override
    protected String doSelect(List<String> serviceAddresses, String rpcServiceName) {
        Random random = new Random();
        return serviceAddresses.get(random.nextInt(serviceAddresses.size()));
    }
}