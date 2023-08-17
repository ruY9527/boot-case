package com.iyang.mvc.web;

import com.iyang.mvc.web.config.WebStartScanConfig;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-24
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class StartMain {

    /***
     * 1 : 启动Tomcat服务器
     * 2 : Tomcat读取web.xml并且初始化DispatcherServlet.
     * 3 : DispatcherServlet  创建IOC容器并且自动注册到ServletContext中
     *
     *
     * @param args
     */
    public static void main(String[] args) {

        // AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebStartScanConfig.class);


    }

}
