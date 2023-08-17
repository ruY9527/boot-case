package com.iyang.boot;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/****
 * author: BaoYang
 * date: 2023/8/4
 * desc:
 ***/

@Slf4j
@Component
public class ApplicationContextUtil  implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {

        applicationContext = context;

    }

    public static void getBeanByName(String name){

        Object bean = applicationContext.getBean(name);
        Class<?> aClass = bean.getClass();

        log.info("aClass name is ---> {} " , aClass.getName());

    }

    /**
     *  动态注入bean
     * @param requiredType 注入类
     * @param beanName bean名称
     */
    public static Object registerBean(String beanName){
        HikariDataSource hikariDataSource = new HikariDataSource();
        // HikariConfig hikariConfig = new HikariConfig();
        hikariDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        hikariDataSource.setJdbcUrl("jdbc:mysql://172.21.129.214:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");
        hikariDataSource.setUsername("root");
        hikariDataSource.setPassword("YdMysqlxx9");
        hikariDataSource.setPoolName("yangName");

        //将applicationContext转换为ConfigurableApplicationContext
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;

        //获取BeanFactory
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext.getAutowireCapableBeanFactory();

        //创建bean信息.
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(hikariDataSource.getClass());
        AbstractBeanDefinition definition = beanDefinitionBuilder
                .addConstructorArgValue(hikariDataSource).getBeanDefinition();
        definition.setPrimary(false);



        //动态注册bean.
        defaultListableBeanFactory.registerBeanDefinition(beanName, definition);

        //获取动态注册的bean.
        return configurableApplicationContext.getBean(beanName);
    }


}
