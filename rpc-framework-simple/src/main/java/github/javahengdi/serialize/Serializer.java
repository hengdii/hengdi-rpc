package github.javahengdi.serialize;

import github.javahengdi.extension.SPI;

/**
 * @program: hengdi-rpc
 * @description: 序列化与反序列化接口
 * @author: Jiaty
 * @create: 2021-03-10 16:31
 **/

@SPI
public interface Serializer {
    /**
     * 序列化
     *
     * @param obj
     * @return
     */
    byte[] serialize(Object obj);

    /**
     * 反序列化
     *
     * @param obj
     * @return
     */
    <T> T deserialize(byte[] bytes,Class<?> clazz);

}
