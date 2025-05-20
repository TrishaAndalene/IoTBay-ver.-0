<%@ page import="model.Product" %>
<%@ page import="java.util.List" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Results</title>   
    <link rel="stylesheet" href="css/BrowseItems.css">
    <link rel="stylesheet" href="css/Header.css">
    <link rel="stylesheet" href="css/Footer.css">

    <link rel="stylesheet" href="css/BrowseItems.css">
    <link rel="stylesheet" href="css/Header.css">
    <link rel="stylesheet" href="css/Footer.css">

    <!-- Style overloading -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sriracha&display=swap" rel="stylesheet">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

</head>
<body>
    <%@ include file="/Header.jsp" %> 
    <!-- main screen -->
    <div id="main_screen">
        <h2>Search Results</h2>
        
        <%
            List<Product> allProduct = (List<Product>) request.getAttribute("allProduct");
            if (allProduct.size() == 0) {
            %>
            <div class="no-results">
            <h3>No matches to your search were found</h3>
            </div>
            <%
            } else {
                %>



        <div id="product-grid">
            <%
                        for (Product p : allProduct) {
                %>
                <div class="product-card">
                    <img src="<%= p.getImg() %>" alt="<%= p.getName() %>" />
                    <h5><%= p.getName() %></h5>
                    <p>$<%= String.format("%.2f", p.getPrice())%></p>
                    <div class="add-view-cont">
                        <%   if (p.getQuantity() <= 0 ){  %> 
                            <button class="sold-out">Sold Out</button>
                        <%   } else {  %> 
                            <%   if (staff != null){  %> 
                                <form action="AddToStoreCartServlet" method="post">
                                    <input type="hidden" name="upc" value="<%= p.getUPC() %>" />
                                    <input type="hidden" name="quantity" value="1" />
                                    <button type="submit">Add to Cart</button>
                                </form>
                            <%   } else if (customer != null){  %> 
                                <form action="AddToCartServlet" method="post">
                                    <input type="hidden" name="userID" value="<%= customerID %>" />
                                    <input type="hidden" name="upc" value="<%= p.getUPC() %>" />
                                    <input type="hidden" name="quantity" value="1" />
                                    <button type="submit">Add to Cart</button>
                                </form>
                            <%   } else {  %>
                                <form action="AddToCartServlet" method="post">
                                    <input type="hidden" name="userID" value="9" />
                                    <input type="hidden" name="upc" value="<%= p.getUPC() %>" />
                                    <input type="hidden" name="quantity" value="1" />
                                    <button type="submit">Add to Cart</button>
                                </form>
                        <%   }} %> 
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
            
    </div>

    <%@ include file="/Footer.jsp" %> 
</body>
</html>