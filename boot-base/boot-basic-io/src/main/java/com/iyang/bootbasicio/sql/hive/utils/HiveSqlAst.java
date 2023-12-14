package com.iyang.bootbasicio.sql.hive.utils;

import com.iyang.bootbasicio.sql.hive.HiveParser;
import com.iyang.bootbasicio.sql.hive.HiveParserBaseVisitor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/***
 * @author: yang_bao
 * @date: 2023/11/3
 * @desc:
 ***/

@Slf4j
public class HiveSqlAst extends HiveParserBaseVisitor {

    private Map<String, Set<String>> dnTableActionMap = new HashMap<>();

    public HiveSqlAst() {
    }

    public HiveSqlAst(Map<String, Set<String>> dnTableActionMap) {
        this.dnTableActionMap = dnTableActionMap;
    }

    public Map<String, Set<String>> getDnTableActionMap() {
        return dnTableActionMap;
    }

    @Override
    public String visitStatement(HiveParser.StatementContext ctx) {
        log.info(" enter visitStatement function ");
/*        HiveParser.DdlStatementContext ddlStatementContext = ctx.execStatement().ddlStatement();
        HiveParser.TableNameContext nameContext = ddlStatementContext.alterStatement().tableName();
        String dbText = nameContext.db.getText();
        String tabText = nameContext.tab.getText();

        log.info("the db is {} , tab is {} , meta is {} " , dbText, tabText,1);*/

        super.visitStatement(ctx);
        return null;
        // return visitChildren(ctx);
    }

    @Override
    public Object visitSelectStatement(HiveParser.SelectStatementContext ctx) {
        System.out.println("\n");
        log.info("enter visitSelectStatement function ");
/*        HiveParser.AtomSelectStatementContext atomSelectStatementContext = ctx.atomSelectStatement();
        String tableName = atomSelectStatementContext.fromClause().fromSource().joinSource().atomjoinSource().tableSource().tabname.getText();

        log.info("the tableName is ---> {} " , tableName);*/
/*
        System.out.println(ctx.getText());
       try {
           SqlParser sqlParser = SqlParser.create(ctx.getText());
           SqlNode sqlNode = sqlParser.parseQuery();
           System.out.println(sqlNode);
       } catch (Exception e){
           e.printStackTrace();
       }
*/
/*        HiveParser.AtomSelectStatementContext atomCtx = ctx.atomSelectStatement();
        HiveParser.FromSourceContext fromSourceContext = atomCtx.fromClause().fromSource();
        HiveParser.AtomjoinSourceContext atomJoinSource = fromSourceContext.joinSource().atomjoinSource();
        String atomTableName = atomJoinSource.tableSource().getText();
        List<HiveParser.JoinSourcePartContext> partContexts = fromSourceContext.joinSource().joinSourcePart();
        for (HiveParser.JoinSourcePartContext sourcePartContext : partContexts) {
            String partTableName = sourcePartContext.tableSource().getText();
            log.info("the partTableName value is ---> {} ", partTableName);
        }
        log.info("the atomJoinTable value is ---> {} " , atomTableName);*/
        // String tabelName = ctx.atomSelectStatement().fromClause().fromSource().joinSource().atomjoinSource().tableSource().getText();

        HiveParser.AtomSelectStatementContext atomSelectStatement = ctx.atomSelectStatement();

        parseSelectSql(atomSelectStatement);
        return null;
    }


    @Override
    public Object visitInsertClause(HiveParser.InsertClauseContext ctx) {
        System.out.println("\n");
        HiveParser.TableOrPartitionContext tableOrPartition = ctx.destination().tableOrPartition();
        String tableName = tableOrPartition.tableName().getText();
        log.info("in visitInsertClause, the tableName is ---> {} " , tableName);
        return super.visitInsertClause(ctx);
    }

    @Override
    public Object visitAlterStatement(HiveParser.AlterStatementContext ctx) {
        System.out.println("\n");
        log.info(" enter visitAlterStatement func ");
        String tableName = ctx.tableName().getText();
        log.info("the tableName is {} " , tableName);

        // tableName 可能会带上catalog的名称；如果需要的话，需要进行catalog的切割
        // ALTER TABLE HIVE_PROD.XIAOBAO_BIGSCREENT.T_ICCE_ENTERPRISE ADD COLUMNS ( SINK_TIME STRING COMMENT 'WRITE DATA TIME')
        return super.visitAlterStatement(ctx);
    }

    @Override
    public Object visitCreateTableStatement(HiveParser.CreateTableStatementContext ctx) {

        String tableName = ctx.tableName().getText();
        log.info("in visitCreateTableStatement, the tableName is {} " , tableName);
        return super.visitCreateTableStatement(ctx);
    }

    @Override
    public Object visitUpdateStatement(HiveParser.UpdateStatementContext ctx) {
        String tableName = ctx.tableName().getText();
        log.info("in visitUpdateStatement, the tableName value is {} ", tableName);
        // where 中可能保存查询库或者表的条件
        setActionToMapByDbTableName(tableName, HiveActionEnum.UPDATE.getAction());
        return super.visitUpdateStatement(ctx);
    }

    @Override
    public Object visitDeleteStatement(HiveParser.DeleteStatementContext ctx) {
        String tableName = ctx.tableName().getText();
        log.info("in visitDeleteStatement, the tableName value is {} " , tableName);
        // where 中可能保存查询库或者表的条件

        return super.visitDeleteStatement(ctx);
    }

    @Override
    public Object visitDropTableStatement(HiveParser.DropTableStatementContext ctx) {
        String tableName = ctx.tableName().getText();
        log.info(" in visitDropTableStatement , the tableName is {} " , tableName);
        return super.visitDropTableStatement(ctx);
    }


    @Override
    public Object visitDropDatabaseStatement(HiveParser.DropDatabaseStatementContext ctx) {
        String dbName = ctx.db_schema().getText();
        log.info(" in visitDropDatabaseStatement, the dbName is {} " , dbName);
        return super.visitDropDatabaseStatement(ctx);
    }

    /**
     * 解析 select 查询的sql语句,获取对应的库和表信息
     */
    private void parseSelectSql(HiveParser.AtomSelectStatementContext atomSelectStatement){

        // atomSelectStatement 中存在需要解析的sql; fromSource,join,subQuery,
        HiveParser.JoinSourceContext sourceContext = atomSelectStatement.fromClause().fromSource().joinSource();
        // 获取传入进来的 atmo的表名字;判断非空即获取
        if (sourceContext.atomjoinSource().tableSource() != null){
            HiveParser.TableNameContext tabname = sourceContext.atomjoinSource().tableSource().tabname;
            log.info("the tabname value us ---> {} ", tabname.getText());
            setActionToMapByDbTableName(tabname.getText(), HiveActionEnum.SELECT.getAction());
        }
        for (HiveParser.JoinSourcePartContext sourcePartContext : sourceContext.joinSourcePart()) {
            // 解析join部分自身获取的 库和表信息
            if (sourcePartContext.tableSource() != null) {
                HiveParser.TableNameContext sourcePartTableName = sourcePartContext.tableSource().tabname;
                setActionToMapByDbTableName(sourcePartTableName.getText(), HiveActionEnum.SELECT.getAction());
                log.info("the sourcePartTableName value is ---> {}" , sourcePartTableName.getText());
            }
            // join部分的sql也是存在子sql的情况下;如果存在子sql的话,就进行迭代处理
            HiveParser.SubQuerySourceContext partSubQuery = sourcePartContext.subQuerySource();
            if (partSubQuery != null) {
                HiveParser.AtomSelectStatementContext partSubQueryAtmo = partSubQuery.queryStatementExpression().queryStatementExpressionBody().regularBody().selectStatement().atomSelectStatement();
                parseSelectSql(partSubQueryAtmo);
            }
            // 存在没有值的情况sql语句
            // HiveParser.TableNameContext sourcePartTableName = sourcePartContext.tableSource().tabname;
            // log.info("the sourcePartTableName value is ---> {}" , sourcePartTableName.getText());
        }

        // 子sql;如果子sql不是null
        HiveParser.SubQuerySourceContext subQuerySourceContext = sourceContext.atomjoinSource().subQuerySource();
        if (subQuerySourceContext != null) {
            HiveParser.AtomSelectStatementContext subQueryAtom = subQuerySourceContext.queryStatementExpression().queryStatementExpressionBody().regularBody().selectStatement().atomSelectStatement();
            parseSelectSql(subQueryAtom);
        }

    }

    /**
     * 封装 db table 对应的action到 map 集合中
     * @param dbTableName
     * @param action
     */
    private void setActionToMapByDbTableName(String dbTableName,String action){

        Set<String> dbTableActionSet = dnTableActionMap.getOrDefault(dbTableName, new HashSet<>());
        dbTableActionSet.add(action);
        dnTableActionMap.put(dbTableName, dbTableActionSet);

    }

}
