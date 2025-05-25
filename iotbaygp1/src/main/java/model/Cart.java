package model;

import java.io.Serializable;
import java.util.List;

// Cart Object (partially dependent on Customer.java) is used only for a temporary container
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

    // this is not used currently
    public double getTotalCost(List<CartItem> products) {
        double total = 0.00;
        return total;
    }
}