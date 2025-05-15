<%@ page import="model.Product" %>
<%@ page import="java.util.List" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Browse Products</title>   
    <link rel="stylesheet" href="css/BrowseItems.css">
    <link rel="stylesheet" href="css/Header.css">
    <link rel="stylesheet" href="css/Footer.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sriracha&display=swap" rel="stylesheet">
    
</head>
<body>
    <!-- navigation bar -->
    <%@ include file="/Header.jsp" %>

    <%
    List<Product> allProduct = (List<Product>) request.getAttribute("allProduct");
    if (allProduct == null) {
    %>
    <p>Oh no!!!!!!!</p>
    <%
    } else {
        %>
    <!-- main screen -->
    <div id="main_screen">
        <h2>Our Products</h2>
        
        <form action="BrowseItemsServlet" method="post">
        <div class="btn-container">
            <button type="submit" name="filter" value="all"> Show all</button>
            <button type="submit" name="filter" value="WIFI">Wifi</button>
            <button type="submit" name="filter" value="HOME_SECURITY">Home Security</button>
            <button type="submit" name="filter" value="ACTIVITY_TRACKERS">Activity Trackers</button>
            <button type="submit" name="filter" value="ACTUATOR">Actuators</button>
            <button type="submit" name="filter" value="AMBIENT_IOT">Ambient IoT</button>
            <button type="submit" name="filter" value="MINI_PC">Mini PC</button>
        </div>
    </form>

                        
        <div id="product-grid">
            <%
                        for (Product p : allProduct) {
                %>
                <div class="product-card">
                    <img src="<%= p.getImg() %>" alt="<%= p.getName() %>" />
                    <h5><%= p.getName() %></h5>
                    <p>$<%= String.format("%.2f", p.getPrice())%></p>
                    <form action="ProductViewServlet" method="post">
                        <input type="hidden" name="upc" value="<%= p.getUPC() %>" />
                        <button type="submit">View Product</button>
                    </form>
                </div>
                <%
             }
            }
        %>
            </div>
            
    </div>


    <!-- footer -->
    <%@ include file="/Footer.jsp" %>
</body>   
</html>