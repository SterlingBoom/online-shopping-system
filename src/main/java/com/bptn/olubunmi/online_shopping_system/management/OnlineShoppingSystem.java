
package com.bptn.olubunmi.online_shopping_system.management;

import com.bptn.olubunmi.online_shopping_system._service.ProductService;
import com.bptn.olubunmi.online_shopping_system._service.ShoppingCartService;
import com.bptn.olubunmi.online_shopping_system._service.UserService;
import com.bptn.olubunmi.online_shopping_system.data.Product;
import com.bptn.olubunmi.online_shopping_system.data.ShoppingCart;
import com.bptn.olubunmi.online_shopping_system.data.UserData;

import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OnlineShoppingSystem {
	private UserData currentUser;
	private UserService userService;
	private ProductService productService;
	private ShoppingCartService shoppingCartService;

	private ManageProduct manageProduct;
	private ManageUser manageUser;
	private ManageCart manageCart;

	public OnlineShoppingSystem() {
		initializeServices();
		manageProduct = new ManageProduct(productService);
		manageUser = new ManageUser(userService);
		manageCart = new ManageCart(shoppingCartService);
		loadDummyData(); //this will be called after managecart, manage product and manage cart have been initialised.
	}

	private void initializeServices() {
		List<UserData> users = new ArrayList<>();
		List<Product> products = new ArrayList<>();
		this.userService = new UserService(users);
		this.productService = new ProductService(products);
		this.shoppingCartService = new ShoppingCartService(new ShoppingCart());
	}

	private void loadDummyData() {
		if (manageProduct != null) {
			manageProduct.addDummyProducts();
		} else {
			System.out.println("ManageProduct is not initialized.");
		}
	}

	public void show() {
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;

		while (!exit) {
			displayMainMenu();
			int choice = 0;

			try {
				choice = scanner.nextInt();
				scanner.nextLine(); // Consume newline
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number between 1 and 7.");
				scanner.nextLine(); // Clear invalid input
				continue;
			}

			switch (choice) {
			case 1:
				manageUser.registerUser(scanner);
				break;
			case 2:
				loginUser(scanner);
				break;
			case 3:
				if (currentUser == null) {
					System.out.println("Please log in to browse products.");
				} else {
					manageProduct.browseProducts(scanner, manageCart);
				}
				break;
			case 4:
				if (currentUser == null) {
					System.out.println("Please log in to view the cart.");
				} else {
					manageCart.viewCart();
				}
				break;
			case 5:
				if (currentUser == null) {
					System.out.println("Please log in to proceed with checkout.");
				} else {
					manageCart.checkout();
				}
				break;
			case 6:
				logout();
				break;
			case 7:
				exit = true;
				System.out.println("Thank you for using Online Shopping System!");
				break;
			default:
				System.out.println("Invalid choice. Please enter a number between 1 and 7.");
				break;
			}
		}

		scanner.close();
	}

	private void displayMainMenu() {
		System.out.println("**************************************************");
		System.out.println("*         Welcome to Online Shopping System       *");
		System.out.println("**************************************************");
		System.out.println("Please select an option:");
		System.out.println("1. Register");
		System.out.println("2. Login");
		System.out.println("3. Browse Products");
		System.out.println("4. View Cart");
		System.out.println("5. Checkout");
		System.out.println("6. Logout");
		System.out.println("7. Exit");
		System.out.print("Enter your choice: ");
	}

	private void loginUser(Scanner scanner) {
		System.out.println("Enter username: ");
		String username = scanner.nextLine();
		System.out.println("Enter password: ");
		String password = scanner.nextLine();

		try {
			UserData user = userService.getUserByUsernameAndPassword(username, password);
			if (user != null) {
				currentUser = user;
				System.out.println("Login successful. Welcome, " + currentUser.getUsername() + "!");
			} else {
				System.out.println("Invalid username or password.");
			}
		} catch (Exception e) {
			System.out.println("Error occurred during login: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private void logout() {
		currentUser = null;
		System.out.println("Logged out.");
	}
}
