package org.example;
import java.util.*;

public class AuthenticationService implements IAuthenticationService {
    private ArrayList<User> users;

    // TODO Now: Add a constructor to initialize the users list with the default user
    public AuthenticationService(){
        ArrayList<User> users = new ArrayList<>();
    }

    // TODO Now: Implement the signUp method to add a new user to the list if the username is not taken and return the user; returns null otherwise
    public User signUp(String username, String password){
        User newUser = new User(username, password);
        for (User currentUser : users){
            if (currentUser.getUsername() == newUser.getUsername()){ // user is not in list
                return null;
            }
        }

        users.add(newUser);
        return newUser;
    }

    // TODO Now: Implement the logIn method to return the user if the username and password match, and null otherwise
    public User logIn(String username, String password){
        User currentUser = new User(username, password);
        for (User user : users){
            if (user.getUsername() == currentUser.getUsername() && user.getPassword() == currentUser.getPassword()){ // user is not in list
                return currentUser;
            }
        }

        return null;
    }
}