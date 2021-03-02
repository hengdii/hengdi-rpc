package github.javahengdi.utils.concurrent.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @program: hengdi-rpc
 * @description: 创建线程池的工具类
 * @author: Jiaty
 * @create: 2021-03-01 16:20
 **/

@Slf4j
public class ThreadPoolFactoryUtils {

    /**
     * 通过 threadNamePrefix 来区分不同的线程池（我们可以把相同的 threadNamePrefix 的线程池看作是为同一业务场景服务）
     * key: threadNamePrefix
     * value: threadPool
     */
    private static final Map<String, ExecutorService> THREAD_POOLS = new ConcurrentHashMap<>();

    private ThreadPoolFactoryUtils() {

    }

    public static ExecutorService createCustomThreadPoolIfAbsent(String threadNamePrefix) {
        CustomThreadPoolConfig config = new CustomThreadPoolConfig();
        return createCustomThreadPoolIfAbsent(threadNamePrefix, config, false);
    }

    public static ExecutorService createCustomThreadPoolIfAbsent(String threadNamePrefix, CustomThreadPoolConfig config) {
        return createCustomThreadPoolIfAbsent(threadNamePrefix, config, false);
    }

    public static ExecutorService createCustomThreadPoolIfAbsent(String threadNamePrefix, CustomThreadPoolConfig config, Boolean daemon) {
        ExecutorService threadPool = THREAD_POOLS.computeIfAbsent(threadNamePrefix, k ->
                createCustomThreadPoolIfAbsent(threadNamePrefix, config, daemon));

        if (threadPool.isShutdown() || threadPool.isTerminated()) {
            THREAD_POOLS.remove(threadNamePrefix);
            threadPool = createThreadPool(config, threadNamePrefix, daemon);
            THREAD_POOLS.put(threadNamePrefix, threadPool);
        }
        return threadPool;
    }

    public static ThreadFactory createThreadFactory(String threadNamePrefix, Boolean daemon) {
        if (threadNamePrefix == null) {
            return Executors.defaultThreadFactory();
        }
        if (daemon == null) {
            return new ThreadFactoryBuilder().setNameFormat(threadNamePrefix + "-%d").build();
        }
        return new ThreadFactoryBuilder().setNameFormat(threadNamePrefix + "-%d").setDaemon(daemon).build();
    }

    private static ExecutorService createThreadPool(CustomThreadPoolConfig config, String threadNamePrefix, Boolean daemon) {
        ThreadFactory threadFactory = createThreadFactory(threadNamePrefix, daemon);
        return new ThreadPoolExecutor(config.getCorePoolSize(), config.getMaximunPoolSize(),
                config.getKeepAliveTime(), config.getUnit(), config.getWorkQueue(), threadFactory);
    }

    /**
     * shutdown方法：
     * 平滑的关闭ExecutorService，当此方法被调用时，ExecutorService停止接收新的任务并且等待已经提交的任务（包含提交正在执行和提交未执行）执行完成。当所有提交任务执行完毕，线程池即被关闭。
     * <p>
     * awaitTermination方法：
     * 接收人timeout和TimeUnit两个参数，用于设定超时时间及单位。当等待超过设定时间时，会监测ExecutorService是否已经关闭，若关闭则返回true，否则返回false。一般情况下会和shutdown方法组合使用。
     */
    public static void shutDownAllThread() {
        log.info("shut down all thread");
        THREAD_POOLS.entrySet().parallelStream().forEach(entry -> {
            ExecutorService executorService = entry.getValue();
            executorService.shutdown();
            log.info("shut down thread {} {}", entry.getKey(), executorService.isTerminated());
            try {
                boolean b = executorService.awaitTermination(10, TimeUnit.SECONDS);
                if (!b) {
                    log.error("thread pool is not terminated");
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                log.error("thread pool is not terminated");
                executorService.shutdownNow();
            }
        });
    }

    /**
     * 打印线程池状态
     *
     * @param threadPool
     */
    public static void printThreadPoolStatus(ThreadPoolExecutor threadPool) {
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1, createThreadFactory("print-thread-pool-status", false));
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            log.info("===========ThreadPool Status===========");
            log.info("ThreadPool Size:{}", threadPool.getPoolSize());
            log.info("Active Threads:{}", threadPool.getActiveCount());
            log.info("Number of Tasks:{}", threadPool.getCompletedTaskCount());
            log.info("Number of Tasks in Queue:{}", threadPool.getQueue().size());
        }, 0, 1, TimeUnit.SECONDS);
    }

}