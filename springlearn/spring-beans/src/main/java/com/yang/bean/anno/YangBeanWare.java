package com.yang.bean.anno;

import org.springframework.beans.factory.BeanNameAware;
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
public class YangBeanWare implements BeanNameAware {

    private String beanBean;

    /*
    *  实现 BeanNameAware 接口,然后调用setBeanName方法即可获取到当前这个bean的名字.
    *  这里能感觉到的作用就是获取bean的名字
    *
    * **/
    @Override
    public void setBeanName(String name) {

        System.out.println("YangBeanWare方法中的name对应的值是" + name);
        beanBean = name;
    }


    public String getBeanBean() {
        return beanBean;
    }
}
