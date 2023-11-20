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
    JTextField textField;
    JPasswordField passwordField;
    JTextField idNumberField;
    JTextField nameField;
    JTextField lastNameField;
    JTextField birthDateField;
    JTextField emailField;
    JTextField phoneNumberField;
    JComboBox<String> roleComboBox;

    public Register() {
        initialize();
    }

     private void initialize() {
        frame = new JFrame("Registro");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);

        int componentWidth = 240; // Sets the width for the txt
        int labelWidth = 150; // Sets width for labels
        int verticalGap = 40; // Set the same spaces between every space

        // Sets in the same position relative to y
        int yPosition = 30;

        //Space for cédula
        JLabel lblIdNumber = new JLabel("Número de cédula:");
        lblIdNumber.setBounds(68, yPosition, labelWidth, 16);
        frame.getContentPane().add(lblIdNumber);

        idNumberField = new JTextField();
        idNumberField.setBounds(68 + labelWidth, yPosition, componentWidth, 22);
        frame.getContentPane().add(idNumberField);
        idNumberField.setColumns(10);
        yPosition += verticalGap;

        // Space for name
        JLabel lblUsername = new JLabel("Nombre:");
        lblUsername.setBounds(68, yPosition, labelWidth, 16);
        frame.getContentPane().add(lblUsername);

        nameField = new JTextField();
        nameField.setBounds(68 + labelWidth, yPosition, componentWidth, 22);
        frame.getContentPane().add(nameField);
        nameField.setColumns(10);
        yPosition += verticalGap;

        // Space for lastName
        JLabel lblLastName = new JLabel("Apellido:");
        lblLastName.setBounds(68, yPosition, labelWidth, 16);
        frame.getContentPane().add(lblLastName);

        lastNameField = new JTextField();
        lastNameField.setBounds(68 + labelWidth, yPosition, componentWidth, 22);
        frame.getContentPane().add(lastNameField);
        lastNameField.setColumns(10);
        yPosition += verticalGap;

        // Space for birthDate
        JLabel lblBirthDate = new JLabel("Fecha de Nacimiento:");
        lblBirthDate.setBounds(68, yPosition, labelWidth, 16);
        frame.getContentPane().add(lblBirthDate);

        birthDateField = new JTextField();
        birthDateField.setBounds(68 + labelWidth, yPosition, componentWidth, 22);
        frame.getContentPane().add(birthDateField);
        birthDateField.setColumns(10);
        yPosition += verticalGap;

        // Space for mail
        JLabel lblEmail = new JLabel("Correo Electrónico:");
        lblEmail.setBounds(68, yPosition, labelWidth, 16);
        frame.getContentPane().add(lblEmail);

        emailField = new JTextField();
        emailField.setBounds(68 + labelWidth, yPosition, componentWidth, 22);
        frame.getContentPane().add(emailField);
        emailField.setColumns(10);
        yPosition += verticalGap;

        // Space for phoneNumber
        JLabel lblPhoneNumber = new JLabel("Número de Teléfono:");
        lblPhoneNumber.setBounds(68, yPosition, labelWidth, 16);
        frame.getContentPane().add(lblPhoneNumber);

        phoneNumberField = new JTextField();
        phoneNumberField.setBounds(68 + labelWidth, yPosition, componentWidth, 22);
        frame.getContentPane().add(phoneNumberField);
        phoneNumberField.setColumns(10);
        yPosition += verticalGap;

        // Space for password
        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(68, yPosition, labelWidth, 16);
        frame.getContentPane().add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(68 + labelWidth, yPosition, componentWidth, 22);
        frame.getContentPane().add(passwordField);
        yPosition += verticalGap;

        // Space for role
        JLabel lblRole = new JLabel("Rol:");
        lblRole.setBounds(68, yPosition, labelWidth, 16);
        frame.getContentPane().add(lblRole);

        String[] roles = {"Admin", "User"};
        roleComboBox = new JComboBox<>(roles);
        roleComboBox.setBounds(68 + labelWidth, yPosition, componentWidth, 22);
        frame.getContentPane().add(roleComboBox);
        yPosition += verticalGap;

        // Sets btn at the end of the screen
        JButton btnRegister = new JButton("Registrarse");
        btnRegister.setBounds(200, yPosition, 120, 30);
        frame.getContentPane().add(btnRegister);

        JButton btnBack = new JButton("Atrás");
        btnBack.setBounds(340, yPosition, 100, 30);
        frame.getContentPane().add(btnBack);

        // ActionListener for each btn
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = nameField.getText();
                String password = new String(passwordField.getPassword());
                String idNumber = idNumberField.getText();
                String name = nameField.getText();
                String lastName = lastNameField.getText();
                String birthDate = birthDateField.getText();
                String email = emailField.getText();
                String phoneNumber = phoneNumberField.getText();
                String role = (String) roleComboBox.getSelectedItem();

             
            }
        });
    }
}
