
package model;

/**
 *
 * @author jefry
 */
public class place {
    private int id;
    private int postalCode;
    private  String name;
    private String address;
    private String city;
    private String latitude;
    private String longitude;
    private String tripAdvisorLink;

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

    public place(int postalCode, String name, String address, String city, String latitude, String longitude, String tripAdvisorLink) {
        this.postalCode = postalCode;
        this.name = name;
        this.address = address;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tripAdvisorLink = tripAdvisorLink;
    }

    public place() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTripAdvisorLink() {
        return tripAdvisorLink;
    }

    public void setTripAdvisorLink(String tripAdvisorLink) {
        this.tripAdvisorLink = tripAdvisorLink;
    }
    
    
}
