package com.bptn.olubunmi.online_shopping_system._service;

import com.bptn.olubunmi.online_shopping_system.data.UserData; // Importing UserData class from data package
import java.util.List;

public class UserService {
    private List<UserData> users; // List to hold UserData objects

    // Constructor to initialize UserService with a list of users
    public UserService(List<UserData> users) {
        this.users = users;
    }

    // Method to add a new user to the list
    public void addUser(UserData newUser) {
        users.add(newUser);
        System.out.println("User registered: " + newUser.getUsername()); // Debugging print statement
    }

    // Method to update an existing user's details
    public void updateUser(UserData updatedUser) {
        users.stream()
             .filter(user -> user.getUsername().equals(updatedUser.getUsername()))
             .forEach(user -> user.setPassword(updatedUser.getPassword())); // Update password using lambda expression
    }

    // Method to retrieve a user by their username
    public UserData getUserByUsername(String username) {
        for (UserData user : users) {
            if (user.getUsername().equals(username)) {
                return user; // Return the user object if found
            }
        }
        return null; // Return null if user is not found
    }

    // Method to retrieve a user by their username and password
    public UserData getUserByUsernameAndPassword(String username, String password) {
        for (UserData user : users) {
            System.out.println("Checking user: " + user.getUsername()); // printing out to see to check
            
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("User found: " + user.getUsername()); // printing out to check if this is returning the user name
                return user; // Return the user object if found
            }
        }
        return null; // Return null if user is not found
    }
}
