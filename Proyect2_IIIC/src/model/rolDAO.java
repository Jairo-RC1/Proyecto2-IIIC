package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class rolDAO {

    // Retrieve a list of all roles from the database
    public List<rol> readRoles() {
        // Create a new instance of the DBConnectionJava class to establish a database connection
        DBConnectionJava db = new DBConnectionJava();

        // Create an empty list to store role objects retrieved from the database
        List<rol> roles = new ArrayList<>();
        // SQL query to select all columns from the 'roles' table
        String sql = "SELECT * FROM roles";

        try {
            // Attempt to establish a connection to the database
            Connection connection = db.getConnection();
            // Create a PreparedStatement with the SQL query
            PreparedStatement ps = connection.prepareStatement(sql);
            // Execute the query and retrieve the result set
            ResultSet resultSet = ps.executeQuery();

            // Iterate through the result set and extract role information
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                // Create a new rol object with the retrieved information and add it to the list
                roles.add(new rol(id, name));
            }
        } catch (SQLException e) {
            // Print an error message if any SQL exception occurs
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Disconnect from the database in the finally block to ensure resources are released
            db.disconnect();
        }

        // Return the list of role objects retrieved from the database
        return roles;
    }

    // Retrieve a role by its name from the database
    public rol getRolByName(String roleName) {
        // Establish a new database connection
        DBConnectionJava db = new DBConnectionJava();
        // Define the SQL query to retrieve a role by its name
        String sql = "SELECT * FROM roles WHERE name = ?";

        try (PreparedStatement ps = db.getConnection().prepareStatement(sql)) {
            // Set the parameter for the role name in the prepared statement
            ps.setString(1, roleName);
            // Execute the SQL query and retrieve the result set
            ResultSet resultSet = ps.executeQuery();

            // Check if a result is found
            if (resultSet.next()) {
                // Extract role information from the result set
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                // Return a new role object with the retrieved information
                return new rol(id, name);
            }
        } catch (SQLException e) {
            // Handle any SQL exception and print an error message
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Disconnect from the database in the finally block to ensure it happens even if an exception occurs
            db.disconnect();
        }

        // Returns null if the role is not found in the database
        return null;
    }

    // Retrieve the name of a role by its ID
    public String getRoleNameById(int roleId) {
        // Establish a connection to the database
        DBConnectionJava db = new DBConnectionJava();

        // SQL query to select the name of a role based on its ID
        String sql = "SELECT name FROM roles WHERE id = ?";

        try {
            // Prepare a SQL statement with a parameterized query
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            // Set the value of the parameter to the provided role ID
            ps.setInt(1, roleId);
            // Execute the SQL query and store the result set
            ResultSet resultSet = ps.executeQuery();

            // Check if there is a result in the result set
            if (resultSet.next()) {
                // Return the name of the role found in the result set
                return resultSet.getString("name");
            }
        } catch (SQLException e) {
            // Print an error message if a SQL exception occurs
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Disconnect from the database regardless of the outcome
            db.disconnect();
        }

        // Return null if no name is found corresponding to the provided ID
        return null;
    }

    // Retrieve the ID of a role by its name
    public int getRoleIdByName(String roleName) {
        // Create a new instance of the DBConnectionJava class
        DBConnectionJava db = new DBConnectionJava();

        // SQL query to select the ID from the "roles" table where the name matches the provided roleName
        String sql = "SELECT id FROM roles WHERE name = ?";

        try {
            // Prepare a SQL statement with the provided query
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            // Set the parameter in the prepared statement to the provided roleName
            ps.setString(1, roleName);
            // Execute the query and obtain the result set
            ResultSet resultSet = ps.executeQuery();

            // Check if there is a result in the result set
            if (resultSet.next()) {
                // If a result is found, return the corresponding ID
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            // Print an error message if a SQL exception occurs
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Disconnect from the database in the finally block to ensure proper resource management
            db.disconnect();
        }

        // Return -1 if no corresponding ID is found (you can choose a default value)
        return -1;
    }
}
