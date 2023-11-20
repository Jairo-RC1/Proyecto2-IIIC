/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author JRS
 */

    public class validation {

        public validation() {

        }

        public boolean validateABC(String valor) {
            Pattern pat = Pattern.compile("[a-zA-Z\\s]*");
            Matcher mat = pat.matcher(valor);
            return mat.matches();

        }

        public boolean validateNumbers(String valor) {
            Pattern pat = Pattern.compile("[0-9]*");
            Matcher mat = pat.matcher(valor);
            return mat.matches();
        }

        public boolean validateDecimals(String valor) {
            Pattern pat = Pattern.compile("[0-9.0-9]");
            Matcher mat = pat.matcher(valor);
            return mat.matches();
        }

        public boolean validateAlphaN(String valor) {

            Pattern pat = Pattern.compile("^[a-zA-Z0-9]*$");
            Matcher mat = pat.matcher(valor);
            return mat.matches();

        }

        public boolean validateCRID(String valor) {
            Pattern pat = Pattern.compile("^[0-9]{1}-[0-9]{4}-[0-9]{4}$");
            Matcher mat = pat.matcher(valor);
            return mat.matches();
        }
        public boolean validateNotEmpty(String valor) {
        return valor != null && !valor.isEmpty();
}
        public boolean validateEmail(String valor) {
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    Pattern pat = Pattern.compile(emailRegex);
    Matcher mat = pat.matcher(valor);
    return mat.matches();
}
        public boolean validatePasswordStrength(String password) {
    
    return password.matches("^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$");
}
    }

