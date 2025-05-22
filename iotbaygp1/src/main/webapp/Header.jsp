<%@ page import="model.Product, model.Staff, model.Customer" %>
<%@ page import="java.util.List" %>

    <!-- navigation bar -->
<header>
    <%
    Customer customer = (Customer) session.getAttribute("customer");
    Staff staff = (Staff) session.getAttribute("staff");
    Integer cartID = (Integer) session.getAttribute("cartID");
    Integer customerID = (Integer) session.getAttribute("customerID");
    Integer staffID = (Integer) session.getAttribute("staffID");
    Integer storeCartID = (Integer) session.getAttribute("storeCartID");

    if (staff != null) {
%>
    <nav class="headernav-bar">
        <a href="index.jsp"><div class="headercompany-details">
        <img src="img/company_logo.png" class="headercompany-logo">
        <h1 id="headercompany-name">IoT Bay</h1>
        </div></a>


        <div class="headerlinks">
        <ul class="headernav-links">
            <li class="headerdropdown">
                <a href="BrowseItemsServlet" class="headerdropbtn">Products</a>
                <div class="headerdropdown-content">
                  <a href="BrowseItemsServlet?filter=all">Show All</a>
                  <a href="BrowseItemsServlet?filter=WIFI">Wifi</a>
                  <a href="BrowseItemsServlet?filter=HOME_SECURITY">Home Security</a>
                  <a href="BrowseItemsServlet?filter=ACTIVITY_TRACKERS">Activity Trackers</a>
                  <a href="BrowseItemsServlet?filter=ACTUATOR">Actuators</a>
                  <a href="BrowseItemsServlet?filter=AMBIENT_IOT">Ambient IoT</a>
                  <a href="BrowseItemsServlet?filter=MINI_PC">Mini PC</a>
                </div> </li>
            <li><a href="StaffLanding.jsp" id="headermenu_home">Staff Home</a></li>
            <li><a href="StockMgmtServlet" id="headermenu_home">Stock Management</a></li>
            <li class="headerdropdown">
                <a href="ReportingServlet" class="headerdropbtn">Reporting</a>
                <div class="headerdropdown-content">
                    <a href="InStoreSalesServlet">In-Store Sales</a>
                    <a href="ReportingServlet?filter=daily">Daily Sales</a>
                    <a href="ReportingServlet?filter=salesperson">Sales by Salesperson</a>
                    <a href="ReportingServlet?filter=item">Sales by Item</a>
                    <a href="ReportingServlet?filter=item">Sales by Customer</a>
                </div> </li>
        </ul>
        </div>


        <div class="headersearch-container">
            <form action="StockSearchServlet">
              <input type="text" placeholder="What are you looking for today?" name="search">
              <button type="submit"> </button>
            </form>
        </div>
        
        <div class ="headerimage-container">
            <p>Welcome <%=staff.getFirstName()%>!</p>
            <a href="StoreCartServlet"><img src="img/staff_bag.jpg" class="headerdropimg"/></a>
            <div class="headerdropdown">
            <img src="img/profile-icon.jpg" class="headerdropimg"/>
                <div class="headerdropdown-content">
                    <a href="Myaccount.jsp">My Account</a>
                    <a href="#">Orders</a>
                    <a href="Logout.jsp">Log Out</a>
                </div>
            </div>  
        </div>    
    </nav>
    <%
} else if (customer != null) {
%>
    <nav class="headernav-bar">
        <a href="index.jsp"><div class="headercompany-details">
        <img src="img/company_logo.png" class="headercompany-logo">
        <h1 id="headercompany_name">IoT Bay</h1>
        </div></a>

        <div class="headerlinks">
        <ul class="headernav-links">
            <li><a href="index.jsp" id="headermenu_home">Home</a></li>
            <li class="headerdropdown">
                <a href="BrowseItemsServlet" class="headerdropbtn">Products</a>
                <div class="headerdropdown-content">
                  <a href="BrowseItemsServlet?filter=all">Show All</a>
                  <a href="BrowseItemsServlet?filter=WIFI">Wifi</a>
                  <a href="BrowseItemsServlet?filter=HOME_SECURITY">Home Security</a>
                  <a href="BrowseItemsServlet?filter=ACTIVITY_TRACKERS">Activity Trackers</a>
                  <a href="BrowseItemsServlet?filter=ACTUATOR">Actuators</a>
                  <a href="BrowseItemsServlet?filter=AMBIENT_IOT">Ambient IoT</a>
                  <a href="BrowseItemsServlet?filter=MINI_PC">Mini PC</a>
                </div> </li>   
        </ul>
        </div>
        <div class="headersearch-container">
            <form action="StockSearchServlet">
              <input type="text" placeholder="What are you looking for today?" name="search">
              <button type="submit"></button>
            </form>
        </div>
        
        <div class ="headerimage-container">
            <p>Welcome <%=customer.getFirstName()%>!</p>  
            <div class="headerdropdown">
            <img src="img/profile-icon.jpg" class="headerdropimg"/>
                <div class="headerdropdown-content">
                    <a href="Myaccount.jsp">My Account</a>
                    <a href="ViewOrderServlet">Orders</a>
                    <a href="Logout.jsp">Log Out</a>
                </div>
            </div>
            <div class="headerdropdown">
            <img src="img/shopping-cart.jpg" class="headerdropimg"/>
                <div class="headerdropdown-content">
                    <a href="ViewCartServlet">View Cart</a>
                </div>
            </div>
        </div>
        
    </nav>

    <%
} else {
%>

    <nav class="headernav-bar">
        <a href="index.jsp"><div class="headercompany-details">
            <img src="img/company_logo.png" class="headercompany-logo">
            <h1 id="headercompany_name">IoT Bay</h1>
        </div></a>
        <div class="headerlinks">
            <ul class="headernav-links">
                <li><a href="index.jsp" id="menu_home">Main Home</a></li>
                <li class="headerdropdown">
                    <a href="BrowseItemsServlet" class="headerdropbtn">Products</a>
                    <div class="headerdropdown-content">
                      <a href="BrowseItemsServlet?filter=all">Show All</a>
                      <a href="BrowseItemsServlet?filter=WIFI">Wifi</a>
                      <a href="BrowseItemsServlet?filter=HOME_SECURITY">Home Security</a>
                      <a href="BrowseItemsServlet?filter=ACTIVITY_TRACKERS">Activity Trackers</a>
                      <a href="BrowseItemsServlet?filter=ACTUATOR">Actuators</a>
                      <a href="BrowseItemsServlet?filter=AMBIENT_IOT">Ambient IoT</a>
                      <a href="BrowseItemsServlet?filter=MINI_PC">Mini PC</a>
                    </div>
                </li>

            </ul>
            </div>
        <div class="headersearch-container">
            <form action="StockSearchServlet">
              <input type="text" placeholder="What are you looking for today?" name="search">
              <button type="submit"></button>
            </form>
        </div>
        <div class="headerdropdown">
            <img src="img/shopping-cart.jpg" class="headerdropimg"/>
                <div class="headerdropdown-content">
                    <a href="ViewCartServlet">View Cart</a>
                </div>
            </div>
        <div class="headeraccount-container">
            <ul class="headeraccount-links">
                <li><a href="CustomerRegister.jsp" id="signup">Sign Up</a></li>
                <li><a href="CustomerLogin.jsp" id="login">Log In</a></li>
                <li><a href="StaffLogin.jsp" id="staff-login"><button class="headerstaff-btn">Staff Portal</button></a></li>
            </ul>
        </div>
    </nav>
    <%
    }
%>
</header>