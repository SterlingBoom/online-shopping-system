package com.bptn.olubunmi.online_shopping_system._service;

import com.bptn.olubunmi.online_shopping_system.data.Product;



import java.util.List;

// Service class for managing products in the online shopping system.

public class ProductService {
    private List<Product> products; // List to hold Product objects

    
//    Parameterized Constructor to initialize ProductService with a list of products.
     
    public ProductService(List<Product> products) {
        this.products = products;
    }

    
//      Adds a new product to the list of products.
     
    public void addProduct(Product newProduct) {
        products.add(newProduct);
    }

    
//     Updates an existing products details based on the provided updated product.
     
    public void updateProduct(Product updatedProduct) {
        for (Product product : products) {
            if (product.getId() == updatedProduct.getId()) {
                // Update product details
                product.setName(updatedProduct.getName());
                product.setDescription(updatedProduct.getDescription());
                product.setPrice(updatedProduct.getPrice());
                product.setQuantity(updatedProduct.getQuantity());
                break; // Exit loop once product is updated
            }
        }
    }

    
//     Retrieves a product by its ID.
     
    public Product getProductById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product; // Return the product if found
            }
        }
        return null; // Return null if product with specified ID is not found
    }
}

