package com.yang.bean.anno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-5-26
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/

@Configuration
public class YangBeanConfig {

    @Bean
    public YangBeanPost yangBeanPost(){
        return new YangBeanPost();
    }

}
