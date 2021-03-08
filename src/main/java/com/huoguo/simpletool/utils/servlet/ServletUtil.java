package com.huoguo.simpletool.utils.servlet;

import cn.hutool.core.convert.Convert;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Tool
 *
 * @author lizhenghuang
 */
public class ServletUtil {

    /**
     * 获取ServletRequestAttributes
     *
     * @return ServletRequestAttributes
     */
    private static ServletRequestAttributes getRequestAttributes() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }

    /**
     * 获取HttpServletRequest
     *
     * @return HttpServletRequest
     */
    public static HttpServletRequest getRequest() {
        return getRequestAttributes().getRequest();
    }

    /**
     * 获取HttpServletResponse
     *
     * @return HttpServletResponse
     */
    public static HttpServletResponse getResponse() {
        return getRequestAttributes().getResponse();
    }

    /**
     * 获取HttpSession
     *
     * @return HttpSession
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * 获取请求参数
     *
     * @param name 参数名称
     * @return String
     */
    public static String getParameter(String name) {
        return getRequest().getParameter(name);
    }

    /**
     * 获取默认参数
     *
     * @param name         参数名称
     * @param defaultValue 默认参数值
     * @return String
     */
    public static String getParameter(String name, String defaultValue) {
        return Convert.toStr(getRequest().getParameter(name), defaultValue);
    }

    /**
     * 获取Integer类型参数
     *
     * @param name 参数名称
     * @return Integer
     */
    public static Integer getParameterToInt(String name) {
        return Convert.toInt(getRequest().getParameter(name));
    }

    /**
     * 获取默认Integer
     *
     * @param name         参数名称
     * @param defaultValue 默认参数值
     * @return Integer
     */
    public static Integer getParameterToInt(String name, Integer defaultValue) {
        return Convert.toInt(getRequest().getParameter(name), defaultValue);
    }
}
