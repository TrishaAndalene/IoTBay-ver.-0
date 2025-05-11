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
</head>
<body>
    <%@ include file="/Header.jsp" %> 
    <!-- main screen -->
    <div id="main_screen">
        <h2>Search Results</h2>
        
        <%
            List<Product> allProduct = (List<Product>) request.getAttribute("allProduct");
            if (allProduct == null) {
            %>
            <p>I'm sorry, no items found.</p>
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

    <%@ include file="/Footer.jsp" %> 
</body>
</html>