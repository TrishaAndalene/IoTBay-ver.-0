package model;

import java.util.List;

public class StoreCart {
    private int cartID;
    private int staffID;
    private String status;
    private int customerID;
    private int salespersonID;


    public StoreCart (int staffID, int cartID){
        this.cartID = cartID;
    }

    public int getCartID() {
        return this.cartID;
    }

    public int getStaffID(){
        return this.staffID;
    }

    public void setSalesperson(int salespersonID){
        this.salespersonID = salespersonID;   
    }

    public int getSalesperson(){
        return this.salespersonID;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
