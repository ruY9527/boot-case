package com.yang.bootjavabasic.threads.sync;

import java.text.SimpleDateFormat;
import java.util.Date;

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
public class ThreadLocalCase {

    private static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>(){

        @Override
        protected SimpleDateFormat initialValue() {
            // return super.initialValue();
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static void main(String[] args) {

        Thread tOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(dateFormatThreadLocal.get().format(new Date()));
            }
        });

        Thread tTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(dateFormatThreadLocal.get().format(new Date()));
            }
        });

        tOne.start();
        tTwo.start();
    }

}
