package github.javahengdi.utils.concurrent.threadpool;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @program: hengdi-rpc
 * @description: 线程池自定义配置类，可自行根据业务场景修改配置参数
 * @author: Jiaty
 * @create: 2021-03-01 16:20
 **/

@Setter
@Getter
public class CustomThreadPoolConfig {
    /**
     * 默认核心线程数量
     */
    private static final int DEFAULT_CORE_POOL_SIZE = 10;
    /**
     * 默认最大线程数量
     */
    private static final int DEFAULT_MAXIMUN_POOL_SIZE = 100;
    /**
     * 默认存活时间
     */
    private static final int DEFAULT_KEEP_ALIVE_TIME = 1;
    /**
     * 默认时间单位
     */
    private static final TimeUnit DEFAULT_TIME_UNIT = TimeUnit.MINUTES;

    /**
     * 默认的封锁容量
     */
    private static final int DEFAULT_BLOCKING_QUEUE_CAPACITY = 100;
    /**
     * 队列大小
     */
    private static final int BLOCK_QUEUE_CAPACITY = 100;


    private int corePoolSize = DEFAULT_CORE_POOL_SIZE;

    private int maximunPoolSize = DEFAULT_MAXIMUN_POOL_SIZE;

    private long keepAliveTime = DEFAULT_KEEP_ALIVE_TIME;

    private TimeUnit unit = DEFAULT_TIME_UNIT;

    /**
     * 双端队列
     * BlockingDeque 是java.util.concurrent包中的一个双端队列，向其中加入元素或从中取出元素都是线程安全的
     */
    private BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(BLOCK_QUEUE_CAPACITY);

}