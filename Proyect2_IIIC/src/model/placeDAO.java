package model;

// Importing necessary Java SQL
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jefry
 */
// This Java class, pleaceDAO, serves as a Data Access Object (DAO) for managing place-related data in a database.
public class placeDAO {

    // Constructor for the pleaceDAO class
    public placeDAO() {

    }

    // Method to save a new place in the database
    public void createPlace(place pleace) {
        // Establish a connection to the database using the DBConnection class
        DBConnectionJava db = new DBConnectionJava();
        // SQL query to insert place information into the 'pleaces' table
        String consultaSQL = "INSERT INTO pleaces (name, address, city, postal_code, latitude, longitude, tripAdvisor_link) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            // Prepare a SQL statement with parameter placeholders
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);

            // Set values for the parameters based on the 'place' object
            ps.setString(1, pleace.getName());
            ps.setString(2, pleace.getAddress());
            ps.setInt(3, pleace.getPostalCode());
            ps.setString(4, pleace.getLatitude());
            ps.setString(5, pleace.getLongitude());
            ps.setString(6, pleace.getTripAdvisorLink());
            // Execute the SQL statement to insert the data into the database
            ps.execute();

            // Display a success message using JOptionPane
            JOptionPane.showMessageDialog(null, "Su destino de viaje ha sido registrado.");
        } catch (SQLException e) {
            // Display an error message using JOptionPane if an exception occurs during database interaction
            JOptionPane.showMessageDialog(null, "No se puede guardar el destino. Error: " + e.getMessage());
        } finally {
            // Disconnect from the database in the 'finally' block to ensure it happens regardless of success or failure
            db.disconnect();
        }
    }

    // Method to retrieve a list of all pleaces saved from the database
    public List<place> readPlaces() {
        // Create a new instance of the DBConnectionJava class for database connectivity
        DBConnectionJava db = new DBConnectionJava();

        // Initialize a list to store the retrieved places from the database
        List<place> pleaces = new ArrayList<>();
        // SQL query to select all records from the 'places' table
        String sql = "SELECT * FROM places";

        try {
            // Establish a prepared statement using the database connection
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            // Execute the query and retrieve the result set
            ResultSet resultSet = ps.executeQuery();

            // Iterate through the result set and create Place objects for each record
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int postalCode = resultSet.getInt("postal_code");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String latitude = resultSet.getString("latitude");
                String longitude = resultSet.getString("longitude");
                String tripAdvisorLink = resultSet.getString("tripAdvisor_link");

                // Create a new Place object and add it to the list
                pleaces.add(new place(id, postalCode, name, address, city, latitude, longitude, tripAdvisorLink));
            }
        } catch (SQLException e) {
            // Print an error message if a SQL exception occurs
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Disconnect from the database in the finally block to ensure proper resource cleanup
            db.disconnect();
        }
        return pleaces; // Return the list of places retrieved from the database
    }

    // Method to update an existing place record in the database
    public void updatePlace(place place) {
        // Create a new instance of the DBConnectionJava class to establish a database connection
        DBConnectionJava db = new DBConnectionJava();

        // SQL query to update a record in the 'places' table with new values
        String sqlQuery = "UPDATE places SET postalCode=?, name=?, address=?, city=?, latitude=?, longitude=?, tripAdvisor_link=? WHERE id=?";

        try {
            // Prepare a SQL statement with parameters for the update query
            PreparedStatement ps = db.getConnection().prepareStatement(sqlQuery);

            // Set the values of the parameters using data from the 'place' object
            ps.setInt(1, place.getPostalCode());
            ps.setString(2, place.getName());
            ps.setString(3, place.getAddress());
            ps.setString(4, place.getCity());
            ps.setString(5, place.getLatitude());
            ps.setString(6, place.getLongitude());
            ps.setString(7, place.getTripAdvisorLink());
            ps.setInt(8, place.getId());

            // Execute the update query
            ps.execute();

            // Display a success message using JOptionPane
            JOptionPane.showMessageDialog(null, "Modificación exitosa");
        } catch (SQLException e) {
            // Display an error message if the update operation fails
            JOptionPane.showMessageDialog(null, "No se pudo modificar el lugar de destino. Error: " + e.getMessage());
        } finally {
            // Disconnect from the database in the 'finally' block to ensure it happens even if an exception occurs
            db.disconnect();
        }
    }

    // Method to delete a place record from the database by ID
    public void deletePlace(int id) {
        // Create a new instance of the DBConnectionJava class for database connection
        DBConnectionJava db = new DBConnectionJava();
        // SQL query to delete a record from the 'places' table based on the provided ID
        String sqlQuery = "DELETE FROM places WHERE id=?";
        try {
            // Prepare a SQL statement with the given query
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sqlQuery);
            // Set the ID parameter in the prepared statement
            preparedStatement.setInt(1, id);
            // Execute the SQL statement to delete the record
            preparedStatement.execute();

            // Display a success message using JOptionPane if the deletion is successful
            JOptionPane.showMessageDialog(null, "El destino se ha eliminado correctamente.");
        } catch (SQLException e) {
            // Display an error message using JOptionPane if an SQLException occurs during the deletion
            JOptionPane.showMessageDialog(null, "No se puede eliminar el destino. Error: " + e.getMessage());
        } finally {
            // Disconnect from the database in the 'finally' block to ensure proper cleanup
            db.disconnect();
        }
    }


    public int getIDPlaces(String name) {
    // Initialize the ID variable to 0.
    int ID = 0;
    
    // Create a new instance of the DBConnectionJava class for database connectivity.
    DBConnectionJava db = new DBConnectionJava();
    
    // Define the SQL query to select the ID based on the provided name.
    String sql = "SELECT id FROM places WHERE name = ?";
    
    try {
        // Establish a prepared statement with the SQL query.
        PreparedStatement ps = db.getConnection().prepareStatement(sql);
        
        // Set the parameter in the prepared statement with the provided name.
        ps.setString(1, name);
        
        // Execute the query and get the result set.
        ResultSet resultSet = ps.executeQuery();
        
        // Check if a result is found in the ResultSet.
        if (resultSet.next()) {
            // Retrieve the ID from the result set.
            ID = resultSet.getInt("id");
        }
    } catch (SQLException e) {
        // Print an error message if an SQLException occurs during the database operations.
        System.err.println("Error: " + e.getMessage());
    } finally {
        // Ensure that the database connection is closed, regardless of success or failure.
        db.disconnect();
    }
    
    // Return the retrieved or default (0) ID.
    return ID;
}

    // This method retrieves the name of a place from a database based on its ID.
public String getNamePlaces(int id) {
    // Initialize an empty string to store the place name.
    String name = "";
    
    // Create a new instance of the DBConnectionJava class to manage database connection.
    DBConnectionJava db = new DBConnectionJava();
    
    // Define the SQL query to select the name from the 'places' table where the ID matches.
    String sql = "SELECT name FROM places WHERE id = ?";
    
    try {
        // Establish a prepared statement with the specified SQL query.
        PreparedStatement ps = db.getConnection().prepareStatement(sql);
        
        // Set the parameter in the SQL query to the provided 'id' value.
        ps.setInt(1, id);
        
        // Execute the query and obtain the result set.
        ResultSet resultSet = ps.executeQuery();
        
        // Check if there is a result and retrieve the 'name' value from the result set.
        if (resultSet.next()) {
            name = resultSet.getString("name");
        }
    } catch (SQLException e) {
        // Handle any SQL exception by printing an error message.
        System.err.println("Error: " + e.getMessage());
    } finally {
        // Ensure the database connection is closed in the 'finally' block.
        db.disconnect();
    }
    
    // Return the retrieved place name, which may be an empty string if no matching record is found.
    return name;
}
}
