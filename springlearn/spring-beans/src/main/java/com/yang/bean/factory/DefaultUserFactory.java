package com.yang.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-5-25
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class DefaultUserFactory implements InitializingBean, DisposableBean {


    @PostConstruct
    public void init(){
        System.out.println("DefaultUserFactory.class in init function初始化中......");
    }

    @Override
    public void destroy() throws Exception {

        System.out.println("DefaultUserFactory 正在进行销毁操作");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("DefaultUserFactory#afterPropertiesSet 调用使用过程中");
    }
}
