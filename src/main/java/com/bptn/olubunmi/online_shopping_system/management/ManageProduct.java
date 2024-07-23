package com.bptn.olubunmi.online_shopping_system.management;

import com.bptn.olubunmi.online_shopping_system._service.ProductService;
import com.bptn.olubunmi.online_shopping_system.data.Product;
import java.util.List;
import java.util.Scanner;

public class ManageProduct {
    private ProductService productService; // Service for managing product-related operations

    // Constructor to initialize ManageProduct with a ProductService
    public ManageProduct(ProductService productService) {
        this.productService = productService; // Assign the provided ProductService to the class field
    }

    // Adding some dummy products to the product service
    public void addDummyProducts() {
        // Add various products with details such as name, description, price, and quantity
        productService.addProduct(new Product("Java Books", "Beginner level Java programming books", 2000, 10));
        productService.addProduct(new Product("JavaScript Books", "Advanced JavaScript learning materials", 800, 20));
        productService.addProduct(new Product("Know Your Python", "Intermediate Python programming guide", 1000, 15));
        productService.addProduct(new Product("Learn React", "Framework for building user interfaces", 500, 5));
        productService.addProduct(new Product("Be Expert in Bootstrap", "Advanced Bootstrap development techniques", 89.99, 25));
        productService.addProduct(new Product("More Books Coming Soon", "New products coming soon to the platform", 0.00, 0));
    }

    // Allows the user to browse products and add them to their cart
    public void browseProducts(Scanner scanner, ManageCart manageCart) {
        // Retrieve the list of available products
        List<Product> availableProducts = productService.getAllProducts();
        System.out.println("Available Products:");

        // Displaying each product's name, price, and description
        availableProducts.forEach(product -> System.out
            .println(product.getName() + " - $" + product.getPrice() + " | " + product.getDescription()));

        // Prompting user to enter a product name to add to their cart or type 'exit' to go back
        System.out.println("Enter the name of the product to add to cart (or type 'exit' to go back): ");
        String productName = scanner.nextLine().trim();

        // If the user does not choose to exit, proceed with adding the product to the cart
        if (!productName.equalsIgnoreCase("exit")) {
            try {
                Product selectedProduct = null;

                // Find the product that matches the user's input
                for (Product product : availableProducts) {
                    if (product.getName().equalsIgnoreCase(productName)) {
                        selectedProduct = product;
                        break; // Exit the loop once the product is found
                    }
                }

                // If a matching product is found, add it to the cart
                if (selectedProduct != null) {
                    manageCart.addProductToCart(selectedProduct);
                    System.out.println("Added " + selectedProduct.getName() + " to cart.");
                } else {
                    // Notify user if the product was not found
                    System.out.println("Product '" + productName + "' not found.");
                }
            } catch (Exception e) {
                // Handle any unexpected errors that occur during product browsing
                System.out.println("Error occurred while browsing products: " + e.getMessage());
                e.printStackTrace(); // Print stack trace for debugging
            }
        }
    }
}

