package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Shipment;

public class ShipmentDAO {
    private Connection conn;

    public ShipmentDAO(Connection conn) {
        this.conn = conn;
    }

    public void addShipment(Shipment shipment) throws SQLException {
        String sql = "INSERT INTO Shipment (orderId, shipmentMethod, shipmentDate, shipmentAddress) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, shipment.getOrderId());
            stmt.setString(2, shipment.getShipmentMethod());
            stmt.setDate(3, new java.sql.Date(shipment.getShipmentDate().getTime()));
            stmt.setString(4, shipment.getShipmentAddress());
            stmt.executeUpdate();
        }
    }

    public Shipment getShipmentById(int shipmentId) throws SQLException {
        String sql = "SELECT * FROM Shipment WHERE shipmentId = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, shipmentId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Shipment shipment = new Shipment();
                    shipment.setShipmentId(rs.getInt("shipmentId"));
                    shipment.setOrderId(rs.getInt("orderId"));
                    shipment.setShipmentMethod(rs.getString("shipmentMethod"));

                    String dateStr = rs.getString("shipmentDate");
                    if (dateStr != null && !dateStr.trim().isEmpty()) {
                        try {
                            shipment.setShipmentDate(Date.valueOf(dateStr));
                        } catch (IllegalArgumentException e) {
                            shipment.setShipmentDate(null);
                        }
                    }

                    shipment.setShipmentAddress(rs.getString("shipmentAddress"));
                    return shipment;
                }
            }
        }
        return null;
    }

    public List<Shipment> getAllShipments() throws SQLException {
        List<Shipment> shipments = new ArrayList<>();
        String sql = "SELECT * FROM Shipment";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Shipment s = new Shipment();
                s.setShipmentId(rs.getInt("shipmentId"));
                s.setOrderId(rs.getInt("orderId"));
                s.setShipmentMethod(rs.getString("shipmentMethod"));

                String dateStr = rs.getString("shipmentDate");
                if (dateStr != null && !dateStr.trim().isEmpty()) {
                    try {
                        s.setShipmentDate(Date.valueOf(dateStr));
                    } catch (IllegalArgumentException e) {
                        s.setShipmentDate(null);
                    }
                }

                s.setShipmentAddress(rs.getString("shipmentAddress"));
                shipments.add(s);
            }
        }
        return shipments;
    }

    public void updateShipment(Shipment shipment) throws SQLException {
        String sql = "UPDATE Shipment SET shipmentMethod = ?, shipmentDate = ?, shipmentAddress = ? WHERE shipmentId = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, shipment.getShipmentMethod());
            stmt.setDate(2, new java.sql.Date(shipment.getShipmentDate().getTime()));
            stmt.setString(3, shipment.getShipmentAddress());
            stmt.setInt(4, shipment.getShipmentId());
            stmt.executeUpdate();
        }
    }

    public void deleteShipment(int shipmentId) throws SQLException {
        String sql = "DELETE FROM Shipment WHERE shipmentId = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, shipmentId);
            stmt.executeUpdate();
        }
    }
}
