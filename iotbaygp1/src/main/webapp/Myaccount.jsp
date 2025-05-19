<%@ page import="model.Staff" %>
<%@ page import="model.Customer" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iot Bay</title>

    <%-- Style overloading --%>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sriracha&display=swap" rel="stylesheet">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="css/Myaccount.css">
    <link rel="stylesheet" href="css/Header.css">

</head>
<body>
    <%@ include file="/Header.jsp" %>

    <%
        // 세션에서 현재 사용자 정보 가져오기
        // 수정가능하게 하고
        // 수정값 데이터베이스에서 업데이트
        if (staff != null){
    %>
        <%-- Staff --%>
    <div id="content_area">
        <h2>Account Detail</h2>
        <form action="AccountDetailServlet" method="post">
            <h3>First Name</h3>
            <input type="text" name="firstName" value=<%= staff.getFirstName()%> >
            
            <h3>Last Name</h3>
            <input type="text" name="lastName" value=<%= staff.getLastName()%> >
            
            <h3>Phone Number</h3>
            <input type="text" name="phoneNum" value=<%= staff.getPhoneNum()%> >
            
            <h3>Email</h3>
            <input type="email" name="email" value=<%= staff.getEmail()%> >
            
            <h3>Password</h3>
            <input type="password" name="password" value=<%= staff.getPassword()%> >
            
            <br/>
            <input type="submit" id="saveChange" value="Save Changes">
        </form>
        <h2>Access Log</h2>
        <form action="AccessLogServlet" method="post">
            <input type="submit" id="accessLog" value="Access Log">
        </form>
        <h2>Delete Account</h2>
        <form action="AccountDeleteServlet" method="post">
            <input type="email" name="email" placeholder="Enter your email to delete your account">
            <input type="password" name="password" placeholder="Enter your password to delete your account">
            <input type="submit" id="accountDelete" value="Delete Account">
        </form>
    </div>

    <% 
        } else if (customer != null){
    %>

        <%-- Customer --%>
    <div id="content_area">
        <h2>Account Detail</h2>
        <form action="AccountDetailServlet" method="post">
            <h3>First Name</h3>
            <input type="text" name="firstName" value=<%=customer.getFirstName()%> >
            
            <h3>Last Name</h3>
            <input type="text" name="lastName" value=<%= customer.getLastName()%> >
            
            <h3>Phone Number</h3>
            <input type="text" name="phoneNum" value=<%= customer.getPhoneNum()%> >
            
            <h3>Email</h3>
            <input type="email" name="email" value=<%= customer.getEmail()%> >
            
            <h3>Password</h3>
            <input type="password" name="password" value=<%= customer.getPassword()%> >
            
            <br/>
            <input type="submit" id="saveChange" value="Save Changes">
        </form>
        <h2>Access Log</h2>
        <form action="AccessLogServlet" method="post">
            <input type="submit" id="accessLog" value="Access Log">
        </form>
        <h2>Delete Account</h2>
        <form action="AccountDeleteServlet" method="post">
            <input type="email" name="email" placeholder="Enter your email to delete your account">
            <input type="password" name="password" placeholder="Enter your password to delete your account">
            <input type="submit" id="accountDelete" value="Delete Account">
        </form>
    </div>

    <%
        } else {
    %>
        <%-- 로그인 or signin --%>
        <h2>You are currently not signed in</h2>
        <button><a href="CustomerLogin.jsp"><h3>Sign in now!</h3></a></button>
        <h2>Don't have an account with us yet?</h2>
        <button><a href="CustomerRegister.jsp"><h3>Sign up now!</h3></a></button>
    <%
        }
    %>