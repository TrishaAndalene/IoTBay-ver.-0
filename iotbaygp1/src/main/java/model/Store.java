package model;
import java.util.ArrayList;


public class Store {
    ListUsers users;
    ListItems products;

    public Store(ListUsers users, ListItems products){
        this.users = users;
        this.products = products;
    }

    public void Use(){
        
        System.out.println("Welcome to the store");
        ArrayList<Customer>customers = this.users.getCustomers();
        for (Customer customer : customers){
            System.out.println(customer);
        }

    
        ArrayList<Staff>staff = this.users.getStaff();
        for (Staff stf : staff){
            System.out.println(stf);
        }
        
        for (Product p : this.products.getProductsByBrand("Apple")){
            System.out.println(p);
        }
       
        
           


    for (Product p : this.products.getProductsByColour("Black")){
            System.out.println(p);
        }

        for (Product p : this.products.getProductsByPrice(50.0, 200.0)){
            System.out.println(p);
        }

        for (Product p : this.products.getProductsByCategory("Apple")){
        System.out.println(p);
        }

    }
    
    
}
