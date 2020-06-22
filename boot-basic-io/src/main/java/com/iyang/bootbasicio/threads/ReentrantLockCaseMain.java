package com.iyang.bootbasicio.threads;

import java.util.concurrent.locks.ReentrantLock;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-20
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class ReentrantLockCaseMain {

    private ReentrantLock lock = new ReentrantLock();


    public void lockUseCase(){

        lock.lock();
        try {
            System.out.println("执行业务代码逻辑");
        }finally {
            lock.unlock();
        }


    }

}
