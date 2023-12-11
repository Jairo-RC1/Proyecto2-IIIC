package model;

import java.util.List;

public class loginDAO {

    userDAO dao = new userDAO();

    // Method to authenticate and retrieve user data
    public user authenticateUser(String email, String password) {
        user currentUser = null;
        List<user> users = dao.readUserTxt();
        for (user u : users) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                currentUser = u;
                break;
            }
        }
        return currentUser;
    }
}
