<%@ page import="model.Product" %>
<%@ page import="java.util.List" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Stock Management</title>   
    <link rel="stylesheet" href="css/StockMgmt.css">
    <link rel="stylesheet" href="css/Header.css">
    <link rel="stylesheet" href="css/Footer.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
</head>

<body>
    <%@ include file="/Header.jsp" %>

    <%
            List<Product> allProduct = (List<Product>) request.getAttribute("allProduct");
            if (allProduct == null) {
            %>
            <p>Oh no!!!!!!!</p>
            <% } else { %>
    <!-- main screen -->
    <div id="main_screen">
        <h2 id="staff_name">Stock Management</h2>

        <div id="add_btn">
            <a href="AddProduct.jsp">Add Product</a>
        </div> 
        
        <table id="product-table">
            <thead>
                <tr>
                  <th scope="col">UPC</th>
                  <th scope="col">Brand</th>
                  <th scope="col">Product Name</th>
                  <th scope="col">Stock Qty</th>
                  <th scope="col">Update Stock</th>
                  <th scope="col">Manage Item</th>
                </tr>
            </thead>
            <%
                    for (Product p : allProduct) {
            %>
                <tbody>  
                <tr>
                  <td><%= p.getUPC() %></td>
                  <td><%= p.getBrand() %></td>
                  <td><%= p.getName() %></td>
                  <td><%= p.getQuantity() %></td>
                  <td><form action="UpdateStockServlet" method="post">
                    <input type="hidden" name="upc" value="<%= p.getUPC() %>">
                    <input type="text" name="quantity" required>
                    <button type="submit">Update Stock</button>
                  </form></td>
                  <td><form action="ProductEditServlet" method="post">
                    <input type="hidden" name="upc" value="<%= p.getUPC() %>">
                    <button type="submit">Manage Product</button>
                  </form></td>
                </tr>                  
                 
            </tbody> 
            <%
        }
    }
            %>      
        </table>

    </div>
    <%@ include file="/Footer.jsp" %>
      
</body>
</html>