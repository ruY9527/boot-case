package com.iyang.boot.redission.filters;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author : luohong
 * @desc :  基于 Guava 包的 api 来实现布隆过滤器.
 * @since : 2021/4/6 / 下午10:14
 */
public class GuavaBloomFilter {


    public static void main(String[] args) {

        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), 100000, 0.01);
        bloomFilter.put("10086");
        bloomFilter.put("10010");

        System.out.println(bloomFilter.mightContain("10086"));
        System.out.println(bloomFilter.mightContain("9827"));

    }

}
