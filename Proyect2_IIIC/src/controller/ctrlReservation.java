package controller;

import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.event;
import model.eventDAO;
import model.place;
import model.reservation;
import model.reservationDAO;
import view.ShowAPI;

public class ctrlReservation {

    validation vali = new validation();
    reservationDAO dao = new reservationDAO();
    eventDAO event = new eventDAO();
    int id;

    public void loadDataReservation(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<TableModel>(model);
        table.setRowSorter(order);
        model.setRowCount(0);
        List<reservation> reservation = dao.readReservation();
        for (reservation reservations : reservation) {
            Object[] row = {reservations.getId(), reservations.getUserName(), reservations.getDate(), reservations.getQuantity(), this.event.getEventsName(reservations.getIdEvent())};
            model.addRow(row);
        }
    }

    public void loadDataReservationForUser(JTable table, String username) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<>(model);
        table.setRowSorter(order);
        model.setRowCount(0);

        // Aquí, asumiendo que tienes un DAO que lee las reservas para un usuario específico
        List<reservation> reservationsForUser = dao.readReservationsForUser(username);

        for (reservation reservation : reservationsForUser) {
            Object[] row = {
                reservation.getId(),
                reservation.getUserName(),
                reservation.getDate(),
                reservation.getQuantity(),
                this.event.getEventsName(reservation.getIdEvent())
            };
            model.addRow(row);
        }
    }

    public void createReservation(JTextField userName, JTextField date, int quantity, int eventId) {
        if (!validateName(userName)) {
            return;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date reservationDate = dateFormat.parse(date.getText());
            this.dao.createReservation(new reservation(userName.getText(), reservationDate, quantity, eventId));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato en la fecha, el formato correcto es año-mes-día (yyyy-MM-dd): " + ex.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar la reserva: " + e.toString());
        }
        this.clearFields(userName, date);
    }
    // Create a date formatter for parsing the date string

    public void updatedReservation(JTextField userName, JTextField date, int quantity, int eventId) {
        if (!validateName(userName)) {
            return;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date reservationDate = dateFormat.parse(date.getText());
            this.dao.updateReservation(new reservation(this.id, userName.getText(), reservationDate, quantity, eventId));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato, el indicado es año-mes-día : ");
        }
        this.clearFields(userName, date);
    }
    // Delete the role with the specified ID from the data source

    public void deleteReservation() {
        this.dao.deleteReservation(this.id);
    }
    // Set the text content of each JTextField to an empty string

    public void clearFields(JTextField userName, JTextField date) {
        userName.setText("");
        date.setText("");
    }

    // Method to validate a user's name entered in a JTextField.
    // The method takes a JTextField as a parameter.
    public boolean validateName(JTextField userName) {
        // Check if the entered name does not match the specified format using a validation helper method.
        if (!vali.validateABCWithSpaces(userName.getText())) {
            JOptionPane.showMessageDialog(null, "El nombre que ingresaste no cumple con el formato");
            return false;
        }
        return true; // If the name passes validation, return true to indicate successful validation.
    }

    // This method validates the quantity entered in a JTextField.
    public boolean validateQuantity(JTextField valor) {
        // Check if the text in the JTextField contains only numbers
        if (!vali.validateNumbers(valor.getText())) {
            JOptionPane.showMessageDialog(null, "La canitidad que ingresaste no cumple con el formato");
            return false;
        }
        return true;
    }

    // This method deletes a reservation based on the provided reservation ID.
    public void deleteReservationByID(int reservationID, JTable table) {
        // Check if a valid reservation ID is provided (-1 indicates no selection).
        if (reservationID != -1) {
            // Call the deleteReservation method from the dao (data access object) to delete the reservation from the database.
            dao.deleteReservation(reservationID);

            // Get the table model associated with the provided JTable.
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            // Remove the row corresponding to the selected reservation from the table.
            model.removeRow(table.getSelectedRow());
        }
    }

    // This method retrieves the reservation ID associated with the clicked cell in a JTable.
    public int getReservationIDFromTable(JTable table, MouseEvent evt) {
        // Initialize eventID with -1, indicating no valid reservation ID found initially.
        int eventID = -1;

        // Get the row and column indices of the cell where the mouse event occurred.
        int row = table.rowAtPoint(evt.getPoint());
        int col = table.columnAtPoint(evt.getPoint());

        // Check if the mouse event is within a valid cell (row and column indices are non-negative).
        if (row >= 0 && col >= 0) {
            // Retrieve the reservation ID from the cell at the specified row and the first column (column index 0).
            eventID = (int) table.getValueAt(row, 0);
        }

        // Return the obtained reservation ID. If no valid ID is found, the method returns -1.
        return eventID;
    }

}
