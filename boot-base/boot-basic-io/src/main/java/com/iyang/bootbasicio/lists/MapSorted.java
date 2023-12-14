package com.iyang.bootbasicio.lists;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

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

@Slf4j
public class MapSorted {

    /**
     * 消费数据
     */
    public static final Consumer<String> CCC =  (s) -> {
        log.info("com.iyang.bootbasicio.lists.MapSorted's CCC is {}" , s);
    };

    /**
     * Supplier 看起来更像是一种默认值的应用
     */
    public static final Supplier<String> SUPPLIER_STR = () ->  " 's test";

    /**
     * 定义function的调用
     */
    public static final Function<Integer, Integer> iFunciton =  (iValue) -> {
        if (iValue == null) {
            iValue =  0;
        }
        return iValue;
    };

    /**
     * 长度计算的
     */
    BiFunction<String,String,Integer> lengthSumFunction = (s1,s2) -> s1.length() + s2.length();

    /**
     * Runnable定义
     */
    public static Runnable rThread = () -> {
        System.out.println("rThread 运行操作");
    };

    /**
     * 排序
     */
    Comparator<Integer> integerComparator =  (o1,o2) -> {
        log.info("the o1 is ---> {} ", o1);
        log.info("the o2 is ---> {} " , o2);
        return o1.compareTo(o2);
    };

    /**
     * Map的字典
     */
    public static void mapPrint(){
        Map<String,Integer> maps = new HashMap<>();
        maps.put("zhangsan", 22);
        maps.put("lisi", 24);
        maps.put("wangwu", 18);
        maps.put("zhaoliu", 22);

        Comparator<Map.Entry<String, Integer>> valCmp = (Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) -> o1.getValue() - o2.getValue();
        List<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(maps.entrySet());
        Collections.sort(list,valCmp);
        for(Map.Entry<String,Integer> entry : list){
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // 获取第一个是否存在
        Optional<String> first = maps.entrySet().stream().filter(v -> "BaoYang".equalsIgnoreCase(v.getKey())).map(Map.Entry::getKey).findFirst();
        log.info("the first exist : {} " , first.orElseGet(SUPPLIER_STR));

        // 非空判断
        Objects.requireNonNull(maps);
    }

    /**
     * 收集List转换Map
     */
    public static void statisticsListToMap(){

        List<DictInfo> dictInfos = Arrays.asList(
                DictInfo.builder().key("key1").value(1).build(),
                DictInfo.builder().key("key1").value(21).build(),
                DictInfo.builder().key("key2").value(11).build(),
                DictInfo.builder().key("key3").value(null).build()
        );
        Map<String, Integer> dictSumMap = new HashMap<>();
        dictInfos.forEach(v -> dictSumMap.merge(v.getKey(), iFunciton.apply(v.getValue()),Integer::sum));
        System.out.println(dictSumMap);

        // 收集集合的操作, 于之前的 for 判断是否存在然后add调整操作
        Map<String, List<Integer>> dictIntegerList = new HashMap<>();
        dictInfos.stream().forEach(v -> dictIntegerList.computeIfAbsent(v.getKey(), vv -> new ArrayList<>()).add(v.getValue()));
        log.info(" the dictIntegerList is ---> {}" , dictIntegerList);
    }

    /**
     * recu
     */
    public static void extractReduce(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer sumValue = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sumValue);
    }

    public static void main(String[] args) {

        statisticsListToMap();
        // statisticsListToMap();
        // new Thread(rThread).start();
        // CCC.accept("baoyang");
    }

}
