package model;

/**
 *
 * @author jefry
 */
public class place {
    // Private instance variables to store information about the place.

    private int id;                 // Unique identifier for the place.
    private int postalCode;         // Postal code of the place.
    private String name;            // Name of the place.
    private String address;         // Address of the place.
    private String city;            // City where the place is located.
    private String latitude;        // Latitude coordinates of the place.
    private String longitude;       // Longitude coordinates of the place.
    private String tripAdvisorLink; // Link to the TripAdvisor page for the place.

    // Constructor for the 'place' class
    public place(int id, int postalCode, String name, String address, String city, String latitude, String longitude, String tripAdvisorLink) {
        this.id = id;
        this.postalCode = postalCode;
        this.name = name;
        this.address = address;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tripAdvisorLink = tripAdvisorLink;
    }

    // Constructor for the 'place' class
    public place(int postalCode, String name, String address, String city, String latitude, String longitude, String tripAdvisorLink) {
        // Initializing instance variables with the values passed as arguments
        this.postalCode = postalCode;
        this.name = name;
        this.address = address;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tripAdvisorLink = tripAdvisorLink;
    }

    // Default constructor
    public place() {
    }

    // Getter method for retrieving the ID of the place.
    public int getId() {
        return id;
    }

    // Setter method for setting the ID of the place.
    public void setId(int id) {
        this.id = id;
    }

    // Getter method for retrieving the postal code of the place.
    public int getPostalCode() {
        return postalCode;
    }

    // Setter method for setting the postal code of the place.
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    // Getter method for retrieving the name of the place.
    public String getName() {
        return name;
    }

    // Setter method for setting the name of the place.
    public void setName(String name) {
        this.name = name;
    }

    // Getter method for retrieving the address of the place.
    public String getAddress() {
        return address;
    }

    // Setter method for setting the address of the place.
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter method for retrieving the city of the place.
    public String getCity() {
        return city;
    }

    // Setter method for setting the city of the place.
    public void setCity(String city) {
        this.city = city;
    }

    // Getter method for retrieving the latitude of the place.
    public String getLatitude() {
        return latitude;
    }

    // Setter method for setting the latitude of the place.
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    // Getter method for retrieving the longitude of the place.
    public String getLongitude() {
        return longitude;
    }

    // Setter method for setting the longitude of the place.
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    // Getter method for retrieving the TripAdvisor link of the place.
    public String getTripAdvisorLink() {
        return tripAdvisorLink;
    }

    // Setter method for setting the TripAdvisor link of the place.
    public void setTripAdvisorLink(String tripAdvisorLink) {
        this.tripAdvisorLink = tripAdvisorLink;
    }
}
