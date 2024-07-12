// Package declaration for the Online Shopping System console application
package com.bptn.olubunmi.online_shopping_system.console;

// Importing necessary services and data classes
import com.bptn.olubunmi.online_shopping_system._service.ProductService;
import com.bptn.olubunmi.online_shopping_system._service.ShoppingCartService;
import com.bptn.olubunmi.online_shopping_system._service.UserService;
import com.bptn.olubunmi.online_shopping_system.data.Product;
import com.bptn.olubunmi.online_shopping_system.data.UserData;
import com.bptn.olubunmi.online_shopping_system.data.ShoppingCart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// The main class representing the Online Shopping System application
public class OnlineShoppingSystem {
    // Current logged-in user
    private UserData currentUser;
    // Services for user management, product management, and shopping cart operations
    private UserService userService;
    private ProductService productService;
    private ShoppingCartService shoppingCartService;

    // Constructor to initialize the Online Shopping System
    public OnlineShoppingSystem() {
      getServiceStarted(); // Initializes  services
        getStartedWithDummyData(); // Initializes dummy users and products 
    }

    // Method to initialize services required for the system
    private void getServiceStarted() {
        List<UserData> users = new ArrayList<>(); // List to store user data
        List<Product> products = new ArrayList<>(); // List to store product data

        this.userService = new UserService(users); // Initializes UserService with user data
        this.productService = new ProductService(products); // Initializes ProductService with product data
        this.shoppingCartService = new ShoppingCartService(new ShoppingCart()); // Initializes ShoppingCartService
    }

    // Method to initialize dummy data for demonstration purposes
    private void getStartedWithDummyData() {
        // Adding dummy products to the ProductService
    	
    	productService.addProduct(new Product(1, "Java Books", "Beginner level Java programming books", 999.99, 10));
        productService.addProduct(new Product(2, "JavaScript Books", "Advanced JavaScript learning materials", 799.99, 20));
        productService.addProduct(new Product(3, "Know Your Python", "Intermediate Python programming guide", 199.99, 15));
        productService.addProduct(new Product(4, "Learn React", "Framework for building user interfaces", 299.99, 5));
        productService.addProduct(new Product(5, "Be Expert in Bootstrap", "Advanced Bootstrap development techniques", 89.99, 25));
        productService.addProduct(new Product(6, "More Books Coming Soon", "New products coming soon to the platform", 0.00, 0));
    }

    // Method to start the main interaction loop of the application
    public void show() {
        Scanner scanner = new Scanner(System.in); // Scanner object for user input
        boolean exit = false;

        // Main loop of the application for user interaction
        while (!exit) {
            displayMainMenu(); // Displaying the main menu options
            int choice = scanner.nextInt(); // Reading user choice
            scanner.nextLine(); // Consume newline after reading integer input

            switch (choice) {
                case 1:
                    registerUser(scanner); // Option to register a new user
                    break;
                case 2:
                    loginUser(scanner); // Option to login with existing credentials
                    break;
                case 3:
                    browseProducts(scanner); // Option to browse available products
                    break;
                case 4:
                    viewCart(); // Option to view products in the shopping cart
                    break;
                case 5:
                    checkout(); // Option to proceed to checkout
                    break;
                case 6:
                    logout(); // Option to logout from the current session
                    break;
                case 7:
                    exit = true; // Option to exit the application
                    System.out.println("Thank you for using Online Shopping System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                    break;
            }
        }

        scanner.close(); // Closing the scanner object after finishing user interaction
    }

    // Method to display the main menu options
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

    // Method to register a new user
    private void registerUser(Scanner scanner) {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        System.out.println("Enter email address: ");
        String email = scanner.nextLine();
        System.out.println("Enter shipping address: ");
        String address = scanner.nextLine();

        userService.addUser(new UserData(username, password, email, address)); // Adding new user to the system
        System.out.println("Registration successful. You can now login.");
    }

    // Method to login with existing credentials
    private void loginUser(Scanner scanner) {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        UserData user = userService.getUserByUsernameAndPassword(username, password); // Retrieving user data

        if (user != null) {
            currentUser = user; // Setting current user after successful login
            System.out.println("Login successful. Welcome, " + currentUser.getUsername() + "!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    // Method to browse available products and add to cart
    private void browseProducts(Scanner scanner) {
        List<Product> availableProducts = productService.getAllProducts(); // Retrieving all available products
        System.out.println("Available Products:");
        System.out.println("Programming language Books showcase");
        availableProducts.forEach(product -> System.out.println(product.getId() + ". " + product.getName() + " - $" + product.getPrice()));

        System.out.println("Enter product ID to add to cart (0 to exit): ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        if (productId != 0) {
            Product selectedProduct = productService.getProductById(productId); // Retrieving selected product by ID
            if (selectedProduct != null) {
                shoppingCartService.addProductToCart(selectedProduct); // Adding selected product to shopping cart
                System.out.println("Added " + selectedProduct.getName() + " to cart.");
            } else {
                System.out.println("Invalid product ID.");
            }
        }
    }

    // Method to view products in the shopping cart
    private void viewCart() {
        System.out.println("Your Shopping Cart:");
        shoppingCartService.getProductsInCart().forEach(System.out::println); // Displaying products in shopping cart
        System.out.println("Total: $" + shoppingCartService.calculateTotalCost()); // Displaying total cost of items in cart
    }

    // Method to proceed with checkout
    private void checkout() {
        if (currentUser == null) {
            System.out.println("Please login first.");
            return;
        }

        if (shoppingCartService.getProductsInCart().isEmpty()) {
            System.out.println("Your shopping cart is empty.");
            return;
        }

        // Order placement logic can be added here

        System.out.println("Order placed successfully!");
        shoppingCartService.clearCart(); // Clearing the shopping cart after successful checkout
    }

    // Method to logout from the current session
    private void logout() {
        currentUser = null; // Logging out the current user
        System.out.println("Logged out.");
    }

    // Main method to start the Online Shopping System application
    public static void main(String[] args) {
        OnlineShoppingSystem shoppingSystem = new OnlineShoppingSystem();
        shoppingSystem.show(); // Starting  application
    }
}
