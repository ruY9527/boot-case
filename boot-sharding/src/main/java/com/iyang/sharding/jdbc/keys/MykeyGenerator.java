package com.iyang.sharding.jdbc.keys;

import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;

/****
 * author: BaoYang
 * date: 2023/6/9
 * desc:
 ***/
public class MykeyGenerator implements ShardingKeyGenerator {

    private AtomicLong atom = new AtomicLong(0);

    private Properties properties = new Properties();

    @Override
    public Comparable<?> generateKey() {

        LocalDateTime localDateTime = LocalDateTime.now();
        String timestampS = DateTimeFormatter.ofPattern("HHmmssSSS").format(localDateTime);

        return Long.parseLong("" + timestampS + atom.incrementAndGet());
    }

    @Override
    public String getType() {
        return "MYKEY";
    }

    @Override
    public Properties getProperties() {
        return this.properties;
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
