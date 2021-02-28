package github.javahengdi.extension;

/**
 * @program: hengdi-rpc
 * @description:
 * @author: Jiaty
 * @create: 2021-02-28 22:25
 **/

public class Holder<T> {

    private volatile T value;

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }
}