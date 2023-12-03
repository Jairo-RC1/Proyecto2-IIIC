package view;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author JRS
 */
public class register extends javax.swing.JFrame {

    /**
     * Creates new form register
     */
    public register() {
        initComponents();
        FlatIntelliJLaf.setup();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPaneMain = new javax.swing.JPanel();
        txtBirthDate = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        txtIdNumber = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        btnRegis = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();
        lblBirthDate = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblIdNumber = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPaneMain.setBackground(new java.awt.Color(39, 71, 96));
        jPaneMain.setPreferredSize(new java.awt.Dimension(671, 449));
        jPaneMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBirthDate.setBackground(new java.awt.Color(255, 255, 255));
        txtBirthDate.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtBirthDate.setForeground(new java.awt.Color(0, 0, 0));
        txtBirthDate.setText("Fecha de nacimiento");
        txtBirthDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtBirthDateMousePressed(evt);
            }
        });
        jPaneMain.add(txtBirthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 210, 40));

        txtPhoneNumber.setBackground(new java.awt.Color(255, 255, 255));
        txtPhoneNumber.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtPhoneNumber.setForeground(new java.awt.Color(0, 0, 0));
        txtPhoneNumber.setText("Telefono");
        txtPhoneNumber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPhoneNumberMousePressed(evt);
            }
        });
        txtPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneNumberActionPerformed(evt);
            }
        });
        jPaneMain.add(txtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 210, 40));

        txtEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtEmail.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(0, 0, 0));
        txtEmail.setText("Correo electronico");
        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtEmailMousePressed(evt);
            }
        });
        jPaneMain.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 210, 40));

        txtPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtPassword.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(0, 0, 0));
        txtPassword.setText("Contraseña");
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPasswordMousePressed(evt);
            }
        });
        jPaneMain.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 180, 40));

        txtIdNumber.setBackground(new java.awt.Color(255, 255, 255));
        txtIdNumber.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtIdNumber.setForeground(new java.awt.Color(0, 0, 0));
        txtIdNumber.setText("Cedula");
        txtIdNumber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtIdNumberMousePressed(evt);
            }
        });
        jPaneMain.add(txtIdNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 180, 40));

        txtName.setBackground(new java.awt.Color(255, 255, 255));
        txtName.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtName.setForeground(new java.awt.Color(0, 0, 0));
        txtName.setText("Nombre");
        txtName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNameMousePressed(evt);
            }
        });
        jPaneMain.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 180, 40));

        txtLastName.setBackground(new java.awt.Color(255, 255, 255));
        txtLastName.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtLastName.setForeground(new java.awt.Color(0, 0, 0));
        txtLastName.setText("Apellido");
        txtLastName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtLastNameMousePressed(evt);
            }
        });
        jPaneMain.add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 180, 40));

        btnRegis.setBackground(new java.awt.Color(255, 255, 255));
        btnRegis.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnRegis.setForeground(new java.awt.Color(0, 0, 0));
        btnRegis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegis.setText("Registrar");
        btnRegis.setOpaque(true);
        btnRegis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegisMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegisMouseExited(evt);
            }
        });
        jPaneMain.add(btnRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 150, 40));

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/exit.png"))); // NOI18N
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });
        jPaneMain.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 48, 48));

        lblBirthDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/calendar.png"))); // NOI18N
        jPaneMain.add(lblBirthDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 40, 40));

        lblPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/password.png"))); // NOI18N
        jPaneMain.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 40, 40));

        lblPhoneNumber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/phone.png"))); // NOI18N
        jPaneMain.add(lblPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 40, 40));

        lblEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/email.png"))); // NOI18N
        jPaneMain.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 40, 40));

        lblIdNumber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/cedula.png"))); // NOI18N
        jPaneMain.add(lblIdNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 40, 40));

        lblLastName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/user.png"))); // NOI18N
        jPaneMain.add(lblLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 40, 40));

        lblName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/user2.png"))); // NOI18N
        jPaneMain.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 40));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/logoAzulOscuro.jpeg"))); // NOI18N
        jPaneMain.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 100, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPaneMain, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPaneMain, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelColor(JLabel label) {
        label.setBackground(new java.awt.Color(163,226,243));
    }

    private void resetLabelColor(JLabel label) {
        label.setBackground(new java.awt.Color(255,255,255));
    }
    private void txtPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneNumberActionPerformed

    }//GEN-LAST:event_txtPhoneNumberActionPerformed

    private void txtNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNameMousePressed
        if (txtName.getText().equals("Nombre")) {
            txtName.setText("");
            txtName.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtLastName.getText()).isEmpty()) {
            txtLastName.setText("Apellido");
            txtLastName.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtIdNumber.getText()).isEmpty()){
            txtIdNumber.setText("Cedula");
            txtIdNumber.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtEmail.getText()).isEmpty()){
            txtEmail.setText("Correo electronico");
            txtEmail.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtPhoneNumber.getText()).isEmpty()){
            txtPhoneNumber.setText("Telefono");
            txtPhoneNumber.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtBirthDate.getText()).isEmpty()) {
            txtBirthDate.setText("Fecha de nacimiento");
            txtBirthDate.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtPassword.getText()).isEmpty()){
            txtPassword.setText("Contraseña");
            txtPassword.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtNameMousePressed

    private void txtLastNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLastNameMousePressed
        if (txtLastName.getText().equals("Apellido")) {
            txtLastName.setText("");
            txtLastName.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtName.getText()).isEmpty()) {
            txtName.setText("Nombre");
            txtName.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtIdNumber.getText()).isEmpty()) {
            txtIdNumber.setText("Cedula");
            txtIdNumber.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtEmail.getText()).isEmpty()){
            txtEmail.setText("Correo electronico");
            txtEmail.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtPhoneNumber.getText()).isEmpty()) {
            txtPhoneNumber.setText("Telefono");
            txtPhoneNumber.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtBirthDate.getText()).isEmpty()) {
            txtBirthDate.setText("Fecha de nacimiento");
            txtBirthDate.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtPassword.getText()).isEmpty()) {
            txtPassword.setText("Contraseña");
            txtPassword.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtLastNameMousePressed

    private void txtIdNumberMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdNumberMousePressed
        if (txtIdNumber.getText().equals("Cedula")) {
            txtIdNumber.setText("");
            txtIdNumber.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtName.getText()).isEmpty()) {
            txtName.setText("Nombre");
            txtName.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtLastName.getText()).isEmpty()) {
            txtLastName.setText("Apellido");
            txtLastName.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtEmail.getText()).isEmpty()) {
            txtEmail.setText("Correo electronico");
            txtEmail.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtPhoneNumber.getText()).isEmpty()){
            txtPhoneNumber.setText("Telefono");
            txtPhoneNumber.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtBirthDate.getText()).isEmpty()) {
            txtBirthDate.setText("Fecha de nacimiento");
            txtBirthDate.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtPassword.getText()).isEmpty()){
            txtPassword.setText("Contraseña");
            txtPassword.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtIdNumberMousePressed

    private void txtEmailMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMousePressed
        if (txtEmail.getText().equals("Correo electronico")) {
            txtEmail.setText("");
            txtEmail.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtName.getText()).isEmpty()) {
            txtName.setText("Nombre");
            txtName.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtLastName.getText()).isEmpty()) {
            txtLastName.setText("Apellido");
            txtLastName.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtIdNumber.getText()).isEmpty()) {
            txtIdNumber.setText("Cedula");
            txtIdNumber.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtPhoneNumber.getText()).isEmpty()) {
            txtPhoneNumber.setText("Telefono");
            txtPhoneNumber.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtBirthDate.getText()).isEmpty()) {
            txtBirthDate.setText("Fecha de nacimiento");
            txtBirthDate.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtPassword.getText()).isEmpty()){
            txtPassword.setText("Contraseña");
            txtPassword.setForeground(Color.BLACK);
        }
        
    }//GEN-LAST:event_txtEmailMousePressed

    private void txtPhoneNumberMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPhoneNumberMousePressed
        if (txtPhoneNumber.getText().equals("Telefono")) {
            txtPhoneNumber.setText("");
            txtPhoneNumber.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtName.getText()).isEmpty()) {
            txtName.setText("Nombre");
            txtName.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtLastName.getText()).isEmpty()) {
            txtLastName.setText("Apellido");
            txtLastName.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtIdNumber.getText()).isEmpty()) {
            txtIdNumber.setText("Cedula");
            txtIdNumber.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtEmail.getText()).isEmpty()) {
            txtEmail.setText("Correo electronico");
            txtEmail.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtBirthDate.getText()).isEmpty()) {
            txtBirthDate.setText("Fecha de nacimiento");
            txtBirthDate.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtPassword.getText()).isEmpty()) {
            txtPassword.setText("Contraseña");
            txtPassword.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtPhoneNumberMousePressed

    private void txtBirthDateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBirthDateMousePressed
        if (txtBirthDate.getText().equals("Fecha de nacimiento")) {
            txtBirthDate.setText("");
            txtBirthDate.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtName.getText()).isEmpty()) {
            txtName.setText("Nombre");
            txtName.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtLastName.getText()).isEmpty()) {
            txtLastName.setText("Apellido");
            txtLastName.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtIdNumber.getText()).isEmpty()) {
            txtIdNumber.setText("Cedula");
            txtIdNumber.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtEmail.getText()).isEmpty()) {
            txtEmail.setText("Correo electronico");
            txtEmail.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtPhoneNumber.getText()).isEmpty()) {
            txtPhoneNumber.setText("Telefono");
            txtPhoneNumber.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtPassword.getText()).isEmpty()) {
            txtPassword.setText("Contraseña");
            txtPassword.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtBirthDateMousePressed

    private void txtPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMousePressed
        if (String.valueOf(txtPassword.getText()).equals("Contraseña")) {
            txtPassword.setText("");
            txtPassword.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtName.getText()).isEmpty()) {
            txtName.setText("Nombre");
            txtName.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtLastName.getText()).isEmpty()) {
            txtLastName.setText("Apellido");
            txtLastName.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtIdNumber.getText()).isEmpty()) {
            txtIdNumber.setText("Cedula");
            txtIdNumber.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtEmail.getText()).isEmpty()) {
            txtEmail.setText("Correo electronico");
            txtEmail.setForeground(Color.BLACK);
        }
        if (String.valueOf(txtPhoneNumber.getText()).isEmpty()) {
            txtPhoneNumber.setText("Telefono");
            txtPhoneNumber.setForeground(Color.BLACK);
        }
        if (txtBirthDate.getText().isEmpty()) {
            txtBirthDate.setText("Fecha de nacimiento");
            txtBirthDate.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtPasswordMousePressed

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        dispose();
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
       labelColor(btnExit);
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnRegisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisMouseEntered
         labelColor(btnRegis);
    }//GEN-LAST:event_btnRegisMouseEntered

    private void btnRegisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisMouseExited
       resetLabelColor(btnRegis);
    }//GEN-LAST:event_btnRegisMouseExited

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        resetLabelColor(btnExit);
    }//GEN-LAST:event_btnExitMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnExit;
    private javax.swing.JLabel btnRegis;
    private javax.swing.JPanel jPaneMain;
    private javax.swing.JLabel lblBirthDate;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblIdNumber;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JTextField txtBirthDate;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIdNumber;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
