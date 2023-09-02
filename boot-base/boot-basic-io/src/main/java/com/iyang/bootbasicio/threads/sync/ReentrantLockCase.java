package com.iyang.bootbasicio.threads.sync;

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
public class ReentrantLockCase {

    private ReentrantLock lock = new ReentrantLock();

    public void execute(){

        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " do something synchronize");
            try {
                anotherLock();
                Thread.sleep(5000l);
            } catch (InterruptedException e) {
                System.err.println(Thread.currentThread().getName() + " interrupted");
                Thread.currentThread().interrupt();
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void anotherLock(){
        lock.lock();
        try {

            System.out.println(Thread.currentThread().getName() + " invoke anotherLock");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        ReentrantLockCase lockCase = new ReentrantLockCase();
        Thread tOne = new Thread(new Runnable() {
            @Override
            public void run() {
                lockCase.execute();
            }
        });

        Thread tTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                lockCase.execute();
            }
        });

        tOne.start();
        tTwo.start();
    }

}
