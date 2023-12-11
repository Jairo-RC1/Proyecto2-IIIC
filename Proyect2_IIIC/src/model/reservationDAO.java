package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;


public class reservationDAO {

    // This method creates a new reservation in the database.
    // It takes a 'reservation' object as a parameter, which contains information about the reservation.
    public void createReservation(reservation reservation) {

        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "INSERT INTO reservations (user_name, date, quantity, event_id) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, reservation.getUserName());
            ps.setDate(2, new java.sql.Date(reservation.getDate().getTime()));
            ps.setInt(3, reservation.getQuantity());
            ps.setInt(4, reservation.getIdEvent());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se reservo exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede hacer la reserva, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }

    // This code defines a method named readReservation() that retrieves reservation data from a database table.
    public List<reservation> readReservation() {
        DBConnectionJava db = new DBConnectionJava();
        List<reservation> reservation = new ArrayList<>();
        String sql = "SELECT * FROM reservations";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("user_name");
                Date date = resultSet.getDate("date");
                int quantity = resultSet.getInt("quantity");
                int idEvent = resultSet.getInt("event_id");
                reservation.add(new reservation(id, userName, date, quantity, idEvent));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return reservation;
    }

    // This method updates a reservation in a database using the provided Reservation object.
    public void updateReservation(reservation reservation) {
        DBConnectionJava db = new DBConnectionJava();
        String sqlQuery = "UPDATE reservations SET user_name=?, date=?, quantity=?, event_id=? WHERE id=?";

        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sqlQuery);
            preparedStatement.setString(1, reservation.getUserName());
            preparedStatement.setDate(2, new java.sql.Date(reservation.getDate().getTime()));
            preparedStatement.setInt(3, reservation.getQuantity());
            preparedStatement.setInt(4, reservation.getIdEvent());
            preparedStatement.setInt(5, reservation.getId());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Reserva actualizada con éxito");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede actualizar la reserva. Error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }

    // This method deletes a reservation from the database based on the provided reservation ID.
    public void deleteReservation(int id) {
        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "DELETE FROM reservations WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "La reserva ha sido eliminada.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar la reserva, error: " + e.toString());

        } finally {
            db.disconnect();
        }
    }

    // This method retrieves the ID of a reservation based on the given name from the database.
    public int getIDReservation(String name) {
        int id = 0;
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT id FROM reservations WHERE name = ?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return id;
    }

    // This method retrieves the name associated with a reservation ID from a database.
    public String getNameReservation(int id) {
        String name = "";
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT name FROM reservations WHERE id = ?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                name = resultSet.getString("name");
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return name;
    }

}
