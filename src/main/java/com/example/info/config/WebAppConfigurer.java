package com.example.info.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截与不拦截的url
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/*.css", "/*.js", "/images/*.png", "/images/*.jpg", "/images/*.gif");
    }
}
