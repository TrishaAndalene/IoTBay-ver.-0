package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

enum Status{
    RECEIVED, PROCESSED, ONDELIVERY, FINISHED, CANCELLED;
}

// Order Object (dependent on Cart.java)
public class Order implements Serializable{
    // Attributes lists
    private Status status;
    private Customer customer;
    private String name, code;
    private ArrayList<Purchase> orderList;
    private double cost;

    // Constructor
    public Order(Cart cart, String code){
        this.status = Status.RECEIVED;
        this.customer = cart.getCustomer();
        this.orderList = cart.getList();
        this.cost = cart.getTotalCost();
        this.code = code;
        try {
            this.name = this.customer.getFirstName();
            this.customer.addOrder(this.code);
        } catch (NullPointerException e){
            this.name = "anonymous";
        }

        if (this.code.equals("")){
            this.code = this.generateRandomStringList(1, 8);
        }
    }

    // Update methods
    public void setName(String newName){
        this.name = newName;
    }

    // randomiser code (don't know if it's work yet)
    public String generateRandomStringList(int numberOfStrings, int stringLength) {
        List<String> stringList = new ArrayList<>();
        Random random = new Random();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String result = "";

        for (int i = 0; i < numberOfStrings; i++) {
            StringBuilder sb = new StringBuilder(stringLength);
            for (int j = 0; j < stringLength; j++) {
                int randomIndex = random.nextInt(characters.length());
                sb.append(characters.charAt(randomIndex));
            }
            stringList.add(sb.toString());
        }

        for (int n = 0; n < stringList.size(); n++){
            result += stringList.get(n);
        }

        return result;
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

    public String getCode(){
        return this.code;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Purchase> getList(){
        return this.orderList;
    }

    public double getCost(){
        return this.cost;
    }

    public String getStatus(){
        if (this.status == Status.RECEIVED){
            return "Received";
        } else if (this.status == Status.PROCESSED){
            return "Processed";
        } else if (this.status == Status.ONDELIVERY){
            return "On delivery";
        } else if (this.status == Status.FINISHED){
            return "Finished";
        } else {
            return "Cancelled";
        }
    }

    public String toString(){
        return "Order code : " + this.getCode() + " | Customer name: " + this.getName() + " | Items : " + this.getList() + " | Total Cost: " + this.getCost() + " | Status : " + this.getStatus();
    }
}
