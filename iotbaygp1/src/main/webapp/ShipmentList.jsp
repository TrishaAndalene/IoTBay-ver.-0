<%@ page import="java.util.List" %>
<%@ page import="model.Shipment" %>
<jsp:useBean id="shipmentList" scope="request" class="java.util.ArrayList" />

<!DOCTYPE html>
<html>
<head>
  <title>Shipment List</title>
</head>
<body>
  <h2>All Shipments</h2>

  <table border="1">
    <tr>
      <th>ID</th>
      <th>Order ID</th>
      <th>Method</th>
      <th>Date</th>
      <th>Address</th>
      <th>Actions</th>
    </tr>

    <%
      for (Object obj : shipmentList) {
        Shipment s = (Shipment) obj;
    %>
      <tr>
        <td><%= s.getShipmentId() %></td>
        <td><%= s.getOrderId() %></td>
        <td><%= s.getShipmentMethod() %></td>
        <td><%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(s.getShipmentDate()) %></td>
        <td><%= s.getShipmentAddress() %></td>
        <td>
          <a href="shipment?action=edit&id=<%= s.getShipmentId() %>">Edit</a> |
          <a href="shipment?action=delete&id=<%= s.getShipmentId() %>" onclick="return confirm('Delete this shipment?');">Delete</a>
        </td>
      </tr>
    <%
      }
    %>
  </table>

  <br/>
  <a href="shipment?action=new">+ Add New Shipment</a>
</body>
</html>
