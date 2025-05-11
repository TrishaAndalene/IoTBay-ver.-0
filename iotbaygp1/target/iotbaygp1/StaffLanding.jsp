<%@ page import="model.Staff" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Staff Homepage</title>   
    <link rel="stylesheet" href="css/Stafflanding.css">
    <link rel="stylesheet" href="css/Header.css">
    <link rel="stylesheet" href="css/Footer.css">
    
</head>
<body>
    <%@ include file="/Header.jsp" %>

    <%
    if (staff == null){    
 %>
        <p>Please log in first.</p>
<%   
        } else {
%>   
    <!-- main screen -->
    <div id="main_screen">
        <h2 id="staff_name">Welcome <%=staff.getFirstName()%>!</h2>
        <div id="stockmgmt_btn"><a href="StockMgmtServlet" id="stock_mgmt">Stock Management</a></div>
        <div id="ordermgmt_btn"><a href="Order_Mgmt.jsp">Order Management</a></div>
    </div>
    
    <%@ include file="/Footer.jsp" %>
    <%
}
%>
</body>
</html>