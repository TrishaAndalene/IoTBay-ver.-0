package model;

import java.io.Serializable;
import java.util.ArrayList;

enum Status{
    RECEIVED, PROCESSED, ONDELIVERY, FINISHED, CANCELLED;
}

// Order Object (dependent on Cart.java)
public class Order implements Serializable{
    // Attributes lists
    private Status status;
    private Customer customer;
    private String name;
    private ArrayList<Purchase> orderList;
    private double cost;

    // Constructor
    Order(Cart cart){
        this.status = Status.RECEIVED;
        this.customer = cart.getCustomer();
        this.orderList = cart.getList();
        try {
            this.name = this.customer.getFirstName();
        } catch (NullPointerException e){
            this.name = "anonymous";
        }
        this.cost = cart.getTotalCost();
    }

    // Update methods
    public void setName(String newName){
        this.name = newName;
    }

    public void updateStatus(int code){
        if (code == 0){
            this.status = Status.RECEIVED;
        } else if (code == 1){
            this.status = Status.PROCESSED;
        } else if (code == 2){
            this.status = Status.ONDELIVERY;
        } else if (code == 3){
            this.status = Status.FINISHED;
        } else if (code == 4){
            this.status = Status.CANCELLED;
        } else {
            System.out.println("Invalid Code Detected");
        }
    }

    // Read methods
    public void getAllList(){
        if (this.orderList.size() != 0){
            for (Purchase p : this.orderList){
                // command here to show on the html
            }
        } else {
            // command here to show on the html
        }
    }
}
