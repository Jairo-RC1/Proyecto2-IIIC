package view;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author jefry
 */
public class login extends javax.swing.JFrame {

    private boolean imagen1 = true;

    public login() {
        initComponents();
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
        lblTitle = new javax.swing.JLabel();
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
        btnRegis.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnRegis.setOpaque(true);
        loginPane.add(btnRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 170, 50));

        lblClosePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/eyeloked.png"))); // NOI18N
        lblClosePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblClosePasswordMouseClicked(evt);
            }
        });
        loginPane.add(lblClosePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 40, 40));

        Password.setBackground(new java.awt.Color(255, 255, 255));
        Password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PasswordMousePressed(evt);
            }
        });
        loginPane.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 320, 40));

        btnEnter.setBackground(new java.awt.Color(0, 0, 0));
        loginPane.add(btnEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 90, 40));

        txtUser.setBackground(new java.awt.Color(255, 255, 255));
        txtUser.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtUser.setForeground(new java.awt.Color(0, 0, 0));
        txtUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUserMousePressed(evt);
            }
        });
        loginPane.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 320, 40));

        lblser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/user.png"))); // NOI18N
        loginPane.add(lblser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 50, 40));

        lblTitle.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 0));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("TREE TRAVEL");
        loginPane.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 520, 50));

        btnEnterMain.setBackground(new java.awt.Color(255, 255, 255));
        btnEnterMain.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnEnterMain.setForeground(new java.awt.Color(0, 0, 0));
        btnEnterMain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEnterMain.setText("Entrar");
        btnEnterMain.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnEnterMain.setOpaque(true);
        loginPane.add(btnEnterMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 170, 50));

        lblRegis.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lblRegis.setForeground(new java.awt.Color(0, 0, 0));
        lblRegis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegis.setText("¿No te has registrado?");
        loginPane.add(lblRegis, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 320, -1));

        lblBackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/TreeTravel2.jpeg"))); // NOI18N
        loginPane.add(lblBackGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblser;
    private javax.swing.JPanel loginPane;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
