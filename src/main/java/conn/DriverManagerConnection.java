package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerConnection {
    public static void main(String[] args) {

        try (final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc60", "root", "Allin@123")) {

            System.out.println("Driver Manager connection works");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
