package model;
import java.io.Serializable;

public abstract class User implements Serializable {
    // private int userID;

    @SuppressWarnings("unused")
    private static final Long serialVersionUID = 0501L;
    protected String firstName;
    protected String lastName;
    

    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
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

    @Override
    public String toString(){
        return this.firstName + " " + this.lastName ;
    }

    }