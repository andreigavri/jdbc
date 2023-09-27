package queryExecution;

import java.sql.*;

public class StatementMethods {

    protected void createTable() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc60", "root", "Allin@123")) {
            Statement statement = connection.createStatement();
            statement.execute("create table BOOK( Id INT PRIMARY KEY, Title VARCHAR(32) NOT NULL, Type Varchar(32), Description VARCHAR(50))");
            System.out.println("Table book was created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void insertRow() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc60", "root", "Allin@123")) {
            Statement statement = connection.createStatement();
            statement.execute("insert into Book values('2','Java Advanced','Programming','Programming in Java from scratch')");
            System.out.println(" you inserted a new row in the table book");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void getBooks() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc60", "root", "Allin@123")) {
            Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("Select * FROM BOOK");
            while (resultSet.next()) {
                System.out.println("Book id: " + resultSet.getInt(1));
                System.out.println("Title: " + resultSet.getString(2));
                System.out.println("Type: " + resultSet.getString(3));
                System.out.println("Description: " + resultSet.getString(4));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}