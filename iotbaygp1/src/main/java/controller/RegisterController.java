package controller;

import model.Customer;
import model.ListUsers;
import model.Staff;

public class RegisterController {
    ListUsers userList;


    public void registerCustomer(String firstName, String lastName, String email, String password){
        userList.customers.add(new Customer(firstName, lastName, email, password));  
    }

    public void registerStaff(String firstName, String lastName, int id, String password){
        userList.staff.add(new Staff(firstName, lastName, id, password));

    }


}
