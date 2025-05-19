<%@ page import="model.Product" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Product</title>   


    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="css/ProductEdit.css">
    <link rel="stylesheet" href="css/Header.css">
    <link rel="stylesheet" href="css/Footer.css">

</head>
<body>    
    <%@ include file="/Header.jsp" %>
    
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
        <h2 id="staff_name">Update Product</h2>
        
        <table id="product-table">
                <tr>
                    <form action="UpdateProductServlet" method="post">     
                    <td><b>Update Name: </b></td>
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
                    <td><b>Update Brand: </b></td>
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
                    <td><b>Update Price: </b></td>
                    <td>
                        <input type="text" name="value" value="<%= p.getPrice() %>">
                        <div class="err">
                            <% String errorMsg = (String) request.getAttribute("errorMsg"); 
                                if (errorMsg != null) { %>
                                <p><%= errorMsg %></p>
                                <% } %>
                        </div> 
                    </td>
                    <td>
                        <input type="hidden" name="upc" value="<%= p.getUPC() %>">
                        <input type="hidden" name="field" value="price">
                        <button type="submit">Update</button>
                    </td>
                </form>
                </tr>
                <tr>
                    <form action="UpdateProductServlet" method="post"> 
                    <td><b>Update Image URL: </b></td>
                    <td><input type="text" name="value" value="<%= p.getImg() %>">
                     <div class="err2">
                            <% String errorMesg = (String) request.getAttribute("errorMesg"); 
                                if (errorMesg != null) { %>
                                <p><%= errorMesg %></p>
                                <% } %>
                        </div> 
                    </td>
                                           
                    <td>
                        <input type="hidden" name="upc" value="<%= p.getUPC() %>">
                        <input type="hidden" name="field" value="image">
                        <button type="submit">Update</button>
                    </td>
                </form>
                </tr>
                <tr>
                    <form action="UpdateProductServlet" method="post"> 
                    <td><b>Update Description: </b></td>
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
                    <td><b>Update Category: </b></td>
                    <td><input type="text" name="value" value="<%= p.getCategories() %>"></td>
                    <td> 
                        <input type="hidden" name="upc" value="<%= p.getUPC() %>">
                        <input type="hidden" name="field" value="category">
                        <button type="submit">Update</button>
                    </td>
                    </form>
                </tr>                       
        </table>
        <div class="btm-btns">
        <div class="back">
            <a href="StockMgmtServlet">
                <button type="button">Back to Stock Mgmt</button>
            </a>
        </div>
        <div class="remove">
            <form action="RemoveProductServlet" method="post">
                <input type="hidden" name="upc" value="<%= p.getUPC() %>" />
                <button type="submit">Remove Item</button>
            </form>
        </div>
        </div>
    </div>

    
    <%@ include file="/Footer.jsp" %>
    <%
}
%> 
    
</body>
</html>