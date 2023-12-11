package model;

import java.util.List;

public class loginDAO {

    userDAO dao = new userDAO();

    // Method to authenticate and retrieve user data
    /*public user authenticateUser(String email, String password) {
        user currentUser = null;
        List<user> users = dao.readUserTxt();
        for (user u : users) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                currentUser = u;
                break;
            }
        }
        return currentUser;
    }*/
    public String loginUser(String email, String password) {
        String roleName = "";

        user currentUser = authenticateUser(email, password);
        if (currentUser != null) {
            int roleId = currentUser.getRoleId(); // Obtenemos el ID del rol del usuario autenticado
            roleName = rolDAO.getRoleNameById(roleId); // Usamos el método del RolDAO para obtener el nombre del rol por su ID
        }

        return roleName;
    }

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
