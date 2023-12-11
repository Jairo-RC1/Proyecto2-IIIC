package model;

import java.util.Date;
import java.util.List;


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
    private List<String> urlImages;
    private String calification;
    private String cantReviews;
    private String calificationUrlImages;
    private int locationId;

    //Constructor for the Event class.
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

    //Constructs an Event object with the specified attributes.
    public event(String name, String description, Date date, String address, String city, int postalCode, double price, int room, int placeId) {
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

    // Getter method for retrieving the value of the 'city' variable.
    public String getCity() {
        return city;
    }

    // Setter method for updating the value of the 'city' variable.
    public void setCity(String city) {
        this.city = city;
    }

    //This class represents an Event and provides getters and setters for its attributes.
    public event() {

    }

    // Gets the list of URL images.
    public List<String> getUrlImages() {
        return urlImages;//return List<String> representing the URL images.
    }

    //Sets the list of URL images.
    public void setUrlImages(List<String> urlImages) {
        this.urlImages = urlImages;//param urlImages List<String> representing the URL images to be set.
    }

    //Gets the calification (presumably a rating or score)
    public String getCalification() {
        return calification; //return String representing the calification.
    }

    // Sets the calification (presumably a rating or score).
    public void setCalification(String calification) {
        this.calification = calification; //param calification String representing the calification to be set.
    }

    //Gets the number of reviews.
    public String getCantReviews() {
        return cantReviews;//return String representing the number of reviews.
    }

    //Sets the number of reviews for an entity. 
    public void setCantReviews(String cantReviews) {
        this.cantReviews = cantReviews;//param cantReviews The number of reviews to set.
    }

    // Retrieves the URL for the images related to the entity's rating.
    public String getCalificationUrlImages() {
        return calificationUrlImages;//return The URL for the images of the entity's rating.
    }

    // Sets the URL for the images related to the entity's rating.
    public void setCalificationUrlImages(String calificationUrlImages) {
        this.calificationUrlImages = calificationUrlImages; //param calificationUrlImages The URL for the images of the entity's rating to set.
    }

    //Retrieves the location ID associated with the entity.
    public int getLocationId() {
        return locationId;//return The location ID of the entity.
    }

    //Sets the location ID for the entity.
    public void setLocationId(int locationId) {
        this.locationId = locationId;//param locationId The location ID to set for the entity.
    }

    // This method returns the value of the 'id' attribute.
    public int getId() {
        return id;
    }

    // This method sets the value of the 'id' attribute to the provided parameter.
    public void setId(int id) {
        this.id = id;
    }

    // This method returns the value of the 'name' attribute.
    public String getName() {
        return name;
    }

    // This method sets the value of the 'name' attribute to the provided parameter.
    public void setName(String name) {
        this.name = name;
    }

    // This method returns the value of the 'description' attribute.
    public String getDescription() {
        return description;
    }

    // This method sets the value of the 'description' attribute to the provided parameter.
    public void setDescription(String description) {
        this.description = description;
    }

    // This method returns the value of the 'date' attribute.
    public Date getDate() {
        return date;
    }

    // This method sets the value of the 'date' attribute to the provided parameter.
    public void setDate(Date date) {
        this.date = date;
    }

    // Getter method for retrieving the address of the property.
    public String getAddress() {
        return address;
    }

    // Setter method for setting the address of the property.
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter method for retrieving the postal code of the property.
    public int getPostalCode() {
        return postalCode;
    }

    // Setter method for setting the postal code of the property.
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    // Getter method for retrieving the price of the property.
    public double getPrice() {
        return price;
    }

    // Setter method for setting the price of the property.
    public void setPrice(double price) {
        this.price = price;
    }

    // Getter method for retrieving the number of rooms in the property.
    public int getRoom() {
        return room;
    }

    // Setter method for setting the number of rooms in the property.
    public void setRoom(int room) {
        this.room = room;
    }

    // Getter method for retrieving the unique identifier of the place where the property is located.
    public int getPlaceId() {
        return placeId;
    }

    // Setter method for setting the unique identifier of the place where the property is located.
    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }
}
