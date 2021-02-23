package github.javahengdi.loadbalance;

import github.javahengdi.extension.SPI;

import java.util.List;

/**
 * @program: hengdi-rpc
 * @description: 负载均衡
 * @author: Jiaty
 * @create: 2021-02-23 22:31
 **/
@SPI
public interface LoadBalance {
    /**
     * 选择已经存在的服务地址
     *
     * @param serviceAddress 服务地址列表
     * @param rpcServiceName
     * @return 选择完的目标地址
     */
    String selectServiceAddress(List<String> serviceAddress, String rpcServiceName);

}