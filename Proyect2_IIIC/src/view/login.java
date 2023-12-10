package view;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.loginDAO;
import model.*;

public class login extends javax.swing.JFrame {

    private user currentUser;
    private boolean imagen1 = true;

    public login() {
        initComponents();
        FlatIntelliJLaf.setup();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public void clear() {
        this.txtUser.setText("");
        this.Password.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPane = new javax.swing.JPanel();
        btnRegis = new javax.swing.JLabel();
        lblClosePassword = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        btnEnter = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        lblser = new javax.swing.JLabel();
        btnEnterMain = new javax.swing.JLabel();
        lblRegis = new javax.swing.JLabel();
        lblBackGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginPane.setBackground(new java.awt.Color(255, 255, 255));
        loginPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegis.setBackground(new java.awt.Color(255, 255, 255));
        btnRegis.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnRegis.setForeground(new java.awt.Color(0, 0, 0));
        btnRegis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegis.setText("Registrar");
        btnRegis.setOpaque(true);
        btnRegis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegisMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegisMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegisMouseExited(evt);
            }
        });
        loginPane.add(btnRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 170, 50));

        lblClosePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/eyeloked.png"))); // NOI18N
        lblClosePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblClosePasswordMouseClicked(evt);
            }
        });
        loginPane.add(lblClosePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 40, 40));

        Password.setBackground(new java.awt.Color(255, 255, 255));
        Password.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Password.setForeground(new java.awt.Color(0, 0, 0));
        Password.setText("********");
        Password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PasswordMousePressed(evt);
            }
        });
        loginPane.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 320, 40));

        btnEnter.setBackground(new java.awt.Color(0, 0, 0));
        loginPane.add(btnEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 90, 40));

        txtUser.setBackground(new java.awt.Color(255, 255, 255));
        txtUser.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtUser.setForeground(new java.awt.Color(0, 0, 0));
        txtUser.setText("Ingrese su nombre de usuario");
        txtUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUserMousePressed(evt);
            }
        });
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        loginPane.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 320, 40));

        lblser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/user.png"))); // NOI18N
        loginPane.add(lblser, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 50, 40));

        btnEnterMain.setBackground(new java.awt.Color(255, 255, 255));
        btnEnterMain.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnEnterMain.setForeground(new java.awt.Color(0, 0, 0));
        btnEnterMain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEnterMain.setText("Entrar");
        btnEnterMain.setOpaque(true);
        btnEnterMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnterMainMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnterMainMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEnterMainMouseExited(evt);
            }
        });
        loginPane.add(btnEnterMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 170, 50));

        lblRegis.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        lblRegis.setForeground(new java.awt.Color(255, 255, 255));
        lblRegis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegis.setText("¿No te has registrado?");
        loginPane.add(lblRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 250, -1));

        lblBackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/LoginTreeTravel.jpg"))); // NOI18N
        loginPane.add(lblBackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelColor(JLabel label) {
        label.setBackground(new java.awt.Color(163, 226, 243));
    }

    private void resetLabelColor(JLabel label) {
        label.setBackground(new java.awt.Color(255, 255, 255));
    }

    private void lblClosePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClosePasswordMouseClicked
        changeImage();
        togglePasswordVisibility();
    }//GEN-LAST:event_lblClosePasswordMouseClicked

    private void PasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PasswordMousePressed
        if (String.valueOf(Password.getPassword()).equals("********")) {
            Password.setText("");
            Password.setForeground(Color.BLACK);
        }
        if (txtUser.getText().isEmpty()) {
            txtUser.setText("Ingrese su nombre de usuario");
            txtUser.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_PasswordMousePressed

    private void txtUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserMousePressed
        if (txtUser.getText().equals("Ingrese su nombre de usuario")) {
            txtUser.setText("");
            txtUser.setForeground(Color.BLACK);
        }
        if (String.valueOf(Password.getPassword()).isEmpty()) {
            Password.setText("********");
            Password.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtUserMousePressed

    private void btnEnterMainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnterMainMouseEntered
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        labelColor(btnEnterMain);
    }//GEN-LAST:event_btnEnterMainMouseEntered

    private void btnEnterMainMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnterMainMouseExited
        setCursor(Cursor.getDefaultCursor());
        resetLabelColor(btnEnterMain);
    }//GEN-LAST:event_btnEnterMainMouseExited

    private void btnEnterMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnterMainMouseClicked
        String email = txtUser.getText();
        String password = new String(Password.getPassword());

        loginDAO login = new loginDAO();
        currentUser = login.authenticateUser(email, password);

        if (currentUser != null) {
            view.mainView MainView = new view.mainView();
            MainView.setUserData(currentUser); 
            MainView.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas. Por favor, inténtelo de nuevo.", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEnterMainMouseClicked

    private void btnRegisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisMouseClicked
        view.register regis = new register();
        regis.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegisMouseClicked

    private void btnRegisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisMouseEntered
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        labelColor(btnRegis);
    }//GEN-LAST:event_btnRegisMouseEntered

    private void btnRegisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisMouseExited
        setCursor(Cursor.getDefaultCursor());
        resetLabelColor(btnRegis);
    }//GEN-LAST:event_btnRegisMouseExited

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void changeImage() {
        if (imagen1) {
            lblClosePassword.setIcon(new ImageIcon(getClass().getResource("/view/images/eye.png")));
        } else {
            lblClosePassword.setIcon(new ImageIcon(getClass().getResource("/view/images/eyeloked.png")));
        }
        imagen1 = !imagen1;
    }

    private void togglePasswordVisibility() {
        char echoChar = Password.getEchoChar();
        Password.setEchoChar(echoChar == 0 ? '*' : (char) 0);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Password;
    private javax.swing.JLabel btnEnter;
    private javax.swing.JLabel btnEnterMain;
    private javax.swing.JLabel btnRegis;
    private javax.swing.JLabel lblBackGround;
    private javax.swing.JLabel lblClosePassword;
    private javax.swing.JLabel lblRegis;
    private javax.swing.JLabel lblser;
    private javax.swing.JPanel loginPane;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
