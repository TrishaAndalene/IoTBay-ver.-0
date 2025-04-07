package model;

public class Staff extends User {
    private final int id;
    private String email;
    private String password;
    public boolean managerPermissions = false;

    public Staff(String firstName, String lastName, int id, String password){
        super(firstName, lastName);
        this.id = id;
        this.password = password;
        this.createEmail(firstName, lastName);
    }


    public final void createEmail(String firstName, String lastName){
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@iotbay.com.au";
    }

    public void makeManager(){
        this.managerPermissions = true;
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
        if (this.managerPermissions){
            return "Manager ID: #" + this.id +  "\n" + this.firstName + " " + this.lastName; } 
         else {
            return "Staff ID #" + this.id +  ": " + this.firstName + " " + this.lastName; }

    }

    public void setPassword(String password) {
        this.password = password;
    }


}
