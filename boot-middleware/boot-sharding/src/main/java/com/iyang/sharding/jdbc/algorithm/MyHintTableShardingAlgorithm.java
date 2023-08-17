package com.iyang.sharding.jdbc.algorithm;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.Arrays;
import java.util.Collection;

/****
 * author: BaoYang
 * date: 2023/6/9
 * desc:
 ***/
public class MyHintTableShardingAlgorithm implements HintShardingAlgorithm<Integer> {


    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames,
                                         HintShardingValue<Integer> shardingValue) {

        String key = "course_" + shardingValue.getValues().toArray()[0];
        if (availableTargetNames.contains(key)) {
            return Arrays.asList(key);
        }
        throw new UnsupportedOperationException("route "+key+" is not supported. please check your config");
        // return null;
    }

}
