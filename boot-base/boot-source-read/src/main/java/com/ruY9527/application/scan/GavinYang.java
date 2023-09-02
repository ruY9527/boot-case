package com.ruY9527.application.scan;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-24
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Indexed
public @interface GavinYang {

    String value() default "GavinYang";

}
