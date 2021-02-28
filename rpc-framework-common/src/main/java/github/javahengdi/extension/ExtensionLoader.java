package github.javahengdi.extension;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: hengdi-rpc
 * @description:
 * @author: Jiaty
 * @create: 2021-02-28 22:21
 **/

@Slf4j
public final class ExtensionLoader<T> {

    private static final String SERVICE_DIRECTORY = "META-INF/extensions";

    private static final Map<Class<?>, ExtensionLoader<?>> EXTENSION_LOADERS = new ConcurrentHashMap<>();

    private static final Map<Class<?>, Object> EXTENSION_INSTANCES = new ConcurrentHashMap<>();

    private final Class<?> type;

    private final Map<String, Holder<Object>> cacheInstances = new ConcurrentHashMap<>();

    private final Holder<Map<String, Class<?>>> cacheClasses = new Holder<>();


    private ExtensionLoader(Class<?> type) {
        this.type = type;
    }

    /**
     * 扩容
     *
     * @param type
     * @param <S>
     * @return
     */
    public static <S> ExtensionLoader<S> getExtensionLoader(Class<S> type) {
        if (type == null) {
            throw new IllegalArgumentException("Extension type should not be null");
        }
        if (!type.isInterface()) {
            throw new IllegalArgumentException("Extension type must be an interface");
        }
        if (type.getAnnotation(SPI.class) == null) {
            throw new IllegalArgumentException("Extension type must be annotation by @SPI");
        }

        ExtensionLoader<S> extensionLoader = (ExtensionLoader<S>) EXTENSION_LOADERS.get(type);

        if (extensionLoader == null) {
            EXTENSION_LOADERS.putIfAbsent(type, new ExtensionLoader<S>(type));
            extensionLoader = (ExtensionLoader<S>) EXTENSION_LOADERS.get(type);
        }
        return extensionLoader;
    }


    public T getExtension(String name) {
//        if (name == null || name.isEmpty()){
//            throw new IllegalArgumentException("Extension name should not be null or empty");
//        }
        Holder<Object> holder = cacheInstances.get(name);
//        if (holder == null){
//            cacheInstances.putIfAbsent(name,new Holder<>());
//            holder =
//        }
        Object instance = holder.get();
        return (T) instance;
    }

}