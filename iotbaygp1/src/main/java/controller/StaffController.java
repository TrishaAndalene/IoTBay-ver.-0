package controller;

import model.ListUsers;
import model.Staff;


public class StaffController {

    private ListUsers userList;
    
    public boolean validateStaff(String email, String password){
        for (Staff s : this.userList.getStaff()){
            if (s.getEmail().equals(email) && s.getPassword().equals(password)){
                return true;
            }}
        return false;   
    }



}
