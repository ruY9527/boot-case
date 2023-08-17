package com.yang.bean.anno;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-5-26
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/

public class YangBeanPost implements BeanPostProcessor {

    public YangBeanPost(){

        System.out.println("YangBeanPost中的无参构造方法");
    }

    /**
     * YangBeanPost中的无参构造方法
     * AnnoBeanMain 无惨构造方法
     *  YangBeanPost 中 beanName的值是 : annoBeanMain
     * YangServiceImpl 无参构造函数
     *  YangBeanPost 中 beanName的值是 : yangServiceImpl
     * YangTwoServiceImpl 中的无参数构造方法
     *  YangBeanPost 中 beanName的值是 : yangTwoServiceImpl
     *
     * 从打印的机构来看,自定义的bean在走完无参构造函数的时候,都会进入到这个 {@link YangBeanPost}的postProcessAfterInitialization方法中来.
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        // System.out.println(" YangBeanPost 中 beanName的值是 : " + beanName);
        return bean;
    }


}
