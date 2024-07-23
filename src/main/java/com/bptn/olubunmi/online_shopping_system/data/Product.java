
package com.bptn.olubunmi.online_shopping_system.data;

public class Product {
	private String name;
	private String description;
	private double price;
	private int quantity;

	// Constructor to initialize Product with name, description, price, and
	// quantity.
	public Product(String name, String description, double price, int quantity) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	// Getter for name
	public String getName() {
		return name;
	}

	// Setter for name
	public void setName(String name) {
		this.name = name;
	}

	// Getter for description
	public String getDescription() {
		return description;
	}

	// Setter for description
	public void setDescription(String description) {
		this.description = description;
	}

	// Getter for price
	public double getPrice() {
		return price;
	}

	// Setter for price
	public void setPrice(double price) {
		this.price = price;
	}

	// Getter for quantity
	public int getQuantity() {
		return quantity;
	}

	// Setter for quantity
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

//	toString method to return a string representation of the Product
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}

	
}
