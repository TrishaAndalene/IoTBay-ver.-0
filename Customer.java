package javafiles.model;
import java.util.ArrayList;

public class Customer extends User {
    private final String email;
    private String password;
    private int phoneNum;
    private String address = null;
    private ArrayList<Order> orders = new ArrayList<>();
    


    public Customer(String firstName, String lastName, String email, String password){
        super(firstName, lastName);
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

    public void addOrder(Order order){
        this.orders.add(order);
    }

    public ArrayList<Order> getOrders(){
        return this.orders;
    }

    public String details(){
        return "Customer:" + this.firstName + " " + this.lastName + "\n" + this.email;
    }

    @Override
    public String toString(){
        return "Customer:" + this.firstName + " " + this.lastName + "\n" + this.email;
    }
}