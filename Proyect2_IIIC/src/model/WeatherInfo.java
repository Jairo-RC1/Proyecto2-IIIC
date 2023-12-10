package model;

/**
 *
 * @author jairo
 */
// WeatherInfo class represents information about weather conditions at a specific location.
public class WeatherInfo {

    // Private fields to store various weather-related data.
    private String locationName;        // Name of the location
    private double latitude;            // Latitude of the location
    private double longitude;           // Longitude of the location
    private String weatherDescription;  // Description of the weather conditions
    private String temperature;         // Temperature at the location
    private String humidity;            // Humidity level at the location
    private String feelsLike;           // "Feels like" temperature
    private int cloudiness;             // Cloudiness percentage
    private String windSpeed;           // Wind speed at the location

    public WeatherInfo(String locationName, double latitude, double longitude, String weatherDescription, String temperature, String humidity, String feelsLike, int cloudiness, String windSpeed) {

        // Assigning the provided values to the corresponding attributes of the WeatherInfo object.
        this.locationName = locationName; // String representing the name of the location.
        this.latitude = latitude;//Double representing the latitude of the location.
        this.longitude = longitude;//Double representing the longitude of the location.
        this.weatherDescription = weatherDescription;//String describing the current weather conditions.
        this.temperature = temperature;//String representing the temperature at the location.
        this.humidity = humidity;//String representing the humidity level at the location.
        this.feelsLike = feelsLike;//String representing the perceived temperature at the location.
        this.cloudiness = cloudiness;//Integer representing the cloudiness percentage at the location.
        this.windSpeed = windSpeed;//String representing the wind speed at the location.
    }

    // Default constructor for WeatherInfo class.
    public WeatherInfo() {
    }

    // Getter and setter methods for locationName field.
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    // Getter and setter methods for latitude field.
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    // Getter and setter methods for longitude field.
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    // Getter and setter methods for weatherDescription field.
    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    // Getter and setter methods for temperature field.
    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    // Getter and setter methods for humidity field.
    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    // Getter and setter methods for feelsLike field.
    public String getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
    }

    // Getter and setter methods for cloudiness field.
    public int getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(int cloudiness) {
        this.cloudiness = cloudiness;
    }

    // Getter and setter methods for windSpeed field.
    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }
}
