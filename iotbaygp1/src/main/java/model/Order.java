
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

enum Status{
    RECEIVED, PROCESSED, ONDELIVERY, FINISHED, CANCELLED;
}

// Order Object (dependent on Cart.java)
public class Order implements Serializable{
    // Attributes lists

    private int customerID, paymentID;
    private String orderID, date;
    private Status status;
    private double cost;

    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Constructor
    public Order(int customerID, double cost){
        this.status = Status.RECEIVED;
        this.date = LocalDate.now().format(dateFormat);
        System.out.println(date); // -> debugging
        this.orderID = this.generateRandomStringList(1, 8);
        this.customerID = customerID;
        this.cost = cost;
    }

    public Order(String code, int customerID, String date, double cost, int paymentID){
        this.status = Status.RECEIVED;
        this.customerID = customerID;
        this.orderID = code;
        this.date = date;
        this.cost = cost;
        this.paymentID = paymentID;
    }

    public Order(String code, int customerID, String date, double cost, String status){
        this.status = this.getStatus(status);
        this.customerID = customerID;
        this.orderID = code;
        this.date = date;
        this.cost = cost;
    }

    // randomiser code (don't know if it's work yet)
    public static String generateRandomStringList(int numberOfStrings, int stringLength) {
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

    public Status updateStatus(String status){
        if (status.equalsIgnoreCase("Received")){
            return Status.RECEIVED;
        } else if (status.equalsIgnoreCase("Processed")){
            return Status.PROCESSED;
        } else if (status.equalsIgnoreCase("On delivery")){
            return Status.ONDELIVERY;
        } else if (status.equalsIgnoreCase("Finished")){
            return Status.FINISHED;
        } else if (status.equalsIgnoreCase("Cancelled")){
            return Status.CANCELLED;
        }
        return Status.FINISHED;
    }

    // Read methods
    public String getOrderId(){
        return this.orderID;
    }

    public double getCost(){
        return this.cost;
    }

    public String getDate(){
        return this.date;
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

    public Status getStatus(String status){
        if (status.equalsIgnoreCase("Received")){
            return Status.RECEIVED;
        } else if (status.equalsIgnoreCase("Processed")){
            return Status.PROCESSED;
        } else if (status.equalsIgnoreCase("On delivery")){
            return Status.ONDELIVERY;
        } else if (status.equalsIgnoreCase("Finished")){
            return Status.FINISHED;
        } else if (status.equalsIgnoreCase("Cancelled")){
            return Status.CANCELLED;
        }
        return Status.FINISHED;
    }

    public String toString(){
        return "Order code : " + this.getOrderId() + " | Total Cost: " + this.getCost() + " | Status : " + this.getStatus();
    }
}