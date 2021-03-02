package github.javahengdi.utils;

/**
 * @program: hengdi-rpc
 * @description:
 * @author: Jiaty
 * @create: 2021-03-01 19:56
 **/

public class RuntimeUtil {
    /**
     * 获得CPU核心数
     *
     * @return
     */
    public static int cpus() {
        return Runtime.getRuntime().availableProcessors();
    }


}