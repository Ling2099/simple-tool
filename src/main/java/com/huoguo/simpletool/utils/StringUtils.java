package com.huoguo.simpletool.utils;

import com.huoguo.simpletool.constant.SimpleConstants;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;

/**
 * 字符串工具类
 *
 * @author lizhenghuang
 */
public final class StringUtils {

    /**
     * 获取参数不为空值
     *
     * @param value defaultValue 要判断的value
     * @return value 返回值
     */
    public static <T> T nvl(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }

    /**
     * 判断一个对象是否为空
     *
     * @param object Object
     * @return true：为空 false：非空
     */
    public static boolean isNull(Object object) {
        return object == null;
    }

    /**
     * 判断一个对象是否非空
     *
     * @param object Object
     * @return true：非空 false：空
     */
    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }

    /**
     * 判断一个字符串是否为空串
     *
     * @param str String
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(String str) {
        return isNull(str) || SimpleConstants.NULLSTR.equals(str.trim());
    }

    /**
     * 判断一个Collection是否为空， 包含List1，Set，Queue
     *
     * @param coll 要判断的Collection
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Collection<?> coll) {
        return isNull(coll) || coll.isEmpty();
    }

    /**
     * 判断一个对象数组是否为空
     *
     * @param objects 要判断的对象数组
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Object[] objects) {
        return isNull(objects) || (objects.length == 0);
    }

    /**
     * 判断一个Map是否为空
     *
     * @param map 要判断的Map
     * @return true：为空 false：非空
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return isNull(map) || map.isEmpty();
    }

    /**
     * 判断一个Collection是否非空，包含List，Set，Queue
     *
     * @param coll 要判断的Collection
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Collection<?> coll) {
        return !isEmpty(coll);
    }

    /**
     * 判断一个对象数组是否非空
     *
     * @param objects 要判断的对象数组
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Object[] objects) {
        return !isEmpty(objects);
    }

    /**
     * 判断一个Map是否为空
     *
     * @param map 要判断的Map
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    /**
     * 判断一个字符串是否为非空串
     *
     * @param str String
     * @return true：非空串 false：空串
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 判断一个对象是否是数组类型（Java基本型别的数组）
     *
     * @param object 对象
     * @return true：是数组 false：不是数组
     */
    public static boolean isArray(Object object) {
        return isNotNull(object) && object.getClass().isArray();
    }

    /**
     * 字符串去空格
     *
     * @param str 参数对象
     * @return String
     */
    public static String trim(String str) {
        return (str == null ? SimpleConstants.NULLSTR : str.trim());
    }

    /**
     * 截取字符串
     *
     * @param str   字符串
     * @param start 开始位置
     * @return String
     */
    public static String substring(final String str, int start) {
        int len = str.length();

        if (isNull(str)) {
            return SimpleConstants.NULLSTR;
        }

        if (start < 0) {
            start = len + start;
        }

        if (start < 0) {
            start = 0;
        }
        if (start > len) {
            return SimpleConstants.NULLSTR;
        }

        return str.substring(start);
    }

    /**
     * 截取字符串
     *
     * @param str   字符串
     * @param start 开始位置
     * @param end   结束位置
     * @return 结果
     */
    public static String substring(final String str, int start, int end) {
        int len = str.length();

        if (isNull(str)) {
            return SimpleConstants.NULLSTR;
        }

        if (end < 0) {
            end = len + end;
        }

        if (start < 0) {
            start = len + start;
        }

        if (end > len) {
            end = len;
        }

        if (start > end) {
            return SimpleConstants.NULLSTR;
        }

        if (start < 0) {
            start = 0;
        }
        if (end < 0) {
            end = 0;
        }

        return str.substring(start, end);
    }

    /**
     * 格式化文本, {} 表示占位符<br>
     * 此方法只是简单将占位符 {} 按照顺序替换为参数<br>
     * 如果想输出 {} 使用 \\转义 { 即可，如果想输出 {} 之前的 \ 使用双转义符 \\\\ 即可<br>
     * 例：<br>
     * 通常使用：format("this is {} for {}", "a", "b") -> this is a for b<br>
     * 转义{}： format("this is \\{} for {}", "a", "b") -> this is \{} for a<br>
     * 转义\： format("this is \\\\{} for {}", "a", "b") -> this is \a for b<br>
     *
     * @param template 文本模板，被替换的部分用 {} 表示
     * @param params   参数值
     * @return 格式化后的文本
     */
    public static String format(String template, Object... params) {
        if (isEmpty(params) || isEmpty(template)) {
            return template;
        }
        return StrFormatter.format(template, params);
    }

    /**
     * 是否包含字符串
     *
     * @param str     验证字符串
     * @param strings 字符串组
     * @return 包含返回true
     */
    public static boolean inStringIgnoreCase(String str, String... strings) {
        if (isNotNull(str) && isNotNull(strings)) {
            for (String s : strings) {
                if (str.equalsIgnoreCase(trim(s))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。 例如：HELLO_WORLD->HelloWorld
     *
     * @param name 转换前的下划线大写方式命名的字符串
     * @return 转换后的驼峰式命名的字符串
     */
    public static String convertToCamelCase(String name) {
        StringBuilder result = new StringBuilder();

        if (isNull(name) || isEmpty(name)) {
            return SimpleConstants.NULLSTR;
        }

        if (!name.contains(SimpleConstants.SEPARATOR)) {
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }

        String[] camels = name.split(SimpleConstants.SEPARATOR);
        for (String camel : camels) {
            if (camel.isEmpty()) {
                continue;
            }
            result.append(camel.substring(0, 1).toUpperCase());
            result.append(camel.substring(1).toLowerCase());
        }
        return result.toString();
    }

    /**
     * 下划线转驼峰命名
     *
     * @param str 参数字符串
     * @return String
     */
    public static String toCamelCase(String str) {
        if (isNull(str)) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            String c = String.valueOf(str.charAt(i));
            if (SimpleConstants.SEPARATOR.equals(c)) {
                i = i + 1;
                builder.append(c.toUpperCase());
                continue;
            }
            builder.append(c);
        }
        return builder.toString();
    }

    /**
     * 驼峰命名转下划线
     *
     * @param str 参数字符串
     * @return String
     */
    public static String toUnderScore(String str) {
        if (isNull(str)) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            String c = String.valueOf(str.charAt(i));
            Matcher matcher = SimpleConstants.PATTERN.matcher(c);
            if (matcher.matches()) {
                builder.append(SimpleConstants.SEPARATOR);
            }
            builder.append(c.toLowerCase());
        }
        return builder.toString();
    }

    /**
     * 对象转换
     *
     * @param obj Object
     * @param <T> T
     * @return T
     */
    @SuppressWarnings("unchecked")
    public static <T> T cast(Object obj) {
        return (T) obj;
    }
}
