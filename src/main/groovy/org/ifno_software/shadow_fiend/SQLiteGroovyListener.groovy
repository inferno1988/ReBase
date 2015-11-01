package org.ifno_software.shadow_fiend

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.ErrorNode
import org.antlr.v4.runtime.tree.TerminalNode

/**
 * Created by inferno on 11/1/15.
 */
class SQLiteGroovyListener implements SQLiteListener{
    boolean isColumnName

    @Override
    void enterParse(SQLiteParser.ParseContext ctx) {

    }

    @Override
    void exitParse(SQLiteParser.ParseContext ctx) {

    }

    @Override
    void enterError(SQLiteParser.ErrorContext ctx) {

    }

    @Override
    void exitError(SQLiteParser.ErrorContext ctx) {

    }

    @Override
    void enterSql_stmt_list(SQLiteParser.Sql_stmt_listContext ctx) {

    }

    @Override
    void exitSql_stmt_list(SQLiteParser.Sql_stmt_listContext ctx) {

    }

    @Override
    void enterSql_stmt(SQLiteParser.Sql_stmtContext ctx) {

    }

    @Override
    void exitSql_stmt(SQLiteParser.Sql_stmtContext ctx) {

    }

    @Override
    void enterAlter_table_stmt(SQLiteParser.Alter_table_stmtContext ctx) {

    }

    @Override
    void exitAlter_table_stmt(SQLiteParser.Alter_table_stmtContext ctx) {

    }

    @Override
    void enterAnalyze_stmt(SQLiteParser.Analyze_stmtContext ctx) {

    }

    @Override
    void exitAnalyze_stmt(SQLiteParser.Analyze_stmtContext ctx) {

    }

    @Override
    void enterAttach_stmt(SQLiteParser.Attach_stmtContext ctx) {

    }

    @Override
    void exitAttach_stmt(SQLiteParser.Attach_stmtContext ctx) {

    }

    @Override
    void enterBegin_stmt(SQLiteParser.Begin_stmtContext ctx) {

    }

    @Override
    void exitBegin_stmt(SQLiteParser.Begin_stmtContext ctx) {

    }

    @Override
    void enterCommit_stmt(SQLiteParser.Commit_stmtContext ctx) {

    }

    @Override
    void exitCommit_stmt(SQLiteParser.Commit_stmtContext ctx) {

    }

    @Override
    void enterCompound_select_stmt(SQLiteParser.Compound_select_stmtContext ctx) {

    }

    @Override
    void exitCompound_select_stmt(SQLiteParser.Compound_select_stmtContext ctx) {

    }

    @Override
    void enterCreate_index_stmt(SQLiteParser.Create_index_stmtContext ctx) {

    }

    @Override
    void exitCreate_index_stmt(SQLiteParser.Create_index_stmtContext ctx) {

    }

    @Override
    void enterCreate_table_stmt(SQLiteParser.Create_table_stmtContext ctx) {
        String tableName = ctx.table_name().getText().capitalize().concat("Entity");
        println("public static abstract class " + tableName + " implements BaseColumns {");
    }

    @Override
    void exitCreate_table_stmt(SQLiteParser.Create_table_stmtContext ctx) {
        println("}")
    }

    @Override
    void enterCreate_trigger_stmt(SQLiteParser.Create_trigger_stmtContext ctx) {

    }

    @Override
    void exitCreate_trigger_stmt(SQLiteParser.Create_trigger_stmtContext ctx) {

    }

    @Override
    void enterCreate_view_stmt(SQLiteParser.Create_view_stmtContext ctx) {

    }

    @Override
    void exitCreate_view_stmt(SQLiteParser.Create_view_stmtContext ctx) {

    }

    @Override
    void enterCreate_virtual_table_stmt(SQLiteParser.Create_virtual_table_stmtContext ctx) {

    }

    @Override
    void exitCreate_virtual_table_stmt(SQLiteParser.Create_virtual_table_stmtContext ctx) {

    }

    @Override
    void enterDelete_stmt(SQLiteParser.Delete_stmtContext ctx) {

    }

    @Override
    void exitDelete_stmt(SQLiteParser.Delete_stmtContext ctx) {

    }

    @Override
    void enterDelete_stmt_limited(SQLiteParser.Delete_stmt_limitedContext ctx) {

    }

    @Override
    void exitDelete_stmt_limited(SQLiteParser.Delete_stmt_limitedContext ctx) {

    }

    @Override
    void enterDetach_stmt(SQLiteParser.Detach_stmtContext ctx) {

    }

    @Override
    void exitDetach_stmt(SQLiteParser.Detach_stmtContext ctx) {

    }

    @Override
    void enterDrop_index_stmt(SQLiteParser.Drop_index_stmtContext ctx) {

    }

    @Override
    void exitDrop_index_stmt(SQLiteParser.Drop_index_stmtContext ctx) {

    }

    @Override
    void enterDrop_table_stmt(SQLiteParser.Drop_table_stmtContext ctx) {

    }

    @Override
    void exitDrop_table_stmt(SQLiteParser.Drop_table_stmtContext ctx) {

    }

    @Override
    void enterDrop_trigger_stmt(SQLiteParser.Drop_trigger_stmtContext ctx) {

    }

    @Override
    void exitDrop_trigger_stmt(SQLiteParser.Drop_trigger_stmtContext ctx) {

    }

    @Override
    void enterDrop_view_stmt(SQLiteParser.Drop_view_stmtContext ctx) {

    }

    @Override
    void exitDrop_view_stmt(SQLiteParser.Drop_view_stmtContext ctx) {

    }

    @Override
    void enterFactored_select_stmt(SQLiteParser.Factored_select_stmtContext ctx) {

    }

    @Override
    void exitFactored_select_stmt(SQLiteParser.Factored_select_stmtContext ctx) {

    }

    @Override
    void enterInsert_stmt(SQLiteParser.Insert_stmtContext ctx) {

    }

    @Override
    void exitInsert_stmt(SQLiteParser.Insert_stmtContext ctx) {

    }

    @Override
    void enterPragma_stmt(SQLiteParser.Pragma_stmtContext ctx) {

    }

    @Override
    void exitPragma_stmt(SQLiteParser.Pragma_stmtContext ctx) {

    }

    @Override
    void enterReindex_stmt(SQLiteParser.Reindex_stmtContext ctx) {

    }

    @Override
    void exitReindex_stmt(SQLiteParser.Reindex_stmtContext ctx) {

    }

    @Override
    void enterRelease_stmt(SQLiteParser.Release_stmtContext ctx) {

    }

    @Override
    void exitRelease_stmt(SQLiteParser.Release_stmtContext ctx) {

    }

    @Override
    void enterRollback_stmt(SQLiteParser.Rollback_stmtContext ctx) {

    }

    @Override
    void exitRollback_stmt(SQLiteParser.Rollback_stmtContext ctx) {

    }

    @Override
    void enterSavepoint_stmt(SQLiteParser.Savepoint_stmtContext ctx) {

    }

    @Override
    void exitSavepoint_stmt(SQLiteParser.Savepoint_stmtContext ctx) {

    }

    @Override
    void enterSimple_select_stmt(SQLiteParser.Simple_select_stmtContext ctx) {

    }

    @Override
    void exitSimple_select_stmt(SQLiteParser.Simple_select_stmtContext ctx) {

    }

    @Override
    void enterSelect_stmt(SQLiteParser.Select_stmtContext ctx) {

    }

    @Override
    void exitSelect_stmt(SQLiteParser.Select_stmtContext ctx) {

    }

    @Override
    void enterSelect_or_values(SQLiteParser.Select_or_valuesContext ctx) {

    }

    @Override
    void exitSelect_or_values(SQLiteParser.Select_or_valuesContext ctx) {

    }

    @Override
    void enterUpdate_stmt(SQLiteParser.Update_stmtContext ctx) {

    }

    @Override
    void exitUpdate_stmt(SQLiteParser.Update_stmtContext ctx) {

    }

    @Override
    void enterUpdate_stmt_limited(SQLiteParser.Update_stmt_limitedContext ctx) {

    }

    @Override
    void exitUpdate_stmt_limited(SQLiteParser.Update_stmt_limitedContext ctx) {

    }

    @Override
    void enterVacuum_stmt(SQLiteParser.Vacuum_stmtContext ctx) {

    }

    @Override
    void exitVacuum_stmt(SQLiteParser.Vacuum_stmtContext ctx) {

    }

    @Override
    void enterColumn_def(SQLiteParser.Column_defContext ctx) {
        if (ctx.column_name().any_name().keyword() != null)
            return;

        def typeName = "Object";
        switch (ctx.type_name().name(0).any_name().keyword().start.type) {
            case SQLiteParser.K_INTEGER:
                typeName = "int";
                break;
            case SQLiteParser.K_TEXT:
                typeName = "String"
                break;
            case SQLiteParser.K_NUMERIC:
                typeName = "bool"
                break;
        }
        def columnNameSimple = ctx.column_name().any_name().text
        def columnNameCaps = columnNameSimple.toUpperCase()
            println("       public static final $typeName COLUMN_NAME_$columnNameCaps = \"$columnNameSimple\";")
    }

    @Override
    void exitColumn_def(SQLiteParser.Column_defContext ctx) {

    }

    @Override
    void enterType_name(SQLiteParser.Type_nameContext ctx) {

    }

    @Override
    void exitType_name(SQLiteParser.Type_nameContext ctx) {

    }

    @Override
    void enterColumn_constraint(SQLiteParser.Column_constraintContext ctx) {

    }

    @Override
    void exitColumn_constraint(SQLiteParser.Column_constraintContext ctx) {

    }

    @Override
    void enterConflict_clause(SQLiteParser.Conflict_clauseContext ctx) {

    }

    @Override
    void exitConflict_clause(SQLiteParser.Conflict_clauseContext ctx) {

    }

    @Override
    void enterExpr(SQLiteParser.ExprContext ctx) {

    }

    @Override
    void exitExpr(SQLiteParser.ExprContext ctx) {

    }

    @Override
    void enterForeign_key_clause(SQLiteParser.Foreign_key_clauseContext ctx) {

    }

    @Override
    void exitForeign_key_clause(SQLiteParser.Foreign_key_clauseContext ctx) {

    }

    @Override
    void enterRaise_function(SQLiteParser.Raise_functionContext ctx) {

    }

    @Override
    void exitRaise_function(SQLiteParser.Raise_functionContext ctx) {

    }

    @Override
    void enterIndexed_column(SQLiteParser.Indexed_columnContext ctx) {

    }

    @Override
    void exitIndexed_column(SQLiteParser.Indexed_columnContext ctx) {

    }

    @Override
    void enterTable_constraint(SQLiteParser.Table_constraintContext ctx) {

    }

    @Override
    void exitTable_constraint(SQLiteParser.Table_constraintContext ctx) {

    }

    @Override
    void enterWith_clause(SQLiteParser.With_clauseContext ctx) {

    }

    @Override
    void exitWith_clause(SQLiteParser.With_clauseContext ctx) {

    }

    @Override
    void enterQualified_table_name(SQLiteParser.Qualified_table_nameContext ctx) {

    }

    @Override
    void exitQualified_table_name(SQLiteParser.Qualified_table_nameContext ctx) {

    }

    @Override
    void enterOrdering_term(SQLiteParser.Ordering_termContext ctx) {

    }

    @Override
    void exitOrdering_term(SQLiteParser.Ordering_termContext ctx) {

    }

    @Override
    void enterPragma_value(SQLiteParser.Pragma_valueContext ctx) {

    }

    @Override
    void exitPragma_value(SQLiteParser.Pragma_valueContext ctx) {

    }

    @Override
    void enterCommon_table_expression(SQLiteParser.Common_table_expressionContext ctx) {

    }

    @Override
    void exitCommon_table_expression(SQLiteParser.Common_table_expressionContext ctx) {

    }

    @Override
    void enterResult_column(SQLiteParser.Result_columnContext ctx) {

    }

    @Override
    void exitResult_column(SQLiteParser.Result_columnContext ctx) {

    }

    @Override
    void enterTable_or_subquery(SQLiteParser.Table_or_subqueryContext ctx) {

    }

    @Override
    void exitTable_or_subquery(SQLiteParser.Table_or_subqueryContext ctx) {

    }

    @Override
    void enterJoin_clause(SQLiteParser.Join_clauseContext ctx) {

    }

    @Override
    void exitJoin_clause(SQLiteParser.Join_clauseContext ctx) {

    }

    @Override
    void enterJoin_operator(SQLiteParser.Join_operatorContext ctx) {

    }

    @Override
    void exitJoin_operator(SQLiteParser.Join_operatorContext ctx) {

    }

    @Override
    void enterJoin_constraint(SQLiteParser.Join_constraintContext ctx) {

    }

    @Override
    void exitJoin_constraint(SQLiteParser.Join_constraintContext ctx) {

    }

    @Override
    void enterSelect_core(SQLiteParser.Select_coreContext ctx) {

    }

    @Override
    void exitSelect_core(SQLiteParser.Select_coreContext ctx) {

    }

    @Override
    void enterCompound_operator(SQLiteParser.Compound_operatorContext ctx) {

    }

    @Override
    void exitCompound_operator(SQLiteParser.Compound_operatorContext ctx) {

    }

    @Override
    void enterCte_table_name(SQLiteParser.Cte_table_nameContext ctx) {

    }

    @Override
    void exitCte_table_name(SQLiteParser.Cte_table_nameContext ctx) {

    }

    @Override
    void enterSigned_number(SQLiteParser.Signed_numberContext ctx) {

    }

    @Override
    void exitSigned_number(SQLiteParser.Signed_numberContext ctx) {

    }

    @Override
    void enterLiteral_value(SQLiteParser.Literal_valueContext ctx) {

    }

    @Override
    void exitLiteral_value(SQLiteParser.Literal_valueContext ctx) {

    }

    @Override
    void enterUnary_operator(SQLiteParser.Unary_operatorContext ctx) {

    }

    @Override
    void exitUnary_operator(SQLiteParser.Unary_operatorContext ctx) {

    }

    @Override
    void enterError_message(SQLiteParser.Error_messageContext ctx) {

    }

    @Override
    void exitError_message(SQLiteParser.Error_messageContext ctx) {

    }

    @Override
    void enterModule_argument(SQLiteParser.Module_argumentContext ctx) {

    }

    @Override
    void exitModule_argument(SQLiteParser.Module_argumentContext ctx) {

    }

    @Override
    void enterColumn_alias(SQLiteParser.Column_aliasContext ctx) {

    }

    @Override
    void exitColumn_alias(SQLiteParser.Column_aliasContext ctx) {

    }

    @Override
    void enterKeyword(SQLiteParser.KeywordContext ctx) {

    }

    @Override
    void exitKeyword(SQLiteParser.KeywordContext ctx) {

    }

    @Override
    void enterName(SQLiteParser.NameContext ctx) {

    }

    @Override
    void exitName(SQLiteParser.NameContext ctx) {

    }

    @Override
    void enterFunction_name(SQLiteParser.Function_nameContext ctx) {

    }

    @Override
    void exitFunction_name(SQLiteParser.Function_nameContext ctx) {

    }

    @Override
    void enterDatabase_name(SQLiteParser.Database_nameContext ctx) {

    }

    @Override
    void exitDatabase_name(SQLiteParser.Database_nameContext ctx) {

    }

    @Override
    void enterTable_name(SQLiteParser.Table_nameContext ctx) {
        if (ctx.parent.ruleIndex == SQLiteParser.RULE_create_table_stmt) {
            println("       public static final String TABLE_NAME = \"$ctx.text\";")
            println("       public static final Uri CONTENT_URI = Uri.parse(CONTENT_PREFIX + AUTHORITY + \"/$ctx.text\");")
        }
    }

    @Override
    void exitTable_name(SQLiteParser.Table_nameContext ctx) {

    }

    @Override
    void enterTable_or_index_name(SQLiteParser.Table_or_index_nameContext ctx) {

    }

    @Override
    void exitTable_or_index_name(SQLiteParser.Table_or_index_nameContext ctx) {

    }

    @Override
    void enterNew_table_name(SQLiteParser.New_table_nameContext ctx) {

    }

    @Override
    void exitNew_table_name(SQLiteParser.New_table_nameContext ctx) {

    }

    @Override
    void enterColumn_name(SQLiteParser.Column_nameContext ctx) {

    }

    @Override
    void exitColumn_name(SQLiteParser.Column_nameContext ctx) {

    }

    @Override
    void enterCollation_name(SQLiteParser.Collation_nameContext ctx) {

    }

    @Override
    void exitCollation_name(SQLiteParser.Collation_nameContext ctx) {

    }

    @Override
    void enterForeign_table(SQLiteParser.Foreign_tableContext ctx) {

    }

    @Override
    void exitForeign_table(SQLiteParser.Foreign_tableContext ctx) {

    }

    @Override
    void enterIndex_name(SQLiteParser.Index_nameContext ctx) {

    }

    @Override
    void exitIndex_name(SQLiteParser.Index_nameContext ctx) {

    }

    @Override
    void enterTrigger_name(SQLiteParser.Trigger_nameContext ctx) {

    }

    @Override
    void exitTrigger_name(SQLiteParser.Trigger_nameContext ctx) {

    }

    @Override
    void enterView_name(SQLiteParser.View_nameContext ctx) {

    }

    @Override
    void exitView_name(SQLiteParser.View_nameContext ctx) {

    }

    @Override
    void enterModule_name(SQLiteParser.Module_nameContext ctx) {

    }

    @Override
    void exitModule_name(SQLiteParser.Module_nameContext ctx) {

    }

    @Override
    void enterPragma_name(SQLiteParser.Pragma_nameContext ctx) {

    }

    @Override
    void exitPragma_name(SQLiteParser.Pragma_nameContext ctx) {

    }

    @Override
    void enterSavepoint_name(SQLiteParser.Savepoint_nameContext ctx) {

    }

    @Override
    void exitSavepoint_name(SQLiteParser.Savepoint_nameContext ctx) {

    }

    @Override
    void enterTable_alias(SQLiteParser.Table_aliasContext ctx) {

    }

    @Override
    void exitTable_alias(SQLiteParser.Table_aliasContext ctx) {

    }

    @Override
    void enterTransaction_name(SQLiteParser.Transaction_nameContext ctx) {

    }

    @Override
    void exitTransaction_name(SQLiteParser.Transaction_nameContext ctx) {

    }

    @Override
    void enterAny_name(SQLiteParser.Any_nameContext ctx) {

    }

    @Override
    void exitAny_name(SQLiteParser.Any_nameContext ctx) {

    }

    @Override
    void visitTerminal(TerminalNode node) {

    }

    @Override
    void visitErrorNode(ErrorNode node) {

    }

    @Override
    void enterEveryRule(ParserRuleContext ctx) {

    }

    @Override
    void exitEveryRule(ParserRuleContext ctx) {

    }
}
