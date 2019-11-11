package com.yang.bootjavabasic.threads.sync;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

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
public class CountDownLatchCase {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(5);
        for(int i=0;i<5;i++){

            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " " + new Date() + " run");
                    try {
                        Thread.sleep(5000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }

        try{
            countDownLatch.await();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("all thread over");
    }

}
