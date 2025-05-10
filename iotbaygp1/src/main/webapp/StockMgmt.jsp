<%@ page import="model.Product" %>
<%@ page import="model.TrialDatabase" %>
<%@ page import="java.util.List" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Stock Management</title>   
    <link rel="stylesheet" href="css/StockMgmt.css">
</head>

<body>
    <!-- navigation bar -->
    <nav class="nav-bar">
        <img src="img/company_logo.png" class="company-logo">
        <h1 id="company_name">IoT Bay</h1>
        <ul class="nav-links">
            <li><a href="index.jsp" id="menu_home">Main Home</a></li>
            <li><a href="BrowseItems.jsp" id="menu_browse">Browse</a></li>
            <li><a href="" id="menu_account">Account</a></li>
            <li><a href="Logout.jsp" id="logout_btn">Log Out</a></li>
        </ul>
        <div class="search-container">
            <form action="BrowseItems.jsp">
              <input type="text" placeholder="Search.." name="search">
              <button type="submit">Submit</button>
            </form>
        </div>
    </nav>

    <!-- main screen -->
    <div id="main_screen">
        <h2 id="staff_name">Stock Management</h2>

        <%
            List<Product> allProduct = (List<Product>) request.getAttribute("allProduct");
            if (allProduct == null) {
            %>
            <p>Oh no!!!!!!!</p>
            <%
            } else {
                %>

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
                <tbody>  
                    <%
                    for (Product p : allProduct) {
            %>
               
                <tr>
                  <td><%= p.getUPC() %></td>
                  <td><%= p.getBrand() %></td>
                  <td><%= p.getName() %></td>
                  <td><%= p.getQuantity() %></td>
                  <td><form action="ProductEdit.jsp" method="post">
                    <input type="hidden" name="upc" value="<%= p.getUPC() %>" />
                    <button type="submit">Update Stock</button>
                  </form></td>
                  <td><form action="ProductEdit.jsp" method="post">
                    <input type="hidden" name="upc" value="<%= p.getUPC() %>" />
                    <button type="submit">Manage Product</button>
                  </form></td>
                </tr>                  
                <%
                    }
                }
            %>  
            </tbody>      
        </table>

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