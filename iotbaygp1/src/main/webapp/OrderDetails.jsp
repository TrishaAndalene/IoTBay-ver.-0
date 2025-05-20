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

    if (orderItems == null) {
    %>
        <p>Wrong!</p>
    
    <% } else { %>

    <div class="top">
        <h1>Order Details</h1>
    </div>
    <br><br>

    <%
        Order order = (Order) request.getAttribute("order");
        if (order == null){
            out.println("null");
        } else {
    %>
    <div class="content">
        <h3>Order id: #<%=order.getOrderId() %></h3>
        <h3>Status: <%= order.getStatus() %></h3>
        <h3>Date placed: <%= order.getDate() %></h3>
        <br>
    <%
    }
    %>

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
                        Product p;
                        int quantity;
                        Order o = (Order) request.getAttribute("order");

                        if (o != null){
                            double totalPrice = o.getCost();
                            if (orderItems != null) {
                                for (OrderItem item: orderItems) {
                                    p = item.getProduct();
                                    quantity = item.getQuantity();
    
                        %>
                        <tr>
                            <td><img style="max-width: 150px; height: auto; min-width: 150px;" src="<%= p.getImg()%>" alt=""></td>
                            <td><%= p.getName() %></td>
                            <td class ="rows2"><!--<button class="inside-row">+</button>--><%= quantity %><!--<button class="inside-row">-</button> --></td>
                            <td><%= totalPrice%></td>
                        </tr>
                        <%
                            }
                        } else {
                            if (orderItems != null) {
                                for (OrderItem item: orderItems) {
                                    p = item.getProduct();
                                    quantity = item.getQuantity();
                                    totalPrice += (p.getPrice() * quantity);
                                
                                %>
                                <tr>
                                    <td><img style="max-width: 150px; height: auto; min-width: 150px;" src="<%= p.getImg()%>" alt=""></td>
                                    <td><%= p.getName() %></td>
                                    <td class ="rows2"><!--<button class="inside-row">+</button>--><%= quantity %><!--<button class="inside-row">-</button> --></td>
                                    <td><%= totalPrice%></td>
                                </tr>
                                <%
                                }}
                 %>   
                <%
                        }
                    } else {
                        System.out.println("is null");
                    }

                %>
                </table>

                <form action="ViewOrderServlet">
                    <input type="submit" value="Return">
                </form>
    </div>
    </section>
    

    <% } %>

    <%@ include file="/Footer.jsp" %>

</body>
</html>