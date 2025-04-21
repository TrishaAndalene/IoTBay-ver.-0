package model;
import java.util.ArrayList;

import controller.Validator;


public class Store {
    ListUsers users;
    ListItem products;
    Validator vldtr = new Validator();

    public Store(ListUsers users, ListItem products){
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
        
        for (Product p : this.products.searchBrand("Apple")){
            System.out.println(p);
        }
       
        
           


    for (Product p : this.products.searchColour("Black")){
            System.out.println(p);
        }

        for (Product p : this.products.searchPrice(50.0, 200.0)){
            System.out.println(p);
        }

        for (Product p : this.products.searchCategory(Categories.ACTIVITY_TRACKERS)){
        System.out.println(p);
        }
/*  
        
     System.out.print("email: ");
     String email = In.nextLine();
     System.out.print("password: ");
     String password = In.nextLine();

     if (!vldtr.validateEmail(email)){
        System.out.println("not valid email");
     } else if (!vldtr.validatePassword(password)){
        System.out.println("not valid password");
     } else {
        System.out.println("success!");
     }
*/
       
    }
    
    
    public static void main(String[] args){
        
    }
}
