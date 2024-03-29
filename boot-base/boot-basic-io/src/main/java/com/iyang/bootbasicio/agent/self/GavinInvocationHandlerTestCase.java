package com.iyang.bootbasicio.agent.self;

import com.iyang.bootbasicio.agent.UserService;
import com.iyang.bootbasicio.agent.UserServiceImpl;

import java.lang.reflect.Proxy;

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
public class GavinInvocationHandlerTestCase {


    public static void main(String[] args) {

        GavinInvocationHandler gavinInvocationHandler = new GavinInvocationHandler();
        UserService userService = new UserServiceImpl();
        gavinInvocationHandler.setTarget(userService);
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),gavinInvocationHandler);

        userServiceProxy.addUser();
        userServiceProxy.removeUser();
        userServiceProxy.searchUser();
    }

}
