package com.iyang.sharding.jdbc.algorithm;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.Collection;

/****
 * author: BaoYang
 * date: 2023/6/9
 * desc: 自定义扩展hint分片算法。Hint分片的分片键从SQL语句中抽离出来，由程序自行指定;
 *      通过HintManager来指定。注意这个HintManager设置的分片键都是线程安全的
 ***/
public class MyHintDSShardingAlgorithm implements HintShardingAlgorithm<Integer> {


    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames,
                                         HintShardingValue<Integer> shardingValue) {

        // 对SQL的零侵入分片方案。shardingValue是通过HintManager



        return null;
    }


}
