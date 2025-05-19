<%@ page import="model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Information</title>   
    <link rel="stylesheet" href="css/ProductView.css">
    <link rel="stylesheet" href="css/Header.css">
    <link rel="stylesheet" href="css/Footer.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

</head>
<body>
    <!-- navigation bar -->
    <%@ include file="/Header.jsp" %>

    <%
    Product product = (Product) request.getAttribute("product");
    List<Product> recommendedList = (List<Product>) request.getAttribute("recommendedList");
    if (product == null){    
    %>
        <p>Uh oh!!!</p>
    <%   } else {  %> 

    <!-- main screen -->
    <div id="main_screen">
        <div class="back-button">
            <a href="BrowseItemsServlet"><button type="submit"> < Back to Products</button></a>
        </div>
        <div class="product-container">
            <div class="product-img">
                <img src="<%= product.getImg() %>" alt="<%= product.getName() %>" />
            </div>
            <div class="product-info">
                <div class="heading"><h2><%= product.getName() %></h2></div>
                <br>
                <p><b>Price: </b> $<%= String.format("%.2f", product.getPrice())%></p>
                <p><b>Brand: </b><%= product.getBrand() %></p>
                <br>
                <br>
                <%   if (product.getQuantity() <= 0 ){  %> 
                    <h4>Sold Out</h4>
                <%   } else {  %> 
                    <%   if (staff != null){  %> 

                    <form action="AddToStoreCartServlet" method="post">
                    <div class = "choose-qty"><b>QTY:</b>
                    <input type="number" name="quantity" value="1" min="1" max="<%= product.getQuantity() %>"/></div>
                        <br>
                        <input type="hidden" name="upc" value="<%= product.getUPC() %>" />
                        <input type="hidden" name="staffID" value="<%= staffID %>" />
                        <button type="submit">Add To Store Purchase</button>
                    </form>
                    <br>
                    <p><b>Colour: </b><%= product.getColour() %> </p>
                    <p><b>Size: </b><%= product.getSize() %></p>
                    <p><b>Description: </b><%= product.getDescription() %></p>
                <%   } else if (customer != null){  %> 
                    <form action="AddToCartServlet" method="post">
                    <div class = "choose-qty"><b>QTY:</b>
                    <input type="number" name="quantity" value="1" min="1" max="<%= product.getQuantity() %>"/></div>
                        <br>
                        <input type="hidden" name="upc" value="<%= product.getUPC() %>" />
                        <input type="hidden" name="userID" value="<%= customerID %>" />
                        <button type="submit">Add To Cart</button>
                    </form>
                <%   } else {  %> 
                    <form action="AddToCartServlet" method="post">
                    <div class = "choose-qty"><b>QTY:</b>
                    <input type="number" name="quantity" value="1" min="1" max="<%= product.getQuantity() %>"/></div>
                        <br>
                        <input type="hidden" name="upc" value="<%= product.getUPC() %>" />
                        <input type="hidden" name="userID" value="9" />
                        <button type="submit">Add To Cart</button>
                    </form>
                    
                <br>
                <p><b>Colour: </b><%= product.getColour() %> </p>
                <p><b>Size: </b><%= product.getSize() %></p>
                <p><b>Description: </b><%= product.getDescription() %></p>
                <%   } }%> 
            </div> 
        </div> 
        
        
        <div class = "rec-header"><h4>Recommended For You:</h4></div>
        <div class="recommended">
            <% for (Product p : recommendedList) {  %>
            <div class="product-card">
                    <img src="<%= p.getImg() %>" alt="<%= p.getName() %>" />
                    <h5><%= p.getName() %></h5>
                    <p>$<%= String.format("%.2f", p.getPrice())%></p>
                    <form action="ProductViewServlet" method="post">
                        <input type="hidden" name="upc" value="<%= p.getUPC() %>" />
                        <button type="submit">View Product</button>
                    </form>
                </div>
                <% } %>
        </div>

    </div>
        <% } 
        %> 


    <%@ include file="/Footer.jsp" %>
     
   
</body>
</html>