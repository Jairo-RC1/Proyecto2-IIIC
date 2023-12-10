package model;

// Importing the Date class from the java.util package
import java.util.Date;

//** @author jefry
public class reservation {

    // Private fields to store reservation details
    private int id;
    private String userName;
    private Date date;
    private int quantity;
    private int idEvent;

    // constructor 
    public reservation(int id, String userName, Date date, int quantity, int idEvent) {
        this.id = id;//The reservation ID.
        this.userName = userName;//The user name associated with the reservation.
        this.date = date;//The reservation date.
        this.quantity = quantity;//The quantity of reservations.
        this.idEvent = idEvent;// The ID of the associated event.
    }

    //constructor to initialize a reservation without an ID.
    public reservation(String userName, Date date, int quantity, int idEvent) {
        this.userName = userName; //The user name associated with the reservation.
        this.date = date;//The reservation date.
        this.quantity = quantity; //The quantity of reservations.
        this.idEvent = idEvent;//The ID of the associated event.
    }

    // Default constructor with no parameters.
    public reservation() {
    }

    // Getter and setter methods for each field
    
    // Gets the reservation ID.
    public int getId() {
        return id; //return The reservation ID.
    }

    //Sets the reservation ID.
    public void setId(int id) {
        this.id = id; //The reservation ID to set.
    }

    //Gets the user name associated with the reservation.
    public String getUserName() {
        return userName;  //return The user name.
    }

    // Sets the user name associated with the reservation.
    public void setUserName(String userName) {
        this.userName = userName;//The user name to set.
    }

    //Gets the reservation date. 
    public Date getDate() {
        return date;//return The reservation date.
    }

    //Sets the reservation date. 
    public void setDate(Date date) {
        this.date = date;// The reservation date to set.
    }

    // Gets the quantity of reservations.  
    public int getQuantity() {
        return quantity;// return The quantity of reservations.
    }

    // Sets the quantity of reservations.
    public void setQuantity(int quantity) {
        this.quantity = quantity; //param quantity The quantity to set.
    }

    //Gets the ID of the associated event. 
    public int getIdEvent() {
        return idEvent;//return The ID of the associated event.
    }

    //Sets the ID of the associated event.
    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;//param idEvent The ID of the associated event to set.
    }
}
