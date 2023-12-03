/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.*;
import view.*;

/**
 *
 * @author jairo
 */
public class mainViewController {

    private APIHandler apiHandler;
    private mainView view;

    public mainViewController(mainView view) {
        this.view = view;
        this.apiHandler = new APIHandler();
        this.view.getSearchButton().addActionListener(e -> searchEvents());
    }

    private void searchEvents() {
        String searchTerm = view.getSearchTerm(); // Método que obtiene el término de búsqueda del JTextField

        try {
            // Obtener la lista de eventos desde la API basada en el término de búsqueda
            List<event> events = apiHandler.findEvents(searchTerm, "ubicacion", "categoria");

            // Suponiendo que tienes etiquetas (JLabel) en tu interfaz gráfica (mainView)
            view.getEventNameLabel().setText(events.get(0).getName());
            // Aquí puedes seguir asignando otros valores a otras etiquetas con otros detalles del evento
        } catch (Exception e) {
            // Manejo de errores
            e.printStackTrace();
        }
    }

    public void loadEventData() {
        try {
            // Obtener la lista de eventos desde la API
            List<event> events = apiHandler.findEvents("nombreEvento", "ubicacion", "categoria");

            // Suponiendo que tienes etiquetas (JLabel) en tu interfaz gráfica (mainView)
            view.getEventNameLabel().setText(events.get(0).getName());
            // Aquí puedes seguir asignando otros valores a otras etiquetas con otros detalles del evento
        } catch (Exception e) {
            // Manejo de errores
            e.printStackTrace();
        }
    }
}
