package com.ruY9527;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/****
 * author: BaoYang
 * date: 2023/7/27
 * desc:
 ***/

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Configuration
@ComponentScan(basePackages = { "com" })
public @interface YangSpringBootApplication {


}
