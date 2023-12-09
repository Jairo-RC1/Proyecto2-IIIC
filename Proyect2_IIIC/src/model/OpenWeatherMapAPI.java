/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.swing.JOptionPane;

/**
 *
 * @author jairo
 */
public class OpenWeatherMapAPI {

    private static final String API_KEY = "a0bec00bf2974cc0103b4794547b5f02";
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=";

    public static JSONObject callWeatherAPI(String location) {
        try {
            URL url = new URL(API_URL + location + "&appid=" + API_KEY);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            return new JSONObject(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static WeatherInfo parseWeatherJSON(String json, String locationName) {
        JSONObject obj = new JSONObject(json);

        double longitude = obj.getJSONObject("coord").getDouble("lon");
        double latitude = obj.getJSONObject("coord").getDouble("lat");
        String weather = obj.getJSONArray("weather").getJSONObject(0).getString("description");
        int clouds = obj.getJSONObject("clouds").getInt("all");
        double tempKelvin = obj.getJSONObject("main").getDouble("temp");
        double tempCelsius = tempKelvin - 273.15;
        double feelsLikeKelvin = obj.getJSONObject("main").getDouble("feels_like");
        double feelsLikeCelsius = feelsLikeKelvin - 273.15; // Convertir de Kelvin a Celsius
        int humidity = obj.getJSONObject("main").getInt("humidity");
        double windSpeed = obj.getJSONObject("wind").getDouble("speed");

        WeatherInfo weatherInfo = new WeatherInfo();
        weatherInfo.setLocationName(locationName);
        weatherInfo.setLongitude(longitude);
        weatherInfo.setLatitude(latitude);
        weatherInfo.setWeatherDescription(weather);
        weatherInfo.setCloudiness(clouds);
        weatherInfo.setTemperature(String.format("%.2f", tempCelsius)); // Redondear la temperatura a 2 decimales
        weatherInfo.setFeelsLike(String.format("%.2f", feelsLikeCelsius)); // Redondear la sensación térmica a 2 decimales
        weatherInfo.setHumidity(Integer.toString(humidity));
        weatherInfo.setWindSpeed(Double.toString(windSpeed));

        return weatherInfo;
    }

    public static void displayWeatherInfo(WeatherInfo weatherInfo) {
        String message = "Ubicación: " + weatherInfo.getLocationName() + "\n"
                + "Latitud: " + weatherInfo.getLatitude() + "\n"
                + "Longitud: " + weatherInfo.getLongitude() + "\n"
                + "Descripción: " + weatherInfo.getWeatherDescription() + "\n"
                + "Temperatura: " + weatherInfo.getTemperature() + " °C\n"
                + "Sensación térmica: " + weatherInfo.getFeelsLike() + " °C\n"
                + "Humedad: " + weatherInfo.getHumidity() + "%\n"
                + "Nubes: " + weatherInfo.getCloudiness() + "%\n"
                + "Velocidad del viento: " + weatherInfo.getWindSpeed() + " m/s";

        JOptionPane.showMessageDialog(null, message, "Información del Clima", JOptionPane.INFORMATION_MESSAGE);
    }
}
