package com.iyang.boot.redission.filters;

import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * @author : luohong
 * @desc :  Redis 实现布隆过滤器的底层就是通过bitmap这种数据结构.
 *          这里是基于Redission来构造布隆过滤器.
 * @since : 2021/4/6 / 上午10:27
 */
public class RedissonBloomFilter {

    public static void main(String[] args) {
//String
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379");
        RedissonClient redissonClient = Redisson.create(config);
        RBloomFilter<String> bloomFilter = redissonClient.getBloomFilter("phoneList");
        bloomFilter.tryInit(100000000L,0.03);
        bloomFilter.add("10086");
        bloomFilter.add("9527");

        System.out.println(bloomFilter.contains("10086"));
        System.out.println(bloomFilter.contains("95277"));

    }

}
