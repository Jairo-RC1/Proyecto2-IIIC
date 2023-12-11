package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.*;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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

        // Check if the current user is not null
        if (currentUser != null) {
            // Set user information in text fields
            txtId.setText(String.valueOf(currentUser.getId()));
            txtIdNumber.setText(String.valueOf(currentUser.getIdNumber()));
            txtName.setText(currentUser.getName());
            txtLastName.setText(currentUser.getLastName());

            // Convert the date of birth to a readable format
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String birthDateString = dateFormat.format(currentUser.getBirthDate());
            txtBirthDate.setText(birthDateString);

            txtEmail.setText(currentUser.getEmail());
            txtPhoneNumber.setText(String.valueOf(currentUser.getPhoneNumber()));
            txtPassword.setText(currentUser.getPassword());
        } else {
            // If user is null, you could handle this case depending on your needs
            System.out.println("El usuario actual es nulo");
        }
    }

    public void addUser(JTextField idNumber, JTextField name, JTextField lastName, JTextField email, JTextField phoneNumber,
            JTextField birthDate, JTextField password, JComboBox<String> cbxRole) throws ParseException {
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

        // Attempt to execute the following code block
        try {
            // Create a SimpleDateFormat object with the pattern "yyyy-MM-dd"
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Parse the dateText using the dateFormat and store it in a Date object named flowDate
            Date flowDate = dateFormat.parse(dateText);

            // Get the selected item from a combo box named cbxRole and cast it to a String
            String roleName = (String) cbxRole.getSelectedItem();

            // Create an instance of the ctrlRol class
            ctrlRol ctrlRol = new ctrlRol();

            // Get the role ID by calling the getRoleIdByName2 method of ctrlRol with the roleName as a parameter
            int roleId = ctrlRol.getRoleIdByName2(roleName);

            // Create a new user object with the provided input data and the obtained role ID
            this.dao.createUser(new user(Integer.parseInt(idNumberText), nameText, lastNameText, flowDate, emailText, Integer.parseInt(phoneNumberText), passwordText, roleId));

            // Clear the input fields
            this.clearFields(name, idNumber, lastName, email, birthDate, phoneNumber, password);
        } catch (NumberFormatException ex) {
            // Handle an exception if there's a NumberFormatException
            JOptionPane.showMessageDialog(null, "Error de formato en legal ID o número de teléfono.");
        }

    }

    // Method to update a user in the system
    public void updateUser(user currentUser) {
        // Check if the provided user is valid
        if (validateUser(currentUser)) {
            // If the user is valid, update the user using the data access object (dao)
            dao.updateUser(currentUser);
        }
    }

    // Method to validate an object of type 'user'.
    // Receives as a parameter a 'user' object called 'currentUser'.
    private boolean validateUser(user currentUser) {
        String idNumberText = String.valueOf(currentUser.getIdNumber());
        String nameText = currentUser.getName();
        String lastNameText = currentUser.getLastName();
        String emailText = currentUser.getEmail();
        String phoneNumberText = String.valueOf(currentUser.getPhoneNumber());

        validation validator = new validation();

        // Check if the ID number is not valid using the validator object
        if (!validator.validateID(idNumberText)) {
            JOptionPane.showMessageDialog(null, "Número de cédula no válido. Debe seguir el formato correcto.");
            return false;
        }

        // The following code checks the validity of the 'nameText' and 'lastNameText' strings using a custom validation method called 'validateABCWithSpaces'.
        if (!(validator.validateABCWithSpaces(nameText) && validator.validateABCWithSpaces(lastNameText))) {
            JOptionPane.showMessageDialog(null, "Nombre o Apellido no válido");
            return false;
        }

        // Check if the email address does not pass the validation using the validateMail method.
        if (!validator.validateMail(emailText)) {
            JOptionPane.showMessageDialog(null, "Correo electrónico no válido. Debe tener un formato válido.");
            return false;
        }

        // The condition "!validator.validatePhone(phoneNumberText)" checks if the phone number fails the validation.
        if (!validator.validatePhone(phoneNumberText)) {
            JOptionPane.showMessageDialog(null, "Número de teléfono no válido. Debe contener solo números.");
            return false;
        }

        // Validar el formato de la fecha de nacimiento
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // Formatear la fecha de nacimiento a un texto en el formato deseado
            String birthDateText = dateFormat.format(currentUser.getBirthDate());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fecha de nacimiento no válida. Debe tener el formato aaaa-MM-dd.");
            return false; // Detiene el proceso si la fecha no es válida
        }

        return true;
    }

    // This method is a part of a class and is designed to delete a user.
    public void deleteUser() {
        dao.deleteUser(this.id);
    }

    // This method populates text fields with data from the selected row in a JTable.
    public void selectedRow(JTable table, JTextField IDNumber, JTextField name, JTextField lastName, JTextField birthDate, JTextField email, JTextField phoneNumber, JTextField password) {
        try {
            // Get the index of the selected row in the JTable.
            int row = table.getSelectedRow();
            // Check if a row is selected.
            if (row >= 0) {
                this.id = Integer.parseInt(table.getValueAt(row, 0).toString());
                IDNumber.setText(table.getValueAt(row, 1).toString());
                name.setText(table.getValueAt(row, 2).toString());
                lastName.setText(table.getValueAt(row, 3).toString());
                birthDate.setText(table.getValueAt(row, 4).toString());
                email.setText(table.getValueAt(row, 5).toString());
                phoneNumber.setText(table.getValueAt(row, 6).toString());
                password.setText(table.getValueAt(row, 7).toString());
            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección, error: " + e.toString());
        }
    }

    // This method clears the text content of the specified JTextField components.
    public void clearFields(JTextField name, JTextField idNumber, JTextField lastName, JTextField email, JTextField birthDate, JTextField phoneNumber, JTextField password) {
        name.setText("");
        idNumber.setText("");
        lastName.setText("");
        email.setText("");
        birthDate.setText("");
        phoneNumber.setText("");
        password.setText("");

    }

    // This method populates a JComboBox with user roles.
    // The method takes a JComboBox<String> as a parameter.
    public void loadRolesToUserComboBox(JComboBox<String> comboBox) {
        // Create an instance of the 'ctrlRol' class, which presumably handles role-related operations.
        ctrlRol ctrlRol = new ctrlRol();

        // Call the 'loadRolesToComboBox' method of the 'ctrlRol' instance,
        // passing the provided 'comboBox' as a parameter.
        ctrlRol.loadRolesToComboBox(comboBox);
    }

}
