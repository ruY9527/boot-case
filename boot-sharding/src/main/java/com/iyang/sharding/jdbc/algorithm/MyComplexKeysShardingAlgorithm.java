package com.iyang.sharding.jdbc.algorithm;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/****
 * author: BaoYang
 * date: 2023/6/9
 * desc: 多个分片实例进行综合分片
 ***/

public class MyComplexKeysShardingAlgorithm implements ComplexKeysShardingAlgorithm<Long> {

    /**
     * collection : 源表
     * complexKeysShardingValue :  logicTableName  / columnNameAndShardingValuesMap /  columnNameAndRangeValuesMap
     *                  三个属性分别为： 逻辑表 / 分片列的精确值集合 /  分片列的范围值集合
     * @param collection
     * @param complexKeysShardingValue
     * @return
     */
    @Override
    public Collection<String> doSharding(Collection<String> collection,
                                         ComplexKeysShardingValue<Long> complexKeysShardingValue) {

        // select * from course where cid in (1,3,5) and userid Between 200 and 300;

        Collection<Long> cid = complexKeysShardingValue.getColumnNameAndShardingValuesMap().get("cid");
        Range<Long> userId = complexKeysShardingValue.getColumnNameAndRangeValuesMap().get("user_id");

        Long lowerEndpoint = userId.lowerEndpoint();
        Long upperEndpoint = userId.upperEndpoint();

        // 实现自定义分片逻辑 例如可以自己实现 course_$->{cid%2+1 + (30-20)+1} 这样的复杂分片逻辑
        List<String> resultList = cid.stream().map(v -> {
            BigInteger bigInteger = BigInteger.valueOf(v);
            BigInteger addResult = bigInteger.mod(BigInteger.valueOf(2L)).add(new BigInteger("1"));
            return "course_" + addResult;
        }).collect(Collectors.toList());

        return resultList;
    }

}
