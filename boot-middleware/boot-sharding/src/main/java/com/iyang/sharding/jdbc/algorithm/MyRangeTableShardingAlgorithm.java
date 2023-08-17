package com.iyang.sharding.jdbc.algorithm;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Arrays;
import java.util.Collection;

/****
 * author: BaoYang
 * date: 2023/6/9
 * desc:
 ***/
public class MyRangeTableShardingAlgorithm  implements RangeShardingAlgorithm<Long> {


    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames,
                                         RangeShardingValue<Long> shardingValue) {

        Long lowerEndpoint = shardingValue.getValueRange().lowerEndpoint();
        Long upperEndpoint = shardingValue.getValueRange().upperEndpoint();


        return Arrays.asList(shardingValue.getLogicTableName()+"_1" , shardingValue.getLogicTableName()+"_2");
    }

}
