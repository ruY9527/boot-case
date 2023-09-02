package com.yang.bean.anno;

import org.springframework.beans.factory.InitializingBean;
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
public class YangOne implements InitializingBean {


    @Autowired
    private YangTwo yangTwo;

    @Autowired
    private YangTwoServiceImpl yangTwoService;

    public YangOne(){

        System.out.println("YangOne构造函数方法");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        eat();
    }

    private void eat(){

        yangTwo.eat();
    }

}
