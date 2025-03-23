package javafiles.model;
import java.util.ArrayList;

public class Store {
    Users users;
    Products products;

    public Store(Users users, Products products){
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
        ArrayList<Product> products = this.products.getProducts();
        for (Product p : products){
            System.out.println(p);
        }
       
    }
    
    
    public static void main(String[] args){
        

        Users exampleUsers = new Users().demoUsers();
        Products exampleProducts = new Products().demoProducts();

        new Store(exampleUsers, exampleProducts).Use();
    }
}
