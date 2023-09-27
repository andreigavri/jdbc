package Task2;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieDAOImpl implements MovieDAO {
    private final Connection connection;

    public MovieDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS Movies" +
                    "(id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "title VARCHAR(255)," +
                    "genre VARCHAR(255)," +
                    "yearOfRelease INT)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE Movies");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createMovie(Movie movie) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " +
                "Movies(Title,Genre, yearOfRelease)" +
                "Values(?,?,?)")) {
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getGenre());
            preparedStatement.setInt(3, movie.getYearOfRelease());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMovie(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Movies WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMoviesTitle(int id, String newTitle) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Movies Set title = ? WHERE id = ?")) {
            preparedStatement.setString(1, newTitle);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Movie> findMovieById(int id) {
        Movie movie = new Movie();
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM Movies WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                movie.setId(resultSet.getInt(1));
                movie.setTitle(resultSet.getString(2));
                movie.setGenre(resultSet.getString(3));
                movie.setYearOfRelease(resultSet.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(movie);
    }


    @Override
    public List<Movie> findAll() {
        List<Movie> moviesList = new ArrayList<>();
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM Movies")) {
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getInt(1));
                movie.setTitle(resultSet.getString(2));
                movie.setGenre(resultSet.getString(3));
                movie.setYearOfRelease(resultSet.getInt(4));
                moviesList.add(movie);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return moviesList;
    }
}