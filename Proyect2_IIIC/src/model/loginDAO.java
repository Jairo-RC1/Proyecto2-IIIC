package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class loginDAO {

    // Method to authenticate a user's login based on username and password only
    public boolean loginUser(String username, String password) {
        boolean isAuthenticated = false;
        String query = "SELECT * FROM users WHERE name = ? AND password = ?";

        // Use your database connection class to establish the connection 
        DBConnectionJava dbConnection = new DBConnectionJava();
        try (Connection connection = dbConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                isAuthenticated = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.disconnect();
        }

        return isAuthenticated;
    }

    // Método para autenticar y obtener los datos del usuario
    public user authenticateUser(String username, String password) {
        user currentUser = null;
        String query = "SELECT * FROM users WHERE name = ? AND password = ?";

        // Use your database connection class to establish the connection 
        DBConnectionJava dbConnection = new DBConnectionJava();
        try (Connection connection = dbConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // Obtener los datos del usuario si las credenciales son correctas
                int id = resultSet.getInt("id");
                int idNumber = resultSet.getInt("id_number");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_name");
                Date birthDate = resultSet.getDate("birth_date");
                String email = resultSet.getString("email");
                int phoneNumber = resultSet.getInt("phone_number");
                String passwordHash = resultSet.getString("password");

                // Crear un objeto user con los datos obtenidos
                currentUser = new user(id, idNumber, name, lastName, birthDate, email, phoneNumber, passwordHash);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.disconnect();
        }

        return currentUser;
    }
}
