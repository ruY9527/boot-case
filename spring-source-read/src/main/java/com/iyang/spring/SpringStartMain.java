package com.iyang.spring;

import com.iyang.spring.bean.YangBeanOne;
import com.iyang.spring.config.StartReadConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-23
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/


public class SpringStartMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.iyang.spring");
        YangBeanOne yangBeanOne = context.getBean(YangBeanOne.class);
        System.out.println(yangBeanOne.getClass().toString());
    }
}
