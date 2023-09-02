package com.iyang.bootbasicio.threads.sync;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

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
public class ConditionCase {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Thread tOne = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try{
                    System.out.println(Thread.currentThread().getName() + " run");
                    System.out.println(Thread.currentThread().getName() + " wait for condition");
                    condition.await();
                    System.out.println(Thread.currentThread().getName() + " continue");
                }catch (Exception e){
                    e.printStackTrace();
                    System.err.println(Thread.currentThread().getName() + " interrupted");
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread tTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " run");
                    System.out.println(Thread.currentThread().getName() + " sleep 5 secs");
                    try {
                        Thread.sleep(5000l);
                    } catch (InterruptedException e) {
                        System.err.println(Thread.currentThread().getName() + " interrupted");
                        Thread.currentThread().interrupt();
                    }
                    condition.signalAll();
                } finally {
                    lock.unlock();
                }
            }
        });

        tOne.start();
        tTwo.start();
    }

}
