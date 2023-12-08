package model;

import java.io.InputStream;//To read the content of the HTTP connection response.
import java.net.HttpURLConnection;//This class allows you to make HTTP connections and handle both the request and the response.
import java.net.URL;//Represents a URL and provides methods for working with it.
import java.util.Scanner;//It is to read the content of the input stream obtained from the HTTP connection.
import org.json.JSONObject;//It is to access JSON elements or to make strings.

public class ApiPlace {

    //LOCATION_URL that stores the base URL for requests to the TripAdvisor API.
    private static final String LOCATION_URL = "https://api.content.tripadvisor.com/api/v1/";
    //API_KEY stores the API key used to authenticate requests to the TripAdvisor API.
    private static final String API_KEY = "A65E329C442347F9B840D61B29879651";

    public place getPlaceDetails(int id) throws Exception {
        // An instance of the 'place' class is created to store the place details.
        place place = new place();

        // The API URL is constructed using the location ID and API key.
        String endpoint = String.format("location/%s/details?key=%s&language=en&currency=USD", id, API_KEY);
        URL url = new URL(LOCATION_URL + endpoint);

        // An HTTP connection is established and configured as a GET request.
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        // Get the input stream (InputStream) of the connection.
        InputStream in = connection.getInputStream();
        // Se lee el cuerpo de la respuesta HTTP.
        String responseBody = new Scanner(in, "UTF-8").useDelimiter("\\A").next();
        // The response is converted to a JSON object for easy manipulation.
        JSONObject jsonResponse = new JSONObject(responseBody);
        // Place details are extracted and mapped from the JSON object to the 'place' object.
        place.setName(jsonResponse.getString("name"));
        place.setAddress(jsonResponse.getJSONObject("address_obj").getString("address_string"));

        // The existence of the city is checked in the JSON response.
        if (jsonResponse.has("city") && !jsonResponse.isNull("city")) {
            place.setCity(jsonResponse.getString("city"));
        } else {// If city information is not provided, a default value is set.
            place.setCity("Ciudad no disponible");
        }

        // The existence of the zip code is checked in the JSON response.
        if (jsonResponse.has("postalcode") && !jsonResponse.isNull("postalcode")) {
            place.setPostalCode(jsonResponse.getInt("postalcode"));
        } else {// If no zip code is provided, a default value is set.
            place.setPostalCode(0);
        }

        // Latitude and longitude coordinates are assigned.
        place.setLatitude(jsonResponse.getString("latitude"));
        place.setLongitude(jsonResponse.getString("longitude"));
        // The TripAdvisor link is assigned.
        place.setTripAdvisorLink(jsonResponse.getString("web_url"));
        return place;// The 'place' object is returned with the details of the place.
    }
}
