<%@ page import="model.Product" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product: </title>   
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
    if (product == null){    
    %>
        <p>Uh oh!!!</p>
    <%   } else {  %> 

    <!-- main screen -->
    <div id="main_screen">
        <div class="product-container">
            <div class="product-img">
                <img src="<%= product.getImg() %>" alt="<%= product.getName() %>" />
            </div>
            <div class="product-info">
                <div class="heading"><h2><%= product.getName() %></h2></div>
                <br>
                <p>Price: <%= product.getPrice() %></p>
                <p>Brand: <%= product.getBrand() %></p>
                <p>Colour: <%= product.getColour() %> </p>
                <p>Size: <%= product.getSize() %></p>
                <p>Description: <%= product.getDescription() %></p>
                <br>
                <br>
                <%   if (product.getQuantity() <= 0 ){  %> 
                    <h4>Sold Out</h4>
                <%   } else {  %> 
                    <p>add qty here</p>
                    <p>Add to cart (replace with button)</p>
                <%   } %> 
                

            </div> 
        </div>  
    </div>

    <%@ include file="/Footer.jsp" %>
    <% } %>  
   
</body>
</html>