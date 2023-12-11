package model;


import java.util.Date;


public class reservation {


    private int id;
    private String userName;
    private Date date;
    private int quantity;
    private int idEvent;


    public reservation(int id, String userName, Date date, int quantity, int idEvent) {
        this.id = id;
        this.userName = userName;
        this.date = date;
        this.quantity = quantity;
        this.idEvent = idEvent;
    }


    public reservation(String userName, Date date, int quantity, int idEvent) {
        this.userName = userName; 
        this.date = date;
        this.quantity = quantity; 
        this.idEvent = idEvent;
    }


    public reservation() {
    }

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
        return userName; 
    }

    // Sets the user name associated with the reservation.
    public void setUserName(String userName) {
        this.userName = userName;
    }

    //Gets the reservation date. 
    public Date getDate() {
        return date;
    }

    //Sets the reservation date. 
    public void setDate(Date date) {
        this.date = date;
    }

    // Gets the quantity of reservations.  
    public int getQuantity() {
        return quantity;
    }

    // Sets the quantity of reservations.
    public void setQuantity(int quantity) {
        this.quantity = quantity; 
    }

    //Gets the ID of the associated event. 
    public int getIdEvent() {
        return idEvent;
    }

    //Sets the ID of the associated event.
    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }
}
