package com.palmtree.jsqlparser;

import java.util.List;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectExpressionItem;
import net.sf.jsqlparser.statement.select.SelectItem;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws JSQLParserException {
        Select stmt = (Select) CCJSqlParserUtil.parse("SELECT AccountId, Id FROM Opportunity as oppor");
        PlainSelect plainSelect = (PlainSelect) stmt.getSelectBody();
        List<SelectItem> selectItems = plainSelect.getSelectItems();
        for (SelectItem selectItem : selectItems) {
            Column column = (Column) ((SelectExpressionItem) selectItem).getExpression();
            System.out.println(column.getColumnName());
        }
    }

}