package model;

import java.sql.Connection;//Represents a connection to a database.
import java.sql.DriverManager;//This class is responsible for managing a list of database drivers.
import java.sql.SQLException;//This class represents a specific SQL exception that can occur during interaction with a database.

// Class to manage the connection to the MariaDB database
public class DBConnectionJava {

    // Database configuration parameters
    static String bd = "eventsystem";
    static String port = "3306";
    static String login = "root";
    static String password = "Jairo8553";
    static String url = "jdbc:mariadb://localhost:" + port + "/" + bd;

    // Database connection object
    Connection connection = null;

    // Constructor to establish the connection to the database
    public DBConnectionJava() {
        try {
            // Load the MariaDB JDBC driver
            Class.forName("org.mariadb.jdbc.Driver");
            // Establish the connection using configuration parameters
            connection = DriverManager.getConnection(url, login, password);
            // Print successful connection message if everything is correct
            System.out.println("Conexion exitosa a la base de datos");

        } catch (ClassNotFoundException e) {
            //Catch exception if JDBC driver not found
            System.err.println("Error al cargar la base de datos" + e.getMessage());
        } catch (SQLException e) {
            // Capturar excepción si hay un error al establecer la conexión
            System.err.println("Error al establecer la conexion" + e.getMessage());
        }
    }

    // Method to obtain the connection to the database
    public Connection getConnection() {
        return connection;
    }

    // Method to establish a custom connection (may not be necessary)
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    // Method to close the connection to the database
    public void disconnect() {
        if (connection != null) {
            try {
                // Close the connection
                connection.close();
                // Print connection closed message
                System.out.println("Conexion cerrada");
            } catch (SQLException e) {
                // Catch exception if there is an error closing the connection
                System.err.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
    }
} 
