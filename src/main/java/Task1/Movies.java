package Task1;

/*Create a table MOVIES with columns: id of type INTEGER AUTO INCREMENT,title of type VARCHAR (255), genre of type VARCHAR (255),yearOfRelease of type INTEGER. Note that a table named MOVIE may already exist. In that case, delete it.
  add any three records to the MOVIES table
 update one selected record (use the PreparedStatement)
  delete selected record with specified id
display all other records in the database
 In the task, focus on the correct use of the JDBC API. All queries can be made directly in the main method. Use a single connection to execute all queries.
  However, remember to use try-with-resources when opening
a connection and creating objects such asStatement or PreparedStatement. Also, don't worry about exception handling in this task
(in case of error, display stacktrace).


 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Movies {
    protected void createTable() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc60", "root", "Allin@123")) {
            Statement statement = connection.createStatement();
            statement.execute("create table movies(Id int PRIMARY KEY AUTO_INCREMENT, Title VARCHAR(255), Genre VARCHAR(255), yearOfRelease int)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void insertRow() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc60", "root", "Allin@123")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into movies values('1','Titanic','Romance','2000')");
            Statement statement1 = connection.createStatement();
            statement1.executeUpdate("insert into movies values('2','GhostRider','Action','2006')");
            Statement statement2 = connection.createStatement();
            statement2.executeUpdate("insert into movies values('3','Blues','Comedy ','2003')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void getMovies() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc60", "root", "Allin@123")) {
            PreparedStatement prepareStatement = connection.prepareStatement("UPDATE Movies set yearOfRelease = 1994 WHERE Title = 'Titanic'");
            prepareStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void deleteMovies() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc60", "root", "Allin@123")) {
            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM Movies WHERE Id= 2");


        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    protected void getAllMovies() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc60", "root", "Allin@123")) {
            Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("Select * From Movies");
            List<MovieEntity> movieEntities = new ArrayList<>();
            while(resultSet.next()){
                MovieEntity movieEntity = new MovieEntity();
                movieEntity.setId(resultSet.getInt(1));
                movieEntity.setTitle(resultSet.getString(2));
                movieEntity.setGenre(resultSet.getString(3));
                movieEntity.setYearOfRelease(resultSet.getInt(4));
                movieEntities.add(movieEntity);
            }
            movieEntities.forEach(movieEntity -> System.out.println(movieEntity.getTitle()));


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

