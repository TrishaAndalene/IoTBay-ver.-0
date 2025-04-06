package model;

import java.io.Serializable;

public class Order implements Serializable{
    private final Cart cart;
    private final Customer customer;
    private String paymentReference;
    private String status;
    private String address;
    private String delivery;
    private Double totalCost;


    public Order(Cart cart){
        this.cart = cart;
        this.customer = cart.getCustomer();
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public void setPayRef(String ref){
        this.paymentReference = ref;
    }

    public String getPayRef(){
        return this.paymentReference;
    }

    public void setAddress(Cart cart){
        if (!cart.getCustomer().getAddress().isEmpty()){
            this.address = cart.getCustomer().getAddress();}
    }

    public void setDelivery(String delivery){
        this.delivery = delivery;
    }

    public String getDelivery(){
        return this.delivery;
    }

    public Double getTotalCost(){
        Double cartCost = this.cart.getTotalCost();
        Double shipping = 0.00;
        switch (this.delivery){
            case "express" : shipping = 15.00;
            case "overnight": shipping = 20.00;
            default: shipping = 9.00;
        }
        this.totalCost += cartCost + shipping;
        return this.totalCost;
    }

    public void changeStatus(String status){
        this.status = status;
    }

    @Override
    public String toString(){
        return "Order details:\n" + this.cart.getProducts() + " with " + this.delivery + " delivery comes to a total of $" + this.totalCost;
    }



}
