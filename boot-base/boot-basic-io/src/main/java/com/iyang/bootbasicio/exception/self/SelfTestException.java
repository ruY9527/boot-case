package com.iyang.bootbasicio.exception.self;

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
public class SelfTestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SelfTestException(){}

    public SelfTestException(String message){
        super(message);
    }

    public SelfTestException(final Throwable cause){
        super(cause);
    }

    public SelfTestException(String exceptionMesg, final Throwable cause){
        super(exceptionMesg,cause);
    }
}
