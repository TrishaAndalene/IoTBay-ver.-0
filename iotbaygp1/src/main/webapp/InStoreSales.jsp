<%@ page import="model.StorePurchase" %>
<%@ page import="java.util.List" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>In Store Transactions</title>   

    <link rel="stylesheet" href="css/StockMgmt.css">
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

    <%
            List<Customer> customerList = (List<Customer>) request.getAttribute("customerList");
            List<Staff> staffList = (List<Staff>) request.getAttribute("staffList");
            List<StorePurchase> storePurchaseList = (List<StorePurchase>) request.getAttribute("storePurchaseList");
            if (storePurchaseList == null) {
            %>
            <p>Oh no!!!!!!!</p>
            <% } else { %>
                
    <!-- main screen -->
    <div id="main_screen">
        <h2 id="staff_name">Store Transactions</h2>

        <table id="product-table">
            <thead>
                <tr>
                  <th scope="col" class="mid-col">Transaction #</th>
                  <th scope="col" class="mid-col">Customer</th>
                  <th scope="col" class="mid-col">Salesperson</th>
                  <th scope="col" class="mid-col">Transaction Type</th>

                </tr>
            </thead>
            <%
                    for (StorePurchase p : storePurchaseList) {
                      String salesperson = "Unknown Staff";
                      String cust = "No Customer";
                      int salespersonID = p.getSalespersonID();
                      for (Staff s : staffList){
                        if (salespersonID == s.getID()){
                          salesperson = s.getFirstName() + " " + s.getLastName().charAt(0) + ".";
                          break;
                        }
                      }
                      int custID = p.getCustomerID();
                        for (Customer c : customerList){
                        if (custID == c.getID()){
                          cust = c.getFirstName() + " " + c.getLastName();
                          break;
                        }
                      }
                      
            %>
                <tbody>  
                <tr>
                  <td><%= p.getPurchaseID() %></td>
                  <td><%= cust %></td>
                  <td><%= salesperson %></td>
                  <td><%= p.getTransType() %></td>
                  <td><form action="#" method="post">
                    <input type="hidden" name="purchaseID" value="<%= p.getPurchaseID() %>">
                    <button type="submit">View Purchase</button>
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