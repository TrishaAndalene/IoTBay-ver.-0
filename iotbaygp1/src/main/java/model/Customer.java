package model;
import java.io.Serializable;


public class Customer implements Serializable{
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int phoneNum;
    private String address = null;
    
    public Customer(){

    }

    public Customer(String firstName, String lastName, String email, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public void changePassword(String password){
        this.password = password;
    }

    public int getPhoneNum(){
        return this.phoneNum ;
    }

    public void setPhoneNum(int phoneNum){
        this.phoneNum = phoneNum;
    }

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String address){
        this.address = address;
    }


    public String details(){
        return "Customer:" + this.firstName + " " + this.lastName + "\n" + this.email;
    }

    @Override
    public String toString(){
        return "Customer:" + this.firstName + " " + this.lastName + "\n" + this.email;
    }
}
