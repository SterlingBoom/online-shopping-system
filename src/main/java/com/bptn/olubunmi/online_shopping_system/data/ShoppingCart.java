package com.bptn.olubunmi.online_shopping_system.data;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    // List to store products in the shopping cart
    private List<Product> products;

    // Constructor to initialize the products list
    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    // Method to add a product to the cart
    public void addProduct(Product product) {
        products.add(product);
    }

    // Method to get the list of products in the cart
    public List<Product> getProducts() {
        return products;
    }

    // Method to calculate the total price of all products in the cart
    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    // Method to check if the cart is empty
    public boolean isEmpty() {
        return products.isEmpty();
    }

    // Method to clear all products from the cart
    public void clearCart() {
        products.clear();
    }
}

