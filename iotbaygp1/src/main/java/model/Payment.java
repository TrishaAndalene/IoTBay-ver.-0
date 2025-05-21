package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Payment implements Serializable{

    private String name;
    private String cardNumber;
    private String type;
    private double amount;
    private LocalDate date;
    private int customerID;
    private String orderID;


    // for new 
    public Payment(String name, String cardNumber, String type) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.type = type;
    }

    // for db
    // public Payment(int customerID, String name, String cardNumber, String type, double amount, LocalDateTime date, String orderID) {
    public Payment(int customerID, String name, String cardNumber, String type) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.type = type;
        this.customerID = customerID;
    }

    public Payment(String orderID, int customerID,  String name, String cardNumber, String type, double amount, LocalDate date) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.name = name;
        this.cardNumber = cardNumber;
        this.type = type;
        this.amount = amount;
        this.date = date;

    }
   
   
    public String getName() {
        return name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return this.date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd E HH:mm:ss"));
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    // public String getOrderID() {
    //     return orderID;
    // }

    // public void setOrderID(String orderID) {
    //     this.orderID = orderID;
    // }

}
    

