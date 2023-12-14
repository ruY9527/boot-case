package com.iyang.bootbasicio.sql.hive.utils;

/***
 * @author: yang_bao
 * @date: 2023/11/5
 * @desc:
 ***/
public enum HiveActionEnum {

    SELECT("select"),
    ALERT("alter"),
    DELETE("delete"),
    UPDATE("update"),
    INSERT("insert"),
    DROP("drop"),
    CREATE("create")
    ;

    private String action;

    HiveActionEnum(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
