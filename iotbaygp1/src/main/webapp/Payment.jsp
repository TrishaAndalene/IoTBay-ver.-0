<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="model.CartItem" %>
<%@ page import="model.Customer" %>
<%@ page import="model.Payment" %>
<%@ page import="model.Product" %>
<%@ page import="dao.CartItemsDAO" %>
<%@ page import="dao.PaymentDAO" %>
<%@ page import="dao.ProductDAO" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.LinkedHashMap" %>
<%@ page import="java.util.List" %>

<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IoTBay - Payment</title>

    <!-- Style overloading -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sriracha&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/payment.css">
    <link rel="stylesheet" href="css/Header.css">

</head>

<jsp:include page="Header.jsp" />

<%
    String action = request.getParameter("action");

    Customer customer = (Customer) session.getAttribute("customer");
    int customerID = customer.getID();

    ArrayList<Payment> savedPayments = new ArrayList<>();
    if (customer != null) {
        PaymentDAO paymentManager = (PaymentDAO) session.getAttribute("paymentManager");
        if (paymentManager != null) {
            savedPayments = (ArrayList<Payment>) paymentManager.getPaymentsByCustomerID(customerID);
        }
    }
    
    Integer cartIDint = (Integer) session.getAttribute("cartID");
    int cartID = 0;
    if (cartIDint != null) {
        cartID = cartIDint.intValue();
    } else {
        out.println("<p>No cart ID found in session.</p>");
        return;
    }
    
    CartItemsDAO cartItemsManager = (CartItemsDAO) session.getAttribute("cartItemsManager");
    ProductDAO productManager = (ProductDAO) session.getAttribute("productManager");

    List<CartItem> items = (List<CartItem>) session.getAttribute("cartItems");

    Map<Product, Integer> itemList = new LinkedHashMap<>();
    double totalCost = 0.0;

    if (cartID != 0 && cartItemsManager != null && productManager != null) {
        try {
            for (CartItem item : items) {
                Product p = productManager.findProduct(item.getUPC());
                itemList.put(p, item.getQuantity());
                totalCost += p.getPrice() * item.getQuantity();
            }
        } catch (Exception e) {
            out.println("<p>Error loading cart: " + e.getMessage() + "</p>");
        }
    }

    String name = (String) session.getAttribute("name");
    String cardNumber = (String) session.getAttribute("cardNumber");
    String type = (String) session.getAttribute("type");
    String savePayment = request.getParameter("savePayment");

%>



<body>

<br><br><br>

<h1> Your Order List </h1>

    <% if (itemList.isEmpty()) { %>
    <p>Your cart is empty.</p>
<% } else { %>
    <table>
        <tr>
            <th>Product</th><th>Qty</th><th>Price</th><th>Total</th>
        </tr>
        <% for (Map.Entry<Product, Integer> entry : itemList.entrySet()) {
               Product p = entry.getKey();
               int qty = entry.getValue();
               double total = p.getPrice() * qty;
        %>
        <tr>
            <td><%= p.getName() %></td>
            <td><%= qty %></td>
            <td>A$<%= p.getPrice() %></td>
            <td>A$<%= total %></td>
        </tr>
        <% } %>
        <tr>
            <td colspan="3" align="right"><strong>Total Amount: </strong></td>
            <td><strong>A$<%= totalCost %></strong></td>
        </tr>
    </table>
<% } %>

    <br>

    <h1>Enter Payment Details</h1>

    <form method="post" action="Payment.jsp">
        <button type="submit" name="action" value="new">Add New Payment Method</button>
        <button type="submit" name="action" value="saved">Select Saved Payment Method</button>
    </form>
<hr>

<% if ("new".equals(action)) { %>
    
    <form method="post" action="PaymentServlet">
        <p><strong>Add New Payment Method</strong></p>
        <input type="hidden" name="action" value="add">
        Name: <input type="text" name="name" required><br>
        Card Number: <input type="text" name="cardNumber" required><br>
        Type:
        <div class="toggle-type">
            <input type="radio" name="type" id="visa" value="Visa" required>
            <label for="visa">Visa</label>
            <input type="radio" name="type" id="master" value="Master">
            <label for="master">Master</label>
            <input type="radio" name="type" id="debit" value="Debit">
            <label for="debit">Debit</label>
            <input type="radio" name="type" id="afterpay" value="Afterpay">
            <label for="afterpay">Afterpay</label>
            </div><br>
        <input type="checkbox" name="savePayment" value="true" id="savePayment">
        <label for="savePayment">Would you like to save this payment?</label><br>
        <input type="hidden" name="action" value="enter">
        <button type="submit">Enter</button>
    </form>

    <%
        } else if ("enter".equals(action)) {
    %>

    <%
        if (name == null || cardNumber == null || type == null) {
            name = request.getParameter("name");
            cardNumber = request.getParameter("cardNumber");
            type = request.getParameter("type");
            savePayment = request.getParameter("savePayment");

            session.setAttribute("name", name);
            session.setAttribute("cardNumber", cardNumber);
            session.setAttribute("type", type);
        }

        if (name == null || cardNumber == null || type == null) {
            out.println("<p>Error: Missing payment information. Please try again.</p>");
        } else {
    %>
        <h3>Your Payment:</h3>
        <p><strong>Name:</strong> <%= name %></p>
        <p><strong>Card Number:</strong> <%= cardNumber %></p>
        <p><strong>Type:</strong> <%= type %></p>

        <form method="post" action="PaymentServlet">
            <input type="hidden" name="action" value="confirm">
            <input type="hidden" name="name" value="<%= name %>">
            <input type="hidden" name="cardNumber" value="<%= cardNumber %>">
            <input type="hidden" name="type" value="<%= type %>">
            <input type="hidden" name="totalCost" value="<%= totalCost %>">
            <input type="hidden" name="savePayment" value="<%= savePayment != null ? savePayment : "false" %>">
            <button type="submit" name="action" value="edit"> Edit </button>
            <button type="submit" name="action" value="confirm">Confirm Payment</button>
        </form>
    <% } %>

<% } else if ("saved".equals(action)) { %>
    
    <p><strong>Saved Payment Methods</strong></p>

    <% if (savedPayments == null || savedPayments.isEmpty()) { %>
        <p>No saved payments found in session.</p>
    <% } else { %>
        <form method="post" action="Payment.jsp">
            <% for (int i = 0; i < savedPayments.size(); i++) {
                Payment pp = savedPayments.get(i); %>
                <input type="radio" name="selected"
                       value="<%= i %>">
                <strong><%= pp.getName() %></strong> - <%= pp.getCardNumber() %> - <%= pp.getType() %> - $<%= pp.getAmount() %> on <%= pp.getDate() %><br>
            <% } %>
            <br>
            <input type="hidden" name="action" value="use">
            <button type="submit">Enter</button>
        </form>  
    <% } %>
<% } else if ("use".equals(action)) { %>
    <%
        String selectedIndex = request.getParameter("selected");
        if (savedPayments == null || savedPayments.isEmpty()) {
                out.println("<p>No saved payments available to select.</p>");
            } else if (selectedIndex == null || selectedIndex.trim().isEmpty()) {
                out.println("<p>Please select a payment method before proceeding.</p>");
            } else {
                try {
                    int index = Integer.parseInt(selectedIndex);
                    if (index >= 0 && index < savedPayments.size()) {
                        Payment selectedPayment = savedPayments.get(index);
                        name = selectedPayment.getName();
                        cardNumber = selectedPayment.getCardNumber();
                        type = selectedPayment.getType().toString();
                
    %>

<h3>Your Payment:</h3>
<p><strong>Name:</strong> <%= name %></p>
<p><strong>Card Number:</strong> <%= cardNumber %></p>
<p><strong>Type:</strong> <%= type %></p>
<form method="post" action="PaymentServlet">
    <input type="hidden" name="action" value="confirm">
    <input type="hidden" name="name" value="<%= name %>">
        <input type="hidden" name="cardNumber" value="<%= cardNumber %>">
        <input type="hidden" name="type" value="<%= type %>">
        <input type="hidden" name="totalCost" value="<%= totalCost %>">
        <input type="hidden" name="savePayment" value="true">
        <button type="submit" name="action" value="confirm">Confirm Payment</button>
    </form>
    <% 
            } else {
                out.println("<p>Invalid payment selection.</p>");
            }
        } catch (NumberFormatException e) {
            out.println("<p>Invalid input for payment selection.</p>");
        }
    }
    %>
<% } else if ("edit".equals(action)) { %>
    <form method="post" action="Payment.jsp">
        <p><strong>Edit Payment Method</strong></p>
        Name: <input type="text" name="name" value="<%= request.getParameter("name") %>" required><br>
        Card Number: <input type="text" name="cardNumber" value="<%= request.getParameter("cardNumber") %>" required><br>
        Type:
        <div class="toggle-type">
            <input type="radio" name="type" id="visa" value="Visa" <%= "Visa".equals(request.getParameter("type")) ? "checked" : "" %>>
            <label for="visa">Visa</label>
            <input type="radio" name="type" id="master" value="Master" <%= "Master".equals(request.getParameter("type")) ? "checked" : "" %>>
            <label for="master">Master</label>
            <input type="radio" name="type" id="debit" value="Debit" <%= "Debit".equals(request.getParameter("type")) ? "checked" : "" %>>
            <label for="debit">Debit</label>
            <input type="radio" name="type" id="afterpay" value="Afterpay" <%= "Afterpay".equals(request.getParameter("type")) ? "checked" : "" %>>
            <label for="afterpay">Afterpay</label>
        </div><br>
        <input type="hidden" name="action" value="enter">
        <input type="hidden" name="savePayment" value="<%= request.getParameter("savePayment") %>">
        <button type="submit">Enter</button>
    </form>
<% } %>

<%
// 결제 요약 및 버튼 보여주기
Payment newPayment = (Payment) session.getAttribute("newPaymentSummary");
if (newPayment != null) {
%>
    <hr>
    <h3>Your Payment:</h3>
    <p><strong>Name:</strong> <%= newPayment.getName() %></p>
    <p><strong>Card Number:</strong> <%= newPayment.getCardNumber() %></p>
    <p><strong>Type:</strong> <%= newPayment.getType() %></p>

    <form action="PaymentServlet" method="post">
        <input type="hidden" name="action" value="edit">
        <button type="submit">Edit</button>
    </form>

    <form action="PaymentServlet" method="post">
        <input type="hidden" name="action" value="confirm">
        <input type="text" name="name">
        <input type="text" name="cardNumber">
        <input type="text" name="type">
        <input type="text" name="amount">
        <button type="submit">Confirm Payment</button>
    </form>
<%
session.removeAttribute("newPaymentSummary");
}
%>


</body>
</html>