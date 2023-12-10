package model;

import java.util.List;// Provides the List interface to store result sets.

public class loginDAO {

    userDAO dao = new userDAO(); // Creating an instance of the userDAO class for user data access

    // Method to authenticate and retrieve user data
    public user authenticateUser(String username, String password) {
        user currentUser = null; // Initializing a variable to store the authenticated user
        List<user> users = dao.readUserTxt(); // Calling the method to obtain the list of users from the userDAO

        // Searching for the user by username and password in the list of users
        for (user u : users) {
            if (u.getName().equals(username) && u.getPassword().equals(password)) {
                currentUser = u; // Assigning the found user to the currentUser variable
                break; // Exiting the loop once the user is found
            }
        }

        return currentUser; // Returning the authenticated user (or null if not found)
    }
}
