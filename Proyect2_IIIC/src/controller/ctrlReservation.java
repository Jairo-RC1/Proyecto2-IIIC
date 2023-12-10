package controller;

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

/**
 *
 * @author jefry
 */

public class ctrlReservation {

    validation vali = new validation();
    reservationDAO dao = new reservationDAO();
    eventDAO event = new eventDAO();
    int id;

    public void loadDataReservation(JTable table) {
        // Get the table model and set up a TableRowSorter for sorting functionality

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

    public void addReservation(JTextField userName, JTextField date, int quantity, int eventId) {
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

    public void deleteRol() {
        this.dao.deleteReservation(this.id);
    }
    // Set the text content of each JTextField to an empty string

    public void clearFields(JTextField userName, JTextField date) {
        userName.setText("");
        date.setText("");
    }

    public boolean validateName(JTextField userName) {
        if (!vali.validateABCWithSpaces(userName.getText())) {
            JOptionPane.showMessageDialog(null, "El nombre que ingresaste no cumple con el formato");
            return false;
        }
        return true;
    }

    public boolean validateQuantity(JTextField valor) {
        if (!vali.validateNumbers(valor.getText())) {
            JOptionPane.showMessageDialog(null, "La canitidad que ingresaste no cumple con el formato");
            return false;
        }
        return true;
    }

}
