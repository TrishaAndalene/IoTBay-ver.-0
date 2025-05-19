package dao;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.Payment;
import model.Type;

public class PaymentDAO {
    private Connection conn;

    public PaymentDAO(Connection conn) {
        this.conn = conn;
    }

    public void savePayment(Payment payment) throws SQLException {
        try {
            String query = "INSERT INTO Payments (customerID, name, cardNumber, type, amount, date, orderID) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, payment.getCustomerID());
            ps.setString(2, payment.getName());
            ps.setString(3, payment.getCardNumber());
            ps.setString(4, payment.getType().toString());
            ps.setDouble(5, payment.getAmount());
            ps.setString(6, payment.getDate());
            ps.setString(7, payment.getOrderID());

            ps.executeUpdate();
            System.out.println("Payment saved to database.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Payment> getPaymentsByCustomerID(int customerID) throws SQLException {
    List<Payment> payments = new ArrayList<>();
    String query = "SELECT * FROM Payments WHERE customerID = ?";
    try (PreparedStatement ps = conn.prepareStatement(query)) {
        ps.setInt(1, customerID);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            String cardNumber = rs.getString("cardNumber");
            Type type = Type.valueOf(rs.getString("type"));
            double amount = rs.getDouble("amount");
            String dateStr = rs.getString("date");
            LocalDateTime date = LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd E HH:mm:ss"));
            int cid = rs.getInt("customerID");
            String orderID = rs.getString("orderID");

            payments.add(new Payment(cid, name, cardNumber, type, amount, date));
            Payment payment = new Payment(cid, name, cardNumber, type, amount, date);
            payment.setOrderID(orderID);
            payments.add(payment);
        }
    }
    return payments;
    }
}
