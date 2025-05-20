<%@ page import="model.Shipment" %>
<%@ page import="java.text.SimpleDateFormat" %>
<jsp:useBean id="shipment" class="model.Shipment" scope="request" />

<!DOCTYPE html>
<html>
<head>
  <title>Shipment Form</title>
</head>
<body>
  <h2><%= shipment.getShipmentId() > 0 ? "Edit Shipment" : "Add Shipment" %></h2>

  <form action="shipment" method="post">
    <input type="hidden" name="shipmentId" value="<%= shipment.getShipmentId() %>" />

    <label>Order ID:</label>
    <input type="text" name="orderId" value="<%= shipment.getOrderId() %>" readonly /><br/>

    <label>Shipment Method:</label>
    <input type="text" name="shipmentMethod" value="<%= shipment.getShipmentMethod() != null ? shipment.getShipmentMethod() : "" %>" required /><br/>

    <label>Shipment Date:</label>
    <input type="date" name="shipmentDate" value="<%= shipment.getShipmentDate() != null ? new SimpleDateFormat("yyyy-MM-dd").format(shipment.getShipmentDate()) : "" %>" required /><br/>

    <label>Shipment Address:</label>
    <input type="text" name="shipmentAddress" value="<%= shipment.getShipmentAddress() != null ? shipment.getShipmentAddress() : "" %>" required /><br/>

    <input type="submit" value="Submit Shipment" />
  </form>

  <a href="shipment">Back to List</a>
</body>
</html>
