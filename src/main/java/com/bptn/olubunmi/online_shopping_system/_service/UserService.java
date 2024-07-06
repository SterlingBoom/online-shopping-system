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
    }

    // Method to update an existing user's details
    public void updateUser(UserData updatedUser) {
        for (UserData user : users) {
            if (user.getUsername().equals(updatedUser.getUsername())) {
                user.setPassword(updatedUser.getPassword()); // Update password
                // 	user.setEmail(updatedUser.getEmail());
                //  user.setAddress(updatedUser.getAddress());
                break; // Exit loop once user is updated
            }
        }
    }
//    trying to use lambda expression
//    
//    public void updateUser(UserData updatedUser) {
//        users.stream()
//                .filter(user -> user.getUsername().equals(updatedUser.getUsername()))
//                .forEach(user -> user.setPassword(updatedUser.getPassword()));
//    }


    // Method to retrieve a user by their username
    public UserData getUserByUsername(String username) {
        for (UserData user : users) {
            if (user.getUsername().equals(username)) {
                return user; // Return the user object if found
            }
        }
        return null; // Return null if user is not found
    }
}

