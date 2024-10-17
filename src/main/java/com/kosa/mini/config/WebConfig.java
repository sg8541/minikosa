package com.kosa.mini.config;

import com.kosa.mini.interceptor.AdminInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AdminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminInterceptor)
                .addPathPatterns("/admin/**"); // /admin/** 경로에 인터셉터 적용
        //.excludePathPatterns("/admin/login", "/admin/register"); // 필요에 따라 제외할 경로 설정
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/stores/**")
                .addResourceLocations("file:C:/uploads/stores/");
        registry.addResourceHandler("/uploads/menus/**")
                .addResourceLocations("file:C:/uploads/menus/");
    }

}
