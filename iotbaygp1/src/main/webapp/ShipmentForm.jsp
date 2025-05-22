<%@ page import="model.Shipment" %>
<%@ page import="java.text.SimpleDateFormat" %>
<jsp:useBean id="shipment" class="model.Shipment" scope="request" />

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Enter Shipment Details</title>
  <link rel="stylesheet" href="css/Header.css">
  <link rel="stylesheet" href="css/Footer.css">
  <link rel="stylesheet" href="css/Shipment.css">
</head>
<body>

  <div id="shipment_section">
    <h2><%= shipment.getShipmentId() > 0 ? "Edit Shipment" : "Enter Shipment Details" %></h2>

    <% if (shipment.getShipmentId() > 0) { %>
      <p class="shipment-id">
        Shipment ID: <%= String.format("%03d", shipment.getShipmentId()) %>
      </p>
    <% } %>

    <form action="ShipmentServlet" method="post">
      <input type="hidden" name="shipmentId" value="<%= shipment.getShipmentId() %>" />
      <input type="hidden" name="orderId" value="<%= shipment.getOrderId() %>" />

      <label for="shipmentMethod">Shipment Method:</label>
      <select name="shipmentMethod" id="shipmentMethod" required>
        <option value="">Select...</option>
        <option value="Standard" <%= "Standard".equals(shipment.getShipmentMethod()) ? "selected" : "" %>>Standard</option>
        <option value="Express" <%= "Express".equals(shipment.getShipmentMethod()) ? "selected" : "" %>>Express</option>
      </select>

      <label for="shipmentDate">Shipment Date:</label>
      <input type="date" name="shipmentDate" id="shipmentDate"
             value="<%= shipment.getShipmentDate() != null ? new SimpleDateFormat("yyyy-MM-dd").format(shipment.getShipmentDate()) : "" %>" required />

      <label for="shipmentAddress">Shipment Address:</label>
      <textarea name="shipmentAddress" id="shipmentAddress" required><%= shipment.getShipmentAddress() != null ? shipment.getShipmentAddress() : "" %></textarea>

      <input type="submit" value="Submit Shipment" />
    </form>

    <a href="shipment" class="back-link">Back to Shipment List</a>
  </div>

</body>
</html>
