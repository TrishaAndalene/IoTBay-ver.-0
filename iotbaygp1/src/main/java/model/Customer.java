package model;
import java.io.Serializable;


public class Customer implements Serializable{
    // Attributes
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNum;

    // Constructor
    public Customer(String firstName, String lastName, String email, String phoneNum, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNum = phoneNum;
    }

    // Update methods
    public void setPassword(String newPassword){
        this.password = newPassword;
    }

    public void setPhoneNum(String newPhoneNum){
        this.phoneNum = newPhoneNum;
    }

    // Read methods
    public String getPassword(){
        return this.password;
    }

    public String getHashedPassword(){
        String hashedPassword = "";
        for (char i : this.password.toCharArray()){
            hashedPassword += "*";
        }
        return hashedPassword;
    }

    public String getPhoneNum(){
        return this.phoneNum;
    }

    // Delete methods
    public void deleteAllDetails(){
        this.firstName = null;
        this.lastName = null;
        this.email = null;
        this.password = null;
        this.phoneNum = null;
    }

    // updated toString methods
    @Override
    public String toString(){
        return super.toString() + "\n - Password: " + this.getHashedPassword() + " (" + this.getPassword() + ")\n - Phone number: " + this.getPhoneNum();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
