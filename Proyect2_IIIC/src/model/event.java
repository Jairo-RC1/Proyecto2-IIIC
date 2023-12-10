
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author JRS
 */
public class event {

    private int id;
    private String name;
    private String description;
    private Date date;
    private String address;
    private int postalCode;
    private String city;
    private double price;
    private int room;
    private int placeId;
    private List <String> urlImages;
    private String calification;
    private String cantReviews;
    private String calificationUrlImages;
    private int locationId;

    public event(int id, String name, String description, Date date, String address, String city, int postalCode, double price, int room, int placeId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.price = price;
        this.room = room;
        this.placeId = placeId;
    }

    public event(String name, String description, Date date, String address, int postalCode, String city, double price, int room, int placeId) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.price = price;
        this.room = room;
        this.placeId = placeId;
    }   

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public event() {

    }

    public List<String> getUrlImages() {
        return urlImages;
    }

    public void setUrlImages(List<String> urlImages) {
        this.urlImages = urlImages;
    }

    public String getCalification() {
        return calification;
    }

    public void setCalification(String calification) {
        this.calification = calification;
    }

    public String getCantReviews() {
        return cantReviews;
    }

    public void setCantReviews(String cantReviews) {
        this.cantReviews = cantReviews;
    }

    public String getCalificationUrlImages() {
        return calificationUrlImages;
    }

    public void setCalificationUrlImages(String calificationUrlImages) {
        this.calificationUrlImages = calificationUrlImages;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
