package model;

// Importing necessary Java SQL
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class placeDAO {


    public placeDAO() {

    }

    // Method to save a new place in the database
    public void createPlace(place pleace) {
        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "INSERT INTO places (name, address, city, postal_code, latitude, longitude, tripAdvisor_link) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, pleace.getName());
            ps.setString(2, pleace.getAddress());
            ps.setString(3, pleace.getCity());
            ps.setInt(4, pleace.getPostalCode());
            ps.setString(5, pleace.getLatitude());
            ps.setString(6, pleace.getLongitude());
            ps.setString(7, pleace.getTripAdvisorLink());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Se añadio su destino exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede guardar el destino. Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

    // Method to retrieve a list of all pleaces saved from the database
    public List<place> readPlaces() {
        DBConnectionJava db = new DBConnectionJava();
        List<place> pleaces = new ArrayList<>();
        String sql = "SELECT * FROM places";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                int postalCode = resultSet.getInt("postal_code");
                String latitude = resultSet.getString("latitude");
                String longitude = resultSet.getString("longitude");
                String tripAdvisorLink = resultSet.getString("tripAdvisor_link");
                
                pleaces.add(new place(id, postalCode, name, address, city, latitude, longitude, tripAdvisorLink));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return pleaces; 
    }

    // Method to update an existing place record in the database
    public void updatePlace(place place) {
        
        DBConnectionJava db = new DBConnectionJava();

        String sqlQuery = "UPDATE places SET postalCode=?, name=?, address=?, city=?, latitude=?, longitude=?, tripAdvisor_link=? WHERE id=?";

        try {

            PreparedStatement ps = db.getConnection().prepareStatement(sqlQuery);

            ps.setInt(1, place.getPostalCode());
            ps.setString(2, place.getName());
            ps.setString(3, place.getAddress());
            ps.setString(4, place.getCity());
            ps.setString(5, place.getLatitude());
            ps.setString(6, place.getLongitude());
            ps.setString(7, place.getTripAdvisorLink());
            ps.setInt(8, place.getId());

            ps.execute();

            JOptionPane.showMessageDialog(null, "Modificación exitosa");
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No se pudo modificar el lugar de destino. Error: " + e.getMessage());
        } finally {

            db.disconnect();
        }
    }

    public void deletePlace(int id) {

        DBConnectionJava db = new DBConnectionJava();
        
        String sqlQuery = "DELETE FROM places WHERE id=?";
        try {

            PreparedStatement preparedStatement = db.getConnection().prepareStatement(sqlQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "El destino se ha eliminado correctamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar el destino. Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

    public int getIDPlaces(String name) {
        int ID = 0;
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT id FROM places WHERE name = ?";

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

    // This method retrieves the name of a place from a database based on its ID.
    public String getNamePlaces(int id) {
        String name = "";
        DBConnectionJava db = new DBConnectionJava();
        String sql = "SELECT name FROM places WHERE id = ?";

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
