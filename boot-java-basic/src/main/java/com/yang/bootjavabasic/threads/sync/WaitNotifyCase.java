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
public class WaitNotifyCase {

    public synchronized void doWait(){
        System.out.println(Thread.currentThread().getName() + " run");
        System.out.println(Thread.currentThread().getName() + " wait for condition");

        try{
            this.wait();
            System.out.println(Thread.currentThread().getName() + " continue");
        }catch (Exception e){
            e.printStackTrace();
            System.err.println(Thread.currentThread().getName() + " interrupted");
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void doNotify(){

        try {
            System.out.println(Thread.currentThread().getName() + " run");
            System.out.println(Thread.currentThread().getName() + " sleep 5 secs");
            Thread.sleep(5000l);
            this.notifyAll();

        }catch (Exception e){
            e.printStackTrace();
            System.err.println(Thread.currentThread().getName() + " interrupted");
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        WaitNotifyCase waitNotifyCase = new WaitNotifyCase();
        Thread tOne = new Thread(new Runnable() {
            @Override
            public void run() {
                waitNotifyCase.doWait();
            }
        });

        Thread tTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                waitNotifyCase.doNotify();
            }
        });

        tOne.start();
        tTwo.start();
    }
}
