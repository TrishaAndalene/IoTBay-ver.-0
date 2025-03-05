package Database;
import java.io.Serializable;
import java.util.Scanner;

public class User implements Serializable {
    // private int userID;
    private static final Long serialVersionUID = 0501L;
    private String firstName;
    private String lastName;
    private String email;
    private String password ;
    private int phoneNum;
    private String userType;
    private String address = null;
    

    public User(String firstName, String lastName, String email, String password, int phoneNum){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNum = phoneNum ;
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

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public int getPhoneNum(){
        return this.phoneNum ;
    }

    public void setPhoneNum(int phoneNum){
        this.phoneNum = phoneNum;
    }

    public String getUserType(){
        return this.userType;
    }

    public void setUserType(String userType){
        this.userType = userType;
    }

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String address){
        this.address = address;
    }


    public String printUserDetails(){
        return this.firstName + " " + this.lastName + "\n" + this.email + "\n" + this.firstName + " is a " + this.userType;
    }

    public boolean isStaff(){
        if (this.userType == "Staff"){
            return true;
        }
        return false;
    }

    public boolean isStaffAdmin(){
        if (this.userType == "Staff Admin"){
            return true;
        }
        return false;
    }


    public void createUser(String firstName, String lastName, String email, String password, int phoneNum){
        Scanner input = new Scanner(System.in);
        System.out.println("Hello welcome to creating a user");

        System.out.println("Enter first name:");
        String createFirst = input.next();

        System.out.println("Enter last name:");
        String createLast = input.next();

        System.out.println("Enter email:");
        String createEmail = input.next();

        System.out.println("Enter password:");
        String createPassword = input.next();

        System.out.println("Enter phone number:");
        int createPhoneNum = input.nextInt();
        
        User newUser = new User(createFirst, createLast, createEmail, createPassword, createPhoneNum);
        newUser.printUserDetails();

        input.close();
    }
}