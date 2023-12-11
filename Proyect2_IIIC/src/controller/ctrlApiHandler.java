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
import view.mainView;

public class ctrlApiHandler {

    // Creates an instances
    private APIHandler api = new APIHandler();
    private place place = new place();
    private List<event> events;

    // Constructor for the 'ctrlApiHandler' class.
    public ctrlApiHandler() {
        // Initializes the 'api' variable with the previously created APIHandler instance.
        this.api = api;

        // Initializes the 'events' List with a new ArrayList to store 'event' instances.
        this.events = new ArrayList<>();
    }

    // Method to search for events based on user input and update the display accordingly
    public void searchEvents(JTextField name, JTextField ubiField, JScrollPane scroll, JComboBox type, mainView user) {
        try {
            // Call the API's findEvents method with the provided parameters
            events = api.findEvents(name.getText(), ubiField.getText(), type.getSelectedItem().toString());

            // Update the display of events using the provided JScrollPane and mainView
            displayEvents(scroll, user);
        } catch (Exception e) {
            // Display an error message if an exception occurs during the event search
            JOptionPane.showMessageDialog(null, "Error buscando eventos: " + e.getMessage());
        }
    }

    // This method is responsible for displaying events in a JScrollPane within the mainView.
    public void displayEvents(JScrollPane scrollPane, mainView user) {
        // Create a JPanel to hold the event panels in a vertical BoxLayout.
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Iterate through each event in the collection.
        for (event event : events) {
            try {
                // Create an instance of the ShowAPI class to display the details of the current event.
                ShowAPI eventPanel = new ShowAPI(event, api, user);

                // Add the eventPanel to the mainPanel.
                mainPanel.add(eventPanel);
            } catch (Exception e) {
                // Handle any exceptions that may occur while displaying the event.
                System.out.println("Error mostrando el evento: " + e.getMessage());
            }
        }

        // Set the mainPanel as the view of the JScrollPane.
        scrollPane.setViewportView(mainPanel);
    }
}
