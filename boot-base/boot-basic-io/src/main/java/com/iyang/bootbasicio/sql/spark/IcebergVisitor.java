package com.iyang.bootbasicio.sql.spark;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/***
 * @author: yang_bao
 * @date: 2023/10/30
 * @desc:
 ***/

@Slf4j
public class IcebergVisitor extends SqlBaseBaseVisitor {


    private List<String> tableList = new ArrayList<>();

    @Override
    public List<String> visitSingleStatement(SqlBaseParser.SingleStatementContext ctx) {
        super.visitSingleStatement(ctx);


        return tableList;
    }


    @Override
    public List<String> visitTableIdentifier(SqlBaseParser.TableIdentifierContext ctx) {
        String db = ctx.db.getText();
        String table = ctx.table.getText();

        System.out.println("1111");
        log.info("the visitTableIdentifier db value is --> {} , table is ---> {} " , db, table);
        return tableList;
    }


    @Override
    public Object visitInsertOverwriteTable(SqlBaseParser.InsertOverwriteTableContext ctx) {

        return super.visitInsertOverwriteTable(ctx);
    }

/*    @Override
    public Object visitSingleInsertQuery(SqlBaseParser.SingleInsertQueryContext ctx) {
        String queryTermText = ctx.queryTerm().getText();
        String queryStart = ctx.queryTerm().getStart().getText();
        String queryStop = ctx.queryTerm().getStop().getText();


        SqlBaseParser.QueryTermContext termContext = ctx.queryTerm();

        log.info("the visitSingleInsertQuery.queryTerm() --> {}, start ---> {} , stop ---> {} ", queryTermText, queryStart, queryStop);
        return super.visitSingleInsertQuery(ctx);
    }*/

    @Override
    public Object visitUpdateTable(SqlBaseParser.UpdateTableContext ctx) {


        return super.visitUpdateTable(ctx);
    }


    @Override
    public Object visitDeleteFromTable(SqlBaseParser.DeleteFromTableContext ctx) {
        return super.visitDeleteFromTable(ctx);
    }
}
