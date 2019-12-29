package com.yang.boot.security.basic.exception;

import javax.security.sasl.AuthenticationException;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-12-29
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class VerificationCodeException extends AuthenticationException {

    public VerificationCodeException(){
        super("图形验证码检验失败");
    }



}
