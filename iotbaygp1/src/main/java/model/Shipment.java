package model;

import java.io.Serializable;
import java.util.Date;

public class Shipment implements Serializable {
    private int shipmentId;
    private int orderId;
    private String shipmentMethod;
    private Date shipmentDate;
    private String shipmentAddress;

    public Shipment() {}

    public Shipment(int shipmentId, int orderId, String shipmentMethod, Date shipmentDate, String shipmentAddress) {
        this.shipmentId = shipmentId;
        this.orderId = orderId;
        this.shipmentMethod = shipmentMethod;
        this.shipmentDate = shipmentDate;
        this.shipmentAddress = shipmentAddress;
    }

    public int getShipmentId() { return shipmentId; }
    public void setShipmentId(int shipmentId) { this.shipmentId = shipmentId; }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public String getShipmentMethod() { return shipmentMethod; }
    public void setShipmentMethod(String shipmentMethod) { this.shipmentMethod = shipmentMethod; }

    public Date getShipmentDate() { return shipmentDate; }
    public void setShipmentDate(Date shipmentDate) { this.shipmentDate = shipmentDate; }

    public String getShipmentAddress() { return shipmentAddress; }
    public void setShipmentAddress(String shipmentAddress) { this.shipmentAddress = shipmentAddress; }
}