<%@ page import="model.Customer" %>
<%-- <% import java.util.* %> --%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IoTBay - Welcome</title>

    <!-- Style overloading -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sriracha&display=swap" rel="stylesheet">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    
    <link href="css/Welcome.css" rel="stylesheet">

    <%
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phoneNum = request.getParameter("phoneNum");
        String password = request.getParameter("password");

        Customer customer = new Customer(firstName, lastName, email, phoneNum, password);
        session.setAttribute("customer", customer);
    %>


</head>
<body onload="continuePage(1)">
    <section class="welcome" id="page-1">
        <div class="page-1">
            <img src="../img/welcome_logo.png" alt="logo">
            <h1>Hi, <%= customer.getFirstName() %></h1>
            <h2>Welcome to IoTBay</h2>
            <br>
            <button onclick="continuePage(2)"><h4>NEXT</h4></button>
        </div>

    </section>
    <section class="welcome" id="page-2">
        <div class="page-2">
            <img src="img/welcome_logo.png" alt="logo" id="smallerPng">
            <br><br><br>
            <h2>Would you like for us to guide you on</h2>
            <h2>how to navigate through the store?</h2>
            <br>
            <div class="buttons">
                <button onclick="continuePage(4)" id="leftButton"><h4>No</h4></button>
                <button onclick="continuePage(3)" id="rightButton"><h4>Yes</h4></button>
            </div>
        </div> 
    </section>

    <section class="welcome" id="page-3">
        <div class="page-3">
            <img src="img/welcome_logo.png" alt="logo" id="smallerPng">
            <br><br>
            <video controls>
                <source src="vid/video1.mp4" type="video/mp4">
            </video>
            <br><br><br>
            <button onclick="continuePage(4)"><h4>NEXT</h4></button>
        </div>
    </section>
    
    <section class="welcome" id="page-4">
        <div class="page-4">
            <img src="img/welcome_logo.png" alt="logo">
            <br><br>
            <h1>Thank you for joining </h1>
            <h2>the IoTBay family!</h2>
            <br><br>
            <button><a href="Landing.jsp"><h4>Start Exploring!</h4></button>
        </div>
    </section>
</body>
</html>