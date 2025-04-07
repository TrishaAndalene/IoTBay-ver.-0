package model;

import java.util.ArrayList;

public class ListUsers {
    public ArrayList<Customer> customers = new ArrayList<>();
    public ArrayList<Staff> staff = new ArrayList<>();
    public ArrayList<Staff> managers = new ArrayList<>();



    public ArrayList<Customer> getCustomers(){
        return this.customers;
    }

    public ArrayList<Staff> getStaff(){
        return this.staff;
    }

    public ArrayList<Staff> getManager(){
        return this.managers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public void setStaff(ArrayList<Staff> staff) {
        this.staff = staff;
    }

    public void setManager(Staff staff){
        if (staff.managerPermissions){
            managers.add(staff);
        }
    }

    public ArrayList<Staff> getManagers() {
        return managers;
    }

    public void setManagers(ArrayList<Staff> managers) {
        this.managers = managers;
    }


    

    

    

    

    
    


}
