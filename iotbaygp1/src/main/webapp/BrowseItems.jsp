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
        <div id="btn-container">
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
                    <p>$<%= p.getPrice() %></p>
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