/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.*;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ctrlUser {

    int id;
    userDAO dao = new userDAO();

    // Load data of entities into the JTable
    public void loadDataUsers(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<TableModel> order = new TableRowSorter<TableModel>(model);
        table.setRowSorter(order);
        model.setRowCount(0);
        List<user> users = dao.readUserTxt();
        for (user user : users) {
            Object[] row = {user.getId(), user.getIdNumber(), user.getName(), user.getLastName(), user.getBirthDate(),
                user.getEmail(), user.getPhoneNumber(), user.getPassword()};
            model.addRow(row);
        }
    }

    public void loadUserDataIntoFields(JTextField txtId, JTextField txtIdNumber, JTextField txtName, JTextField txtLastName,
            JTextField txtBirthDate, JTextField txtEmail, JTextField txtPhoneNumber, JTextField txtPassword,
            user currentUser) {

        // Verificar si el usuario actual no es nulo
        if (currentUser != null) {
            // Establecer la información del usuario en los campos de texto
            txtId.setText(String.valueOf(currentUser.getId()));
            txtIdNumber.setText(String.valueOf(currentUser.getIdNumber()));
            txtName.setText(currentUser.getName());
            txtLastName.setText(currentUser.getLastName());

            // Convertir la fecha de nacimiento a un formato legible
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String birthDateString = dateFormat.format(currentUser.getBirthDate());
            txtBirthDate.setText(birthDateString);

            txtEmail.setText(currentUser.getEmail());
            txtPhoneNumber.setText(String.valueOf(currentUser.getPhoneNumber()));
            txtPassword.setText(currentUser.getPassword());
        } else {
            // Si el usuario es nulo, podría manejar este caso según tus necesidades
            System.out.println("El usuario actual es nulo");
        }
    }

    public void addUser(JTextField idNumber, JTextField name, JTextField lastName, JTextField email, JTextField phoneNumber,
            JTextField birthDate, JTextField password) throws ParseException {
        validation validator = new validation();

        // Validates date to be "yyyy-MM-dd"
        String dateText = birthDate.getText();
        if (!validator.validateDate(dateText)) {
            JOptionPane.showMessageDialog(null, "Fecha no válida. Debe tener el formato aaaa-MM-dd.");
            return;
        }

        String idNumberText = idNumber.getText();
        if (!validator.validateID(idNumberText)) {
            JOptionPane.showMessageDialog(null, "Numero de cedula no válido. Debe seguir el formato correcto.");
            return;
        }

        // Validates name and address 
        String nameText = name.getText();
        if (!validator.validateABCWithSpaces(nameText)) {
            JOptionPane.showMessageDialog(null, "Nombre no válido. Deben contener solo letras de la A-Z y la Ñ.");
            return;
        }
        String lastNameText = lastName.getText();
        if (!validator.validateABCWithSpaces(lastNameText)) {
            JOptionPane.showMessageDialog(null, "Apellido no valido. Deben contener solo letras de la A-Z y la Ñ.");
            return;
        }

        // Validates email only email format
        String emailText = email.getText();
        if (!validator.validateMail(emailText)) {
            JOptionPane.showMessageDialog(null, "Correo electrónico no válido. Debe tener un formato válido.");
            return;
        }

        // Validates phoneNumber only numbers
        String phoneNumberText = phoneNumber.getText();
        if (!validator.validatePhone(phoneNumberText)) {
            JOptionPane.showMessageDialog(null, "Número de teléfono no válido. Debe contener solo números.");
            return;
        }
        String passwordText = password.getText();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date flowDate = dateFormat.parse(dateText);

            this.dao.createUser(new user(Integer.parseInt(idNumberText), nameText, lastNameText, flowDate, emailText, Integer.parseInt(phoneNumberText), passwordText));
            this.clearFields(name, idNumber, lastName, email, birthDate, phoneNumber, password);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error de formato en legal ID o número de teléfono.");
        }
    }

    public void updateUser(JTextField idNumber, JTextField name, JTextField lastName, JTextField email, JTextField phoneNumber, JTextField txtBirthDate, JTextField password) {
        validation validator = new validation();

        // Obtener los valores de los campos de texto
        String nameText = name.getText();
        String lastNameText = lastName.getText();
        String idNumberText = idNumber.getText();
        String emailText = email.getText();
        String phoneNumberText = phoneNumber.getText();
        String passwordText = password.getText();
        String birthDateText = txtBirthDate.getText();

        // Validaciones para idNumber, name, lastName, email, phoneNumber
        if (!validator.validateID(idNumberText)) {
            JOptionPane.showMessageDialog(null, "Número de cédula no válido. Debe seguir el formato correcto.");
            return; // Detiene el proceso si no es válido
        }

        if (!(validator.validateABCWithSpaces(nameText) && validator.validateABCWithSpaces(lastNameText))) {
            JOptionPane.showMessageDialog(null, "Nombre o Apellido no válido");
            return; // Detiene el proceso si no son válidos
        }

        if (!validator.validateMail(emailText)) {
            JOptionPane.showMessageDialog(null, "Correo electrónico no válido. Debe tener un formato válido.");
            return; // Detiene el proceso si no es válido
        }

        if (!validator.validatePhone(phoneNumberText)) {
            JOptionPane.showMessageDialog(null, "Número de teléfono no válido. Debe contener solo números.");
            return; // Detiene el proceso si no es válido
        }

        // Validar el formato de la fecha de nacimiento
        if (!validator.validateDate(birthDateText)) {
            JOptionPane.showMessageDialog(null, "Fecha de nacimiento no válida. Debe tener el formato aaaa-MM-dd.");
            return;
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date flowDate = dateFormat.parse(birthDateText);
            // Crear el objeto User con los datos validados
            user user = new user(this.id, Integer.parseInt(idNumberText), nameText, lastNameText, flowDate, emailText, Integer.parseInt(phoneNumberText), passwordText);

            // Llamar al método de actualización en el DAO
            dao.updateUser(user);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error de formato en algún campo");
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato de fecha.");
        }
    }

    
    public void deleteUser() {
        dao.deleteUser(this.id);
    }

    public void clearFields(JTextField name, JTextField idNumber, JTextField lastName, JTextField email, JTextField birthDate, JTextField phoneNumber, JTextField password) {
        name.setText("");
        idNumber.setText("");
        lastName.setText("");
        email.setText("");
        birthDate.setText("");
        phoneNumber.setText("");
        password.setText("");

    }

}
