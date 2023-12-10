package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jefry
 */
// This class represents a Data Access Object (DAO) for handling reservations.
public class reservationDAO {

    // This method creates a new reservation in the database.
    // It takes a 'reservation' object as a parameter, which contains information about the reservation.
    public void createReservation(reservation reservation) {

        // Establish a connection to the database using the DBConnectionJava class.
        DBConnectionJava db = new DBConnectionJava();

        // Define a SQL query to insert reservation data into the 'reservations' table.
        String consultaSQL = "INSERT INTO reservations (user_name, date, quantity, event_id) VALUES (?, ?, ?, ?)";

        try {
            // Prepare a SQL statement with the query and set parameters using the reservation object.
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, reservation.getUserName());
            ps.setDate(2, new java.sql.Date(reservation.getDate().getTime()));
            ps.setInt(3, reservation.getQuantity());
            ps.setInt(4, reservation.getIdEvent());

            // Execute the SQL statement to insert the reservation into the database.
            ps.execute();

            // Display a success message using a JOptionPane dialog.
            JOptionPane.showMessageDialog(null, "La reserva se realizó correctamente.");
        } catch (SQLException e) {
            // Display an error message if there's an exception during the database operation.
            JOptionPane.showMessageDialog(null, "No se puede hacer la reserva, error: " + e.toString());
        } finally {
            // Disconnect from the database in the 'finally' block to ensure it happens regardless of success or failure.
            db.disconnect();
        }
    }

    // This code defines a method named readReservation() that retrieves reservation data from a database table.
    public List<reservation> readReservation() {
        // Create a new instance of the DBConnectionJava class to establish a database connection.
        DBConnectionJava db = new DBConnectionJava();
        // Initialize a List to store reservation objects retrieved from the database.
        List<reservation> reservation = new ArrayList<>();
        // SQL query to select all columns from the "reservations" table.
        String sql = "SELECT * FROM reservations";

        try {
            // Prepare a PreparedStatement object with the SQL query.
            PreparedStatement ps = db.getConnection().prepareStatement(sql);

            // Execute the query and obtain the ResultSet containing the result set of the query.
            ResultSet resultSet = ps.executeQuery();

            // Iterate through the ResultSet to retrieve each row of reservation data.
            while (resultSet.next()) {
                // Extract individual column values from the ResultSet.
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("user_name");
                Date date = resultSet.getDate("date");
                int quantity = resultSet.getInt("quantity");
                int idEvent = resultSet.getInt("event_id");

                // Create a new reservation object with the extracted values and add it to the List.
                reservation.add(new reservation(id, userName, date, quantity, idEvent));
            }
        } catch (SQLException e) {
            // Handle any SQLException that might occur during the database operation.
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Disconnect from the database in the finally block to ensure proper cleanup.
            db.disconnect();
        }

        // Return the List containing reservation objects retrieved from the database.
        return reservation;
    }

    // This method updates a reservation in a database using the provided Reservation object.
    public void updateReservation(reservation reservation) {
        // Create a new instance of the DBConnectionJava class for database connection.
        DBConnectionJava db = new DBConnectionJava();

        // SQL query to update the reservations table with new values.
        String sqlQuery = "UPDATE reservations SET user_name=?, date=?, quantity=?, event_id=? WHERE id=?";

        try {
            // Create a prepared statement using the SQL query.
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sqlQuery);

            // Set the parameters for the prepared statement using values from the Reservation object.
            preparedStatement.setString(1, reservation.getUserName());
            preparedStatement.setDate(2, new java.sql.Date(reservation.getDate().getTime()));
            preparedStatement.setInt(3, reservation.getQuantity());
            preparedStatement.setInt(4, reservation.getIdEvent());
            preparedStatement.setInt(5, reservation.getId());

            // Execute the update query.
            preparedStatement.execute();
            // Display a success message using a JOptionPane.
            JOptionPane.showMessageDialog(null, "Reserva actualizada con éxito");
        } catch (SQLException e) {
            // Display an error message if the update operation fails.
            JOptionPane.showMessageDialog(null, "No se puede actualizar la reserva. Error: " + e.toString());
        } finally {
            // Disconnect from the database in the finally block to ensure proper resource management.
            db.disconnect();
        }
    }

    // This method deletes a reservation from the database based on the provided reservation ID.
    public void deleteReservation(int id) {
        // Create a new instance of the DBConnectionJava class to establish a database connection.
        DBConnectionJava db = new DBConnectionJava();

        // Define an SQL query to delete a reservation with the specified ID from the 'reservations' table.
        String consultaSQL = "DELETE FROM reservations WHERE id=?";

        try {
            // Prepare a SQL statement with a parameterized query for deleting the reservation.
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            // Set the value of the parameter in the SQL query to the provided reservation ID.
            ps.setInt(1, id);
            // Execute the prepared statement to delete the reservation from the database.
            ps.execute();

            // Display a success message using a JOptionPane dialog.
            JOptionPane.showMessageDialog(null, "La reserva ha sido eliminada.");

        } catch (SQLException e) {
            // If an SQL exception occurs during the deletion process, display an error message.
            JOptionPane.showMessageDialog(null, "No se puede eliminar la reserva, error: " + e.toString());

        } finally {
            // Ensure that the database connection is closed, regardless of success or failure.
            db.disconnect();
        }
    }

    // This method retrieves the ID of a reservation based on the given name from the database.
    public int getIDReservation(String name) {
        // Initialize the variable to store the reservation ID.
        int id = 0;

        // Create a new instance of the DBConnectionJava class for database connectivity.
        DBConnectionJava db = new DBConnectionJava();

        // Define the SQL query to select the ID from the reservations table based on the name.
        String sql = "SELECT id FROM reservations WHERE name = ?";

        try {
            // Establish a prepared statement with the SQL query.
            PreparedStatement ps = db.getConnection().prepareStatement(sql);

            // Set the parameter in the prepared statement with the provided name.
            ps.setString(1, name);
            // Execute the query and retrieve the result set.
            ResultSet resultSet = ps.executeQuery();

            // Check if there is a result in the result set.
            if (resultSet.next()) {
                // If a result is found, retrieve the ID from the result set.
                id = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            // Handle any SQL exception that may occur and print an error message.
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Ensure the database connection is closed in the finally block.
            db.disconnect();
        }

        // Return the obtained reservation ID.
        return id;
    }

    // This method retrieves the name associated with a reservation ID from a database.
    public String getNameReservation(int id) {
        // Initialize an empty string to store the retrieved name.
        String name = "";

        // Create a new instance of the DBConnectionJava class to manage the database connection.
        DBConnectionJava db = new DBConnectionJava();

        // SQL query to select the name from the 'reservations' table where the ID matches the provided parameter.
        String sql = "SELECT name FROM reservations WHERE id = ?";

        try {
            // Establish a prepared statement with the SQL query.
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            // Set the parameter in the prepared statement to the provided reservation ID.
            ps.setInt(1, id);
            // Execute the query and store the result in a ResultSet.
            ResultSet resultSet = ps.executeQuery();
            // Check if there is a result in the ResultSet.
            if (resultSet.next()) {
                // Retrieve the name from the ResultSet and assign it to the 'name' variable.
                name = resultSet.getString("name");
            }
        } catch (SQLException e) {
            // Print an error message if a SQL exception occurs.
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Ensure that the database connection is disconnected, regardless of success or failure.
            db.disconnect();
        }

        // Return the retrieved name, which may be an empty string if no matching reservation is found.
        return name;
    }

}
