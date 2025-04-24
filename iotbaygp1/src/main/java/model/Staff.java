package model;

import java.io.Serializable;

public class Staff implements Serializable{
    private String firstName, lastName, email, password, phoneNum;

    public Staff(String firstName, String lastName, String email, String phoneNum, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.password = password;
    }


    public void createEmail(String firstName, String lastName){
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@iotbay.com.au";
    }

    public String getPassword(){
        return this.password;
    }

    public String getEmail(){
        return this.email;
    }


    public String toString(){
            return "Staff ID #" + this.email +  ": " + this.firstName + " " + this.lastName; 
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
