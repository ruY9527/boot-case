package com.iyang.bootbasicio.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-19
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class TimeFormatUtils {

    private TimeFormatUtils(){}

    /**
     * 当前时间转化为 String 格式化的时间.
     * @return
     */
    public static String nowTimeToString(){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sf.format(new Date());
    }

}
