package com.iyang.rocketmq.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/****
 * author: BaoYang
 * date: 2023/6/7
 * desc:
 ***/

@Component
public class WebConfig implements WebMvcConfigurer {

    /**
     * 跨域配置方式一
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("*")
                // .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .maxAge(3600L);
    }


}
