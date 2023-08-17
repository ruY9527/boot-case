package com.iyang.one.bean;

import com.iyang.one.bean.bean.GavinYangOneBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-27
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/

public class OneBeanStart {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.iyang.one.bean");

        GavinYangOneBean oneBean = context.getBean(GavinYangOneBean.class);

        oneBean.sleepppp();

    }


}
