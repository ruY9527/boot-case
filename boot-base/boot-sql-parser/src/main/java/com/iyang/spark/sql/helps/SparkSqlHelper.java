package com.iyang.spark.sql.helps;

import com.iyang.spark.sql.SparkSQLLexer;
import com.iyang.spark.sql.SparkSQLParser;
import com.iyang.spark.sql.self.SparkSQLAstBuilder;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.apache.calcite.sql.parser.SqlParser;

/****
 * boot-case / com.iyang.spark.sql.helps
 * @author: Yang_Bao
 * @time: 2023/10/12 / 10:49
 * @desc:
 **/
public class SparkSqlHelper {

    private static final String QUERY_SQL = "SELECT * FROM AAA.BBB";
    private static final String ALERT_SQL = "ALTER TABLE HIVE_PROD.XIAOBAO_BIGSCREENT.T_ICCE_ENTERPRISE ADD COLUMNS ( SINK_TIME STRING COMMENT 'WRITE DATA TIME')";

    public static void main(String[] args) throws Exception {
        SqlParser.Config config = SqlParser.Config.DEFAULT;

        SparkSQLLexer lexer = new SparkSQLLexer(CharStreams.fromString(ALERT_SQL));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SparkSQLParser parser = new SparkSQLParser(tokenStream);
        parser.getInterpreter().setPredictionMode(PredictionMode.SLL);

        SparkSQLAstBuilder sqlAstBuilder = new SparkSQLAstBuilder(config);
        sqlAstBuilder.visit(parser.singleStatement());

    }

}
