package model;

import java.util.List;

public class StorePurchase {
    private int purchaseID;
    private String transType;
    private int customerID;
    private int salespersonID;
    

    public StorePurchase (int salespersonID, int purchaseID, int customerID, String transType){
        this.purchaseID = purchaseID;
        this.salespersonID = salespersonID;
        this.customerID = customerID;
        this.transType = transType;
    }

    public int getPurchaseID() {
        return this.purchaseID;
    }

    public void setSalespersonID(int salespersonID){
        this.salespersonID = salespersonID;   
    }

    public int getSalespersonID(){
        return this.salespersonID;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getTransType(){
        return this.transType;
    }

    public void setCustomerID(int customerID){
        this.customerID = customerID;
    }

    public int getCustomerID(){
        return this.customerID;
    }

    public double getTotalCost(List<CartItem> products) {
        double total = 0.00;
        // work out how to add this in later - could be taking in a list of the products 
        return total;
    }
}
