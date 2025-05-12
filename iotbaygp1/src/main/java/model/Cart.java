package model;

import java.io.Serializable;
import java.util.List;

// Cart Object (partially dependent on Customer.java)
public class Cart implements Serializable{
    private int cartID;
    private final int userID;
    private String status;

    // Constructor for non-registered customer
    public Cart(int userID){
        this.userID = userID;
    }

    public int getCartID() {
        return cartID;
    }

    public int getUserID() {
        return userID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalCost(List<CartItem> products) {
        double total = 0.00;
        // work out how to add this in later - could be taking in a list of the products 
        return total;
    }

    

}