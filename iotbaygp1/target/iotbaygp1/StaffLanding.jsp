<%@ page import="model.Staff" %>
<%@ page import="model.TrialDatabase" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Staff Homepage</title>   
    <link rel="stylesheet" href="css/Stafflanding.css">
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
            <form action="browse.jsp">
              <input type="text" placeholder="Search.." name="search">
              <button type="submit">Submit</button>
            </form>
        </div>
    </nav>
    <%
    Staff staff = (Staff) session.getAttribute("staff");
    if (staff == null){    
 %>
        <p>Please log in first.</p>
<%   
        } else {
%>   
    <!-- main screen -->
    <div id="main_screen">
        <h2 id="staff_name">Welcome <%=staff.getFirstName()%>!</h2>
        <div id="stockmgmt_btn"><a href="StockMgmt.jsp">Stock Management</a></div>
        <div id="ordermgmt_btn"><a href="Order_Mgmt.jsp">Order Management</a></div>
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