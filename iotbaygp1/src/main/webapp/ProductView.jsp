<%@ page import="model.Product" %>
<%@ page import="model.TrialDatabase" %>



<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product: </title>   
    <link rel="stylesheet" href="css/ProductView.css">
</head>
<body>

    <%
        String upc = request.getParameter("upc");
        Product p = null;

        if (upc != null) {
            p = TrialDatabase.findProduct(upc);
        }
    %>
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
        <h2><%= p.getName() %></h2>
        <div class="product-img">
            <img src="<%= p.getImg() %>" alt="<%= p.getName() %>" />
        </div>
        <div class="product-info">
            <p>Brand: <%= p.getBrand() %></p>
            <p>Colour: <%= p.getColour() %> </p>
            <p>Size: <%= p.getSize() %></p>
            <p>Description: <%= p.getDescription() %></p>
            <br><br>
            <p>Price: <%= p.getPrice() %></p>
            <p>add qty here</p>
            <p>Add to cart (replace with button)</p>

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