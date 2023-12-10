package model;

import org.json.JSONObject;//This library provides a simple way to create and manipulate JSON objects in Java.
import java.io.BufferedReader;//This class reads text from a character-input stream, buffering characters to provide efficient reading of characters, arrays, and lines.
import java.io.IOException;//This exception signals that an I/O (Input/Output) exception of some sort has occurred.
import java.io.InputStreamReader;//This class is used to read bytes and decodes them into characters using a specified charset.
import java.net.HttpURLConnection;//This class allows applications to connect to a URL and interact with the resource pointed to by the URL.
import java.net.URL;//This class represents a Uniform Resource Locator, which is a pointer to a "resource" on the World Wide Web.
import javax.swing.JOptionPane;// This class provides methods to create and show simple dialog boxes for user interaction.

//** @author jairo
//Is designed to make API calls to the OpenWeatherMap service
public class OpenWeatherMapAPI {

    // API key for accessing the OpenWeatherMap service
    private static final String API_KEY = "a0bec00bf2974cc0103b4794547b5f02";
    // Base URL for the OpenWeatherMap API
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=";

    // Method to call the OpenWeatherMap API and retrieve weather information for a given location
    // Takes a location as a parameter and returns a JSONObject containing weather data
    public static JSONObject callWeatherAPI(String location) {
        try {
            // Construct the URL for the API call by combining the base URL, location, and API key
            URL url = new URL(API_URL + location + "&appid=" + API_KEY);
            // Open a connection to the API URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Create a BufferedReader to read the response from the API
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            // Create a StringBuilder to store the response
            StringBuilder response = new StringBuilder();
            String line;

            // Read each line of the response and append it to the StringBuilder
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close(); // Close the BufferedReader

            // Return a new JSONObject constructed from the response String
            return new JSONObject(response.toString());
        } catch (IOException e) {
            // Print the stack trace if an IOException occurs (e.g., network error)
            e.printStackTrace();
            return null;// Return null to indicate that the API call was unsuccessful
        }
    }

    // Parse the JSON string and extract weather information
    public static WeatherInfo parseWeatherJSON(String json, String locationName) {
        // Create a JSONObject from the input JSON string
        JSONObject obj = new JSONObject(json);

        // Extract longitude and latitude from the "coord" object
        double longitude = obj.getJSONObject("coord").getDouble("lon");
        double latitude = obj.getJSONObject("coord").getDouble("lat");

        // Extract weather description from the first element of the "weather" array
        String weather = obj.getJSONArray("weather").getJSONObject(0).getString("description");
        // Extract cloudiness percentage from the "clouds" object
        int clouds = obj.getJSONObject("clouds").getInt("all");
        // Extract temperature in Kelvin from the "main" object
        double tempKelvin = obj.getJSONObject("main").getDouble("temp");
        // Convert temperature from Kelvin to Celsius
        double tempCelsius = tempKelvin - 273.15;
        // Extract feels-like temperature in Kelvin from the "main" object
        double feelsLikeKelvin = obj.getJSONObject("main").getDouble("feels_like");
        // Convert feels-like temperature from Kelvin to Celsius
        double feelsLikeCelsius = feelsLikeKelvin - 273.15; // Convertir de Kelvin a Celsius
        // Extract humidity percentage from the "main" object
        int humidity = obj.getJSONObject("main").getInt("humidity");
        // Extract wind speed from the "wind" object
        double windSpeed = obj.getJSONObject("wind").getDouble("speed");

        // Create a new WeatherInfo object and set its properties
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

        return weatherInfo;// Return the populated WeatherInfo object
    }

    // Display weather information using a JOptionPane dialog.
    public static void displayWeatherInfo(WeatherInfo weatherInfo) {
        // Create a formatted message with weather details.
        String message = "Ubicación: " + weatherInfo.getLocationName() + "\n"
                + "Latitud: " + weatherInfo.getLatitude() + "\n"
                + "Longitud: " + weatherInfo.getLongitude() + "\n"
                + "Descripción: " + weatherInfo.getWeatherDescription() + "\n"
                + "Temperatura: " + weatherInfo.getTemperature() + " °C\n"
                + "Sensación térmica: " + weatherInfo.getFeelsLike() + " °C\n"
                + "Humedad: " + weatherInfo.getHumidity() + "%\n"
                + "Nubes: " + weatherInfo.getCloudiness() + "%\n"
                + "Velocidad del viento: " + weatherInfo.getWindSpeed() + " m/s";

        // Display the weather information in a JOptionPane dialog.
        JOptionPane.showMessageDialog(null, message, "Información del Clima", JOptionPane.INFORMATION_MESSAGE);
    }
}
