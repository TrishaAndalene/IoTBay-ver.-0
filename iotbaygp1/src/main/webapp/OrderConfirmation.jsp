<%@ page import="model.Product" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="model.OrderItem" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Received</title>

    <!-- Style overloading -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sriracha&display=swap" rel="stylesheet">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="css/Header.css">
    <link rel="stylesheet" href="css/Footer.css">
    <link rel="stylesheet" href="css/ViewCart.css"> <!-- share the same template-->
</head>
<body style="overflow-x: hidden; overflow-y: scroll;">
    <%@ include file="/Header.jsp" %>

    <%
    List<OrderItem> orderItems = (List<OrderItem>) request.getAttribute("orderItems");
    String orderID = (String) request.getAttribute("orderID");
    int confirmedPaymentID = (int) request.getAttribute("confirmedPaymentID");

    if (orderItems == null) {
    %>
    <p>Oh no!!!!!!!</p>
    <%
    } else {
        %>

        <section class="content">
            <li><a href="index.jsp"><- Return</a></li>
            <br>
            <!-- Content page -->
            <div class="top">
                <h1>Order Succesful</h1>
            </div>
            <br><br><br><br><br>
            <form action="OrderDetailsServlet" method="post">
                <% 
                double totalPrice = 0;
                Product p;
                int quantity;
                if (orderItems != null) {
                    for (OrderItem item: orderItems) {
                        p = item.getProduct();
                        quantity = item.getQuantity();
                        totalPrice += (p.getPrice() * quantity);
                %>
                        <input type="hidden" name="upc" value="<%= p.getUPC() %>">
                        <input type="hidden" name="quantity" value="<%= quantity %>">
                <%
                    }}
                %>
                <input type="hidden" name="orderID" value="<%= orderID %>">
                <input type="hidden" name="totalPrice" value="<%= totalPrice %>">
                <input type="submit" value="View Order"  style="margin-left: 5%;" class="buttonEntry">
            </form>
        </section style="padding-bottom: 10vh;">
        <%
    }
   
%>

<%@ include file="/Footer.jsp" %>
</body>
</html>