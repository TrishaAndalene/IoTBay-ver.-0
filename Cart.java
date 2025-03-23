package javafiles.model;

public class Cart {
    private Customer customer;
    private Products products;
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

    public Products getProducts(){
        return this.products;
    }

    public Double getTotalCost(){
        return this.totalCost;
    }

}
