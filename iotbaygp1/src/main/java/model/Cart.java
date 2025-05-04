package model;

import java.io.Serializable;


// Java Library
import java.util.*;

// Cart Object (partially dependent on Customer.java)
public class Cart implements Serializable{
    private final Customer customer;
    private String code;
    private ArrayList<Purchase> products;
    private double totalCost;

    // Constructor
    public Cart(Customer customer, String code){
        this.customer = customer;
        this.products = new ArrayList<>();
        this.totalCost = 0;

        if (this.code.equals("")){
            this.code = Order.generateRandomStringList(1, 8);
        }
    }

    // Constructor for non-registered customer
    public Cart(){
        this.customer = null;
        this.products = new ArrayList<>();
        this.totalCost = 0;

        if (this.code.equals("")){
            this.code = Order.generateRandomStringList(1, 8);
        }
    }

    // Update methods
    public void addItemToCart(Purchase item){
        this.products.add(item);
    }

    public void addItemToCart(ArrayList<Purchase> items){
        this.products = items;
    }

    public void updateCost(){
        double cost = 0;
        for (Purchase p : this.products){
            cost += p.getTotalCost();
        }
        this.totalCost = cost;
    }

    // Read methods

    public Customer getCustomer(){
        return this.customer;
    }

    public ArrayList<Purchase> getList(){
        return this.products;
    }

    public double getTotalCost(){
        return this.totalCost;
    }

    public int getUniqueItemCount(){
        int count = 0;
        for (Purchase p : this.products){
            count++;
        }
        return count;
    }

    public int getTotalQuantity(){
        int total = 0;
        for (Purchase purchase : this.products){
            total += purchase.getQuantity();
        }
        return total;
    }

    // (this is to get the specific index of a product in the array)
    public int getProductIndex(String name){
        if (this.products.size() != 0){
            for (Purchase p : this.products){
                if (name.equals(p.product.getName())){
                    return this.products.indexOf(p);
                }
            }
        }
        return -1;
    }

    // Delete methods
    public void deleteItem(String name){
        if (this.products.size() != 0){
            for (Purchase p : this.products){
                if (name.equals(p.product.getName())){
                    this.products.remove(p);
                }
            }
        }
    }

    public void deleteAllItem(){
        if (this.products.size() != 0){
            for (Purchase p : this.products){
                this.products.remove(p);
            }
        }
    }

}