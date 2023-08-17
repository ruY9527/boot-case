package com.iyang.bootbasicio.pojo;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-28
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class UserService {

    @GavinYangAutowired
    private User user;

    public UserService(){
        System.out.println("UserService 无参构造方法");
    }

    public void hello(){
        user.say();
    }

}
