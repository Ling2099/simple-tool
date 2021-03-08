package com.huoguo.simpletool.constant;


/**
 * 默认常量类
 *
 * @author lizhenghuang
 */
public final class SimpleConstants {

    /** 默认核心线程数 **/
    public static final int DEFAULT_CORE_SIZE = 2 * Runtime.getRuntime().availableProcessors();

    /** 最大线程数 **/
    public static final int MAX_QUEUE_SIZE = 2 * Runtime.getRuntime().availableProcessors();

    /** 空闲线程存活时长 **/
    public static final int MAX_KEEP_LIVE = 5000;

}
