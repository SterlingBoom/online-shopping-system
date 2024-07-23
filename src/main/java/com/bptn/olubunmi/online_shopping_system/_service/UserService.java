package com.bptn.olubunmi.online_shopping_system._service;

import com.bptn.olubunmi.online_shopping_system.data.UserData;
import java.util.List;

public class UserService {
	private List<UserData> users; // List to hold UserData objects

	// Constructor to initialize UserService with a list of users
	public UserService(List<UserData> users) {
	    if (users == null) {
	        throw new IllegalArgumentException("User list cannot be null");
	    }
	    this.users = users; // the users parameter, which is a list of UserData objects, is being stored in the class field this.users. 
	}


	// Method to add a new user to the list
	public void addUser(UserData newUser) {
		if (newUser == null) {
			throw new IllegalArgumentException("User data cannot be null"); // Ensure newUser is not null
		}
		// Check if the username already exists
		for (UserData user : users) {
			if (user.getUsername().equals(newUser.getUsername())) {
				throw new IllegalArgumentException("User with this username already exists"); // Prevent duplicate users
			}
		}
		try {
			users.add(newUser);
			System.out.println("User registered: " + newUser.getUsername()); // checking if user registered
		} catch (Exception e) {
			// Handle unexpected issues during the add user process
			System.err.println("Error adding user: " + e.getMessage());
		}
	}

	// Method to update an existing user's details
	public void updateUser(UserData updatedUser) {
		if (updatedUser == null) {
			throw new IllegalArgumentException("Updated user data cannot be null"); // Ensure updatedUser is not null
		}

		boolean userFound = false;
		try {
			users.stream().filter(user -> user.getUsername().equals(updatedUser.getUsername())) // it filters users whose username matches updatedUser's username.
					.forEach(user -> user.setPassword(updatedUser.getPassword())); // Updating password using lambda expression ,it updates the password of the filtered user.
																					

			userFound = users.stream().anyMatch(user -> user.getUsername().equals(updatedUser.getUsername())); //this anyMatch takes a lambda expression as its parameter and returns true if any elements in the stream match the given predicate

			if (!userFound) {
				throw new IllegalArgumentException("User with username " + updatedUser.getUsername() + " not found"); // Handles error where user is not found
																														
			}
		} catch (Exception e) {
			// Handle unexpected issues during the update process
			System.out.println("Error updating user: " + e.getMessage());
		}
	}

	// Method to retrieve a user by their username
	public UserData getUserByUsername(String username) {
		if (username == null || username.isEmpty()) {
			throw new IllegalArgumentException("Username cannot be null or empty"); // Ensuring username is valid
		}

		try {
			for (UserData user : users) {
				if (user.getUsername().equals(username)) {
					return user; // Return the user object
				}
			}
			return null; // Return null if user is not found
		} catch (Exception e) {
			// Handle unexpected issues during retrieval
			System.out.println("Error retrieving user: " + e.getMessage());
			return null; // Ensure method returns a consistent result
		}
	}

	// Method to retrieve a user by their username and password
	public UserData getUserByUsernameAndPassword(String username, String password) {
		if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
			throw new IllegalArgumentException("Username and password cannot be null or empty"); // Ensure username and password are valid
																									
		}

		try {
			for (UserData user : users) {
				System.out.println("Checking user: " + user.getUsername()); // print statement to check 

				if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
					System.out.println("User found: " + user.getUsername()); // print statement to check
					return user; // Return the user object if found
				}
			}
			return null; // Return null if user is not found
		} catch (Exception e) {
			// Handle unexpected issues during
			System.out.println("Error checking details: " + e.getMessage());
			return null; // Ensure method returns result
		}
	}
}
