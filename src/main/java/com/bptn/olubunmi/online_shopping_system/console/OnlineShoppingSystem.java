package com.bptn.olubunmi.online_shopping_system.console;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.bptn.olubunmi.online_shopping_system.data.UserData;
import com.bptn.olubunmi.online_shopping_system.data.Product;
import com.bptn.olubunmi.online_shopping_system.data.ShoppingCart;
import com.bptn.olubunmi.online_shopping_system._service.UserService;
import com.bptn.olubunmi.online_shopping_system._service.ProductService;
import com.bptn.olubunmi.online_shopping_system._service.ShoppingCartService;

public class OnlineShoppingSystem {
    private UserData currentUser;
    private UserService userService;
    private ProductService productService;
    private ShoppingCartService shoppingCartService;

    public OnlineShoppingSystem() {
        initializeServices();
        initializeDummyData(); // Initialize dummy users and products
    }

    private void initializeServices() {
        List<UserData> users = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        this.userService = new UserService(users);
        this.productService = new ProductService(products);
        this.shoppingCartService = new ShoppingCartService(new ShoppingCart());
    }

    private void initializeDummyData() {
//         initialize 
//         Example:
//         users.add(new User("username", "password", "email", "address"));
//         products.add(new Product(1, "Product A", "Description A", 50.0, 10));
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    loginUser(scanner);
                    break;
                case 3:
                    browseProducts(scanner);
                    break;
                case 4:
                    viewCart();
                    break;
                case 5:
                    checkout();
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

}