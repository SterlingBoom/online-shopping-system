package com.bptn.olubunmi.online_shopping_system.management;

import com.bptn.olubunmi.online_shopping_system._service.UserService;
import com.bptn.olubunmi.online_shopping_system.data.UserData;

import java.util.Scanner;

public class ManageUser {
    private UserService userService; //To manage user-related operations
    private UserData currentUser; // Holds the currently loggedin user

    public ManageUser(UserService userService) {
        this.userService = userService; // Initialize userService with provided UserService instance
    }

    // Method to register a new user
    public void registerUser(Scanner scanner) {
        String username, password, email, address;

        // Prompting for username and validate it
        System.out.println("Enter username (at least 5 characters, no spaces, no special characters): ");
        username = scanner.nextLine();

        // Check if username is empty
        if (username.isEmpty()) {
            System.out.println("Username cannot be empty.");
            return;
        }

        // Check if username length is at least 5 characters
        if (username.length() < 5) {
            System.out.println("Username must be at least 5 characters long.");
            return;
        }

        // Check if username contains spaces
        if (username.contains(" ")) {
            System.out.println("Username cannot contain spaces.");
            return;
        }

        // Check if username contains only letters and digits
        for (char c : username.toCharArray()) {
        	//This method checks whether the specified character c is a letter (either uppercase or lowercase) or a digit (0-9).
            if (!Character.isLetterOrDigit(c)) {
                System.out.println("Username can only contain letters and digits.");
                return;
            }
        }

        System.out.println("Username is valid.");

        // Prompt for password and validate it
        System.out.println("Enter password (at least 8 characters, no spaces, one uppercase, one lowercase, one digit): ");
        password = scanner.nextLine();

        // Check if password is empty
        if (password.isEmpty()) {
            System.out.println("Password cannot be empty.");
            return;
        }

        // Check if password length is at least 8 characters
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return;
        }

        // Check if password contains spaces
        if (password.contains(" ")) {
            System.out.println("Password cannot contain spaces.");
            return;
        }

        // Check for at least one uppercase letter, one lowercase letter, and one digit
        boolean uppercase = false;
        boolean lowercase = false;
        boolean digit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                uppercase = true;
            } else if (Character.isLowerCase(c)) {
                lowercase = true;
            } else if (Character.isDigit(c)) {
                digit = true;
            }
        }

        // Check if password contains an uppercase letter
        if (!uppercase) {
            System.out.println("Password must contain at least one uppercase letter.");
            return;
        }

        // Check if password contains a lowercase letter
        if (!lowercase) {
            System.out.println("Password must contain at least one lowercase letter.");
            return;
        }

        // Check if password contains a digit
        if (!digit) {
            System.out.println("Password must contain at least one digit.");
            return;
        }

        // Prompt for email and validate it
        System.out.println("Enter email address: ");
        email = scanner.nextLine();

        if (email.isEmpty()) {
            System.out.println("Email address cannot be empty.");
            return; // Exit if fails
        }
     // Check if email contains spaces
        if (email.contains(" ")) {
            System.out.println("Email address cannot contain spaces.");
            return; // Exit if fails
        }

        // email validation (must contain "@" and ".")
        if (!email.contains("@") || !email.contains(".")) {
            System.out.println("Email address must contain '@' and '.'");
            return; // exit if this fails
        }

        // Prompt for shipping address and validate it
        System.out.println("Enter shipping address: ");
        address = scanner.nextLine();
        if (address.isEmpty()) {
            System.out.println("Shipping address cannot be empty.");
            return;
        }

        // Register the new user using the provided details
        userService.addUser(new UserData(username, password, email, address));
        System.out.println("Registration successful. You can now login.");
    }

    // Method to login an existing user
    public void loginUser(Scanner scanner) {
        // Prompt for username
        System.out.println("Enter username: ");
        String username = scanner.nextLine();

        // Prompt for password
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        try {
            // Attempt to get user with the provided username and password
            currentUser = userService.getUserByUsernameAndPassword(username, password);
            if (currentUser != null) {
                // Login successful
                System.out.println("Login successful. Welcome, " + currentUser.getUsername() + "!");
            } else {
                // Invalid credentials
                System.out.println("Invalid username or password.");
            }
        } catch (Exception e) {
            // Handle errors during login
            System.out.println("Error occurred during login: " + e.getMessage());
            e.printStackTrace(); 
        }
    }

    // Method to logout the current user
    public void logout() {
        currentUser = null; // Clear the current user
        System.out.println("Logged out.");
    }

    // Get the current logged-in user
    public UserData getCurrentUser() {
        return currentUser; // Return the current user
    }
}
