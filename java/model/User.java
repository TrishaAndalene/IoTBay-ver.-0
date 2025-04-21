package model;
import java.io.Serializable;

// Abstract class (for Customer and Staff)
public abstract class User implements Serializable {

    @SuppressWarnings("unused")
    // Attributes
    protected String firstName, lastName, email;
    protected static final Long serialVersionUID = 0501L; // not implemented yet

    // Constructor
    User(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Update methods
    public void setFirstName(String newFirstName){
        this.firstName = newFirstName;
    }

    public void setLastName(String newLastName){
        this.lastName = newLastName;
    }

    public void setEmail(String newEmail){
        this.email = newEmail;
    }

    // Read methods
    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getEmail(){
        return this.email;
    }

    // Delete methods
    public void deleteAllDetails(){
        this.email = null;
        this.firstName = null;
        this.lastName = null;
    }

    // ToString methods
    public String toString(){
        return "User details: \n - First name: " + this.getFirstName() + "\n - Last name: " + this.getLastName() + "\n - Email: " + this.getEmail();
    }

}