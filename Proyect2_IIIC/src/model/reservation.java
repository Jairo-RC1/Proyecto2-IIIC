
package model;

import java.util.Date;

/**
 *
 * @author jefry
 */
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }
    
    
}
