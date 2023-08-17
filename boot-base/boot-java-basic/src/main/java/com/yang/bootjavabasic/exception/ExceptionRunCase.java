package com.yang.bootjavabasic.exception;

import com.yang.bootjavabasic.exception.self.RunExceptionClazz;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-11-11
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class ExceptionRunCase {

    public static void main(String[] args) {

        functionOne();
        System.out.println("CCC");
    }

    public static void functionOne(){

        try{
            RunExceptionClazz runtimeException = new RunExceptionClazz();
            runtimeException.throwException();
        } catch (Exception e){

            throw new NullPointerException("Gavin Null Point ");
        } finally {
            System.out.println(" finally one ");
        }


    }

}
