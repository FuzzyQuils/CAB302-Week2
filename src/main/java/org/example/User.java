package org.example;
import java.util.*;

public class User {
    private String username;
    private String password;

    private ArrayList<ToDoItem> toDoItems;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.toDoItems = new ArrayList<>();
    }

    /**
     * Gets the username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the username of the user.
     * @param username The username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the password of the user.
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<ToDoItem> getToDoItems () {
        return toDoItems;
    }
}