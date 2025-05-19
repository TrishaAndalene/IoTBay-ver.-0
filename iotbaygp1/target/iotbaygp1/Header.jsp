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
    <nav class="nav-bar">
        <a href="index.jsp"><div class="company-details">
        <img src="img/company_logo.png" class="company-logo">
        <h1 id="company-name">IoT Bay</h1>
        </div></a>


        <div class="links">
        <ul class="nav-links">
            <li class="dropdown">
                <a href="BrowseItemsServlet" class="dropbtn">Products</a>
                <div class="dropdown-content">
                  <a href="BrowseItemsServlet?filter=all">Show All</a>
                  <a href="BrowseItemsServlet?filter=WIFI">Wifi</a>
                  <a href="BrowseItemsServlet?filter=HOME_SECURITY">Home Security</a>
                  <a href="BrowseItemsServlet?filter=ACTIVITY_TRACKERS">Activity Trackers</a>
                  <a href="BrowseItemsServlet?filter=ACTUATOR">Actuators</a>
                  <a href="BrowseItemsServlet?filter=AMBIENT_IOT">Ambient IoT</a>
                  <a href="BrowseItemsServlet?filter=MINI_PC">Mini PC</a>
                </div> </li>
            <li><a href="StaffLanding.jsp" id="menu_home">Staff Home</a></li>
            <li><a href="StockMgmtServlet" id="menu_home">Stock Management</a></li>
            <li class="dropdown">
                <a href="ReportingServlet" class="dropbtn">Reporting</a>
                <div class="dropdown-content">
                    <a href="InStoreSalesServlet">In-Store Sales</a>
                    <a href="ReportingServlet?filter=daily">Daily Sales</a>
                    <a href="ReportingServlet?filter=salesperson">Sales by Salesperson</a>
                    <a href="ReportingServlet?filter=item">Sales by Item</a>
                    <a href="ReportingServlet?filter=item">Sales by Customer</a>
                </div> </li>
        </ul>
        </div>


        <div class="search-container">
            <form action="StockSearchServlet">
              <input type="text" placeholder="What are you looking for today?" name="search">
              <button type="submit"> </button>
            </form>
        </div>
        
        <div class ="image-container">
            <a href="StoreCartServlet"><img src="img/staff_bag.jpg" class="dropimg"/></a>
            <div class="dropdown">
            <img src="img/profile-icon.jpg" class="dropimg"/>
                <div class="dropdown-content">
                    <a href="#">My Account</a>
                    <a href="#">Orders</a>
                    <a href="Logout.jsp">Log Out</a>
                </div>
            </div>  
            <p>Welcome <%=staff.getFirstName()%>!</p>
        </div>    
    </nav>
    <%
} else if (customer != null) {
%>
    <nav class="nav-bar">
        <a href="index.jsp"><div class="company-details">
        <img src="img/company_logo.png" class="company-logo">
        <h1 id="company_name">IoT Bay</h1>
        </div></a>

        <div class="links">
        <ul class="nav-links">
            <li><a href="index.jsp" id="menu_home">Home</a></li>
            <li class="dropdown">
                <a href="BrowseItemsServlet" class="dropbtn">Products</a>
                <div class="dropdown-content">
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
        <div class="search-container">
            <form action="StockSearchServlet">
              <input type="text" placeholder="What are you looking for today?" name="search">
              <button type="submit"></button>
            </form>
        </div>
        
        <div class ="image-container">  
            <div class="dropdown">
            <img src="img/profile-icon.jpg" class="dropimg"/>
                <div class="dropdown-content">
                    <a href="#">My Account</a>
                    <a href="ViewOrderServlet">Orders</a>
                    <a href="Logout.jsp">Log Out</a>
                </div>
            </div>
            <div class="dropdown">
            <img src="img/shopping-cart.jpg" class="dropimg"/>
                <div class="dropdown-content">
                    <a href="ViewCartServlet">View Cart</a>
                    <a href="#">Check Out</a>
                </div>
            </div>
            <p>Welcome <%=customer.getFirstName()%>!</p>
        </div>
        
    </nav>

    <%
} else {
%>

    <nav class="nav-bar">
        <a href="index.jsp"><div class="company-details">
            <img src="img/company_logo.png" class="company-logo">
            <h1 id="company_name">IoT Bay</h1>
        </div></a>
        <div class="links">
            <ul class="nav-links">
                <li><a href="index.jsp" id="menu_home">Main Home</a></li>
                <li class="dropdown">
                    <a href="BrowseItemsServlet" class="dropbtn">Products</a>
                    <div class="dropdown-content">
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
        <div class="search-container">
            <form action="StockSearchServlet">
              <input type="text" placeholder="What are you looking for today?" name="search">
              <button type="submit"></button>
            </form>
        </div>
        <div class="dropdown">
            <img src="img/shopping-cart.jpg" class="dropimg"/>
                <div class="dropdown-content">
                    <a href="ViewCartServlet">View Cart</a>
                    <a href="#">Check Out</a>
                </div>
            </div>
        <div class="account-container">
            <ul class="account-links">
                <li><a href="CustomerRegister.jsp" id="signup">Sign Up</a></li>
                <li><a href="CustomerLogin.jsp" id="login">Log In</a></li>
                <li><a href="StaffLogin.jsp" id="signup"><button class="staff-btn">Staff Portal</button></a></li>
            </ul>
        </div>
    </nav>
    <%
    }
%>
</header>