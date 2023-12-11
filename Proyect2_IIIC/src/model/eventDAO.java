package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class eventDAO {

    // Method to save a new event in the database
    public void createEvent(event event) {
        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "INSERT INTO events (name, description, date, address, city, postal_code, price, room, place_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
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
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se insertó correctamente el evento");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No Se insertó correctamente el evento, error: " + e.toString());
        } finally {
            db.disconnect();
        }
    }

    // Method to retrieve a list of all places saved from the database
    public List<event> readEvent() {
        DBConnectionJava db = new DBConnectionJava();
        List<event> event = new ArrayList<>();
        String sql = "SELECT * FROM events";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt("id"); 
                String name = resultSet.getString("name"); 
                String description = resultSet.getString("description"); 
                Date date = resultSet.getDate("date"); 
                String address = resultSet.getString("address"); 
                String city = resultSet.getString("city"); 
                int postal_code = Integer.parseInt(resultSet.getString("postal_code")); 
                double price = Double.parseDouble(resultSet.getString("price")); 
                int room = Integer.parseInt(resultSet.getString("room")); 
                int place_id = Integer.parseInt(resultSet.getString("place_id")); 
                
                event.add(new event(id, name, description, date, address, city, postal_code, price, room, place_id));
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return event;
    }

    // This method updates an event in a database using the provided event object.
    public void updateEvent(event event) {
        DBConnectionJava db = new DBConnectionJava();
        String updateSQL = "UPDATE events SET name=?, description=?, date=?, address=?, city=?, postal_code=?, price=?, room=?, place_id=? WHERE id=?";

        try {
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
            ps.execute();
            JOptionPane.showMessageDialog(null, "Actualización exitosa");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "La actualización falló, error: " + e.toString());

        } finally {
            db.disconnect();
        }
    }

    // This method deletes an event from the database with the specified ID.
    public void deleteEvent(int id) {
        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "DELETE FROM events WHERE id=?";
        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(consultaSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "El evento fue eliminado exitosamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar, error: " + e.toString());

        } finally {
            db.disconnect();
        }
    }

    // This method retrieves the ID of an event from the database based on its name.
    public int getIDEvents(String name) {
        int ID = 0;
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT id FROM events WHERE name = ?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                ID = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return ID;
    }

    // This method retrieves the name of an event based on its ID from a database.
    // The method takes an integer parameter 'id' representing the unique identifier of the event.
    public String getEventsName(int id) {
        String name = "";
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT name FROM events WHERE id = ?";

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
