package github.javahengdi.config;

import github.javahengdi.remoting.transport.netty.server.NettyRpcServer;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * @program: hengdi-rpc
 * @description: 当服务关闭时，确保下线所有服务
 * @author: Jiaty
 * @create: 2021-03-01 16:15
 **/

@Slf4j
public class CustomShutDownHook {

    private static final CustomShutDownHook CUSTOM_SHUTDOWN_HOOK = new CustomShutDownHook();

    public static CustomShutDownHook getCustomShutdownHook() {
        return CUSTOM_SHUTDOWN_HOOK;
    }

    public void clearAll() {
        log.info("addShutdownHook for clearAll");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getLocalHost().getHostAddress(), NettyRpcServer.PORT);
            } catch (UnknownHostException e) {

            }
            ThreadPoolF
        }));
    }
}