package com.huoguo.simpletool.constant;

import java.util.regex.Pattern;

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

    /** 默认空字符串 **/
    public static final String NULLSTR = "";

    /** 默认下划线 **/
    public static final String SEPARATOR = "_";

    /** 默认正则英文字母大写 **/
    public static Pattern PATTERN = Pattern.compile("[A-Z]+");
}
