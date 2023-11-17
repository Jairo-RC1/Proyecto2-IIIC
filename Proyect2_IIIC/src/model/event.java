
package model;

import java.util.Date;

/**
 *
 * @author JRS
 */
public class event {

    private int id;
    private String name;
    private String description;
    private Date utilDate;
    private String address;
    private int postalCode;
    private double price;
    private int room;
    private int placeId;

    public event(int id, String name, String description, Date utilDate, String address, int postalCode, double price, int room, int placeId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.utilDate = utilDate;
        this.address = address;
        this.postalCode = postalCode;
        this.price = price;
        this.room = room;
        this.placeId = placeId;
    }

    public event(String name, String description, Date utilDate, String address, int postalCode, double price, int room, int placeId) {
        this.name = name;
        this.description = description;
        this.utilDate = utilDate;
        this.address = address;
        this.postalCode = postalCode;
        this.price = price;
        this.room = room;
        this.placeId = placeId;
    }

    public event() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUtilDate() {
        return utilDate;
    }

    public void setUtilDate(Date utilDate) {
        this.utilDate = utilDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    
}
