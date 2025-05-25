<%@ page import="model.Staff" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Staff Portal</title>  
    
     <!-- adding google fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sriracha&display=swap" rel="stylesheet">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

    <!-- adding css -->
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
        <div id="storepurchase_btn"><a href="StoreCartServlet" id="stock_mgmt">Store Cart</a></div>
        <div id="stockmgmt_btn"><a href="StockMgmtServlet" id="stock_mgmt">Stock Management</a></div>
        <div id="ordermgmt_btn"><a href="#">Reports</a></div>
    </div>
    
    <%@ include file="/Footer.jsp" %>
    <%
}
%>
</body>
</html>