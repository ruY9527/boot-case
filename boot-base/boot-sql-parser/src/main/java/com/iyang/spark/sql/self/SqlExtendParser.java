package com.iyang.spark.sql.self;

import com.iyang.spark.sql.SparkSQLLexer;
import com.iyang.spark.sql.SparkSQLParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.apache.calcite.sql.SqlBasicCall;
import org.apache.calcite.sql.SqlCall;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.parser.SqlParser;

import java.util.function.Function;

// import com.jiefei.sql.trino.TrinoLexer;
// import com.jiefei.sql.trino.TrinoParser;

/**
 * @author jiefei
 * @version : SqlParser.java, v 0.1 2023-05-05 17:16 jiefei
 */
public class SqlExtendParser {

    public SqlCall parseStatement() {

        return null;
    }

    public SqlBasicCall parseExpression(String expression) {
        return (SqlBasicCall) invokeSparkSQLParser("SparkSQL expression", expression, SparkSQLParser::singleExpression, config());
    }

    public SqlBasicCall parseAlterSql(String expression) {
        return (SqlBasicCall) invokeSparkSQLParser("SparkSQL expression", expression, SparkSQLParser::singleStatement, config());
    }

    public SqlBasicCall parseExpression(String expression, com.iyang.spark.sql.self.Config config) {
/*        if (config.getSqlDialect() instanceof PrestoSqlDialect) {
            return (SqlBasicCall) invokeTrinoParser("SparkSQL expression", expression, TrinoParser::standaloneExpression, config);
        }*/
        return (SqlBasicCall) invokeSparkSQLParser("SparkSQL expression", expression, SparkSQLParser::singleExpression, config);
    }

    private SqlNode invokeSparkSQLParser(String name, String sql, Function<SparkSQLParser, ParserRuleContext> parseFunction, SqlParser.Config config) {
        try {
            SparkSQLLexer lexer = new SparkSQLLexer(new CaseInsensitiveStream(CharStreams.fromString(sql)));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            SparkSQLParser parser = new SparkSQLParser(tokenStream);
            parser.setErrorHandler(new DefaultErrorStrategy()
            {
                @Override
                public Token recoverInline(Parser recognizer)
                        throws RecognitionException
                {
                    if (nextTokensContext == null) {
                        throw new InputMismatchException(recognizer);
                    }
                    throw new InputMismatchException(recognizer, nextTokensState, nextTokensContext);
                }
            });


            ParserRuleContext tree;
            try {
                // first, try parsing with potentially faster SLL mode
                parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
                tree = parseFunction.apply(parser);
            }
            catch (ParseCancellationException ex) {
                // if we fail, parse with LL mode
                tokenStream.seek(0); // rewind input stream
                parser.reset();

                parser.getInterpreter().setPredictionMode(PredictionMode.LL);
                tree = parseFunction.apply(parser);
            }
            return new SparkSQLAstBuilder(config).visit(tree);
        }
        catch (StackOverflowError e) {
            throw new ParsingException(name + " is too large (stack overflow while parsing)");
        }
    }

/*    private SqlNode invokeTrinoParser(String name, String sql, Function<TrinoParser, ParserRuleContext> parseFunction, SqlParser.Config config) {
        try {
            TrinoLexer lexer = new TrinoLexer(new CaseInsensitiveStream(CharStreams.fromString(sql)));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            TrinoParser parser = new TrinoParser(tokenStream);
            parser.setErrorHandler(new DefaultErrorStrategy()
            {
                @Override
                public Token recoverInline(Parser recognizer)
                        throws RecognitionException
                {
                    if (nextTokensContext == null) {
                        throw new InputMismatchException(recognizer);
                    }
                    throw new InputMismatchException(recognizer, nextTokensState, nextTokensContext);
                }
            });


            ParserRuleContext tree;
            try {
                // first, try parsing with potentially faster SLL mode
                parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
                tree = parseFunction.apply(parser);
            }
            catch (ParseCancellationException ex) {
                // if we fail, parse with LL mode
                tokenStream.seek(0); // rewind input stream
                parser.reset();

                parser.getInterpreter().setPredictionMode(PredictionMode.LL);
                tree = parseFunction.apply(parser);
            }
            return new TrinoAstBuilder(config).visit(tree);
        }
        catch (StackOverflowError e) {
            throw new ParsingException(name + " is too large (stack overflow while parsing)");
        }
    }*/

    public static SqlParser.Config config() {
        return SqlParser.Config.DEFAULT;
    }
}
