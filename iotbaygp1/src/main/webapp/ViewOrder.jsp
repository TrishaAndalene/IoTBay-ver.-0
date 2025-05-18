<%@ page import="model.Order" %>
<%@ page import="controller.ViewOrderServlet" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OrderLists</title>

    <link rel="stylesheet" href="css/Header.css">
    <link rel="stylesheet" href="css/Footer.css">
    <link rel="stylesheet" href="css/ViewOrder.css">
</head>
<body>
    <%@ include file="/Header.jsp" %>
    <br><br><br><br><br><br>
    <section class="content">
        <div class="top">
            <h1>My Order List</h1>

            <form action="ViewOrderServlet" method="post">
                <div class="btn-container">
                    <button type="submit" name="status" value="All"> Show all</button>
                    <button type="submit" name="status" value="Received">Received</button>
                    <button type="submit" name="status" value="Processed">Processed</button>
                    <button type="submit" name="status" value="On delivery">On Delivery</button>
                    <button type="submit" name="status" value="Finished">Completed</button>
                    <button type="submit" name="status" value="Cancelled">Cancelled</button>
                </div>
            </form>
        </div>
        <div class="search-bar">
            <form action="OrderSearchServlet" method="post">
              <input type="text" placeholder="Search by code" name="searchQuery">
              <button type="submit">Search</button> <!-- later change it with icon -->
            </form>
        </div>
        <div class="order-container">
            <table>
                <tr>
                    <th>OrderID</th>
                    <th>Date placed</th>
                    <th>Total cost</th>
                    <th>Status</th>
                </tr>

                <%
                    ArrayList<Order> orderList = (ArrayList<Order>) request.getAttribute("orderLists");
                    if (orderList != null) {
                        for (Order order : orderList) {
                %>

                <tr>
                    <td><%= order.getOrderId() %></td>
                    <td><%= order.getDate() %></td>
                    <td><%= order.getCost() %></td>
                    <td><%= order.getStatus() %></td>

                    <td style="min-width: 4vw; max-width: 4vw;">
                        <form action="OrderDetailsServlet" method="post">
                            <input type="hidden" name="orderID" value="<%= order.getOrderId() %>">
                            <input type="submit" value="View" class="buttonEntry">
                        </form>
                    </td>

                    <% 
                        if (order.getStatus().equalsIgnoreCase("cancelled") || order.getStatus().equalsIgnoreCase("finished")){
                    %>
                    <td style="min-width: 4vw; max-width: 4vw;">
                        <form action="DeleteOrderServlet" method="post">
                            <input type="hidden" name="orderID" value="<%= order.getOrderId()%>">
                            <input type="submit" value="Remove" class="buttonEntry">
                        </form>
                    </td>
    
                    <%
                        } else {
                    %>
                    <td style="min-width: 4vw; max-width: 4vw;">
                        <form action="CancelOrderServlet" method="post">
                            <input type="hidden" name="orderID" value="<%= order.getOrderId() %>">
                            <input type="submit" value="Cancel" class="buttonEntry">
                        </form>
                    </td>
                    <%
                        } %>
                    
                </tr>

                <%
                         }
                    } else {
                        out.println("is null");
                    }
                %>

            </table>
        </div>  
    </section>

    <%@ include file="/Footer.jsp" %>
</body>
</html>