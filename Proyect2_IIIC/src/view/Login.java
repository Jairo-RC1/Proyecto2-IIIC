/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author JRS
 */
public class Login {

    private JFrame frame;
    private JTextField textField;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Login() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Login");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(211, 82, 1));

        frame.getContentPane().setLayout(null);

        frame.getContentPane().setLayout(null);

        JLabel lblUsername = new JLabel("Usuario:");
        lblUsername.setBounds(68, 69, 86, 16);
        frame.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(68, 124, 86, 16);
        frame.getContentPane().add(lblPassword);

        textField = new JTextField();
        textField.setBounds(170, 66, 240, 22);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(170, 121, 240, 22);
        frame.getContentPane().add(passwordField);

        JButton btnLogin = new JButton("Iniciar sesión");
        btnLogin.setBounds(161, 174, btnLogin.getPreferredSize().width, btnLogin.getPreferredSize().height);
        frame.getContentPane().add(btnLogin);

        JButton btnCreateAccount = new JButton("Crear Usuario");
        btnCreateAccount.setBounds(272, 174, btnCreateAccount.getPreferredSize().width, btnCreateAccount.getPreferredSize().height);
        frame.getContentPane().add(btnCreateAccount);

        lblUsername.setPreferredSize(new Dimension(lblUsername.getPreferredSize().width, lblUsername.getPreferredSize().height));
        lblPassword.setPreferredSize(new Dimension(lblPassword.getPreferredSize().width, lblPassword.getPreferredSize().height));

        btnCreateAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Register register = new Register();
                register.frame.setVisible(true);
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Opens window mainView
                mainView mainView = new mainView();
                mainView.setVisible(true);
                // Close currrent window
                frame.dispose();
            }

        });
    }
}
