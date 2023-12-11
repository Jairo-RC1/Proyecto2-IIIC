package controller;

import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.place;
import model.placeDAO;

// This class, ctrlPlace, is responsible for controlling and managing data related to places.
public class ctrlPlace {

    // Creating an instance of the placeDAO class for data access operations.
    placeDAO dao = new placeDAO();

    // Variable to store the ID of a place.
    int id;

    // Method to load place data into a JTable.
    public void loadDataPlace(JTable table) {
        // Retrieving the table model to manipulate its data.
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Creating a TableRowSorter to enable sorting of rows in the JTable.
        TableRowSorter<TableModel> order = new TableRowSorter<TableModel>(model);
        table.setRowSorter(order);

        // Clearing the existing rows in the table model.
        model.setRowCount(0);

        // Retrieving a list of places from the data access object (DAO).
        List<place> place = dao.readPlaces();

        // Iterating through the list of places and adding each place's data to the table model.
        for (place places : place) {
            Object[] row = {places.getId(), places.getName(), places.getAddress(), places.getCity(),
                places.getPostalCode(), places.getLatitude(), places.getLongitude(),
                places.getTripAdvisorLink()};
            model.addRow(row);
        }
    }

    // Method to add a new place using the provided text fields for various attributes.
    public void addPlace(JTextField name, JTextField address, JTextField city, JTextField postalCode, JTextField latitude, JTextField longitude, JTextField tripAdvisorLink) {
        try {
            // Creating a new place object with the information from the text fields and adding it using the DAO.
            this.dao.createPlace(new place(
                    Integer.parseInt(postalCode.getText()),
                    name.getText(),
                    address.getText(),
                    city.getText(),
                    latitude.getText(),
                    longitude.getText(),
                    tripAdvisorLink.getText()
            ));

        } catch (Exception e) {
            // Displaying an error message if an exception occurs during the addition of the place.
            JOptionPane.showMessageDialog(null, "Error al agregar el lugar: " + e.toString());
        }

        // Clearing the input fields after adding the place.
        this.clearFields(name, address, city, postalCode, latitude, longitude, tripAdvisorLink);
    }

    // Description: Updates a place's information in the database based on the provided input fields.
    public void updatedPlace(JTextField name, JTextField address, JTextField city, JTextField postalCode, JTextField latitude, JTextField longitude, JTextField tripAdvisorLink) {
        try {
            // Attempt to update the place in the database using the DAO (Data Access Object) and the provided input fields.
            this.dao.updatePlace(new place(this.id, Integer.parseInt(postalCode.getText()), name.getText(), address.getText(), city.getText(), latitude.getText(), longitude.getText(), tripAdvisorLink.getText()));
        } catch (Exception e) {
            // Display an error message if updating the place encounters an exception.
            JOptionPane.showMessageDialog(null, "Error al actualizar el lugar: " + e.toString());
        }
        // Clear the input fields after the place is updated or if an error occurs.
        this.clearFields(name, address, city, postalCode, latitude, longitude, tripAdvisorLink);
    }

    // This method is responsible for deleting a place using the associated Data Access Object (DAO).
    public void deletePlace() {
        // Invokes the deletePlace method of the DAO, passing the current instance's id for identification.
        this.dao.deletePlace(this.id);
    }

    //This method takes several JTextField parameters and sets their text content to an empty string,
    // effectively clearing the input fields. The provided JTextFields represent various information fields such as
    // name, address, city, postal code, latitude, longitude, and a TripAdvisor link.
    public void clearFields(JTextField name, JTextField address, JTextField city, JTextField postalCode, JTextField latitude, JTextField longitude, JTextField tripAdvisorLink) {
        name.setText("");
        address.setText("");
        city.setText("");
        postalCode.setText("");
        latitude.setText("");
        longitude.setText("");
        tripAdvisorLink.setText("");
    }

    // Deletes a reservation identified by the given reservationID from the data source and updates the JTable.
    // If the reservationID is -1, indicating no selection, the method does nothing.
    public void deleteReservationByID(int reservationID, JTable table) {
        // Check if a valid reservationID is provided
        if (reservationID != -1) {
            // Invoke the DAO (Data Access Object) to delete the reservation by its ID from the data source
            dao.deletePlace(reservationID);

            // Retrieve the table model associated with the JTable
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            // Remove the row corresponding to the selected reservation from the table model
            model.removeRow(table.getSelectedRow());
        }
    }

    // This method retrieves the reservation ID from a given JTable based on the mouse event.
    public int getReservationIDFromTable(JTable table, MouseEvent evt) {
        // Initialize the eventID variable to -1 (default value).
        int eventID = -1;

        // Get the row and column indices of the JTable where the mouse event occurred.
        int row = table.rowAtPoint(evt.getPoint());
        int col = table.columnAtPoint(evt.getPoint());

        // Check if the mouse event coordinates are within a valid cell of the JTable.
        if (row >= 0 && col >= 0) {
            // Retrieve the reservation ID from the cell at the specified row and the first column (column index 0).
            eventID = (int) table.getValueAt(row, 0);
        }

        // Return the obtained reservation ID.
        return eventID;
    }
}
