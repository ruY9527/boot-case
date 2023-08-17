package com.yang.bootjavabasic.agent;

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
public class UserServiceImpl implements UserService {

    @Override
    public void addUser() {

        System.out.println("Gavin ---> addUser");

    }

    @Override
    public void removeUser() {

        System.out.println("Gavin ---> removeUser");

    }

    @Override
    public void searchUser() {

        System.out.println("Gavin ---> searchUser");
    }
}
