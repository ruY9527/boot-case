package com.iyang.bootbasicio.sql.hive.utils;

import com.iyang.bootbasicio.sql.hive.HiveLexer;
import com.iyang.bootbasicio.sql.hive.HiveParser;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.atn.PredictionMode;

import java.util.Map;
import java.util.Set;

/***
 * @author: yang_bao
 * @date: 2023/11/3
 * @desc:
 ***/

@Slf4j
public class HiveSqlHelper {


    private static final String ALERT_SQL = "ALTER TABLE HIVE_PROD.XIAOBAO_BIGSCREENT.T_ICCE_ENTERPRISE ADD COLUMNS ( SINK_TIME STRING COMMENT 'WRITE DATA TIME')";
    private static final String SIMPLE_QUERY_SQL = "SELECT * FROM AAA.CCC";
    private static final String MANY_TABLE_SQL = "SELECT \n" +
            "    NULL                        AS   ID,\n" +
            "    CAST(TEMP_A.CREATE_DATE AS TIMESTAMP)          AS   TIMEC,\n" +
            "    TEMP_A.ENTERPRISE_NUM       AS   ENTERPRISE_NUM,\n" +
            "    TEMP_B.USER_NUM             AS   USER_NUM,\n" +
            "    TEMP_A.VIRTUAL_TENANT       AS   VTENANT,\n" +
            "    CAST(NOW() AS TIMESTAMP)    AS   ETL_LOAD_TS\n" +
            "FROM (\n" +
            "    SELECT \n" +
            "        COUNT(DISTINCT A.ENTERPRISE_ID) AS ENTERPRISE_NUM,\n" +
            "        A.PLATFORM_VIRTUAL_TENANT       AS VIRTUAL_TENANT,\n" +
            "        A.CREATE_DATE                   AS CREATE_DATE\n" +
            "    FROM (SELECT ENTERPRISE_ID,PLATFORM_VIRTUAL_TENANT,SUBSTRING(CREATE_DATE,1,10) AS CREATE_DATE FROM DIM_BIGSCREENT.DIM_ECENTERPRISE_LIST_DI) A GROUP BY PLATFORM_VIRTUAL_TENANT,CREATE_DATE\n" +
            ") TEMP_A LEFT JOIN\n" +
            "(\n" +
            "    SELECT\n" +
            "        COUNT(DISTINCT A.USER_ID) AS USER_NUM,\n" +
            "        A.PLATFORM_VIRTUAL_TENANT AS VIRTUAL_TENANT,\n" +
            "        A.CREATE_DATE\n" +
            "    FROM (SELECT USER_ID,PLATFORM_VIRTUAL_TENANT,SUBSTRING(CREATE_DATE,1,10) AS CREATE_DATE FROM DIM_BIGSCREENT.DIM_ECUSERENTERPRISE_RELATION_LIST_DI) A GROUP BY PLATFORM_VIRTUAL_TENANT,CREATE_DATE\n" +
            ") TEMP_B ON TEMP_A.VIRTUAL_TENANT = TEMP_B.VIRTUAL_TENANT AND TEMP_A.CREATE_DATE = TEMP_B.CREATE_DATE";

    private static final String JOIN_SQL = "select * from aaa.aa as a left join ccc.cc as c on a.id = c.id  left join ddd.dd as d on a.id = d.id";

    private static final String INSERT_QUERY_SQL = "INSERT OVERWRITE TABLE aaa.cc\n" +
            "select * from aaa.aa";

    private static final String CREATE_DDL_SQL = "create table if not exists  ads_bigscreent.ads_cloud_info_sum_df (\n" +
            "\tid                       bigint   comment 'id(主键)'  \t\t\t\t\t\t,\n" +
            "\tplatform_id\t         \t string   comment '平台ID'                          ,\n" +
            "\tplatform_name\t         string   comment '平台名称'                        ,\n" +
            "\tenterprise_num\t         bigint   comment '上云企业数量'                    ,\n" +
            "\tuser_num\t             bigint   comment '注册用户数'                      ,\n" +
            "\ttransaction_num\t     \t bigint   comment '交易用户数'                      ,\n" +
            "\tdeviceconnection_num\t bigint   comment '设备连接数'                      ,\n" +
            "\tpartners_num\t         bigint   comment '生态伙伴数量'                    ,\n" +
            "\tapps_num\t             bigint   comment '工业app数量'                     ,\n" +
            "\tvtenant\t\t\t\t\tstring \t\tcomment '租户'\t\t\t\t\t\t\t,\n" +
            "\tlongitude\t    \t\tdecimal(25,10)  comment\t'经度'\t\t\t\t\t\t,\n" +
            "    latitude\t    \t\tdecimal(25,10)  comment\t'纬度'\t\t\t\t\t\t,\n" +
            "\tetl_load_ts              timestamp comment '创建时间'\n" +
            ")  comment  '上云情况详情'";

    private static final String UPDATE_QUERY_SQL = "update ads_bigscreent.ads_cloud_info_sum_df set name = '123' where id in (select id from aaaa.aa) and " +
            " name in (select name from ads_bigscreent.ads_cloud_info_sum_df)";

    private static final String DELETE_QUERT_SQl = "delete from ads_bigscreent.ads_cloud_info_sum_df where id in (select id from aaaa.cc)";

    private static final String DROP_TABLE_SQL = "drop table ads_bigscreent.ads_cloud_info_sum_df";

    private static final String DROP_DATABASE_SQL = "drop database ads_bigscreent";

    private static final String QUERY_SUB_SQl = "select * from aaa.a as a left join (select * from ccc.c) as c on a.id = c.id";

    public static void main(String[] args) {

        HiveLexer lexer = new HiveLexer(CharStreams.fromString(UPDATE_QUERY_SQL));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        HiveParser parser = new HiveParser(tokenStream);
        parser.getInterpreter().setPredictionMode(PredictionMode.SLL);

        HiveSqlAst hiveSqlAst = new HiveSqlAst();
        hiveSqlAst.visit(parser.statement());

        Map<String, Set<String>> dnTableActionMap = hiveSqlAst.getDnTableActionMap();
        log.info("the dnTableActionMap value is {} ", dnTableActionMap);
    }

}
