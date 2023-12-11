package model;


public class WeatherInfo {


    private String locationName;        
    private double latitude;            
    private double longitude;           
    private String weatherDescription;  
    private String temperature;         
    private String humidity;            
    private String feelsLike;           
    private int cloudiness;             
    private String windSpeed;           

    public WeatherInfo(String locationName, double latitude, double longitude, String weatherDescription, String temperature, String humidity, String feelsLike, int cloudiness, String windSpeed) {

        this.locationName = locationName; 
        this.latitude = latitude;
        this.longitude = longitude;
        this.weatherDescription = weatherDescription;
        this.temperature = temperature;
        this.humidity = humidity;
        this.feelsLike = feelsLike;
        this.cloudiness = cloudiness;
        this.windSpeed = windSpeed;
    }


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
