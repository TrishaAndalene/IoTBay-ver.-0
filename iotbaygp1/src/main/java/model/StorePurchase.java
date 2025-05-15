package model;

import java.util.List;

public class StorePurchase {
    private int cartID;
    private String status = "Purchase";
    private int customerID;
    private int salespersonID;

    public StorePurchase (int salespersonID, int cartID, int customerID){
        this.cartID = cartID;
        this.salespersonID = salespersonID;
        this.customerID = customerID;
    }

    public int getCartID() {
        return this.cartID;
    }

    public void setSalesperson(int salespersonID){
        this.salespersonID = salespersonID;   
    }

    public int getSalesperson(){
        return this.salespersonID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }

    public void setCustomer(int customerID){
        this.customerID = customerID;
    }

    public int getCustomer(){
        return this.customerID;
    }

    public double getTotalCost(List<CartItem> products) {
        double total = 0.00;
        // work out how to add this in later - could be taking in a list of the products 
        return total;
    }
}
