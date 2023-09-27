package Task2;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//Implement the class MovieDAOImpl (DAO - Data Access Object). It should perform basic database operations for the MOVIES table, the structure of which is described in task 1. Assume that an object representing an open database connection comes in the constructor of this class. Remember to use PreparedStatement where possible and close objects (usetry-with-resources). Also implement a Movie class that represents a single row in the MOVIES table that you will use in implementing the MovieDAOImple class.
//        Implement the following operations. Each of them should be represented by a separate public method:
//        creating a MOVIES table
//        delete the MOVIES table
//        adding a record
//        delete record by identifier
//        update of the movie title with id data
//        searching for a movie by ID
//        download all videos
//        In case of an exception SQLException, make the method throw an exceptionDatabaseActionException.
//        This class should extend from the RuntimeException class.
//        The MovieDAOImpl class should implement the following interface:
//        import java.util.List;
//        import java.util.Optional;
//
//        public interface MovieDAO {
//        void createTable();
//        void deleteTable();
//
//        void createMovie(final Movie movie);
//        void deleteMovie(int id);
//        void updateMoviesTitle(int id, String newTitle);
//        Optional<Movie> findMovieById(int id);
//        List<Movie> findAll();
//        }
public class Main {
    public static void main(String[] args) throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/jdbc60");
        dataSource.setUser("root");
        dataSource.setPassword("Allin@123");

        Connection connection = dataSource.getConnection();
        MovieDAOImpl movieDAOimpl = new MovieDAOImpl(connection);

        movieDAOimpl.createTable();
        //movieDAOimpl.deleteTable();
        Movie movie = new Movie(1,"FireFire", "Romance",1998);
//movieDAOimpl.createMovie(movie);
        //movieDAOimpl.deleteMovie(1);
//        movieDAOimpl.updateMoviesTitle(2,"Fast&9000");
        //System.out.println(movieDAOimpl.findMovieById(2));
        List<Movie> movies= movieDAOimpl.findAll();
        movies.forEach(movie1 -> System.out.println(movie1.getTitle()));

    }
}