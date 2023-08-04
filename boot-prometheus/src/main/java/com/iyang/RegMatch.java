package com.iyang;

/****
 * author: BaoYang
 * date: 2023/8/3
 * desc:
 ***/
public class RegMatch {


    private static final String JDBC_MATCH_REGEX = "jdbc:\\w+://\\S+:[0-9]{2,6}(/\\S*)?";

    private static final String JDBC_H2_PROTOCOL = "jdbc:h2";

    public static void validateJdbcUrl(String url) {
        if (!url.matches(JDBC_MATCH_REGEX) && !url.startsWith(JDBC_H2_PROTOCOL)) {
            throw new IllegalArgumentException("JDBC url format error!" + url);
        }
    }

    public static void main(String[] args) {

        String url = "jdbc:mysql://172.27.10.30:3306?a=123";
        validateJdbcUrl(url);

    }

}
