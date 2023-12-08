
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionJava {
     // Constructor to establish a connection to the database
    static String bd = "eventsystem";
    static String port = "3306";
    static String login = "root";
    static String password = "m0r3r@2002";
    static String url = "jdbc:mariadb://localhost:" + port + "/" + bd;

    Connection connection = null;

    public DBConnectionJava() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, password);
            System.out.println("Conexion exitosa a la base de datos");

        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar la base de datos" + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al establecer la conexion" + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexion cerrada");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
    }
}
