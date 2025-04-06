package model;

import java.io.Serializable;

public class Cart implements Serializable{
    private final Customer customer;
    private ListItems products;
    private Double totalCost;

    public Cart(Customer customer){
        this.customer = customer;
    }

    public void addProduct(Product p){
        this.products.addProduct(p);
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public ListItems getProducts(){
        return this.products;
    }

    public Double getTotalCost(){
        return this.totalCost;
    }

}
