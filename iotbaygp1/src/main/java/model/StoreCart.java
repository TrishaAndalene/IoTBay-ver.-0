package model;

import java.util.List;

public class StoreCart {
    private int cartID;
    private final String firstName;
    private final String lastName;
    private String status;
    private Customer customer = null;

    // Constructor for non-registered customer
    public StoreCart(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getCartID() {
        return this.cartID;
    }

    public String getStaffName() {
        return this.firstName + " " + this.lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public double getTotalCost(List<CartItem> products) {
        double total = 0.00;
        // work out how to add this in later - could be taking in a list of the products 
        return total;
    }
}
