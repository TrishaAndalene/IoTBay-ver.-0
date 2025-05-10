<%@ page import="model.Product" %>
<%@ page import="java.util.List" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Browse Products</title>   
    <link rel="stylesheet" href="css/BrowseItems.css">
</head>
<body>
    <!-- navigation bar -->
    <nav class="nav-bar">
        <img src="img/company_logo.png" class="company-logo">
        <h1 id="company_name">IoT Bay</h1>
        <ul class="nav-links">
            <li><a href="index.jsp" id="menu_home">Main Home</a></li>
            <li><a href="" id="menu_browse">Browse</a></li>
            <li><a href="" id="menu_account">Account</a></li>
            <li><a href="Logout.jsp" id="logout_btn">Log Out</a></li>
        </ul>
        <div class="search-container">
            <form action="browse.jsp">
              <input type="text" placeholder="Search.." name="search">
              <button type="submit">Submit</button>
            </form>
        </div>
    </nav>

    
    <!-- main screen -->
    <div id="main_screen">
        <h2>Our Products</h2>
            <%
            List<Product> allProduct = (List<Product>) request.getAttribute("allProduct");
            if (allProduct == null) {
            %>
            <p>Oh no!!!!!!!</p>
            <%
            } else {
                %>
        <div id="btn-container">
            <button class="btn active" onclick="filterSelection('all')"> Show all</button>
            <button class="btn" onclick="filterSelection('wifi')">Wifi</button>
            <button class="btn" onclick="filterSelection('home_security')"> Home Security</button>
            <button class="btn" onclick="filterSelection('activity_trackers')">Activity Trackers</button>
            <button class="btn" onclick="filterSelection('actuator')">Actuators</button>
            <button class="btn" onclick="filterSelection('ambient_iot')">Ambient IoT</button>
            <button class="btn" onclick="filterSelection('mini_pc')">Mini PC</button>
        </div>

                        <%
                        for (Product p : allProduct) {
                %>
        <div id="product-grid">
                <div id="product-card">
                    <img src="<%= p.getImg() %>" alt="<%= p.getName() %>" />
                    <h5><%= p.getName() %></h5>
                    <p>$<%= p.getPrice() %></p>
                    <form action="ProductViewServlet" method="post">
                        <input type="hidden" name="upc" value="<%= p.getUPC() %>" />
                        <button type="submit">View Product</button>
                    </form>
                </div>

            </div>
            <%
        }
    }
%>
    </div>

    





    <!-- footer -->
    <footer class="footer">
        <!-- main company logo -->
        <img id="company_logo2" src="img/company_logo.png">
        <!-- compnay name -->
        <h1 id="company_name2">IoTBay</h1>

        <!-- instagram -->
        <img id="instagram" src="img/insta.png">
        <p id="insta_address">@iotbaysydney</p>

        <!-- Email -->
        <img id="email" src="img/email.png">
        <p id="email_address">staff@iotbay.com</p>
    </footer>
    
 
    
</body>
</html>