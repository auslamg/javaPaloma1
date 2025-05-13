package apuntesclase.jdbc_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBC_Connection {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "123456";

        Connection connection = null;

        try {
            // 1. Load and register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish the connection
            connection = DriverManager.getConnection(url, username, password);

            // 3. Check if connection is successful
            if (connection != null) {
                System.out.println("Connected to the database!");

                // You can now execute SQL queries here
                // For example:
                // Statement statement = connection.createStatement();
                // ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table");
                // while (resultSet.next()) { ... }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        } finally {
            // 4. Close the connection
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException e) {
                System.out.println("Error al acceder a la base de datos:");
                e.printStackTrace();
            }
        }
    }
}