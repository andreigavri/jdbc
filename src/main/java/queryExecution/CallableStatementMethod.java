package queryExecution;

import java.sql.*;

public class CallableStatementMethod {
    protected void getMovies(){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc60", "root", "Allin@123")) {
            CallableStatement callableStatement = connection.prepareCall("{CALL getAllMovies()}");
            final ResultSet resultSet = callableStatement.executeQuery();
            while(resultSet.next()){
                System.out.println("Title: " + resultSet.getString(2));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
