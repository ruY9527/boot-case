package com.iyang.bootbasicio.threads.pool;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

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
public class ExecutorsOneCase {

    public static void main(String[] args) throws Exception {

        ExecutorService es = Executors.newFixedThreadPool(2, new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build());
        final LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<String>();
        for(int i=0;i<=100;i++){
            deque.add(i+"");
        }

        es.submit(new Runnable() {
            @Override
            public void run() {
                while (!deque.isEmpty()) {
                    System.out.println(deque.poll() + "-" + Thread.currentThread().getName() + " GavinOne");
                }
            }
        });

        es.submit(new Runnable() {
            @Override
            public void run() {
                while (!deque.isEmpty()){
                    System.out.println(deque.poll() + "-" + Thread.currentThread().getName() + " GavinTwo");
                }
            }
        });

        Thread.sleep(10000l);
    }

}
