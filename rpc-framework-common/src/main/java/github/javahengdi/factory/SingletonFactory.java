package github.javahengdi.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: hengdi-rpc
 * @description: 单例模式
 * @author: Jiaty
 * @create: 2021-03-01 15:55
 **/

public final class SingletonFactory {

    private static final Map<String, Object> OBJECT_MAP = new HashMap<>();

    private SingletonFactory() {

    }

    public static <T> T getInstance(Class<T> c) {
        String key = c.toString();
        Object instance = OBJECT_MAP.get(key);
        if (instance != null) {
            return c.cast(instance);
        }
        synchronized (SingletonFactory.class) {
            instance = OBJECT_MAP.get(key);
            if (instance == null) {
                try {
                    instance = c.getDeclaredConstructor().newInstance();
                    OBJECT_MAP.put(key, instance);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
            }
        }
        return c.cast(instance);
    }
}