package com.yang.bean.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service
public class YangTwo {

    @Autowired
    private YangOne yangOne;

    public YangTwo(){

        System.out.println("YangTwo 构造函数方法");
    }


    public void eat(){

        System.out.println("YangYwo 中 eat方法");

    }

}
