package model;

import java.io.IOException; // Input/output exception handling
import java.io.InputStream; // Input stream handling
import java.net.HttpURLConnection; // HTTP connection handling
import java.net.URL; // URL handling
import java.net.URLEncoder; // URL encoding
import java.util.ArrayList; // Dynamic arrays for data storage
import java.util.List; // List interface for data storage
import java.util.Scanner; // Scanner for reading user input
import javax.swing.JOptionPane; // Java Swing library for creating graphical user interfaces
import org.json.JSONArray; // JSON array handling
import org.json.JSONObject; // JSON object handling


public class APIHandler {

    // The main URL for searching locations on the TripAdvisor API.
    private static final String MAIN_URL = "https://api.content.tripadvisor.com/api/v1/location/search";
    // The base URL for the TripAdvisor API.
    private static final String LOCATION_URL = "https://api.content.tripadvisor.com/api/v1/";
    // The API key for accessing the TripAdvisor API.
    private static final String API_KEY = "A65E329C442347F9B840D61B29879651";
    // HttpURLConnection object for making HTTP requests.
    HttpURLConnection connection = null;

    // Method to find events based on a name, location, and category using the TripAdvisor API.
    public List<event> findEvents(String name, String location, String category) throws Exception {
        // Encode location and name to handle special characters in the URL.
        String encodedLocation = URLEncoder.encode(location, "UTF-8");
        String encodedName = URLEncoder.encode(name, "UTF-8");
        // Construct the endpoint URL with API key, encoded name, encoded location, category, and language parameters.
        String endPoint = String.format("?key=%s&searchQuery=%s&address=%s&category=%s&language=en", API_KEY, encodedName, encodedLocation, category);
        // Call the lookForEvents method with the constructed endpoint URL.
        return lookForEvents(endPoint);
    }

    // and then sends a GET request to the constructed URL to retrieve event data.
    private List<event> lookForEvents(String endPoint) throws Exception {
        // Create a list to store Event objects
        List<event> events = new ArrayList<>();
        // Construct the URL by combining the main URL and the provided endpoint
        URL url = new URL(MAIN_URL + endPoint);
        // Print the URL for debugging purposes
        System.out.println(url);

        try {
            // Open a connection to the URL
            connection = (HttpURLConnection) url.openConnection();
            // Set the request method to GET
            connection.setRequestMethod("GET");
            // Establish the connection
            connection.connect();
            // Try to get the input stream from the connection
            try (InputStream istrm = connection.getInputStream()) {
                // Read the response body from the input stream
                String responseBody = new Scanner(istrm, "UTF-8").useDelimiter("\\A").next();
                // Parse the JSON response body into a JSONObject
                JSONObject jsonResponse = new JSONObject(responseBody);
                // Get the "data" array from the JSON response
                JSONArray data = jsonResponse.getJSONArray("data");
                // Iterate through each object in the "data" array
                for (int i = 0; i < data.length(); i++) {
                    // Get the current object
                    JSONObject obj = data.getJSONObject(i);
                    // Create a new Event object
                    event event = new event();
                    // Set the Location ID for the event
                    event.setLocationId(obj.getInt("location_id"));
                    System.out.println(event.getLocationId());
                    // Set the name for the event
                    event.setName(obj.getString("name"));
                    // Set the address for the event
                    event.setAddress(obj.getJSONObject("address_obj").getString("address_string"));
                    // Check if the object has "city" and it is not null, then set the city for the event
                    if (obj.has("city") && !obj.isNull("city")) {
                        event.setCity(obj.getString("city"));
                    } else {
                        // If "city" is either missing or null, set a default value
                        event.setCity("No se encuentra la ciudad");
                    }
                    // Check if the object has "postalCode" and it is not null, then set the postal code for the event
                    if (obj.has("postalCode") && !obj.isNull("postalCode")) {
                        event.setPostalCode(obj.getInt("postalCode"));
                    } else {
                        // If "postalCode" is either missing or null, set a default value
                        event.setPostalCode(0);
                    }
                    // Add the Event object to the list of events
                    events.add(event);
                }
            }
        } catch (IOException e) {
            // Handle IOException by displaying an error message
            JOptionPane.showMessageDialog(null, "Error buscando eventos " + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Disconnect the connection in the finally block to ensure proper cleanup
            if (connection != null) {
                connection.disconnect();
            }
        }
        // Return the list of events
        return events;
    }

    // This method retrieves a list of image URLs associated with a given location ID from an external API.
    public List<String> getImagesApi(int id) throws Exception {
        // Initialize a list to store the image URLs.
        List<String> imageUrls = new ArrayList<>();

        // Construct the API endpoint URL with the provided location ID and API key.
        String endpoint = "location/" + id + "/photos?key=A65E329C442347F9B840D61B29879651&language=en";
        URL url = new URL(LOCATION_URL + endpoint);

        // Print the constructed URL for debugging purposes.
        System.out.println(url);

        try {
            // Establish a connection to the API endpoint.
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            // Retrieve and process the API response.
            try (InputStream in = connection.getInputStream()) {
                // Convert the response stream to a string.
                String responseBody = new Scanner(in, "UTF-8").useDelimiter("\\A").next();

                // Parse the response as a JSON object.
                JSONObject jsonResponse = new JSONObject(responseBody);

                // Extract the array of photo data from the JSON response.
                JSONArray photoData = jsonResponse.getJSONArray("data");

                // Iterate through each photo in the array to extract image URLs.
                for (int i = 0; i < photoData.length(); i++) {
                    JSONObject photo = photoData.getJSONObject(i);
                    JSONObject images = photo.getJSONObject("images");
                    JSONObject mediumImg = images.getJSONObject("medium");
                    // Extract the URL of the medium-sized image and add it to the list.
                    String imageUrl = mediumImg.getString("url");
                    imageUrls.add(imageUrl);
                }
            }
        } catch (IOException e) {
            // Display an error message if there is an issue loading images.
            JOptionPane.showMessageDialog(null, "error cargando imagenes " + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Disconnect the connection to release resources.
            if (connection != null) {
                connection.disconnect();
            }
        }
        // Return the list of image URLs obtained from the API.
        return imageUrls;
    }

    // The details include information such as event description, number of reviews, and a URL for event ratings images.
    public event getDetailsApi(int id) throws Exception {
        // Create a new Event object to store the details of the retrieved event.
        event event = new event();

        // Formulate the API endpoint URL based on the provided event ID and a predefined API key.
        String endpoint = String.format("location/%s/details?key=%s&language=en&currency=USD", id, API_KEY);

        // Construct the complete URL for the API request.
        URL url = new URL(LOCATION_URL + endpoint);

        // Print the formed URL for debugging purposes.
        System.out.println(url);

        try {
            // Establish an HTTP connection to the formed URL.
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            // Retrieve the response from the API endpoint.
            try (InputStream in = connection.getInputStream()) {
                // Convert the response InputStream to a String.
                String responseBody = new Scanner(in, "UTF-8").useDelimiter("\\A").next();

                // Parse the JSON response into a JSONObject.
                JSONObject jsonResponse = new JSONObject(responseBody);

                // Extract relevant information from the JSON response and set it in the Event object.
                event.setDescription(jsonResponse.optString("description", "Description not available"));
                event.setCantReviews(jsonResponse.optString("num_reviews"));
                event.setCalificationUrlImages(jsonResponse.optString("rating_image_url"));
            }
        } catch (IOException e) {
            // Display an error message if an exception occurs during the API request.
            JOptionPane.showMessageDialog(null, "Error obtaining event details: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Disconnect the HTTP connection in the finally block to ensure proper cleanup.
            if (connection != null) {
                connection.disconnect();
            }
        }

        // Return the Event object containing the retrieved event details.
        return event;
    }
}
