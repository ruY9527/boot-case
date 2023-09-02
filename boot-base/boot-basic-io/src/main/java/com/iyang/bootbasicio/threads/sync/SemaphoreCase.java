package com.iyang.bootbasicio.threads.sync;

import java.util.Date;
import java.util.concurrent.Semaphore;

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
public class SemaphoreCase {

    private static Semaphore semaphore = new Semaphore(2);


    public static void main(String[] args) {

        for(int i=0;i<5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + " " + new Date());
                        Thread.sleep(5000);
                        semaphore.release();
                    }catch (Exception e){
                        System.err.println(Thread.currentThread().getName() + " interrupted");
                    }
                }
            }).start();

        }
    }

}
