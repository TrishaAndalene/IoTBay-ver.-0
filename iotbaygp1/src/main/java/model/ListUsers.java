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

    public void createCustomer(String firstName, String lastName, String email, String password){
        customers.add(new Customer(firstName, lastName, email, password));  
    }

    public void createStaff(String firstName, String lastName, int id, String password){
        staff.add(new Staff(firstName, lastName, id, password));
    }

    public void addManager(Staff staff){
        if (staff.managerPermissions){
            managers.add(staff);
        }
    }


    public ListUsers demoUsers(){
        this.createStaff("Michael", "Scott", 1000, "password");
        this.createStaff("Jim", "Halpert", 1001, "password");
        this.createStaff("Kevin", "Malone", 1002, "password");

        this.createCustomer("Robert", "California", "robertcalifornia@dundermifflin.com", "winecellar");
        this.createCustomer("Jan", "Levinson", "janlevinson@scentedcandles.com", "password");
        this.createCustomer("Example", "Customer", "example@example.com", "password");

        return this;
    }
    


}
