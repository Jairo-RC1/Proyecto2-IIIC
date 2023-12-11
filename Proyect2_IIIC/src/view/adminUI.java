/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.*;
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReservations = new javax.swing.JTable();
        btnDeleteReservation = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEvents = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnDeleteEvent = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPlaces = new javax.swing.JTable();
        btnDeletePlace = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Administrador de Reservaciones");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

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

        btnDeleteReservation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/delete.png"))); // NOI18N
        btnDeleteReservation.setBorderPainted(false);
        btnDeleteReservation.setContentAreaFilled(false);
        btnDeleteReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteReservationActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeleteReservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(834, 100, 60, 80));

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

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setText("Administrador de Eventos");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        btnDeleteEvent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/delete.png"))); // NOI18N
        btnDeleteEvent.setBorderPainted(false);
        btnDeleteEvent.setContentAreaFilled(false);
        btnDeleteEvent.setFocusable(false);
        btnDeleteEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteEventActionPerformed(evt);
            }
        });
        jPanel2.add(btnDeleteEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(834, 100, 60, 80));

        jTabbedPane1.addTab("Eventos", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("Administrador de Destinos");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

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

        btnDeletePlace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/delete.png"))); // NOI18N
        btnDeletePlace.setBorderPainted(false);
        btnDeletePlace.setContentAreaFilled(false);
        btnDeletePlace.setFocusPainted(false);
        btnDeletePlace.setFocusable(false);
        btnDeletePlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePlaceActionPerformed(evt);
            }
        });
        jPanel3.add(btnDeletePlace, new org.netbeans.lib.awtextra.AbsoluteConstraints(834, 100, 60, 80));

        jTabbedPane1.addTab("Destinos", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 960, -1));

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/exit.png"))); // NOI18N
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setFocusable(false);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 50, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteReservationActionPerformed
        this.ctlr.deleteReservationByID(reservationID, tblReservations);
    }//GEN-LAST:event_btnDeleteReservationActionPerformed

    private void tblReservationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReservationsMouseClicked
        reservationID = this.ctlr.getReservationIDFromTable(tblReservations, evt);
    }//GEN-LAST:event_tblReservationsMouseClicked

    private void btnDeleteEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteEventActionPerformed
        this.cte.deleteReservationByID(reservationID, tblEvents);
    }//GEN-LAST:event_btnDeleteEventActionPerformed

    private void tblEventsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEventsMouseClicked
        reservationID = this.cte.getReservationIDFromTable(tblEvents, evt);
    }//GEN-LAST:event_tblEventsMouseClicked

    private void btnDeletePlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePlaceActionPerformed
        this.ctp.deleteReservationByID(reservationID, tblPlaces);
    }//GEN-LAST:event_btnDeletePlaceActionPerformed

    private void tblPlacesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPlacesMouseClicked
        reservationID = this.ctp.getReservationIDFromTable(tblPlaces, evt);
    }//GEN-LAST:event_tblPlacesMouseClicked

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        login lg = new login();
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteEvent;
    private javax.swing.JButton btnDeletePlace;
    private javax.swing.JButton btnDeleteReservation;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblEvents;
    private javax.swing.JTable tblPlaces;
    private javax.swing.JTable tblReservations;
    // End of variables declaration//GEN-END:variables
}
