
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import model.APIHandler;
import model.event;
import model.place;
import view.ShowAPI;

/**
 *
 * @author jefry
 */
public class ctrlApiHandler {
    private APIHandler api = new APIHandler();
    private place place = new place(); 
    private List<event> events;

    public ctrlApiHandler() {
        this.api = api;
        this.events = new ArrayList<>();
    }

    public void searchEvents(JTextField name, JTextField ubiField, JScrollPane scroll, JComboBox type) {
        try {
            events = api.findEvents(name.getText(), ubiField.getText(), type.getSelectedItem().toString());
            displayEvents(scroll);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error buscando eventos: " + e.getMessage());
        }
    }

    public void displayEvents(JScrollPane scrollPane) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        for (event event : events) {
            try {
                ShowAPI eventPanel = new ShowAPI(event, api);
                mainPanel.add(eventPanel);
            } catch (Exception e) {
                System.out.println("Error mostrando el evento: " + e.getMessage());
            }
        }
        scrollPane.setViewportView(mainPanel);
    }
}
