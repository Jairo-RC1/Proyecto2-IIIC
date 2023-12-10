
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
public class reservationDAO {
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
            JOptionPane.showMessageDialog(null, "Se realizó correctamente la reservación");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No fue posible realizar correctamente la reservación, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    } 
   
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
   
   public void updateReservation(reservation Reservation) {

        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "UPDATE reservations SET user_name=?, date=?, quantity=?, event_id=? WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, Reservation.getUserName());
            ps.setDate(2, new java.sql.Date(Reservation.getDate().getTime()));
            ps.setInt(3, Reservation.getQuantity());
            ps.setInt(4, Reservation.getIdEvent());
            ps.setInt(5, Reservation.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "La reservacion se modificó de forma exitosa");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No fue posible modificar, error:" + e.toString());
        } finally {
            db.disconnect();
        }
    }
   
   public void deleteReservation(int id) {

        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "DELETE FROM reservations WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se ha eliminado la reservación");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se pudo eliminar la reservacion, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }
   
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
