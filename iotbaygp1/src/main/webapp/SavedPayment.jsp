<%@ page import="dao.PaymentDAO" %>
<%@ page import="model.Payment" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IoTBay - Payment</title>

    <!-- Style overloading -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sriracha&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="css/Header.css">
    <link rel="stylesheet" href="css/Footer.css">
    <link rel="stylesheet" href="css/Payment.css">

</head>

<body>
    <%@ include file="/Header.jsp" %>
    <% 
        ArrayList<Payment> savedPayments = (ArrayList<Payment>) request.getAttribute("savedPayments");

    %>

    <section class="content">
        <form method="post" action="SavedPaymentChoiceServlet">
        <p><strong>Saved Payment Methods</strong></p>

        <% if (savedPayments == null || savedPayments.isEmpty()) { %>
            <p>No saved payments found in session.</p>
        <% } else { %>
                <table border="1" cellpadding="5" cellspacing="0">
                <thead>
                    <tr>
                        <th>Select</th>
                        <th>Name</th>
                        <th>Card Number</th>
                        <th>Type</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < savedPayments.size(); i++) {
                        Payment payment = savedPayments.get(i);
                        String name = payment.getName();
                        String cardNumber = payment.getCardNumber();
                        String fourDigits = cardNumber.substring(cardNumber.length() - 4);
                        String type = payment.getType();
                        String combined = name +"."+ cardNumber +"."+ type;
                        
                    %>
                    <tr>
                        <td style="text-align: center;">
                            <input type="radio" name="selected" value="<%= combined %>" required>
                        </td>
                        <td><%= name %></td>
                        <td>XXXX-<%= fourDigits %></td>
                        <td><%= type %></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
                <% } %>
        
            <br>
            
            <input type="submit" name="submit" value="Choose Payment Method" style="margin-left: 5%;" class="buttonEntry">
        </form>  
    </section>



    <%@ include file="/Footer.jsp" %>
</body>