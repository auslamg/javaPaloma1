package apuntesclase.jdbc_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_StatementExample {
    public static void main(String[] args) {
        // Same connection parameters as original
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "123456";
        
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM employees")) {
            
            System.out.println("Employee Data:");
            while (resultSet.next()) {
                System.out.println(
                    "ID: " + resultSet.getInt("id") + 
                    ", Name: " + resultSet.getString("name") +
                    ", Salary: " + resultSet.getDouble("salary")
                );
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}