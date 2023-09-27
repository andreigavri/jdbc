package queryExecution;

import java.sql.*;

public class PrepareStatementMethod {

    protected void getBooks(int id){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc60", "root", "Allin@123")){
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT* FROM BOOK WHERE Id = ?");
            preparedStatement.setInt(1,id);
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                    System.out.println("Book id: " + resultSet.getInt(1));
                    System.out.println("Title: " + resultSet.getString(2));
                    System.out.println("Type: " + resultSet.getString(3));
                    System.out.println("Description: " + resultSet.getString(4));
            }

        }catch(SQLException e){
            e.printStackTrace();

        }
    }
}
