package queryExecution;

import java.sql.PreparedStatement;
import java.sql.Statement;

public class StatementMain {
    public static void main(String[] args) {
        StatementMethods statementMethods = new StatementMethods();
        //statementMethods.createTable();
        //statementMethods.insertRow();
        //statementMethods.getBooks();
//        PrepareStatementMethod prepareStatementMethod = new PrepareStatementMethod();
//        prepareStatementMethod.getBooks(1);
        CallableStatementMethod callableStatementMethod = new CallableStatementMethod();
        callableStatementMethod.getMovies();
    }
}
