
package model;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

/**
 *
 * @author jefry
 */
public class ApiPlace {
    
    private static final String LOCATION_URL = "https://api.content.tripadvisor.com/api/v1/";
    private static final String API_KEY = "A65E329C442347F9B840D61B29879651";

    public place getPlaceDetails(int id) throws Exception {
        place place = new place();
        String endpoint = String.format("location/%s/details?key=%s&language=en&currency=USD", id, API_KEY);
        URL url = new URL(LOCATION_URL + endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        InputStream in = connection.getInputStream();
        String responseBody = new Scanner(in, "UTF-8").useDelimiter("\\A").next();
        JSONObject jsonResponse = new JSONObject(responseBody);
        place.setName(jsonResponse.getString("name"));
        place.setAddress(jsonResponse.getJSONObject("address_obj").getString("address_string"));
        if (jsonResponse.has("city") && !jsonResponse.isNull("city")) {
            place.setCity(jsonResponse.getString("city"));
        } else {
            place.setCity("Ciudad no disponible");
        }
        if (jsonResponse.has("postalcode") && !jsonResponse.isNull("postalcode")) {
            place.setPostalCode(jsonResponse.getInt("postalcode"));
        } else {
            place.setPostalCode(0);
        }
        place.setLatitude(jsonResponse.getString("latitude"));
        place.setLongitude(jsonResponse.getString("longitude"));
        place.setTripAdvisorLink(jsonResponse.getString("web_url"));
        return place;
    }
}
