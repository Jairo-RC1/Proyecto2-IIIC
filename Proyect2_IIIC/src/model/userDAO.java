/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class userDAO {

    public userDAO() {
    }
    // Method to create a new user in the database

    public void createUser(user user) {
        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "INSERT INTO users (id_number, name, last_name, email, birth_date, phone_number, password, role_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, user.getIdNumber());
            ps.setString(2, user.getName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getEmail());
            ps.setDate(5, new java.sql.Date(user.getBirthDate().getTime()));
            ps.setInt(6, user.getPhoneNumber());
            ps.setString(7, user.getPassword());
            ps.setInt(8, user.getRoleId());

            ps.execute();
            JOptionPane.showMessageDialog(null, "Usuario insertado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo insertar el usuario, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

    public List<user> readUser() {
        DBConnectionJava db = new DBConnectionJava();
        List<user> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idNumber = resultSet.getInt("id_number");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_name");
                Date birthDate = resultSet.getDate("birth_date");
                String email = resultSet.getString("email");
                int phoneNumber = resultSet.getInt("phone_number");
                String password = resultSet.getString("password");
                int roleId = resultSet.getInt("role_id");
                users.add(new user(id, idNumber, name, lastName, birthDate, email, phoneNumber, password, roleId));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return users;
    }

    // Method to update an existing user in the database
    public void updateUser(user user) {
        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "UPDATE users SET id_number=?, name=?, last_name=?, birth_date=?, email=?, phone_number=?, password=?, role_id=? WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, user.getIdNumber());
            ps.setString(2, user.getName());
            ps.setString(3, user.getLastName());
            ps.setDate(4, new java.sql.Date(user.getBirthDate().getTime()));
            ps.setString(5, user.getEmail());
            ps.setInt(6, user.getPhoneNumber());
            ps.setString(7, user.getPassword());
            ps.setInt(8, user.getRoleId());
            ps.setInt(9, user.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar el usuario, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

    // Method to delete a user from the database by ID
    public void deleteUser(int id) {
        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "DELETE FROM users WHERE id=?";

        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(consultaSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el usuario, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }
}
