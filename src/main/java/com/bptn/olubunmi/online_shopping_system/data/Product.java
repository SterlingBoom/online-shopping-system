package com.bptn.olubunmi.online_shopping_system.data;

// The product in this online shopping system.
public class Product {
    private int id;             // Unique identifier for the product
    private String name;        // Name of the product
    private String description; // Description of the product
    private double price;       // Price of the product
    private int quantity;       // Available quantity of the product
    
    // Parameterized Constructor for the  new Product.
    
    public Product(int id, String name, String description, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
    
    // Retrieves the unique identifier of the product.
    // Returns the ID of the product
    public int getId() {
        return id;
    }
    
    // Retrieves the name of the product.
    // Returns the name of the product
    public String getName() {
        return name;
    }
    
    // Retrieves the description of the product.
    // Returns the description of the product
    public String getDescription() {
        return description;
    }
    
    // Retrieves the price of the product.
    // Returns the price of the product
    public double getPrice() {
        return price;
    }
    
    // Retrieves the available quantity of the product.
    // Returns the available quantity of the product
    public int getQuantity() {
        return quantity;
    }
    
    // Sets the name of the product.
    // name: The new name of the product
    public void setName(String name) {
        this.name = name;
    }
    
    // Sets the description of the product.
    // description: The new description of the product
    public void setDescription(String description) {
        this.description = description;
    }
    
    // Sets the price of the product.
    // price: The new price of the product
    public void setPrice(double price) {
        this.price = price;
    }
    
    // Sets the available quantity of the product.
    // quantity: The new quantity of the product
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    // Returns a string representation of the Product object.
    // Returns a string representation including the ID, name, description, price, and quantity of the product
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
