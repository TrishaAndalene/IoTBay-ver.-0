package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Type;

public class Payment implements Serializable{

    private String name;
    private String cardNumber;
    private Type type;
    private double amount;
    private LocalDateTime date;
    private int customerID;
    private String orderID;

    public Payment(int customerID, String name, String cardNumber, Type type, double amount, LocalDateTime date) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.customerID = customerID;
        this.orderID = null;
    }
   
    public String getName() {
        return name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Type getType() {
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

    public void setType(Type type) {
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

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

}
    

