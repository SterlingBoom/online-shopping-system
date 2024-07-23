package com.bptn.olubunmi.online_shopping_system._service;

import com.bptn.olubunmi.online_shopping_system.data.Product;
import com.bptn.olubunmi.online_shopping_system.data.ShoppingCart;
import com.bptn.olubunmi.online_shopping_system.data.UserData;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartService {
	private ShoppingCart shoppingCart;
	private List<UserData> users; // List to store users

	public ShoppingCartService(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
		this.users = new ArrayList<>(); // Initializing user list
	}

	// Method to add a product to the cart
	public void addProductToCart(Product product) {
		shoppingCart.addProduct(product);
	}

	// Method to remove a product from the cart
	public void removeProductFromCart(Product product) {
		shoppingCart.removeProduct(product);
	}

	// Method to calculate the total cost of the cart
	public double calculateTotalCost() {
		return shoppingCart.calculateTotal();
	}

	// Method to retrieve products in the cart from ShoppingCart
	public List<Product> getProductsInCart() {
		return shoppingCart.getProductsInCart();
	}

	// Method to clear the cart
	public void clearCart() {
		shoppingCart.clearCart();
	}

	// Method to register a new user
	public void registerUser(UserData user) {
		users.add(user);
	}

	// Method to retrieve a user by their username and password
	public UserData getUserByUsernameAndPassword(String username, String password) {
		for (UserData user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	// Method to get the list of users to check
	public List<UserData> getUsers() {
		return users;
	}
}
