package controller;
import model.Customer;
import model.ListUsers;


public class CustomerController {
    ListUsers userList;
    
    public boolean validateCustomer(String email, String password){
        for (Customer c : this.userList.getCustomers()){
            if (c.getEmail().equals(email) && c.getPassword().equals(password)){
                return true;
            }}
        return false;   
    }

}
