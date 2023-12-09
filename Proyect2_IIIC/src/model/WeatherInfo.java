/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jairo
 */
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

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
    }

    public int getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(int cloudiness) {
        this.cloudiness = cloudiness;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }
    

    

}
