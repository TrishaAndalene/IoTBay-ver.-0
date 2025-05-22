<%@ page import="model.Product" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Product</title>   
    <link rel="stylesheet" href="css/AddProduct.css">
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
        <h2 id="staff_name">Add Item</h2>
        <form action="AddProductServlet" method="post">
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
                <td><input type="text" name="price" placeholder="Price">
                     <div class="err">
                            <% String errorMsg = (String) request.getAttribute("errorMsg"); 
                                if (errorMsg != null) { %>
                                <p class="error"><%= errorMsg %></p>
                                <% } %>
                        </div>                 
                </td>
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
                <td><input type="text" name="image" placeholder="Image URL">
                     <div class="err2">
                            <% String errorMesg = (String) request.getAttribute("errorMesg"); 
                                if (errorMesg != null) { %>
                                <p class="error"><%= errorMesg %></p>
                                <% } %>
                        </div>                  
                </td>
            </tr>
            <tr>
                <td>Product QTY: </td>    
                <td><input type="text" name="quantity" placeholder="QTY">
                     <div class="err3">
                            <% String errorMssg = (String) request.getAttribute("errorMessg"); 
                                if (errorMssg != null) { %>
                                <p class="error"><%= errorMssg %></p>
                                <% } %>
                        </div>                   
                </td>
            </tr>
            <tr>
                <td>Product Category: </td>
                <td><select class="cat" name="category" id="categoryStr">
                        <option value="wifi">WiFi</option>
                        <option value="home_security">Home Security</option>
                        <option value="activity_trackers">Activity Trackers</option>
                        <option value="actuator">Actuators</option>
                        <option value="ambient_iot">Ambient IoT</option>
                        <option value="mini_pc">Mini PC</option>
                    </select>
                </td>
            </tr>
        </table>
        <div id = "button-cont">
            <a href="StockMgmtServlet">
                <button type="button"> < Back to Stock Mgmt</button>
            </a>
            <input type="submit" id="add-item" value="Add Item">
        </div>
        </form>
        
    </div>
    
    <%@ include file="/Footer.jsp" %>
   
</body>
</html>