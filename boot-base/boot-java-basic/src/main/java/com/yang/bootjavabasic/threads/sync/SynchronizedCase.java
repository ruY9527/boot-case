package com.yang.bootjavabasic.threads.sync;

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
public class SynchronizedCase {

    public synchronized void execute(){
        System.out.println(Thread.currentThread().getName() + " do something synchronize");
        try {
            anotherLock();
            Thread.sleep(5000l);
        }catch (Exception e){
            e.printStackTrace();
            System.err.println(Thread.currentThread().getName() + " interrupted");
            Thread.currentThread().interrupt();
        }
    }


    public synchronized void anotherLock(){
        System.out.println(Thread.currentThread().getName() + " invoke anotherLock");
    }

    public static void main(String[] args) {
        final SynchronizedCase synchronizedCase = new SynchronizedCase();

        Thread tOne = new Thread(new Runnable() {
            public void run() {
                synchronizedCase.execute();
            }
        });

        Thread tTwo = new Thread(new Runnable() {
            public void run() {
                synchronizedCase.execute();
            }
        });

        tOne.start();
        tTwo.start();
    }
}
