package com.iyang.bootbasicio.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

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
public class ThreadPoolExecutorMain {


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        //executorService.execute();
        executorService.execute(new Runnable() {
            @Override
            public void run() {

            }
        });

    }

}
