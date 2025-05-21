<%@ page import="model.Product" %>
<%@ page import="model.Order" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="model.OrderItem" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Details</title>

        <!-- Style overloading -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sriracha&display=swap" rel="stylesheet">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="css/Header.css">
    <link rel="stylesheet" href="css/Footer.css">
    <link rel="stylesheet" href="css/OrderDetail.css">

</head>
<body>
    <%@ include file="/Header.jsp" %>

    <section class="content">
        <%
        List<OrderItem> orderItems = (List<OrderItem>) request.getAttribute("orderItems");
        Order order = (Order) request.getAttribute("order");
        if (orderItems == null) {
                                        %>
                <p>No order items</p>
    
        <% } else if (order == null){ %>

            <p>No order</p>

           <% } else { %>

        <div class="top"><h1>Order Details</h1></div><br><br>
        <div class="content">
            <h3>Order id: #<%=order.getOrderId() %></h3>
            <h3>Status: <%= order.getStatus() %></h3>
            <h3>Date placed: <%= order.getDate() %></h3>
            <h3>Total cost: <%= order.getCost() %></h3>
            <br>

        <!-- Item list -->
        <div class="orderTable">
            <table>
                <tr>
                    <th>Items</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                </tr>
         <%  
            for (OrderItem item: orderItems) {
                Product p = item.getProduct();
                int quantity = item.getQuantity();
                System.out.println(quantity);
                        %>
                        <tr>
                            <% double itemTotal = p.getPrice() * quantity; %>
                            <td><img src="<%= p.getImg()%>" alt=""></td>
                            <td><%= p.getName() %></td>
                            <td><%= quantity %></td>
                            <td><%= itemTotal %></td>
                        </tr>
                        <%   
                    }
                %>
                </table>
                
        <%    if (customer != null){  %>
                <form action="ViewOrderServlet">
                    <input type="submit" value="Return to My Orders">
                </form>
                <% } else { %>
                <form action="index.jsp">
                    <input type="submit" value="Return to Home">
                </form>
                <% } %>
        </div>
    </section>
    

    <% } %>

    <%@ include file="/Footer.jsp" %>

</body>
</html>