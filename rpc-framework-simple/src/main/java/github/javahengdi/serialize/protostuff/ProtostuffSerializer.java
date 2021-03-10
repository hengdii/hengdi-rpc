package github.javahengdi.serialize.protostuff;

import github.javahengdi.serialize.Serializer;

/**
 * @program: hengdi-rpc
 * @description:
 * @author: Jiaty
 * @create: 2021-03-10 23:33
 **/

public class ProtostuffSerializer implements Serializer {


    /**
     * 序列化
     *
     * @param obj
     * @return
     */
    @Override
    public byte[] serialize(Object obj) {
        return new byte[0];
    }

    /**
     * 反序列化
     *
     * @param bytes
     * @param clazz
     * @return
     */
    @Override
    public <T> T deserialize(byte[] bytes, Class<?> clazz) {
        return null;
    }
}