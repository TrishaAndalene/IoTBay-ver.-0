<%@ page import="model.Product" %>
<%@ page import="model.Staff" %>
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
                    <div class="customer">
                        <h5>Add Customer to Sale</h5>
                        <form action="AddStoreCartCustomer" method="post">
                            <input type="text" name="phone" required>
                            <button type="submit">Search for Customer</button>
                        </form>
                    </div>
                    <br>
                    <br>

                    <div class="sales-person">
                        <div>
                        <h5><b>Salesperson:</b> <%= staff.getFirstName() %> <%= staff.getLastName().charAt(0) %></h5>
                        </div>
                        <br>
                        <div class="staf-dropdown"><form action="ChangeStoreCartStaff" method="post">
                            <select class="staff-list" name="staff" id="staff">
                                <%for (Staff s : staffList) {%>
                                <option value="<%=s.getID()%>"><%=s.getFirstName()%> <%=s.getLastName().charAt(0)%>.</option>
                                <% }%>
                            </select>
                        </div>
                        <div class="submit-change">
                            <button type="submit">Change Staff Member</button>
                        </div>
                        </form>
                    </div>
                    <br>
                    <br>

                    <div class="add-item">
                        <p>spaceholder for adding an item</p>
                    </div>
                    <br>
                    <br>
                    
                    <div class ="finalise">
                    <div class="total-cost"><h3>Cart Total: A$<%= String.format("%.2f", totalPrice)%></h3></div>
                    <div class="finalise-btn"><button type="submit">Complete Sale</button></div>
                    </div>
                </div>  
            </div>   
        </div>
    
    <%@ include file="/Footer.jsp" %>
</body>
</html>