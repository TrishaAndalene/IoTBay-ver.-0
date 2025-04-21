package model;
import java.io.Serializable;


public class Customer extends User implements Serializable{
    // Attributes
    private String password, phoneNum;

    // Constructor
    Customer(String firstName, String lastName, String email, String password, String phoneNum){
        super(firstName, lastName, email);
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
    @Override
    public void deleteAllDetails(){
        super.deleteAllDetails();
        this.password = null;
        this.phoneNum = null;
    }

    // updated toString methods
    @Override
    public String toString(){
        return super.toString() + "\n - Password: " + this.getHashedPassword() + " (" + this.getPassword() + ")\n - Phone number: " + this.getPhoneNum();
    }
}
