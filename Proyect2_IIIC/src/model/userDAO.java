package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class userDAO {
    // Method to create a new user in the database

    public userDAO() {
    }

    // This method takes a user object as a parameter and inserts its information into the "users" table in the database.
    public void createUser(user user) {
        // Establish a new database connection
        DBConnectionJava db = new DBConnectionJava();

        // SQL query to insert user information into the "users" table
        String consultaSQL = "INSERT INTO users (id_number, name, last_name, email, birth_date, phone_number, password, role_id) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
        try {
            // Prepare a SQL statement with the provided query
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);

            // Set the values for each parameter in the prepared statement based on the user object
            ps.setInt(1, user.getIdNumber());
            ps.setString(2, user.getName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getEmail());
            ps.setDate(5, new java.sql.Date(user.getBirthDate().getTime()));
            ps.setInt(6, user.getPhoneNumber());
            ps.setString(7, user.getPassword());
            ps.setInt(8, user.getRoleId());

            // Execute the SQL statement to insert the user into the database
            ps.execute();

            // Display a success message using a JOptionPane dialog
            JOptionPane.showMessageDialog(null, "Usuario insertado correctamente");
        } catch (SQLException e) {
            // Display an error message if there is a SQL exception during the insertion process
            JOptionPane.showMessageDialog(null, "No se pudo insertar el usuario, error: " + e.getMessage());
        } finally {
            // Disconnect from the database regardless of success or failure
            db.disconnect();
        }
    }

    // This method reads user information from a database table named 'users' and returns a list of user objects.
    public List<user> readUserTxt() {
        // Create a new instance of the DBConnectionJava class to establish a database connection
        DBConnectionJava db = new DBConnectionJava();

        // Initialize an empty list to store user objects retrieved from the database
        List<user> users = new ArrayList<>();

        // SQL query to select user information from the 'users' table
        String sql = "SELECT id, id_number, name, last_name, birth_date, email, phone_number, password, role_id FROM users";

        try {
            // Prepare the SQL statement and execute it to get the result set
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            // Iterate through the result set to retrieve user information
            while (resultSet.next()) {
                // Extract user attributes from the result set
                int id = resultSet.getInt("id");
                int idNumber = resultSet.getInt("id_number");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_name");
                Date birthDate = resultSet.getDate("birth_date");
                String email = resultSet.getString("email");
                int phoneNumber = resultSet.getInt("phone_number");
                String password = resultSet.getString("password");
                int roleId = resultSet.getInt("role_id");

                // Create a new user object with the retrieved attributes
                user newUser = new user(id, idNumber, name, lastName, birthDate, email, phoneNumber, password, roleId);

                // Add the new user object to the list
                users.add(newUser);
            }
        } catch (SQLException e) {
            // Handle any SQL exception by printing an error message
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Disconnect from the database in the finally block to ensure proper cleanup
            db.disconnect();
        }

        // Return the list of user objects
        return users;
    }

    // Method to update an existing user in the database
    public void updateUser(user currentUser) {
        // Check if the user object is not null
        if (currentUser != null) {
            // Create a new instance of the DBConnectionJava class
            DBConnectionJava db = new DBConnectionJava();

            // SQL query to update user information in the 'users' table
            String consultaSQL = "UPDATE users SET id_number=?, name=?, last_name=?, birth_date=?, email=?, phone_number=?, password=?, role_id=? WHERE id=?";

            try {
                // Establish a prepared statement with the SQL query
                PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
                // Set values for each parameter in the prepared statement using data from the user object
                ps.setInt(1, currentUser.getIdNumber());
                ps.setString(2, currentUser.getName());
                ps.setString(3, currentUser.getLastName());
                ps.setDate(4, new java.sql.Date(currentUser.getBirthDate().getTime()));
                ps.setString(5, currentUser.getEmail());
                ps.setInt(6, currentUser.getPhoneNumber());
                ps.setString(7, currentUser.getPassword());
                ps.setInt(8, currentUser.getRoleId());
                ps.setInt(9, currentUser.getId());

                // Execute the update query
                ps.executeUpdate();

                // Display a success message using a JOptionPane
                JOptionPane.showMessageDialog(null, "Modification successful");
            } catch (SQLException e) {
                // Display an error message if the update operation fails
                JOptionPane.showMessageDialog(null, "Unable to modify user, error: " + e.getMessage());
            } finally {
                // Disconnect from the database in the finally block to ensure it happens even in case of an exception
                db.disconnect();
            }
        } else {
            // Display a message if the provided user object is null
            JOptionPane.showMessageDialog(null, "The current user is null. Cannot update.");
        }
    }

    // Method to delete a user from the database by ID
    public void deleteUser(int id) {
        // Create a new instance of the DBConnectionJava class
        DBConnectionJava db = new DBConnectionJava();
        // SQL query to delete a user with the specified ID from the 'users' table
        String consultaSQL = "DELETE FROM users WHERE id=?";

        try {
            // Prepare a SQL statement using a PreparedStatement to prevent SQL injection
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(consultaSQL);
            // Set the value of the parameter in the SQL query to the provided user ID
            preparedStatement.setInt(1, id);
            // Execute the SQL statement to delete the user from the database
            preparedStatement.execute();
            // Display a success message using a JOptionPane dialog
            JOptionPane.showMessageDialog(null, "User deleted successfully");
        } catch (SQLException e) {
            // Display an error message if an SQL exception occurs during the deletion process
            JOptionPane.showMessageDialog(null, "Unable to delete user, error: " + e.getMessage());
        } finally {
            // Ensure that the database connection is closed, regardless of success or failure
            db.disconnect();
        }
    }
}
