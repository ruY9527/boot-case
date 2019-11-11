package com.yang.bootjavabasic.agent.self;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

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
public class GavinInvocationHandler implements InvocationHandler {


    private Object target;

    public void setTarget(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(" Enter Gavin Class ");
        method.invoke(target,args);
        System.out.println(" End Gavin Class ");
        System.out.println();
        return null;
    }
}
