package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JRS
 */
public class eventDAO {
    // Method to save a new place in the database

    public void createEvent(event event) {
        DBConnectionJava db = new DBConnectionJava();
        try {
            String consultaSQL = "INSERT INTO events (name, description, date, address, postal_code, price, room, place_id) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, event.getName());
            ps.setString(2, event.getDescription());
            ps.setDate(3, new java.sql.Date(event.getDate().getTime()));
            ps.setString(4, event.getAddress());
            ps.setInt(5, event.getPostalCode());
            ps.setDouble(6, event.getPrice());
            ps.setInt(7, event.getRoom());
            ps.setInt(8, event.getPlaceId());
            ps.executeUpdate();
            System.out.println("Evento creado con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al crear el evento: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

    // Method to retrieve a list of all pleaces saved from the database
    public List<event> readEvents() {
        DBConnectionJava db = new DBConnectionJava();
        List<event> events = new ArrayList<>();
        try {
            String consultaSQL = "SELECT * FROM events";
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                java.util.Date date = resultSet.getDate("date");
                String address = resultSet.getString("address");
                int postalCode = resultSet.getInt("postal_code");
                double price = resultSet.getDouble("price");
                int room = resultSet.getInt("room");
                int placeId = resultSet.getInt("place_id");
                String city = resultSet.getString("city");
                event event = new event(id, name, description, date, address, postalCode, city, price, room, placeId);
                events.add(event);
            }
        } catch (SQLException e) {
            System.err.println("Error al leer los eventos: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return events;
    }

    // Method to update an existing place record in the database
    public void updateEvent(event event) {
        DBConnectionJava db = new DBConnectionJava();
        try {
            String consultaSQL = "UPDATE events SET name=?, description=?, date=?, address=?, postal_code=?, price=?, room=?, place_id=? WHERE id=?";
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, event.getName());
            ps.setString(2, event.getDescription());
            ps.setDate(3, new java.sql.Date(event.getDate().getTime()));
            ps.setString(4, event.getAddress());
            ps.setInt(5, event.getPostalCode());
            ps.setDouble(6, event.getPrice());
            ps.setInt(7, event.getRoom());
            ps.setInt(8, event.getPlaceId());
            ps.setInt(9, event.getId());
            ps.executeUpdate();
            System.out.println("Evento actualizado con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar el evento: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

    // Method to delete a place record from the database by ID
    public void deleteEvent(int id) {
        DBConnectionJava db = new DBConnectionJava();
        try {
            String consultaSQL = "DELETE FROM events WHERE id=?";
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Evento eliminado con éxito.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar el evento: " + e.getMessage());
        } finally {
            db.disconnect();
        }

    }

    public int getEventsId(String name) {
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

