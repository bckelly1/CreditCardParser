package connector;

import java.sql.*;
import java.util.Properties;

/**
 * Created by Brian on 10/1/2016.
 *
 */
public class DatabaseConnector {
    Connection connection = null;

    public DatabaseConnector (){
        createConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    public Connection createConnection(){
        return createConnection("localhost", "3306", "inventory", "Inventory", "BriansInventory");
    }

    public Connection createConnection(String ip, String port, String database, String username, String password){
        try {
            String connectionString = "jdbc:mysql://"+ip+":"+port+"/"+database;
            Class.forName("com.mysql.jdbc.Driver");
            Properties properties = new Properties();
            properties.setProperty("useSSL","false");
            properties.setProperty("user",username);
            properties.setProperty("password",password);

            connection = DriverManager.getConnection(connectionString, properties);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public ResultSet queryDatabase(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public int updateDatabase(String update) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeUpdate(update);
    }


}
