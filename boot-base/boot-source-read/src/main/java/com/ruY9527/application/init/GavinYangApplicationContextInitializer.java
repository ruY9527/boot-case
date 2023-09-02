package com.ruY9527.application.init;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-25
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/

public class GavinYangApplicationContextInitializer implements ApplicationContextInitializer {

    public GavinYangApplicationContextInitializer(){

        System.out.println("GavinYang Init Bean");
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {



    }

}
