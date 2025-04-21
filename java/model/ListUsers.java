package model;

import java.util.ArrayList;

public class ListUsers {
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Staff> staff = new ArrayList<>();
    private ArrayList<Staff> managers = new ArrayList<>();



    public ArrayList<Customer> getCustomers(){
        return this.customers;
    }

    public ArrayList<Staff> getStaff(){
        return this.staff;
    }

    public ArrayList<Staff> getManager(){
        return this.managers;
    }

    public void createStaff(String firstName, String lastName, String email, int id, String password){
        staff.add(new Staff(firstName, lastName, email, id, password));
    }

    public void addManager(Staff staff){
        if (staff.manager){
            managers.add(staff);
        }
    }


    public ListUsers demoUsers(){
        this.createStaff("Michael", "Scott", "aaaa", 1000, "password");
        this.createStaff("Jim", "Halpert", "bbbb", 1001, "password");
        this.createStaff("Kevin", "Malone", "cccc",1002, "password");

        // this.createCustomer("Robert", "California", "robertcalifornia@dundermifflin.com", "winecellar");
        // this.createCustomer("Jan", "Levinson", "janlevinson@scentedcandles.com", "password");
        // this.createCustomer("Example", "Customer", "example@example.com", "password");

        return this;
    }
    


}
