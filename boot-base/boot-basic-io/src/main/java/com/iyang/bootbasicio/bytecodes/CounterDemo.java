package com.iyang.bootbasicio.bytecodes;

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
public class CounterDemo {

    private int count = 0;
    public void  increase(){
        ++ count;
    }

    public int getCount(){
        return count;
    }

}
