package apuntesclase.jdbc_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_PreparedStatementExample {
    public static void main(String[] args) {
        // Same connection parameters
        String url = "jdbc:mysql://localhost:3306/instituto";
        String username = "root";
        String password = "123456";

        // Parameter for our query
        String curso = "1DAW"; // Example course filter

        try (Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement pstmt = connection.prepareStatement(
                        "SELECT dni, nombre, apellidos FROM alumnos WHERE curso = ?")) {

            // Set the parameter value
            pstmt.setString(1, curso);

            try (ResultSet resultSet = pstmt.executeQuery()) {
                System.out.println("Alumnos del curso " + curso + ":");
                System.out.println("DNI\t\tNombre\tApellidos\tFecha Nacimiento");

                while (resultSet.next()) {
                    System.out.println(
                            resultSet.getString("dni") + "\t" +
                                    resultSet.getString("nombre") + "\t" +
                                    resultSet.getString("apellidos") + "\t");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al acceder a la base de datos:");
            e.printStackTrace();
        }
    }
}