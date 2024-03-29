package com.iyang.spark.sql.function;

import org.apache.calcite.sql.*;

/**
 * @author jiefei
 * @version : SqlArrayFunction.java, v 0.1 2023-05-06 14:20 jiefei
 */
public class SqlArrayFunction extends SqlSpecialOperator {

    private static final com.iyang.spark.sql.function.SqlArrayFunction INSTANCE;

    private SqlArrayFunction() {
        super("ARRAY", SqlKind.OTHER, 100, false, null, null, null);
    }

    @Override
    public SqlSyntax getSyntax() {
        return super.getSyntax();
    }

    @Override
    public void unparse(SqlWriter writer, SqlCall call, int leftPrec, int rightPrec) {
        SqlWriter.Frame frame = writer.startList("ARRAY[", "]");

        assert call.getOperandList().size() >= 3;
        for (int i = 0; i < call.operandCount(); i++) {
            call.operand(i).unparse(writer, 0, 0);
        }
        writer.endList(frame);
    }

    static {
        INSTANCE = new com.iyang.spark.sql.function.SqlArrayFunction();
    }

    public static com.iyang.spark.sql.function.SqlArrayFunction of() {
        return INSTANCE;
    }

}
