package controller;

import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.eventDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.event;

public class ctrlEvent {

    private eventDAO eventDAO;
    private int id;

    public ctrlEvent() {
        this.eventDAO = new eventDAO();
    }

    // This method loads event data into a JTable.
    public void loadEventData(JTable table) {
        // Get the table model associated with the JTable.
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Create a TableRowSorter for the table model to enable sorting.
        TableRowSorter<TableModel> order = new TableRowSorter<>(model);
        table.setRowSorter(order);

        // Set the row count of the table model to zero to clear existing data.
        model.setRowCount(0);

        // Retrieve a list of events from the eventDAO (Data Access Object).
        List<event> events = eventDAO.readEvent();

        // Iterate through the list of events and add each event's data as a row to the table model.
        for (event event : events) {
            Object[] row = {event.getId(), event.getName(), event.getDescription(), event.getDate(),
                event.getAddress(), event.getPostalCode(), event.getPrice(), event.getRoom(),
                event.getPlaceId()};
            model.addRow(row);
        }
    }

    // This method adds an event to the system with the provided information.
// It takes input parameters representing various details of the event.
    public void addEvent(JTextField name, JTextField description, JTextField utilDate, JTextField address,
            JTextField city, JTextField postalCode, JTextField price, JTextField room, JTextField placeId) {
        // Creating a date formatter with the specified format "yyyy-MM-dd".
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // Parsing the date string from the JTextField into a Date object.
            Date date = dateFormat.parse(utilDate.getText());

            // Creating a new event object with the provided information and adding it to the data access object (DAO).
            this.eventDAO.createEvent(new event(name.getText(), description.getText(), date, address.getText(), city.getText(),
                    Integer.parseInt(postalCode.getText()), Double.parseDouble(price.getText()),
                    Integer.parseInt(room.getText()), Integer.parseInt(placeId.getText())));

            // Displaying a success message using a JOptionPane.
            JOptionPane.showMessageDialog(null, "Evento agregado con éxito");
        } catch (ParseException ex) {
            // Handling an exception if there's an error in parsing the date.
            JOptionPane.showMessageDialog(null, "Error de formato en la fecha, el formato correcto es año-mes-día (yyyy-MM-dd): " + ex.toString());
        } catch (Exception e) {
            // Handling a general exception if there's an error in adding the event.
            JOptionPane.showMessageDialog(null, "Error al agregar el evento: " + e.toString());
        }

        // Clearing the input fields after the event is added or if an error occurs.
        this.clearFields(name, description, utilDate, address, city, postalCode, price, room, placeId);
    }

    //Updates an existing event with the provided information.
    public void updateEvent(JTextField name, JTextField description, JTextField utilDate, JTextField address,
            JTextField postalCode, JTextField city, JTextField price, JTextField room, JTextField placeId) {
        // Create a date formatecified format.
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            //the date string from the JTextField into a Date object.
            Date date = dateFormat.parse(utilDate.getText());

            // Update the event using the EventDAO with the provided information.
            this.eventDAO.updateEvent(new event(this.id, name.getText(), description.getText(), date,
                    address.getText(), city.getText(), Integer.parseInt(postalCode.getText()),
                    Double.parseDouble(price.getText()), Integer.parseInt(room.getText()),
                    Integer.parseInt(placeId.getText())));

            // Show a  message using a JOptionPane.
            JOptionPane.showMessageDialog(null, "Evento actualizado con éxito");
        } catch (NumberFormatException e) {
            // Show an error message for a number format exception.
            JOptionPane.showMessageDialog(null, "Error en el formato de datos: " + e.toString());
        } catch (ParseException ex) {
            // Log a severe error if there's an issue parsing the date.
            Logger.getLogger(ctrlEvent.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Clear the input fields after updating the event.
        this.clearFields(name, description, utilDate, address, city, postalCode, price, room, placeId);
    }

    public void deleteEvent() {
        this.eventDAO.deleteEvent(this.id);
    }

    // Method to populate text fields with data from the selected row in a JTable
    public void selectedRow(JTable table, JTextField name, JTextField description, JTextField date, JTextField address,
            JTextField postalCode, JTextField price, JTextField room, JTextField placeId) {
        try {
            // Get the index of the selected row
            int row = table.getSelectedRow();
            // Check if a row is selected
            if (row >= 0) {
                // Extract and set the values from the selected row to the corresponding text fields
                this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
                name.setText(table.getValueAt(row, 1).toString());
                description.setText(table.getValueAt(row, 2).toString());
                date.setText(table.getValueAt(row, 3).toString());
                address.setText(table.getValueAt(row, 4).toString());
                postalCode.setText(table.getValueAt(row, 5).toString());
                price.setText(table.getValueAt(row, 6).toString());
                room.setText(table.getValueAt(row, 7).toString());
                placeId.setText(table.getValueAt(row, 8).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
        }
    }

    //Clears the text content of specified JTextFields.
    public void clearFields(JTextField name, JTextField description, JTextField date, JTextField address,
            JTextField city, JTextField postalCode, JTextField price, JTextField room, JTextField placeId) {
        name.setText("");
        description.setText("");
        date.setText("");
        address.setText("");
        city.setText("");
        postalCode.setText("");
        price.setText("");
        room.setText("");
        placeId.setText("");
    }

    // Deletes a reservation from the database and removes the corresponding row from the specified JTable.
    public void deleteReservationByID(int reservationID, JTable table) {
        // Check if a valid reservation ID is provided (not equal to -1).
        if (reservationID != -1) {
            // Call the deleteEvent method of the eventDAO (assumed to be an instance of a data access object for events/reservations),
            // passing the reservation ID to delete the reservation from the database.
            eventDAO.deleteEvent(reservationID);

            // Obtain the DefaultTableModel associated with the provided JTable.
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            // Remove the row corresponding to the selected reservation from the JTable's model.
            model.removeRow(table.getSelectedRow());
        }
    }

    // This method retrieves the reservation ID associated with the selected row in a JTable based on a MouseEvent.
    public int getReservationIDFromTable(JTable table, MouseEvent evt) {
        // Initialize the eventID variable to -1, indicating no valid reservation ID initially.
        int eventID = -1;

        // Get the row and column indices of the cell at the mouse pointer's location.
        int row = table.rowAtPoint(evt.getPoint());
        int col = table.columnAtPoint(evt.getPoint());

        // Check if the mouse pointer is within a valid cell in the table.
        if (row >= 0 && col >= 0) {
            // Retrieve the reservation ID (assumed to be stored in the first column, index 0) from the selected row.
            eventID = (int) table.getValueAt(row, 0);
        }

        // Return the obtained reservation ID, or -1 if no valid ID was found.
        return eventID;
    }
}
