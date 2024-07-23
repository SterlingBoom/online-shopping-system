
package com.bptn.olubunmi.online_shopping_system.management;

import com.bptn.olubunmi.online_shopping_system._service.ShoppingCartService;
import com.bptn.olubunmi.online_shopping_system.data.Product;

import java.util.List;
import java.util.Scanner;

public class ManageCart {
	private ShoppingCartService shoppingCartService;

	public ManageCart(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}

	// Method to add a product to the cart
	public void addProductToCart(Product product) {
		shoppingCartService.addProductToCart(product);
	}

	// Method to view all products in the cart
	public void viewCart() {
		List<Product> productsInCart = shoppingCartService.getProductsInCart();

		if (productsInCart.isEmpty()) {
			System.out.println("Your shopping cart is empty.");
		} else {
			System.out.println("Your Shopping Cart:");
			for (Product product : productsInCart) {
				System.out.println("Product Name: " + product.getName());
				System.out.println("Product Description: " + product.getDescription());
				System.out.println("Price: $" + product.getPrice());
				System.out.println(); // Add an empty line between products
			}
			// Print the total cost
			System.out.println("Total: $" + shoppingCartService.calculateTotalCost());
		}
	}

	// Method to proceed with checkout
	public void checkout() {
		if (shoppingCartService.getProductsInCart().isEmpty()) {
			System.out.println("Your shopping cart is empty.");
			return;
		}

		System.out.println("Order placed successfully!");
		shoppingCartService.clearCart();
	}
}
