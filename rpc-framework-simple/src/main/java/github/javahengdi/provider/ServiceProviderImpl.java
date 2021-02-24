package github.javahengdi.provider;

import github.javahengdi.entity.RpcServiceProperties;

import java.util.Map;

/**
 * @program: hengdi-rpc
 * @description:
 * @author: Jiaty
 * @create: 2021-02-24 17:20
 **/

public class ServiceProviderImpl implements ServiceProvider{

//    private final Map<String,Object> serviceMap;
//
//    private final Set<String> registeredService;
//
//    private final Ser



    @Override
    public void addService(Object service, Class<?> serviceClass, RpcServiceProperties rpcServiceProperties) {

    }

    @Override
    public Object getService(RpcServiceProperties rpcServiceProperties) {
        return null;
    }

    @Override
    public void publishService(Object service, RpcServiceProperties rpcServiceProperties) {

    }

    @Override
    public void publishService(Object service) {

    }
}