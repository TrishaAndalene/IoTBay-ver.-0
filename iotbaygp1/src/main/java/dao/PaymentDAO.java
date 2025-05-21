package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Payment;

public class PaymentDAO {
    private Connection conn;
    private Statement st;

    public PaymentDAO (Connection conn) throws SQLException {
        this.conn = conn;
        st = conn.createStatement();
    }

    public int setPayment(int customerID, String name, String cardNum, String type) throws SQLException {
        try {
            String query = "INSERT INTO Payments (customerID, name, cardNumber, type) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, customerID);
            ps.setString(2, name);
            ps.setString(3, cardNum);
            ps.setString(4, type);

            ps.executeUpdate();
            System.out.println("Payment saved to database.");
            
            String q3 = "SELECT" +" last_insert_rowid() AS id";
            ResultSet rs = st.executeQuery(q3);
            if (rs.next()) {
                return rs.getInt("id"); // returns generated cart ID
            } else {
                throw new SQLException("Failed to create payment.");
                    }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void savePayment(int customerID, String name, String cardNum, String type) throws SQLException {
        try {
            String query = "INSERT INTO SavedPayments (customerID, name, cardNumber, type) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, customerID);
            ps.setString(2, name);
            ps.setString(3, cardNum);
            ps.setString(4, type);

            ps.executeUpdate();
            System.out.println("Saved payment saved to database.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }


    public int confirmPayment(String orderID, int paymentID) throws SQLException {
        try {
            int customerID = 0;
            String name = null;
            String type = null;
            String cardNumber = null;
            //int customerID, String name, String cardNum, String type, double amount, LocalDateTime date

            String q1 = "SELECT" + " * FROM Payments WHERE id = " + paymentID;
            ResultSet rs = st.executeQuery(q1);

            while (rs.next()){
                customerID = rs.getInt("customerID");
                name = rs.getString("name");
                type = rs.getString("type");
                cardNumber = rs.getString("cardNumber");
            }

            String q2 = "SELECT" + " totalCost FROM Orders WHERE orderID = '" + orderID + "'";
            ResultSet rs2 = st.executeQuery(q2);
            double totalCost = 0;
            if (rs.next()) {
                totalCost = rs2.getDouble("totalCost");
            } else {
                    throw new SQLException("No order found with ID: " + orderID);
                }


            String query = "INSERT INTO ConfirmedPayments (orderID, customerID, name, cardNumber, type, amount, purchaseDate) VALUES (?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, orderID);
            ps.setInt(2, customerID);
            ps.setString(3, name);
            ps.setString(4, cardNumber);
            ps.setString(5, type);
            ps.setDouble(6, totalCost);

            ps.executeUpdate();
            System.out.println("Payment saved to database.");


            String q3 = "SELECT" +" last_insert_rowid() AS confirmedPaymentID";
            ResultSet rs3 = st.executeQuery(q3);
            if (rs3.next()) {
                return rs.getInt("confirmedPaymentID"); // returns generated cart ID
            } else {
                throw new SQLException("Failed to create payment.");
                    }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Payment> getPaymentsByCustomerID(int customerID) throws SQLException {
    List<Payment> payments = new ArrayList<>();
    String query = "SELECT * FROM ConfirmedPayments WHERE customerID = ?";
    try (PreparedStatement ps = conn.prepareStatement(query)) {
        ps.setInt(1, customerID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String orderID = rs.getString("orderID");
            String name = rs.getString("name");
            String cardNumber = rs.getString("cardNumber");
            String type = rs.getString("type");
            double amount = rs.getDouble("amount");
            LocalDate date = rs.getDate("shipmentDate").toLocalDate();

            Payment payment = new Payment(orderID, customerID, name, cardNumber, type, amount, date);
            payments.add(payment);
            System.out.println(payment);
        }
    }
    return payments;
    }

    public ArrayList<Payment> getSavedPaymentsByCustomerID(int customerID) throws SQLException {
        ArrayList<Payment> savedPayments = new ArrayList<>();
        String query = "SELECT * FROM SavedPayments WHERE customerID = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
        ps.setInt(1, customerID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            String cardNumber = rs.getString("cardNumber");
            String type = rs.getString("type");
            System.out.println("Retrieving payment method for : " + name + " " + type);

            Payment payment = new Payment(customerID, name, cardNumber, type);
            savedPayments.add(payment);
            
        }
    }
    return savedPayments;
    }
}
