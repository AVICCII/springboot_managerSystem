package com.aviccii.config;

import com.sun.corba.se.spi.resolver.LocalResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @Author: aviccii
 * @Description:
 * @Date: Created in 22:03 2020/8/12
 */
public class MyLocaleResolver implements LocaleResolver {

    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取请求中的语言参数
        String language = httpServletRequest.getParameter("l");
        Locale locale = Locale.getDefault();//如果没有就使用默认的

        //如果请求的连接携带了地区化的参数，
        if (!StringUtils.isEmpty(language)){
            //zh-CN
            String[] split = language.split("-");
            //国家，地区
        locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
