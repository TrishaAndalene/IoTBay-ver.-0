<%@ page import="model.Product" %>
<%@ page import="model.Staff" %>
<%@ page import="model.Customer" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Store Cart</title>   
    <link rel="stylesheet" href="css/StoreCart.css">
    <link rel="stylesheet" href="css/Header.css">
    <link rel="stylesheet" href="css/Footer.css">  

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

</head>
<body>
    <%@ include file="/Header.jsp" %>


    <%
    Customer storeCustomer= (Customer) session.getAttribute("storeCustomer");
    List<Staff> staffList = (List<Staff>) request.getAttribute("staffList");
    Map<Product, Integer> cartItems = (Map<Product, Integer>) request.getAttribute("cartItems");
    %>

    
        <div id="main_screen">
            <h2 id="page_name">In-Store Purchase</h2>
            <!-- Item list -->

            <div class="order">
                <table id="order-table">
                    <tr>
                        <th>Items</th>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                    </tr>
                    <%      double totalPrice = 0;
                            Product p;
                            int quantity;
                            if (cartItems != null) {
                                for (Map.Entry<Product, Integer> item: cartItems.entrySet()) {
                                    p = item.getKey();
                                    quantity = item.getValue();
                                    totalPrice += (p.getPrice() * quantity);
                     %>
                    <tr>
                        <% double itemTotal = p.getPrice() * quantity; %>
                        <td><img src="<%= p.getImg()%>" alt=""></td>
                        <td><%= p.getName() %></td>
                        <td class ="qty">
                            <form action="UpdateStaffCartStockServlet" method="post">
                            <input type="hidden" name="upc" value="<%= p.getUPC() %>">
                            <button type="submit" name = "symbol" value="-1">-  </button>
                            <%= quantity %>
                            <button type="submit" name = "symbol" value="+1">  +</button>
                            </form>
                        </td>
                        <td><b>$<%= String.format("%.2f",itemTotal) %></b></td>
                        <td class ="remove">
                            <form action="UpdateStaffCartStockServlet" method="post">
                            <input type="hidden" name="upc" value="<%= p.getUPC() %>">
                            <button type="submit" name = "symbol" value="remove">Remove</button>
                            </form>
                        </td>
                        
                    </tr>
                    <%
                            }
                        } else {
                            System.out.println("is null");
                        }
                    %>
                </table>
                
                <div class="purchase-options">
                    <form action="AddStoreCustomerServlet" method="post">
                    <div class="customer">
                        <h5>Add Customer to Sale</h5>
                        <% if (storeCustomer != null)
                         { %> <h5><b>Customer:</b> <%= storeCustomer.getFirstName() %> <%= storeCustomer.getLastName() %></h5>
                        <% } else { %> 
                            <h5><b>Cusomter:</b> No Current Customer</h5>
                        <% } %> 
                            <input type="text" name="customerPhn" placeholder="Search Phone #">
                            <button type="submit">Search for Customer</button>
                        </form>
                    </div>
                    <br>
                    <br>


                    <form action="AddToStoreCartServlet" method="post">
                    <div class="add-item">
                        <h5>Add Item to Sale</h5>
                            <input type="text" name="upc" placeholder="Item UPC">
                            <input type="hidden" name="staffID" value="<%= staffID %>" />
                            <input type="hidden" name="quantity" value="1" />
                            <button type="submit">Search for Item</button>
                    </div>
                    </form>

                    <br>
                    <br>

                    <form action="StorePurchaseServlet" method="post">
                    <div class="sales-person">
                        <div>
                        <h5><b>Salesperson:</b> <%= staff.getFirstName() %> <%= staff.getLastName().charAt(0) %></h5>
                        </div>
                        <br>
                        <div class="staff-dropdown">
                            <select class="staff-list" name="salespersonID" id="staff">
                                <%for (Staff s : staffList) {%>
                                <option value="<%=s.getID()%>">
                                    <%=s.getFirstName()%> <%=s.getLastName().charAt(0)%>.
                                </option>
                                <% }%>
                            </select>
                        </div>
                    </div>

                    <br>
                    <br>
                    
                    <div class ="finalise">
                    <div class="total-cost"><h3>Cart Total: A$<%= String.format("%.2f", totalPrice)%></h3></div>
                    <input type="hidden" name="storeCartID" value="<%= storeCartID %>" />
                    <% if (storeCustomer != null)
                         { %> 
                        <input type="hidden" name="storeCustomerID" value="<%= storeCustomer.getID() %>" />
                        <% } else { %> 
                            <input type="hidden" name="storeCustomerID" value="0" />
                        <% } %> 
                    <input type="hidden" name="totalPrice" value="<%= totalPrice %>" />
                    <div class="finalise-btn"><button type="submit">Complete Sale</button></div>
                    </form>
                    </div>
                </div>  
            </div>   
        </div>
    
    <%@ include file="/Footer.jsp" %>
</body>
</html>