package controller;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private final String nameValidation = "([A-Za-z]+)";
    private final String passwordValidation = "([a-zA-Z0-9]+){8,}";
    private final String emailValidation = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{2})((([.])[a-z]{0,2})*)";

    public Validator(){}

    public boolean validate(String ptrn, String input){
        Pattern pattern = Pattern.compile(ptrn);
        Matcher match = pattern.matcher(input);
        return match.matches();
    }   

    public boolean checkEmpty(String email, String password){
        return email.isEmpty() || password.isEmpty();
    }

    public boolean validateEmail(String email){
        return validate(this.emailValidation, email);
    }

    public boolean validatePassword(String password){
        return validate(this.passwordValidation, password);
    }

    public boolean validateName(String name){
        return validate(this.nameValidation, name);
    }
}
