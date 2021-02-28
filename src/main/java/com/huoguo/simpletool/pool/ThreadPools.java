package com.huoguo.simpletool.pool;

import com.huoguo.simpletool.constant.SimpleConstants;

import java.util.concurrent.*;

/**
 * 线程池类
 *
 * @author lizhenghuang
 */
public class ThreadPools {

    private ThreadPools() {
    }

    /**
     * 默认线程池对象
     **/
    private volatile static ThreadPoolExecutor executor;

    /**
     * 创建线程池
     *
     * @return ThreadPoolExecutor
     */
    private static ThreadPoolExecutor getInstance() {
        if (executor == null) {
            synchronized (ThreadPools.class) {
                if (executor == null) {
                    executor = new ThreadPoolExecutor(SimpleConstants.DEFAULT_CORE_SIZE, SimpleConstants.MAX_QUEUE_SIZE,
                            SimpleConstants.MAX_KEEP_LIVE, TimeUnit.MILLISECONDS,
                            new LinkedBlockingQueue<>(Integer.MAX_VALUE),
                            Executors.defaultThreadFactory(),
                            new ThreadPoolExecutor.AbortPolicy());
                }
            }
        }
        return executor;
    }

    /**
     * 创建线程池
     *
     * @param coreSize  核心线程数
     * @param keepLive  空闲线程存活时长
     * @param queueSize 最大线程数
     * @return ThreadPoolExecutor
     */
    private static ThreadPoolExecutor getInstance(int coreSize, int keepLive, int queueSize) {
        if (executor == null) {
            synchronized (ThreadPools.class) {
                if (executor == null) {
                    executor = new ThreadPoolExecutor(coreSize, keepLive,
                            queueSize, TimeUnit.MILLISECONDS,
                            new LinkedBlockingQueue<>(Integer.MAX_VALUE),
                            Executors.defaultThreadFactory(),
                            new ThreadPoolExecutor.AbortPolicy());
                }
            }
        }
        return executor;
    }

    /**
     * 执行线程（不带返回值的）
     *
     * @param runnable 线程任务
     */
    public static void execute(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        getInstance().execute(runnable);
    }

    /**
     * 执行线程（不带返回值的）
     *
     * @param runnable
     * @param coreSize  核心线程数
     * @param keepLive  空闲线程存活时长
     * @param queueSize 最大线程数
     */
    public static void execute(Runnable runnable, int coreSize, int keepLive, int queueSize) {
        if (runnable == null) {
            return;
        }
        getInstance(coreSize, keepLive, queueSize).execute(runnable);
    }

    /**
     * 执行线程（带返回值的）
     *
     * @param task 线程任务
     * @param <T>  该参数泛型
     * @return Future<T>
     */
    public static <T> Future<T> submit(Callable<T> task) {
        if (task == null) {
            return null;
        }
        return getInstance().submit(task);
    }

    /**
     * 执行线程（带返回值的）
     *
     * @param task      线程任务
     * @param coreSize  核心线程数
     * @param keepLive  空闲线程存活时长
     * @param queueSize 最大线程数
     * @param <T>       该参数泛型
     * @return Future<T>
     */
    public static <T> Future<T> submit(Callable<T> task, int coreSize, int keepLive, int queueSize) {
        if (task == null) {
            return null;
        }
        return getInstance().submit(task);
    }

    /**
     * 从线程队列中移除该线程
     *
     * @param obj 线程任务
     */
    public static void cancel(Object obj) {
        if (getInstance() != null) {
            getInstance().getQueue().remove(obj);
        }
    }
}
