
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.place;
import model.placeDAO;

/**
 *
 * @author jefry
 */
public class ctrlPlace {
    placeDAO dao = new placeDAO();
    int id;

    public void loadDataPlace(JTable table) {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<TableModel>(model);
        table.setRowSorter(order);
        model.setRowCount(0);
        List<place> place = dao.readPlaces();
        for (place places : place) {
            Object[] row = {places.getId(), places.getName(), places.getAddress(), places.getCity(), places.getPostalCode(), places.getLatitude(), places.getLongitude(), places.getTripAdvisorLink()};
            model.addRow(row);
        }
    }

    public void addPlace(JTextField name, JTextField address, JTextField city, JTextField postalCode, JTextField latitude, JTextField longitude, JTextField tripAdvisorLink) {
        try {
            this.dao.createPlace(new place(Integer.parseInt(postalCode.getText()), name.getText(), address.getText(), city.getText(),latitude.getText(), longitude.getText(), tripAdvisorLink.getText()));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar el lugar: " + e.toString());
        }
        this.clearFields(name, address, city, postalCode, latitude, longitude, tripAdvisorLink);
    }
    
     public void updatedPlace(JTextField name, JTextField address, JTextField city, JTextField postalCode, JTextField latitude, JTextField longitude, JTextField tripAdvisorLink) {
        try {     
            this.dao.updatePlace(new place(this.id,Integer.parseInt(postalCode.getText()), name.getText(), address.getText(), city.getText(),latitude.getText(), longitude.getText(), tripAdvisorLink.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el lugar: " + e.toString());
        }
        this.clearFields(name, address, city, postalCode, latitude, longitude, tripAdvisorLink);
    }

    public void deletePlace() {
        this.dao.deletePlace(this.id);
    }

    public void clearFields(JTextField name, JTextField address, JTextField city, JTextField postalCode, JTextField latitude, JTextField longitude, JTextField tripAdvisorLink) {
        name.setText("");
        address.setText("");
        city.setText("");
        postalCode.setText("");
        latitude.setText("");
        longitude.setText("");
        tripAdvisorLink.setText("");
    }
}
