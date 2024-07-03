package com.bptn.olubunmi.online_shopping_system.data;


/*
 The product in this online shopping system.
 */
public class Product {
    private int id;             // Unique identifier for the product
    private String name;        // Name of the product
    private String description; // Description of the product
    private double price;       // Price of the product
    private int quantity;       // Available quantity of the product
    
    /*
      Constructs a new Product object.
      
      id Unique identifier
     name Name of the product
      description Description of the product
     price Price of the product
      quantity Available quantity of the product
     */
    
    public Product(int id, String name, String description, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
    
    /*
      Retrieves the unique identifier of the product.
      
      The ID of the product
     */
    public int getId() {
        return id;
    }
    
    /*
      Retrieves the name of the product.
      
      The name of the product
     */
    public String getName() {
        return name;
    }
    
    /*
      Retrieves the description of the product.
      
      The description of the product
     
    public String getDescription() {
        return description;
    }
    
    /*
      Retrieves the price of the product.
      
      The price of the product
     */
    public double getPrice() {
        return price;
    }
    
    /*
     Retrieves the available quantity of the product.
      
      @return The available quantity of the product
     */
    public int getQuantity() {
        return quantity;
    }
    
    /*
     Returns a string representation of the Product object.
      A string representation including the ID, name, description, price, and quantity of the product
     */
    
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
