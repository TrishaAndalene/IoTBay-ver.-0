<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IoT Bay - Staff Login</title>

    <!-- Style overloading -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sriracha&display=swap" rel="stylesheet">
    
    <link rel="stylesheet" href="css/Stafflogin.css">
    <link rel="stylesheet" href="css/Header.css">
    <link rel="stylesheet" href="css/Footer.css">
    

</head>

<body>

    <%@ include file="/Header.jsp" %>

    <div id="main_screen">
        <div class="login-box">
            <div class ="store-logo">
                    <img src="img/company_logo.png" alt="Company Logo">
                    <h1>IoT Bay</h1>
            </div>
            <div class="login-title">
                <h2>Staff Log In</h2>
            </div>
            <form action="StaffLoginServlet" method="post">
                <div class="input-cont">
                        <input type="text" name="email" placeholder="Staff Email">
                        <input type="password" name="password" placeholder="Password">
                </div>
                <div class="submit-cont">
                        <input type="submit" id="signInBtn" value="Sign In">
                        <div class="err">
                            <% String errorMsg = (String) request.getAttribute("errorMsg"); 
                                if (errorMsg != null) { %>
                                <p><%= errorMsg %></p>
                                <% } %>
                    </div> 
                </div> 
                
                </form>
                <br>
                <div class="forgot-container">
                    <h4 id="alternativeLabel">Forgot your password? <a href="#" id="alternativeLink">Click here</a></h4>
                </div>
        </div>
    </div>
    <!-- footer -->
    <%@ include file="/Footer.jsp" %>
</body>
</html>