package com.iyang.spark.sql.self;

import com.google.common.collect.Lists;
import com.iyang.spark.sql.SparkSQLParser;
import com.iyang.spark.sql.SparkSQLParserBaseVisitor;
import com.iyang.spark.sql.function.SqlOverlayFunction;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.calcite.sql.SqlBasicCall;
import org.apache.calcite.sql.SqlIdentifier;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.parser.SqlParser;
import org.apache.calcite.sql.parser.SqlParserPos;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

/**
 * @author jiefei
 * @version : SparkSqlAstBuilder.java, v 0.1 2023-05-05 17:45 jiefei
 */

@Slf4j
public class SparkSQLAstBuilder extends SparkSQLParserBaseVisitor<SqlNode> {

    private final SqlParser.Config config;

    public SparkSQLAstBuilder(SqlParser.Config config)
    {
        this.config = requireNonNull(config, "parsingOptions is null");
    }

    @Override
    public SqlNode visitAlterTableAlterColumn(SparkSQLParser.AlterTableAlterColumnContext ctx) {

        System.out.println("进入到  visitAlterTableAlterColumn ");
        return super.visitAlterTableAlterColumn(ctx);
    }

    @Override
    public SqlNode visitAlterColumnAction(SparkSQLParser.AlterColumnActionContext ctx) {

        System.out.println("进入到  visitAlterColumnAction ");
        return super.visitAlterColumnAction(ctx);
    }

    @Override
    public SqlNode visitQuotedIdentifierAlternative(SparkSQLParser.QuotedIdentifierAlternativeContext ctx) {

        System.out.println("进入到 visitQuotedIdentifierAlternative 中来");
        return visitChildren(ctx);
    }

    @Override
    public SqlNode visitSingleStatement(SparkSQLParser.SingleStatementContext context)
    {
        log.info("进入到 visitSingleStatement 中来");
        String startText = context.start.getText();
        String stopText = context.stop.getText();

        super.visitSingleStatement(context);

        return visit(context.statement());
    }


    @Override
    public SqlNode visitTableIdentifier(SparkSQLParser.TableIdentifierContext ctx) {
        String db = ctx.db == null ? "" : ctx.db.getText();
        String tableName = ctx.table == null ? "" : ctx.table.getText();

        return null;
    }


    @Override
    public SqlNode visitSingleExpression(SparkSQLParser.SingleExpressionContext context)
    {
        return visit(context.namedExpression());
    }

    @Override
    public SqlNode visitOverlay(SparkSQLParser.OverlayContext ctx) {
        return new SqlBasicCall(SqlOverlayFunction.of(),
                visitList(ctx.valueExpression(), SqlNode.class), getSqlParserPos(ctx));
    }

    @Override
    public SqlNode visitDereference(SparkSQLParser.DereferenceContext ctx) {
        return new SqlIdentifier(Lists.newArrayList(caseSensitive(ctx.getText()).split("\\.")), getSqlParserPos(ctx));
    }



    @Override
    public SqlNode visitIdentifier(SparkSQLParser.IdentifierContext ctx) {
        return new SqlIdentifier(caseSensitive(ctx.getText()), getSqlParserPos(ctx));
    }

    private <T> T visitIfPresent(ParserRuleContext ctx, Class<T> clazz) {
        if (ctx == null) {
            return null;
        }
        SqlNode visit = visit(ctx);
        return clazz.cast(visit);
    }

    private <T> List<T> visitList(List<? extends ParserRuleContext> ctxs, Class<T> clazz) {
        return ctxs.stream().map(x -> visitIfPresent(x, clazz)).collect(Collectors.toList());
    }

    public SqlParserPos getSqlParserPos(ParserRuleContext ctx) {
        return new SqlParserPos(ctx.getStart().getLine(), ctx.getStart().getStartIndex());
    }

    private String caseSensitive(String text) {
        text = text.replaceAll("\\r", " ").replaceAll("\\n", " ");
        if (config.caseSensitive()) {
            return text;
        }
        return text.toLowerCase(Locale.ROOT);
    }

}
