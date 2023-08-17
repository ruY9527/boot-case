package com.iyang.bootsourceconditional.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.system.JavaVersion;

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

@ConditionalOnJava(JavaVersion.NINE)
public class ConditionBeanInImport {


    class SimpleBean{}

    public SimpleBean simpleBean(){

        System.out.println(" ---- SimpleBean --- ");

        return new SimpleBean();
    }

}
