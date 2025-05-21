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

    <section class="content">
        <form action="AddToPaymentServlet" method="post" >
            
            <p><strong>Add New Payment Method</strong></p>
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
            <input type="checkbox" name="savePayment" value="yes" id="savePayment">
            <label for="savePayment">Would you like to save this payment?</label><br>
            <input type="submit" name="submit" value="Confirm Payment" style="margin-left: 5%;" class="buttonEntry">

            </form>
    </section>


    <%@ include file="/Footer.jsp" %>
</body>
</html>