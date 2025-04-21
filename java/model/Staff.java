package model;

import java.io.Serializable;

public class Staff extends User implements Serializable{
    private int id;
    private String email;
    private String password;
    public boolean manager = false;

    public Staff(String firstName, String lastName, String email,int id, String password){
        super(firstName, lastName, email);
        this.id = id;
        this.password = password;
    }


    public void createEmail(String firstName, String lastName){
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@iotbay.com.au";
    }

    public void makeManager(){
        this.manager = true;
    }

    public String getPassword(){
        return this.password;
    }

    public String getEmail(){
        return this.email;
    }

/* 
    public String details(){
        if (this.manager){
            return "Manager ID: #" + this.id +  "\n" + this.firstName + " " + this.lastName; } 
         else {
            return "Staff ID: #" + this.id +  "\n" + this.firstName + " " + this.lastName; }
    }
*/
    @Override
    public String toString(){
        if (this.manager){
            return "Manager ID: #" + this.id +  "\n" + this.firstName + " " + this.lastName; } 
         else {
            return "Staff ID #" + this.id +  ": " + this.firstName + " " + this.lastName; }

    }


}
