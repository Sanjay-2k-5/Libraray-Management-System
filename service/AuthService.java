package service;

import database.Database;
import model.User;

public class AuthService {
    public static User login(String email,String password){
        User user=Database.users.get(email);
        if(user!=null && user.getPassword().equals(password))
            return user;
        return null;
    }
}
