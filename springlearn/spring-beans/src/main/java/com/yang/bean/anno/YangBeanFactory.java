package com.yang.bean.anno;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-5-28
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/


@Component
public class YangBeanFactory implements BeanFactoryAware {

    public YangBeanFactory(){

        System.out.println("YangBeanFactory 构造函数中调用方法");
    }

    private static BeanFactory beanFactory;

    public static String beanFactoryTest(){

        return beanFactory.getClass().toString();

    }

    /***
     *
     * {@link org.springframework.beans.factory.support.DefaultListableBeanFactory}
     * 这里获取的 beanFactory 是上面的DefaultListableBeanFactory
     * 调用这个方法就是获取到 BeanFactory
     *
     *
     *  平常我们在项目中都会使用到 ApplicationContextAware,实现这个接口,然后在外面也一个 ApplicationContext
     *  来,实现的方法也有 setApplicationContext , 可以赋值给 我们定义的 ApplicationContext, 现在看起来,
     * 我们使用 BeanFactoryAware 也是可以来实现这个功能的.
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

        System.out.println("获取的BeanFactory名字" + beanFactory.getClass());

        YangBeanFactory.beanFactory = beanFactory;
    }



}
