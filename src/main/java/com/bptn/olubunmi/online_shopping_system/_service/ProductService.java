package com.bptn.olubunmi.online_shopping_system._service;

import com.bptn.olubunmi.online_shopping_system.data.Product;
import java.util.List;

// Service class for managing products in the online shopping system.
public class ProductService {
	private List<Product> products; // List to hold Product objects, encapsulating product data.

	// Constructor to initialize ProductService with a list of products.
	public ProductService(List<Product> products) {
		this.products = products; // Assign the provided list to the products field.
	}

	// Adds a new product to the list of products.
	public void addProduct(Product newProduct) {
		products.add(newProduct); // Add the new product to the list.
	}

	// Overloaded method to add a product using individual parameters.
	public void addProduct(String name, String description, double price, int quantity) {
		Product newProduct = new Product(name, description, price, quantity); // Create a new Product instance.
		products.add(newProduct); // Add the newly created product to the list.
	}

	// Updates an existing product's details based on the provided updated product.
	public void updateProduct(Product updatedProduct) {
		for (Product product : products) {
			// Check if the product's name matches the updated product's name.
			if (product.getName().equals(updatedProduct.getName())) {
				product.setName(updatedProduct.getName()); // Update the product's name.
				product.setDescription(updatedProduct.getDescription()); // Update the product's description.
				product.setPrice(updatedProduct.getPrice()); // Update the product's price.
				product.setQuantity(updatedProduct.getQuantity()); // Update the product's quantity.
				break; // Exit the loop once the product is updated.
			}
		}
	}

	// Overloaded method to update a product using individual parameters.
	public void updateProduct(String name, String description, double price, int quantity) {
		for (Product product : products) {
			// Check if the product's name matches the provided name.
			if (product.getName().equals(name)) {
				product.setName(name); // Update the product's name.
				product.setDescription(description); // Update the product's description.
				product.setPrice(price); // Update the product's price.
				product.setQuantity(quantity); // Update the product's quantity.
				break; // Exit the loop once the product is updated.
			}
		}
	}

	// Retrieves a product by its name.
	public Product getProductByName(String name) {
		for (Product product : products) {
			// Check if the product's name matches the provided name.
			if (product.getName().equals(name)) {
				return product; // Return the product if found.
			}
		}
		return null; // Return null if no product with the specified name is found.
	}

	// Retrieves all products.
	public List<Product> getAllProducts() {
		return products; // Return the list of all products.
	}
}
