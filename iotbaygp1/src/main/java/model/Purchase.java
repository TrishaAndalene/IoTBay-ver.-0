package model;

import java.io.Serializable;

// Purchase Object (To store Cart items and quantity)
public class Purchase implements Serializable{

    // Attributes
    public Product product;
    public int quantity;

    // Constructor
    public Purchase(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    // Update methods
    public void addQuantity(int addition){
        if (this.product.getQuantity() >= (this.quantity + addition)){
            this.quantity += addition;
        } else {
            System.out.println("Out of Stock");
        }
    }

    public void substractQuantity(int substract){
        if (this.quantity != 0){
            this.quantity -= substract;
        } else {
            System.out.println("Error object does not exist");
        }
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    // Read methods
    public Product getProduct(){
        return this.product;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public double getTotalCost(){
        return this.quantity*this.product.getPrice();
    }

    public String toString() {
        return "Quantity: " + this.quantity + " | " + this.product.toString();
    }

}
