package model;

import java.sql.PreparedStatement;// Provides the functionality to prepare and execute SQL 
import java.sql.ResultSet;// Represents a set of results from an SQL query.
import java.sql.SQLException;// Handle specific SQL exceptions.
import java.util.ArrayList;//Implementation of ArrayList, used to store result sets
import java.util.Date;
import java.util.List;// Provides the List interface to store result sets.
import javax.swing.JOptionPane;

/**
 *
 * @author JRS
 */
// Class representing a Data Access Object (DAO) for handling events in a database
public class eventDAO {

    // Method to save a new event in the database
    public void createEvent(event event) {
        // Create a new instance of the DBConnectionJava class for database connection
        DBConnectionJava db = new DBConnectionJava();
        // SQL query to insert event information into the 'events' table
        String consultaSQL = "INSERT INTO events (name, description, date, address, city, postal_code, price, room, place_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            // Prepare the SQL statement with parameter placeholders
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            // Set values for the parameters using event object's properties
            ps.setString(1, event.getName());
            ps.setString(2, event.getDescription());
            if (event.getDate() != null) {
                ps.setDate(3, new java.sql.Date(event.getDate().getTime()));
            } else {
                ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));
            }
            ps.setString(4, event.getAddress());
            ps.setString(5, event.getCity());
            ps.setInt(6, event.getPostalCode());
            ps.setDouble(7, event.getPrice());
            ps.setInt(8, event.getRoom());
            ps.setInt(9, event.getPlaceId());
            // Execute the SQL update to insert the event into the database
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el evento");
        } catch (SQLException e) {
            // Print an error message if an SQL exception occurs
            JOptionPane.showMessageDialog(null, "No Se insertó correctamente el evento, error: " + e.toString());
        } finally {
            // Disconnect from the database in the 'finally' block to ensure it happens
            db.disconnect();
        }
    }

    // Method to retrieve a list of all places saved from the database
    public List<event> readEvent() {
        // Create a new instance of the DBConnectionJava class for database connectivity
        DBConnectionJava db = new DBConnectionJava();
        // Initialize an empty list to store Event objects retrieved from the database
        List<event> event = new ArrayList<>();
        // Define SQL query to select all columns from the 'events' table
        String sql = "SELECT * FROM events";

        try {
            // Define SQL query to select all columns from the 'events' table
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            // Execute the SQL query and retrieve the result set
            ResultSet resultSet = ps.executeQuery();
            // This loop iterates over the result set obtained from a database query
            while (resultSet.next()) {
                // Retrieve values from the current row in the result set
                int id = resultSet.getInt("id"); // Extracts integer value from the "id" column
                String name = resultSet.getString("name"); // Extracts string value from the "name" column
                String description = resultSet.getString("description"); // Extracts string value from the "description" column
                Date date = resultSet.getDate("date"); // Extracts date value from the "date" column
                String address = resultSet.getString("address"); // Extracts string value from the "address" column
                String city = resultSet.getString("city"); // Extracts string value from the "city" column
                int postal_code = Integer.parseInt(resultSet.getString("postal_code")); // Parses and extracts integer value from the "postal_code" column
                double price = Double.parseDouble(resultSet.getString("price")); // Parses and extracts double value from the "price" column
                int room = Integer.parseInt(resultSet.getString("room")); // Parses and extracts integer value from the "room" column
                int place_id = Integer.parseInt(resultSet.getString("district_id")); // Parses and extracts integer value from the "district_id" column

                // Create an "event" object using the extracted values and add it to a list
                event.add(new event(id, name, description, date, address, city, postal_code, price, room, place_id));
            }

        } catch (SQLException e) {
            // Handle any SQL exceptions that may occur during the database operation
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Ensure that the database connection is closed, whether an exception occurs or not
            db.disconnect();
        }

        // Return the populated list of "event" objects
        return event;
    }

    // This method updates an event in a database using the provided event object.
    public void updateEvent(event event) {
        // Create a new instance of the DBConnectionJava class to establish a database connection.
        DBConnectionJava db = new DBConnectionJava();
        // Define the SQL query to update the event information in the 'events' table.
        String updateSQL = "UPDATE events SET name=?, description=?, date=?, address=?, city=?, postal_code=?, price=?, room=?, place_id=? WHERE id=?";

        try {
            // Prepare a PreparedStatement with the SQL query, setting placeholders with event information.
            PreparedStatement ps = db.getConnection().prepareStatement(updateSQL);
            ps.setString(1, event.getName());
            ps.setString(2, event.getDescription());
            ps.setDate(3, new java.sql.Date(event.getDate().getTime()));
            ps.setString(4, event.getAddress());
            ps.setString(5, event.getCity());
            ps.setInt(6, event.getPostalCode());
            ps.setDouble(7, event.getPrice());
            ps.setInt(8, event.getRoom());
            ps.setInt(9, event.getPlaceId());
            ps.setInt(10, event.getId());

            // Execute the update query in the database.
            ps.execute();
            // Display a success message using JOptionPane.
            JOptionPane.showMessageDialog(null, "Actualización exitosa");

        } catch (SQLException e) {
            // Display an error message using JOptionPane if the update operation fails.
            JOptionPane.showMessageDialog(null, "La actualización falló, error: " + e.toString());

        } finally {
            // Disconnect from the database in the finally block to ensure proper resource management.
            db.disconnect();
        }
    }

    // This method deletes an event from the database with the specified ID.
    public void deleteEvent(int id) {
        // Establish a database connection using the DBConnectionJava class.
        DBConnectionJava db = new DBConnectionJava();

        // Define the SQL query to delete an event with the specified ID from the 'events' table.
        String consultaSQL = "DELETE FROM events WHERE id=?";
        try {
            // Create a prepared statement with the SQL query.
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(consultaSQL);
            // Set the value of the placeholder in the query with the provided event ID.
            preparedStatement.setInt(1, id);
            // Execute the delete operation.
            preparedStatement.execute();
            // Display a success message using a JOptionPane dialog.
            JOptionPane.showMessageDialog(null, "El evento fue eliminado exitosamente.");

        } catch (SQLException e) {
            // Display an error message if an SQLException occurs during the delete operation.
            JOptionPane.showMessageDialog(null, "No se puede eliminar, error: " + e.toString());

        } finally {
            // Disconnect from the database, regardless of success or failure in the try-catch block.
            db.disconnect();
        }
    }

    // This method retrieves the ID of an event from the database based on its name.
    public int getIDEvents(String name) {
        // Initialize the ID variable to 0.
        int ID = 0;
        // Create a new instance of the DBConnectionJava class to handle database connections.
        DBConnectionJava db = new DBConnectionJava();
        // Define the SQL query to select the ID from the 'events' table where the name matches the provided parameter.
        String sql = "SELECT id FROM events WHERE name = ?";

        try {
            // Establish a prepared statement using the database connection and the SQL query.
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            // Set the parameter in the SQL query to the provided 'name'.
            ps.setString(1, name);
            // Execute the query and obtain the result set.
            ResultSet resultSet = ps.executeQuery();
            // Check if the result set contains any rows.
            if (resultSet.next()) {
                // If a row is found, retrieve the 'id' column value from the result set and assign it to the ID variable.
                ID = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            // If an SQL exception occurs, print an error message with the details of the exception.
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Ensure that the database connection is closed in the 'finally' block, regardless of whether an exception occurs or not.
            db.disconnect();
        }
        // Return the obtained ID value (0 if no matching event was found).
        return ID;
    }

    // This method retrieves the name of an event based on its ID from a database.
    // The method takes an integer parameter 'id' representing the unique identifier of the event.
    public String getEventsName(int id) {
        // Initialize an empty string to store the name of the event.
        String name = "";
        // Create a new instance of the DBConnectionJava class for database connectivity.
        DBConnectionJava db = new DBConnectionJava();
        // Define an SQL query to select the 'name' column from the 'events' table where the 'id' matches the provided parameter.
        String sql = "SELECT name FROM events WHERE id = ?";

        try {
            // Establish a prepared statement using the database connection and the SQL query.
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            // Set the parameter in the prepared statement to the provided 'id'.
            ps.setInt(1, id);
            // Execute the query and obtain a result set.
            ResultSet resultSet = ps.executeQuery();

            // Check if there is a result in the result set.
            if (resultSet.next()) {
                // Retrieve the 'name' column value from the result set.
                name = resultSet.getString("name");
            }
        } catch (SQLException e) {
            // Print an error message if a SQL exception occurs during the execution of the query.
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Disconnect from the database in the 'finally' block to ensure it happens regardless of success or failure.
            db.disconnect();
        }

        // Return the retrieved name of the event, which may be an empty string if the event with the provided ID is not found.
        return name;
    }
}
