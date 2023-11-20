/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author JRS
 */


public class Register {
    JFrame frame;

    public Register() {
        initialize();
    }

  private void initialize() {
        frame = new JFrame("Registro");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);

        frame.getContentPane().setLayout(null);

        JLabel lblUsername = new JLabel("Usuario:");
        lblUsername.setBounds(68, 69, 86, 16);
        frame.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(68, 124, 86, 16);
        frame.getContentPane().add(lblPassword);

        JTextField textField = new JTextField();
        textField.setBounds(170, 66, 240, 22);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(170, 121, 240, 22);
        frame.getContentPane().add(passwordField);

        JButton btnRegister = new JButton("Registrarse");
        btnRegister.setBounds(161, 174, btnRegister.getPreferredSize().width, btnRegister.getPreferredSize().height);
        frame.getContentPane().add(btnRegister);

        JButton btnBack = new JButton("Atrás");
        btnBack.setBounds(272, 174, btnBack.getPreferredSize().width, btnBack.getPreferredSize().height);
        frame.getContentPane().add(btnBack);

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
    }
}
