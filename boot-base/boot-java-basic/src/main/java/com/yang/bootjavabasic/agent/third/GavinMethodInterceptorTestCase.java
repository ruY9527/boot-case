package com.yang.bootjavabasic.agent.third;

import com.yang.bootjavabasic.agent.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-11-10
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class GavinMethodInterceptorTestCase {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(new GavinMethodInterceptor());
        UserServiceImpl proxy = (UserServiceImpl) enhancer.create();

        proxy.addUser();
        proxy.removeUser();
        proxy.searchUser();
    }

}
