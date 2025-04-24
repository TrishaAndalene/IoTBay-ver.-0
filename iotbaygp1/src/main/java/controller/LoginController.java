package controller;
import model.In;


public class LoginController {
    CustomerController customerController = new CustomerController();
    StaffController staffController = new StaffController();


    public void customerLogin(){
        System.out.print("email: ");
        String email = In.nextLine();
        System.out.print("password: ");
        String password = In.nextLine();

        try {
            customerController.validateCustomer(email, password);
        } catch (Exception e) {
            System.out.println("No customer exists");
        }}

    public void staffLogin(){
        System.out.print("email: ");
        String email = In.nextLine();
        System.out.print("password: ");
        String password = In.nextLine();
    
        try {
                staffController.validateStaff(email, password);
            } catch (Exception e) {
                System.out.println("No staff exists");
            }      
        }


    }
