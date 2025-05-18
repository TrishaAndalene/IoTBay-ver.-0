<%@ page import="model.Product" %>
<%@ page import="model.Staff" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Store Cart</title>   
    <link rel="stylesheet" href="css/StoreCart.css">
    <link rel="stylesheet" href="css/Header.css">
    <link rel="stylesheet" href="css/Footer.css">  

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

</head>
<body>
    <%@ include file="/Header.jsp" %>


    <%
    List<Staff> staffList = (List<Staff>) request.getAttribute("staffList");
    Map<Product, Integer> cartItems = (Map<Product, Integer>) request.getAttribute("cartItems");
    %>

    
        <div id="main_screen">
            <h2 id="page_name">Purchase Confirmation</h2>
            <!-- Item list -->

            <h4>Purchase confirmed!</h4>
            
        </div>
    
    <%@ include file="/Footer.jsp" %>
</body>
</html>