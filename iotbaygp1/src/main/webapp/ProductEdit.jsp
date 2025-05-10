<%@ page import="model.Product" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Product</title>   
    <link rel="stylesheet" href="css/ProductEdit.css">
</head>
<body>

        
    <!-- navigation bar -->
    <nav class="nav-bar">
        <img src="img/company_logo.png" class="company-logo">
        <h1 id="company_name">IoT Bay</h1>
        <ul class="nav-links">
            <li><a href="index.jsp" id="menu_home">Main Home</a></li>
            <li><a href="StaffLanding.jsp" id="staff_landing"><h1>Staff Home</h1></a></li>
            <li><a href="BrowseItemsServlet" id="menu_browse"><h1>Browse</h1></a></li>
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
        Product p = (Product) request.getAttribute("product");
        if (p == null){    
    %>
            <p>Uh oh!!!</p>
    <%   
            } else {

    %> 

     <!-- main screen -->
     <div id="main_screen">
        <h2 id="staff_name">Stock Management</h2>
        
        <table id="product-table">
                <tr>
                    <form action="UpdateProductServlet" method="post">     
                    <td>Update Name: </td>
                    <td><input type="text" name="value" value="<%= p.getName() %>"></td>
                    <td>
                        <input type="hidden" name="upc" value="<%= p.getUPC() %>">
                        <input type="hidden" name="field" value="name">
                        <button type="submit">Update</button>
                    </td>
                    </form>
                </tr>
                <tr>
                    <form action="UpdateProductServlet" method="post"> 
                    <td>Update Brand: </td>
                    <td><input type="text" name="value" value="<%= p.getBrand() %>"></td>
                    <td>
                        <input type="hidden" name="upc" value="<%= p.getUPC() %>">
                        <input type="hidden" name="field" value="brand">
                        <button type="submit">Update</button>
                    
                    </td>
                </form>
                </tr>
                <tr>
                    <form action="UpdateProductServlet" method="post"> 
                    <td>Update Price: </td>
                    <td><input type="text" name="value" value="<%= p.getPrice() %>"></td>
                    <td>
                        <input type="hidden" name="upc" value="<%= p.getUPC() %>">
                        <input type="hidden" name="field" value="price">
                        <button type="submit">Update Price</button>
                    </td>
                </form>
                </tr>
                <tr>
                    <form action="UpdateProductServlet" method="post"> 
                    <td>Update Image URL: </td>
                    <td><input type="text" name="value" value="<%= p.getImg() %>"></td>
                    <td>
                        <input type="hidden" name="upc" value="<%= p.getUPC() %>">
                        <input type="hidden" name="field" value="image">
                        <button type="submit">Update</button>
                    </td>
                </form>
                </tr>
                <tr>
                    <form action="UpdateProductServlet" method="post"> 
                    <td>Update Description: </td>
                    <td><input type="text" name="value" value="<%= p.getDescription() %>"></td>
                    <td> 
                        <input type="hidden" name="upc" value="<%= p.getUPC() %>">
                        <input type="hidden" name="field" value="description">
                        <button type="submit">Update</button>
                    </td>
                    </form>
                </tr> 
                <tr>
                    <form action="UpdateProductServlet" method="post"> 
                    <td>Update Category: </td>
                    <td><input type="text" name="value" value="<%= p.getCategories() %>"></td>
                    <td> 
                        <input type="hidden" name="upc" value="<%= p.getUPC() %>">
                        <input type="hidden" name="field" value="category">
                        <button type="submit">Update</button>
                    </td>
                    </form>
                </tr>                       
        </table>
        <div id = "remove">
            <form action="RemoveProductServlet" method="post">
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
    
    <%
}
%> 
    
</body>
</html>