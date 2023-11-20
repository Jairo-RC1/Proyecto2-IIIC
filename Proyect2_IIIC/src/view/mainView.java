package view;

import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author jefry
 */
public class mainView extends javax.swing.JFrame {

    public mainView() {
        initComponents();
        FlatIntelliJLaf.setup();
        System.out.println("55655");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        MainPanel = new javax.swing.JPanel();
        DashBoard = new javax.swing.JPanel();
        SideBar = new javax.swing.JPanel();
        lblOptions = new javax.swing.JLabel();
        ProfilePane = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        lblUser = new javax.swing.JLabel();
        lblProfile = new javax.swing.JLabel();
        SerchPane = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        lblSerch = new javax.swing.JLabel();
        lblSerchEvent = new javax.swing.JLabel();
        BookingPane = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        lblCalendar = new javax.swing.JLabel();
        lblBooking = new javax.swing.JLabel();
        separator1 = new javax.swing.JSeparator();
        separator2 = new javax.swing.JSeparator();
        lblOptions1 = new javax.swing.JLabel();
        Events = new javax.swing.JPanel();
        pnBooking = new javax.swing.JPanel();
        pnProfile = new javax.swing.JPanel();
        pnSerchEvent = new javax.swing.JPanel();
        lblIcon = new javax.swing.JLabel();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setMinimumSize(new java.awt.Dimension(1000, 625));
        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DashBoard.setBackground(new java.awt.Color(255, 255, 255));
        DashBoard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SideBar.setBackground(new java.awt.Color(211, 82, 1));
        SideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblOptions.setBackground(new java.awt.Color(211, 82, 1));
        lblOptions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOptions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/options_icon_254403.png"))); // NOI18N
        lblOptions.setOpaque(true);
        lblOptions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOptionsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOptionsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOptionsMouseExited(evt);
            }
        });
        SideBar.add(lblOptions, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 48, 48));

        ProfilePane.setBackground(new java.awt.Color(211, 82, 1));
        ProfilePane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProfilePaneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProfilePaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProfilePaneMouseExited(evt);
            }
        });
        ProfilePane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        ProfilePane.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 189, 10));

        lblUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/user.png"))); // NOI18N
        ProfilePane.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 48, 48));

        lblProfile.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblProfile.setForeground(new java.awt.Color(0, 0, 0));
        lblProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProfile.setText("Mi perfil");
        ProfilePane.add(lblProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 140, 40));

        SideBar.add(ProfilePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 190, 60));

        SerchPane.setBackground(new java.awt.Color(211, 82, 1));
        SerchPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SerchPaneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SerchPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SerchPaneMouseExited(evt);
            }
        });
        SerchPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        SerchPane.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 189, 10));

        lblSerch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/serch.png"))); // NOI18N
        SerchPane.add(lblSerch, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 48, 48));

        lblSerchEvent.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblSerchEvent.setForeground(new java.awt.Color(0, 0, 0));
        lblSerchEvent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSerchEvent.setText("Buscar Evento");
        SerchPane.add(lblSerchEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 140, 40));

        SideBar.add(SerchPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 190, 60));

        BookingPane.setBackground(new java.awt.Color(211, 82, 1));
        BookingPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BookingPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BookingPaneMouseExited(evt);
            }
        });
        BookingPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        BookingPane.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 189, 10));

        lblCalendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/calendar.png"))); // NOI18N
        BookingPane.add(lblCalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 48, 48));

        lblBooking.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblBooking.setForeground(new java.awt.Color(0, 0, 0));
        lblBooking.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBooking.setText("Reservar");
        BookingPane.add(lblBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 140, 40));

        SideBar.add(BookingPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 190, 60));

        separator1.setBackground(new java.awt.Color(0, 0, 0));
        separator1.setForeground(new java.awt.Color(0, 0, 0));
        SideBar.add(separator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 188, 20));

        separator2.setBackground(new java.awt.Color(0, 0, 0));
        separator2.setForeground(new java.awt.Color(0, 0, 0));
        SideBar.add(separator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 188, 20));

        DashBoard.add(SideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 550));

        lblOptions1.setBackground(new java.awt.Color(255, 255, 255));
        lblOptions1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOptions1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/options_icon_254403.png"))); // NOI18N
        lblOptions1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOptions1MouseClicked(evt);
            }
        });
        DashBoard.add(lblOptions1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 48, 48));

        Events.setBackground(new java.awt.Color(255, 255, 255));
        Events.setLayout(new java.awt.CardLayout());

        pnBooking.setBackground(new java.awt.Color(255, 255, 255));
        pnBooking.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Events.add(pnBooking, "card3");

        pnProfile.setBackground(new java.awt.Color(0, 0, 0));
        pnProfile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Events.add(pnProfile, "card4");

        pnSerchEvent.setBackground(new java.awt.Color(255, 255, 255));
        pnSerchEvent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Events.add(pnSerchEvent, "card2");

        DashBoard.add(Events, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 810, 520));

        MainPanel.add(DashBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1010, 520));

        lblIcon.setBackground(new java.awt.Color(211, 82, 1));
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/TreeTravel.jpeg"))); // NOI18N
        MainPanel.add(lblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1000, 140));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void labelColor(JLabel label) {
        label.setBackground(new java.awt.Color(255, 100, 1));
    }

    private void resetLabelColor(JLabel label) {
        label.setBackground(new java.awt.Color(211, 82, 1));
    }

    private void panelColor(JPanel panel) {
        panel.setBackground(new java.awt.Color(255, 100, 1));
    }
    private void resetPanelColor(JPanel panel) {
    panel.setBackground(new java.awt.Color(211, 82, 1));
}


    int x = 250;
    private void lblOptions1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOptions1MouseClicked
        Thread th = new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i <= 188; i++) {
                        Thread.sleep(1);
                        SideBar.setSize(i, 540);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        });

        th.start();
        x = 210;
    }//GEN-LAST:event_lblOptions1MouseClicked

    private void lblOptionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOptionsMouseClicked
        Thread th = new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 210; i >= 0; i--) {
                        Thread.sleep(1);
                        SideBar.setSize(i, 540);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        });

        th.start();
        x = 0;
    }//GEN-LAST:event_lblOptionsMouseClicked

    private void lblOptionsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOptionsMouseEntered
        labelColor(lblOptions);
    }//GEN-LAST:event_lblOptionsMouseEntered

    private void lblOptionsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOptionsMouseExited
        resetLabelColor(lblOptions);
    }//GEN-LAST:event_lblOptionsMouseExited

    private void ProfilePaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfilePaneMouseEntered
        panelColor(ProfilePane);
    }//GEN-LAST:event_ProfilePaneMouseEntered

    private void ProfilePaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfilePaneMouseExited
        resetPanelColor(ProfilePane);
    }//GEN-LAST:event_ProfilePaneMouseExited

    private void SerchPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SerchPaneMouseEntered
        panelColor(SerchPane);
    }//GEN-LAST:event_SerchPaneMouseEntered

    private void SerchPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SerchPaneMouseExited
        resetPanelColor(SerchPane);
    }//GEN-LAST:event_SerchPaneMouseExited

    private void BookingPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookingPaneMouseEntered
        panelColor(BookingPane);
    }//GEN-LAST:event_BookingPaneMouseEntered

    private void BookingPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookingPaneMouseExited
        resetPanelColor(BookingPane);
    }//GEN-LAST:event_BookingPaneMouseExited

    private void SerchPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SerchPaneMouseClicked
        pnSerchEvent.setVisible(true);
        pnBooking.setVisible(false);
        pnProfile.setVisible(false);
        
        SerchPane.setBackground(new java.awt.Color(255,100,1));
    }//GEN-LAST:event_SerchPaneMouseClicked

    private void ProfilePaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfilePaneMouseClicked
        pnSerchEvent.setVisible(false);
        pnBooking.setVisible(false);
        pnProfile.setVisible(true);
        
        ProfilePane.setBackground(new java.awt.Color(255,100,1));
    }//GEN-LAST:event_ProfilePaneMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BookingPane;
    private javax.swing.JPanel DashBoard;
    private javax.swing.JPanel Events;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel ProfilePane;
    private javax.swing.JPanel SerchPane;
    private javax.swing.JPanel SideBar;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblBooking;
    private javax.swing.JLabel lblCalendar;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblOptions;
    private javax.swing.JLabel lblOptions1;
    private javax.swing.JLabel lblProfile;
    private javax.swing.JLabel lblSerch;
    private javax.swing.JLabel lblSerchEvent;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel pnBooking;
    private javax.swing.JPanel pnProfile;
    private javax.swing.JPanel pnSerchEvent;
    private javax.swing.JSeparator separator1;
    private javax.swing.JSeparator separator2;
    // End of variables declaration//GEN-END:variables

}
