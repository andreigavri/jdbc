package conn;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceConnection {
    public static void main(String[] args) {
        MysqlDataSource dataSource= new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/jdbc60");
        dataSource.setUser("root");
        dataSource.setPassword("Allin@123");

        try(Connection connection = dataSource.getConnection()){
            System.out.println("DataSource connection works");
        }catch (SQLException e){
            e.printStackTrace();

        }
    }
}
