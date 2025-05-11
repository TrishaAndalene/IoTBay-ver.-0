<%@ page import="model.Product" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Product</title>   
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
        <div id = "back">
            <a href="StockMgmtServlet">
                <button type="button">Back to Stock Mgmt</button>
            </a>
        </div>
        <div id = "remove">
            <form action="RemoveProductServlet" method="post">
                <input type="hidden" name="upc" value="<%= p.getUPC() %>" />
                <button type="submit">Remove Item</button>
            </form>
        </div>
    </div>

    
    <%@ include file="/Footer.jsp" %>
    <%
}
%> 
    
</body>
</html>