<%@ page import="model.Product" %>
<%@ page import="model.TrialDatabase" %>



<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Product</title>   
    <link rel="stylesheet" href="css/ProductEdit.css">
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
        <h2 id="staff_name">Stock Management</h2>
        <table id="product-table">
            <thead>
                <tr>
                  <th scope="col">Field</th>
                  <th scope="col">Current</th>
                  <th scope="col">Edit</th>
                </tr>
            </thead>
                <tbody>  
                <tr>
                    <td>Product Name</td>
                    <td><%= p.getName() %></td>
                    <td>
                        <form action="" method="post">
                        <input type="hidden" name="upc" value="<%= p.getUPC() %>" />
                        <button type="submit">Update Name</button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td>Product Brand</td>
                    <td><%= p.getBrand() %></td>
                    <td><form action="" method="post">
                      <input type="hidden" name="upc" value="<%= p.getUPC() %>" />
                      <button type="submit">Update Brand</button>
                    </form></td>
                </tr>
                <tr>
                    <td>Product Price</td>
                    <td><%= p.getPrice() %></td>
                    <td><form action="" method="post">
                      <input type="hidden" name="upc" value="<%= p.getUPC() %>" />
                      <button type="submit">Update Price</button>
                    </form></td>
                </tr>
                <tr>
                    <td>Product Image</td>
                    <td><%= p.getImg() %></td>
                    <td><form action="" method="post">
                      <input type="hidden" name="upc" value="<%= p.getUPC() %>" />
                      <button type="submit">Update Image</button>
                    </form></td>
                </tr>
                <tr>
                    <td>Product Description</td>
                    <td><%= p.getDescription() %></td>
                    <td><form action="" method="post">
                      <input type="hidden" name="upc" value="<%= p.getUPC() %>" />
                      <button type="submit">Update Description</button>
                    </form></td>
                </tr>                  
            </tbody>      
        </table>
        <div id = "remove">
            <form action="" method="post">
                <input type="hidden" name="upc" value="<%= p.getUPC() %>" />
                <button type="submit">Remove Item</button>
            </form>
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