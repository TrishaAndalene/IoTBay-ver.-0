<%@ page import="model.Product" %>
<%@ page import="model.Payment" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Submission</title>

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
    Integer paymentID = (Integer) session.getAttribute("paymentID");
    Payment payment = (Payment) session.getAttribute("payment");

    Map<Product, Integer> cartItems = (Map<Product, Integer>) request.getAttribute("cartItems");

    if (cartItems == null) {
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
                <h1>My Cart</h1>
            </div>
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

                            double totalPrice = 0;
                            Product p;
                            int quantity;
                            if (cartItems != null) {
                                for (Map.Entry<Product, Integer> item: cartItems.entrySet()) {
                                    p = item.getKey();
                                    quantity = item.getValue();
                                    totalPrice += (p.getPrice() * quantity);
                     %>
                    <tr>
                        <td><img style="max-width: 150px; height: auto; min-width: 150px;" src="<%= p.getImg()%>" alt=""></td>
                        <td><%= p.getName() %></td>
                        <td class ="rows2"><!--<button class="inside-row">+</button>--><%= quantity %><!--<button class="inside-row">-</button> --></td>
                        <td><%= p.getPrice() * quantity %></td>
                    </tr>   
                    <%
                            }
                        } else {
                            System.out.println("is null");
                        }

                    %>
                    </table>

                    <br>
                    <!-- Cart details -->
                    <div class="line"><h4>_______</h4></div>
                    <h3  style="margin-left: 5%;">Total : A$<%= totalPrice %></h3>

                    <br><br>

                     <% if (payment == null) { %>
                    

                    <h1>Enter Payment Details</h1>
                    <p>Customer ID: <%= session.getAttribute("customerID") %></p>
                    <p>Payment ID: <%= session.getAttribute("paymentID") %></p>

                    <form action="AddToPayment.jsp" method="post">
                        <input type="submit" value="Add Other Payment Method" style="margin-left: 5%;" class="buttonEntry">
                    </form>
            <% 
                if (customerID != null && customerID != 9){
                            
                        %>
                    <form action="SavedPaymentServlet" method="post">
                        <input type="submit" value="Change to Saved Payment Method" style="margin-left: 5%;" class="buttonEntry">
                    </form>

                    <% 
                }
                     } else {
                            
                        %>
                        <p>Payment Details Confirmed!</p><br><br>
                    <form action="SubmitCartServlet" method="post">
                        <% 
                        if (cartItems != null) {
                            for (Map.Entry<Product, Integer> item: cartItems.entrySet()) {
                                p = item.getKey();
                                quantity = item.getValue();
                        %>
                                <input type="hidden" name="upc" value="<%= p.getUPC() %>">
                        <%
                            }}
                        %>
                        <input type="hidden" name="paymentID" value="paymentID" required>
                        <input type="hidden" name="totalPrice" value="<%= totalPrice %>">
                        <input type="submit" value="Confirm Payment"  style="margin-left: 5%;" class="buttonEntry">
                    </form>

                        <%
                            }
                        %>
                    
                    <form action="ViewCartServlet" method="post">
                        <% 
                        if (cartItems != null) {
                            for (Map.Entry<Product, Integer> item: cartItems.entrySet()) {
                                p = item.getKey();
                                quantity = item.getValue();
                        %>
                                <input type="hidden" name="upc" value="<%= p.getUPC() %>">
                                <input type="hidden" name="quantity" value="<%= quantity %>">
                        <%
                            }}
                        %>
                        <input type="hidden" name="totalPrice" value="<%= totalPrice %>">
                        <input type="submit" value="Cancel"  style="margin-left: 5%;" class="buttonEntry">
                    </form>
                    <br><br>
            </div>

        </section style="padding-bottom: 10vh;">


        
    </section>
    <%
             }
            
        %>

        <%@ include file="/Footer.jsp" %>
</body>
</html>