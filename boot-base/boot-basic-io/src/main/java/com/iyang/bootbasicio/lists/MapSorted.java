package com.iyang.bootbasicio.lists;

import org.springframework.util.CollectionUtils;

import java.util.*;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-7-3
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/

public class MapSorted {


    public static void main(String[] args) {

        Map<String,Integer> maps = new HashMap<String, Integer>();
        maps.put("zhangsan", 22);
        maps.put("lisi", 24);
        maps.put("wangwu", 18);
        maps.put("zhaoliu", 22);


        Comparator<Map.Entry<String, Integer>> valCmp = new Comparator<Map.Entry<String,Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // 降序排序，如果想升序就反过来
                return o1.getValue()-o2.getValue();
            }
        };

        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(maps.entrySet());
        Collections.sort(list,valCmp);

        for(Map.Entry<String,Integer> entry : list){
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

}
