package com.huoguo.simpletool.utils.id;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * 自行维护Hutool雪花ID单例模式
 *
 * @author lizhenghuang
 */
public class Snowflakes {

    private volatile static Snowflake snowflake = null;

    /**
     * 单例模式避免获取的ID重复
     *
     * @return cn.hutool.core.lang.Snowflake
     */
    private static Snowflake getSnowflake() {
        if (snowflake == null) {
            synchronized (Snowflakes.class) {
                if (snowflake == null) {
                    snowflake = IdUtil.getSnowflake(1, 1);
                }
            }
        }
        return snowflake;
    }

    /**
     * 获取雪花ID
     *
     * @return long
     */
    public static long nextId() {
        return getSnowflake().nextId();
    }
}
