package com.iyang.test;

import com.iyang.spark.sql.self.SqlExtendParser;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.parser.SqlParser;
import org.apache.calcite.sql.parser.ddl.SqlDdlParserImpl;

/****
 * boot-case / com.iyang.test
 * @author: Yang_Bao
 * @time: 2023/10/12 / 10:49
 * @desc:
 **/

public class SparkSqlTestMain {

    private static final String ALTER_SQL = "ALTER TABLE HIVE_PROD.XIAOBAO_BIGSCREENT.T_ICCE_ENTERPRISE ADD COLUMNS ( SINK_TIME STRING COMMENT 'WRITE DATA TIME')";
    private static final String QUERY_SQL = "SELECT * FROM AAA.BBB";

    public static void main(String[] args) throws Exception {


/*        SqlParser.Config config = SqlParser.Config.DEFAULT.withParserFactory(SqlDdlParserImpl.FACTORY);
        final SqlNode node = SqlParser.create(ALTER_SQL, config).parseExpression();

        System.out.println(node);*/

        final SqlNode node = new SqlExtendParser().parseAlterSql(QUERY_SQL);
        System.out.println(node);
    }


}
