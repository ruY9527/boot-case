package com.iyang.bootbasicio.bytecodes;

import java.io.FileOutputStream;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-22
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class InitializerDemo {

    private int i = 10;

    private static int aa = 0;

    static {
        System.out.println("static");
    }

    public InitializerDemo(){
        int c = 30;
    }

    {
        int b = 20;
    }

}
