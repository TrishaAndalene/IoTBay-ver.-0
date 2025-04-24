package controller;

import model.Customer;

public class Authorize {
    String firstName;
    String lastName;
    String email;
    String password;
    String phoneNumber;

    public Authorize(String firstName, String lastName, String email, String password, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public boolean authorize(){
        if(this.firstName != null && this.lastName != null && this.email != null && this.password != null && this.phoneNumber != null){
            return true;
        }else{
            return false;
        }
    }
}
