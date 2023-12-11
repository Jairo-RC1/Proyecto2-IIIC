/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.*;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.*;

public class adminUI extends javax.swing.JFrame {

    private int reservationID = -1;
    ctrlReservation ctlr = new ctrlReservation();
    ctrlEvent cte = new ctrlEvent();
    ctrlPlace ctp = new ctrlPlace();

    public adminUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.ctlr.loadDataReservation(tblReservations);
        this.cte.loadEventData(tblEvents);
        this.ctp.loadDataPlace(tblPlaces);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblBookingAdmin = new javax.swing.JLabel();
        btnDeleteReservations = new javax.swing.JPanel();
        lblEventImage1 = new javax.swing.JLabel();
        lblDeletePlace1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReservations = new javax.swing.JTable();
        lblBookingBackground = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEvents = new javax.swing.JTable();
        lblEventsAdmin = new javax.swing.JLabel();
        btnDeleteEvent = new javax.swing.JPanel();
        lblEventImage = new javax.swing.JLabel();
        lblDeleteEvent = new javax.swing.JLabel();
        lblEventsBackground = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblPlaceAdmin = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPlaces = new javax.swing.JTable();
        btnDeletePlace = new javax.swing.JPanel();
        lblImagePlace = new javax.swing.JLabel();
        lblDeletePlace = new javax.swing.JLabel();
        lblPlaceBackground = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBookingAdmin.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblBookingAdmin.setForeground(new java.awt.Color(0, 0, 0));
        lblBookingAdmin.setText("Administrador de Reservaciones");
        jPanel1.add(lblBookingAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        btnDeleteReservations.setBackground(new java.awt.Color(255, 255, 255));
        btnDeleteReservations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteReservationsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteReservationsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteReservationsMouseExited(evt);
            }
        });
        btnDeleteReservations.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEventImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/delete.png"))); // NOI18N
        btnDeleteReservations.add(lblEventImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        lblDeletePlace1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblDeletePlace1.setForeground(new java.awt.Color(0, 0, 0));
        lblDeletePlace1.setText("Eliminar");
        btnDeleteReservations.add(lblDeletePlace1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 90, 20));

        jPanel1.add(btnDeleteReservations, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 150, 150, 40));

        tblReservations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Usuario", "Fecha", "Cantidad", "Evento"
            }
        ));
        tblReservations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReservationsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblReservations);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 960, 280));

        lblBookingBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/reservation.jpg"))); // NOI18N
        jPanel1.add(lblBookingBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 480));

        jTabbedPane1.addTab("Reservas", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblEvents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Descripcion", "Fecha", "Direccion", "Ciudad", "Codigo Postal", "Precio", "Cuarto", "Destino ID"
            }
        ));
        tblEvents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEventsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblEvents);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 960, 280));

        lblEventsAdmin.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblEventsAdmin.setForeground(new java.awt.Color(255, 255, 255));
        lblEventsAdmin.setText("Administrador de Eventos");
        jPanel2.add(lblEventsAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        btnDeleteEvent.setBackground(new java.awt.Color(255, 255, 255));
        btnDeleteEvent.setForeground(new java.awt.Color(255, 0, 0));
        btnDeleteEvent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteEventMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteEventMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteEventMouseExited(evt);
            }
        });
        btnDeleteEvent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEventImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/delete.png"))); // NOI18N
        btnDeleteEvent.add(lblEventImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        lblDeleteEvent.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblDeleteEvent.setForeground(new java.awt.Color(0, 0, 0));
        lblDeleteEvent.setText("Eliminar");
        btnDeleteEvent.add(lblDeleteEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 90, 20));

        jPanel2.add(btnDeleteEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 150, 160, 40));

        lblEventsBackground.setForeground(new java.awt.Color(255, 0, 0));
        lblEventsBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/Events.jpg"))); // NOI18N
        jPanel2.add(lblEventsBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 480));

        jTabbedPane1.addTab("Eventos", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPlaceAdmin.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblPlaceAdmin.setForeground(new java.awt.Color(255, 255, 255));
        lblPlaceAdmin.setText("Administrador de Destinos");
        jPanel3.add(lblPlaceAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        tblPlaces.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Direccion", "Ciudad", "C.Postal", "Latitud", "Longitud", "TripAdvisor"
            }
        ));
        tblPlaces.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPlacesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPlaces);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 960, 280));

        btnDeletePlace.setBackground(new java.awt.Color(255, 255, 255));
        btnDeletePlace.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeletePlaceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeletePlaceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeletePlaceMouseExited(evt);
            }
        });
        btnDeletePlace.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImagePlace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/delete.png"))); // NOI18N
        btnDeletePlace.add(lblImagePlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        lblDeletePlace.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblDeletePlace.setForeground(new java.awt.Color(0, 0, 0));
        lblDeletePlace.setText("Eliminar");
        btnDeletePlace.add(lblDeletePlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 90, 20));

        jPanel3.add(btnDeletePlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 140, 160, 40));

        lblPlaceBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/place.jpg"))); // NOI18N
        jPanel3.add(lblPlaceBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 480));

        jTabbedPane1.addTab("Destinos", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 960, -1));

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/exit.png"))); // NOI18N
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setFocusable(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void panelColor(JPanel panel) {
        panel.setBackground(new java.awt.Color(255,0,0));
    }

    private void resetPanelColor(JPanel panel) {
        panel.setBackground(new java.awt.Color(255,255,255));
    }
    private void tblReservationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReservationsMouseClicked
        reservationID = this.ctlr.getReservationIDFromTable(tblReservations, evt);
    }//GEN-LAST:event_tblReservationsMouseClicked

    private void tblEventsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEventsMouseClicked
        reservationID = this.cte.getReservationIDFromTable(tblEvents, evt);
    }//GEN-LAST:event_tblEventsMouseClicked

    private void tblPlacesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPlacesMouseClicked
        reservationID = this.ctp.getReservationIDFromTable(tblPlaces, evt);
    }//GEN-LAST:event_tblPlacesMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        login lg = new login();
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnDeleteEventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteEventMouseClicked
        this.cte.deleteReservationByID(reservationID, tblEvents);
    }//GEN-LAST:event_btnDeleteEventMouseClicked

    private void btnDeleteEventMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteEventMouseEntered
        panelColor(btnDeleteEvent);
    }//GEN-LAST:event_btnDeleteEventMouseEntered

    private void btnDeleteEventMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteEventMouseExited
        resetPanelColor(btnDeleteEvent);
    }//GEN-LAST:event_btnDeleteEventMouseExited

    private void btnDeletePlaceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeletePlaceMouseClicked
        this.ctp.deleteReservationByID(reservationID, tblPlaces);
    }//GEN-LAST:event_btnDeletePlaceMouseClicked

    private void btnDeletePlaceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeletePlaceMouseEntered
        panelColor(btnDeletePlace);
    }//GEN-LAST:event_btnDeletePlaceMouseEntered

    private void btnDeletePlaceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeletePlaceMouseExited
        resetPanelColor(btnDeletePlace);
    }//GEN-LAST:event_btnDeletePlaceMouseExited

    private void btnDeleteReservationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteReservationsMouseClicked
        this.ctlr.deleteReservationByID(reservationID, tblReservations);
    }//GEN-LAST:event_btnDeleteReservationsMouseClicked

    private void btnDeleteReservationsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteReservationsMouseEntered
       panelColor(btnDeleteReservations);
    }//GEN-LAST:event_btnDeleteReservationsMouseEntered

    private void btnDeleteReservationsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteReservationsMouseExited
        resetPanelColor(btnDeleteReservations);
    }//GEN-LAST:event_btnDeleteReservationsMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnDeleteEvent;
    private javax.swing.JPanel btnDeletePlace;
    private javax.swing.JPanel btnDeleteReservations;
    private javax.swing.JButton btnExit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblBookingAdmin;
    private javax.swing.JLabel lblBookingBackground;
    private javax.swing.JLabel lblDeleteEvent;
    private javax.swing.JLabel lblDeletePlace;
    private javax.swing.JLabel lblDeletePlace1;
    private javax.swing.JLabel lblEventImage;
    private javax.swing.JLabel lblEventImage1;
    private javax.swing.JLabel lblEventsAdmin;
    private javax.swing.JLabel lblEventsBackground;
    private javax.swing.JLabel lblImagePlace;
    private javax.swing.JLabel lblPlaceAdmin;
    private javax.swing.JLabel lblPlaceBackground;
    private javax.swing.JTable tblEvents;
    private javax.swing.JTable tblPlaces;
    private javax.swing.JTable tblReservations;
    // End of variables declaration//GEN-END:variables
}
