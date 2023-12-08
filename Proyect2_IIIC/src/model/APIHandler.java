package model;

import java.io.IOException;//handle input/output exceptions.
import java.io.InputStream;//Byte input, used to read binary data, such as reading data from a network connection.
import java.net.HttpURLConnection;//Opening HTTP connections to send or receive data.
import java.net.URL;//It can be used to construct and manipulate URLs.
import java.net.URLEncoder;//Used to encode query parameters in a URL.
import java.util.ArrayList;//It is used to store data in a dynamic list.
import java.util.List;//Represents an ordered collection of elements.
import java.util.Scanner;//It is used to read data from an input source, such as an input stream or a file.
import javax.swing.JOptionPane;//Used to display message dialog boxes
import org.json.JSONArray;//Allows you to manipulate and access data in JSON format.
import org.json.JSONObject;//Used to represent a JSON object

public class APIHandler {

    private static final String MAIN_URL = "https://api.content.tripadvisor.com/api/v1/location/search"; //MAIN_URL: This is the base URL for searching locations in the TripAdvisor API.
    private static final String LOCATION_URL = "https://api.content.tripadvisor.com/api/v1/";//LOCATION_URL: This is the base URL to interact with the TripAdvisor Locations API.
    private static final String API_KEY = "4BB0E403299542FEB3BF8DEB5EF58051"; //API_KEY: An API key used to authenticate requests to the TripAdvisor API.
    HttpURLConnection connection = null;//It is a class that allows establishing and manipulating HTTP connections.

    public List<Event> findEvents(String name, String location, String category) throws Exception {
        // Encodes the name and location parameters in URL format.
        String encodedLocation = URLEncoder.encode(location, "UTF-8");
        String encodedName = URLEncoder.encode(name, "UTF-8");
        // Create a query string that will be used in the API request.
        String endPoint = String.format("?key=%s&searchQuery=%s&address=%s&category=%s&language=en", API_KEY, encodedName, encodedLocation, category);
        // Call the lookForEvents function with the query string and return the resulting list of events
        return lookForEvents(endPoint);
    }

    private List<Event> lookForEvents(String endPoint) throws Exception {
        // A list is created to store the events obtained.
        List<Event> events = new ArrayList<>();
        // The URL is constructed by combining the main URL (MAIN_URL) and the given endpoint.
        URL url = new URL(MAIN_URL + endPoint);
        System.out.println(url);
        try {
            // HTTP connection is established.
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            try (InputStream istrm = connection.getInputStream()) {
                // The body of the HTTP response is read.
                String responseBody = new Scanner(istrm, "UTF-8").useDelimiter("\\A").next();
                // Converts the JSON response to a JSONObject object.
                JSONObject jsonResponse = new JSONObject(responseBody);
                // Get the event array from the JSON object.
                JSONArray data = jsonResponse.getJSONArray("data");

                // The events array is traversed and the necessary information is extracted.
                for (int i = 0; i < data.length(); i++) {
                    JSONObject obj = data.getJSONObject(i);
                    Event Event = new Event();
                    Event.setLocationId(obj.getInt("location_id"));
                    System.out.println(Event.getLocationId());
                    Event.setName(obj.getString("name"));
                    Event.setAddress(obj.getJSONObject("address_obj").getString("address_string"));

                    // Checks if the JSON object has the key "city" and is not null.
                    if (obj.has("city") && obj.isNull("ciyi")) {
                        Event.setCity(obj.getString("city"));
                    } else {// If there is no city information, a default value is set.
                        Event.setCity("No se encuentra la ciudad");
                    }

                    // Checks if the JSON object has the key "postalCode" and is not null.
                    if (obj.has("postalCode") && !obj.isNull("postalCode")) {
                        Event.setPostalCode(obj.getInt("postalCode"));
                    } else {// If there is no zip code information, a default value is set.
                        Event.setPostalCode(0);
                    }
                    events.add(Event);// The event is added to the list.
                }
            }
        } catch (IOException e) {
            // In case of I/O error, an error message is displayed.
            JOptionPane.showMessageDialog(null, "Error buscando eventos " + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Makes sure the connection is closed correctly.
            if (connection != null) {
                connection.disconnect();

            }
        }
        return events;// The list of events obtained is returned.
    }

    public List<String> getImagesApi(int id) throws Exception {
        // A list is created to store the image URLs
        List<String> imageUrls = new ArrayList<>();

        // Construct the URL for the GET request to the API
        String endpoint = "location/" + id + "/photos?key=4BB0E403299542FEB3BF8DEB5EF58051&language=en";
        URL url = new URL(LOCATION_URL + endpoint);
        System.out.println(url);// Print the URL (for debugging purposes)

        // An HTTP connection is initialized
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            // The connection response is read
            try (InputStream in = connection.getInputStream()) {
                // Convert the response to a text string
                String responseBody = new Scanner(in, "UTF-8").useDelimiter("\\A").next();

                // Se crea un objeto JSON a partir de la respuesta
                JSONObject jsonResponse = new JSONObject(responseBody);

                // Obtain the array of image data
                JSONArray photoData = jsonResponse.getJSONArray("data");

                // Iterates over each image object in the array
                for (int i = 0; i < photoData.length(); i++) {
                    JSONObject photo = photoData.getJSONObject(i);
                    // Get the "images" object inside the image object
                    JSONObject images = photo.getJSONObject("images");
                    // Obtain the "medium" object inside the "images" object
                    JSONObject smallImg = images.getJSONObject("medium");
                    // Obtain the URL of the image in medium size
                    String imageUrl = smallImg.getString("url");
                    // The URL is added to the list of image URLs
                    imageUrls.add(imageUrl);
                }
            }
        } catch (IOException e) {
            // In case of connection error, an error message is displayed
            JOptionPane.showMessageDialog(null, "error cargando imagenes " + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Connection is disconnected after use
            if (connection != null) {
                connection.disconnect();
            }
        }
        return imageUrls;// The list of image URLs is returned
    }

    public Event getDetailsApi(int id) throws Exception {
        // A new instance of the Event class is created to store the event details.
        Event event = new Event();

        // The API URL is constructed using the event id and an API key.
        String endpoint = String.format("location/%s/details?key=%s&language=en&currency=USD", id, API_KEY);
        URL url = new URL(LOCATION_URL + endpoint);
        System.out.println(url);// Print the URL to the console (may be useful for debugging purposes).

        try {
            // An HTTP connection is established to the URL.
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            try (InputStream in = connection.getInputStream()) {
                // The response from the server is read and converted to a text string.
                String responseBody = new Scanner(in, "UTF-8").useDelimiter("\\A").next();

                // Converts the JSON string to a JSONObject object.
                JSONObject jsonResponse = new JSONObject(responseBody);

                // Se obtienen datos específicos del objeto JSON y se establecen en el objeto Event.
                event.setDescription(jsonResponse.optString("description", "Descripcion no disponible"));
                event.setCantReviews(jsonResponse.optString("num_reviews"));
                event.setCalificationUrlImages(jsonResponse.optString("rating_image_url"));
            }
        } catch (IOException e) {
            // In case of a connection error, an error message is displayed.
            JOptionPane.showMessageDialog(null, "Error obteniendo detalles de eventos " + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // The connection is disconnected after the request is made.
            if (connection != null) {
                connection.disconnect();
            }
        }
        return event;// The Event object is returned with the event details obtained from the API.
    }
}
