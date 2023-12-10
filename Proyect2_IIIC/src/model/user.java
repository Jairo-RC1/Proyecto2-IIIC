package model;

import java.util.Date;

public class user {

    // Private attributes of the user class
    private int id;
    private int idNumber;
    private String name;
    private String lastName;
    private Date birthDate;
    private String email;
    private int phoneNumber;
    private String password;

    // Default constructor with no parameters
    public user() {

    }

    // Constructor with all attributes as parameters for initializing the user object
    public user(int id, int idNumber, String name, String lastName, Date birthDate, String email, int phoneNumber, String password) {
        this.id = id;
        this.idNumber = idNumber;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    // Constructor without the 'id' parameter for scenarios where the id is generated automatically
    public user(int idNumber, String name, String lastName, Date birthDate, String email, int phoneNumber, String password) {
        this.idNumber = idNumber;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;

    }

    // Getter method for retrieving the id attribute
    public int getId() {
        return id;
    }

    // Setter method for modifying the id attribute
    public void setId(int id) {
        this.id = id;
    }

    // Getter method for retrieving the idNumber attribute
    public int getIdNumber() {
        return idNumber;
    }

    // Setter method for modifying the idNumber attribute
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    // Getter method for retrieving the name attribute
    public String getName() {
        return name;
    }

    // Setter method for modifying the name attribute
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for retrieving the lastName attribute
    public String getLastName() {
        return lastName;
    }

    // Setter method for modifying the lastName attribute
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter method for retrieving the birthDate attribute
    public Date getBirthDate() {
        return birthDate;
    }

    // Setter method for modifying the birthDate attribute
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    // Getter method for retrieving the email attribute
    public String getEmail() {
        return email;
    }

    // Setter method for modifying the email attribute
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter method for retrieving the phoneNumber attribute
    public int getPhoneNumber() {
        return phoneNumber;
    }

    // Setter method for modifying the phoneNumber attribute
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Getter method for retrieving the password attribute
    public String getPassword() {
        return password;
    }

    // Setter method for modifying the password attribute
    public void setPassword(String password) {
        this.password = password;
    }
}
