<%@ page import="model.Product" %>
<%@ page import="model.TrialDatabase" %>



<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Product</title>   
    <link rel="stylesheet" href="css/AddProduct.css">
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



     <!-- main screen -->
     <div id="main_screen">
        <h2 id="staff_name">Add Item</h2>
        <form action="StockMgmt.jsp" method="post">
            <table id="form-table">
            <tr>
                <td>Product UPC: </td>
                <td><input type="text" name="upc" placeholder="Product UPC"></td>
            </tr>
            <tr>
                <td>Product Name: </td>           
                <td><input type="text" name="name" placeholder="Name"></td>
            </tr>
            <tr>            
                <td>Product Brand: </td>
                <td><input type="text" name="brand" placeholder="Brand"></td>
            </tr>
            <tr>
                <td>Product Price: </td>   
                <td><input type="number" name="price" placeholder="Price"></td>
            </tr>
            <tr>
                <td>Product Colour: </td>
                <td><input type="text" name="colour" placeholder="Colour"></td>
            </tr>
            <tr>
                <td>Product Size: </td>    
                <td><input type="text" name="size" placeholder="Size"></td>
            </tr>
            <tr>
                <td>Product Description: </td>
                <td><input type="text" name="description" placeholder="Description"></td>
            </tr>
            <tr>
                <td>Product Image URL: </td>
                <td><input type="text" name="img" placeholder="Image URL"></td>
            </tr>
        </table>
        <input type="submit" id="add-item" value="Add Item">
        </form>
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