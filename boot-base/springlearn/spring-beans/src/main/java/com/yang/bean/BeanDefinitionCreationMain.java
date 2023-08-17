package com.yang.bean;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;

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
public class BeanDefinitionCreationMain {


    public static void main(String[] args) {
        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition();
        definitionBuilder.addPropertyValue("id",9527).addPropertyValue("name","GavinYang");
        BeanDefinition beanDefinition = definitionBuilder.getBeanDefinition();

        System.out.println(beanDefinition);
    }

}
