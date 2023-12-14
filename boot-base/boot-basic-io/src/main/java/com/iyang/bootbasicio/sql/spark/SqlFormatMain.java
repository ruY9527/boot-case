package com.iyang.bootbasicio.sql.spark;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.apache.spark.sql.catalyst.parser.UpperCaseCharStream;

/***
 * @author: yang_bao
 * @date: 2023/10/30
 * @desc:
 ***/
public class SqlFormatMain {

    public static void main(String[] args) {

        String sql = "insert overwrite table a.table_test123\n" +
                "select * from bao_test.table_test";

        // String sql = "select * from bao_test.table_test";

        UpperCaseCharStream charStream = new UpperCaseCharStream(CharStreams.fromString(sql));
        SqlBaseLexer lexer = new SqlBaseLexer(charStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        SqlBaseParser parser = new SqlBaseParser(commonTokenStream);
        parser.getInterpreter().setPredictionMode(PredictionMode.SLL);

        IcebergVisitor sparkSqlAst = new IcebergVisitor();
        Object visit = sparkSqlAst.visit(parser.singleStatement());



    }

}
