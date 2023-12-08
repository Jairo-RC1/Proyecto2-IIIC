package model;


import java.util.List;

public class loginDAO {

    userDAO dao = new userDAO();

   

    // Método para autenticar y obtener los datos del usuario
    public user authenticateUser(String username, String password) {
        user currentUser = null;
        List<user> users = dao.readUserTxt(); // Llamada al método que obtiene los usuarios

        // Buscar al usuario por nombre de usuario y contraseña
        for (user u : users) {
            if (u.getName().equals(username) && u.getPassword().equals(password)) {
                currentUser = u;
                break;
            }
        }

        return currentUser;
    }
}
