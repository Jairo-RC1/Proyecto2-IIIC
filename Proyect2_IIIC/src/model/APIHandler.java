package model;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author jefry
 */
public class APIHandler {

    private static final String MAIN_URL = "https://api.content.tripadvisor.com/api/v1/location/search";
    private static final String LOCATION_URL = "https://api.content.tripadvisor.com/api/v1/";
    private static final String API_KEY = "A65E329C442347F9B840D61B29879651";
    HttpURLConnection connection = null;

    public List<Event> findEvents(String name, String location, String category) throws Exception {
        String encodedLocation = URLEncoder.encode(location, "UTF-8");
        String encodedName = URLEncoder.encode(name, "UTF-8");
        String endPoint = String.format("?key=%s&searchQuery=%s&address=%s&category=%s&language=en", API_KEY, encodedName, encodedLocation, category);
        return lookForEvents(endPoint);
    }

    private List<Event> lookForEvents(String endPoint) throws Exception {
        List<Event> events = new ArrayList<>();
        URL url = new URL(MAIN_URL + endPoint);
        System.out.println(url);
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            try (InputStream istrm = connection.getInputStream()) {

                String responseBody = new Scanner(istrm, "UTF-8").useDelimiter("\\A").next();

                JSONObject jsonResponse = new JSONObject(responseBody);
                JSONArray data = jsonResponse.getJSONArray("data");

                for (int i = 0; i < data.length(); i++) {
                    JSONObject obj = data.getJSONObject(i);
                    Event Event = new Event();
                    Event.setLocationId(obj.getInt("location_id"));
                    System.out.println(Event.getLocationId());
                    Event.setName(obj.getString("name"));
                    Event.setAddress(obj.getJSONObject("address_obj").getString("address_string"));
                    if (obj.has("city") && obj.isNull("ciyi")) {
                        Event.setCity(obj.getString("city"));
                    } else {
                        Event.setCity("No se encuentra la ciudad");
                    }
                    if (obj.has("postalCode") && !obj.isNull("postalCode")) {
                        Event.setPostalCode(obj.getInt("postalCode"));
                    } else {
                        Event.setPostalCode(0);
                    }
                    events.add(Event);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error buscando eventos " + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (connection != null) {
                connection.disconnect();
              
            }
        }
       return events;
    }

    public List<String> getImagesApi(int id) throws Exception {
        List<String> imageUrls = new ArrayList<>();

        String endpoint = "location/" + id + "/photos?key=A65E329C442347F9B840D61B29879651&language=en";
        URL url = new URL(LOCATION_URL + endpoint);
        System.out.println(url);

        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            try (InputStream in = connection.getInputStream()) {
                String responseBody = new Scanner(in, "UTF-8").useDelimiter("\\A").next();

                JSONObject jsonResponse = new JSONObject(responseBody);
                JSONArray photoData = jsonResponse.getJSONArray("data");

                for (int i = 0; i < photoData.length(); i++) {
                    JSONObject photo = photoData.getJSONObject(i);
                    JSONObject images = photo.getJSONObject("images");
                    JSONObject smallImg = images.getJSONObject("medium");
                    String imageUrl = smallImg.getString("url");
                    imageUrls.add(imageUrl);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "error cargando imagenes " + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return imageUrls;
    }

    public Event getDetailsApi(int id) throws Exception {
        Event event = new Event();
        String endpoint = String.format("location/%s/details?key=%s&language=en&currency=USD", id, API_KEY);
        URL url = new URL(LOCATION_URL + endpoint);
        System.out.println(url);
        
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            try (InputStream in = connection.getInputStream()) {
                String responseBody = new Scanner(in, "UTF-8").useDelimiter("\\A").next();

                JSONObject jsonResponse = new JSONObject(responseBody);
                event.setDescription(jsonResponse.optString("description", "Descripcion no disponible"));
                event.setCantReviews(jsonResponse.optString("num_reviews"));
                event.setCalificationUrlImages(jsonResponse.optString("rating_image_url"));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error obteniendo detalles de eventos " + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return event;
    }
}
