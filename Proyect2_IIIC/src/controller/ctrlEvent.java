/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.eventDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.event;

/**
 *
 * @author JRS
 */
public class ctrlEvent {
     private eventDAO eventDAO;
    private int id;

    public ctrlEvent() {
        this.eventDAO = new eventDAO();
    }

    public void loadEventData(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<>(model);
        table.setRowSorter(order);
        model.setRowCount(0);
        List<event> events = eventDAO.readEvents();
        for (event event : events) {
            Object[] row = { event.getId(), event.getName(), event.getDescription(), event.getDate(),
                    event.getAddress(), event.getPostalCode(), event.getPrice(), event.getRoom(),
                    event.getPlaceId() };
            model.addRow(row);
        }
    }

    public void addEvent(JTextField name, JTextField description, JTextField date, JTextField address,
            JTextField postalCode, JTextField price, JTextField room, JTextField placeId) {
        try {
            
            /*this.eventDAO.createEvent(new event(0, name.getText(), description.getText(), utilDate, address.getText(),
                    Integer.parseInt(postalCode.getText()), Double.parseDouble(price.getText()),
                    Integer.parseInt(room.getText()), Integer.parseInt(placeId.getText())));*/
            JOptionPane.showMessageDialog(null, "Evento agregado con éxito");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato de datos: " + e.toString());
        }
    }

    public void updateEvent(JTextField name, JTextField description, JTextField date, JTextField address,
            JTextField postalCode, JTextField price, JTextField room, JTextField placeId) {
        try {
            
            /*this.eventDAO.updateEvent(new event(this.id, name.getText(), description.getText(), utilDate,
                    address.getText(), Integer.parseInt(postalCode.getText()), Double.parseDouble(price.getText()),
                    Integer.parseInt(room.getText()), Integer.parseInt(placeId.getText())));*/
            JOptionPane.showMessageDialog(null, "Evento actualizado con éxito");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato de datos: " + e.toString());
        }
    }

    public void deleteEvent() {
        this.eventDAO.deleteEvent(this.id);
    }

    public void selectedRow(JTable table, JTextField name, JTextField description, JTextField date, JTextField address,
            JTextField postalCode, JTextField price, JTextField room, JTextField placeId) {
        try {
            int row = table.getSelectedRow();
            if (row >= 0) {
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

    public void clearFields(JTextField name, JTextField description, JTextField date, JTextField address,
            JTextField postalCode, JTextField price, JTextField room, JTextField placeId) {
        name.setText("");
        description.setText("");
        date.setText("");
        address.setText("");
        postalCode.setText("");
        price.setText("");
        room.setText("");
        placeId.setText("");
    }
}
