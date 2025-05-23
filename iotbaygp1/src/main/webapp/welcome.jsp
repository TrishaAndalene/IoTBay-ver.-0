<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Company name - Welcome</title>

    <!-- Style overloading -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sriracha&display=swap" rel="stylesheet">
    <script src="script.js"></script>
    
    <link rel="stylesheet" href="style.css">

</head>
<body onload="continuePage(1)">
    <section class="welcome" id="page-1">
        <div class="page-1">
            <img src="WelcomeLogo.png" alt="logo">
            <h1>Hi, {User}!</h1>
            <h2>Welcome to Company name</h2>
            <br>
            <button onclick="continuePage(2)"><h4>NEXT</h4></button>
        </div>

    </section>
    <section class="welcome" id="page-2">
        <div class="page-2">
            <img src="WelcomeLogo.png" alt="logo" id="smallerPng">
            <br><br><br>
            <h2>Would you like for us to guide you on</h2>
            <h2>how to navigate through the store?</h2>
            <br>
            <div class="buttons">
                <button onclick="continuePage(4)" id="leftButton"><h4>No</h4></button>
                <button onclick="continuePage(3)" id="rightButton"><h4>Yes</h4></button>
            </div>
        </div> 
    </section>

    <section class="welcome" id="page-3">
        <div class="page-3">
            <img src="WelcomeLogo.png" alt="logo" id="smallerPng">
            <br><br>
            <video controls>
                <source src="video1.mp4" type="video/mp4">
            </video>
            <br><br><br>
            <button onclick="continuePage(4)"><h4>NEXT</h4></button>
        </div>
    </section>
    
    <section class="welcome" id="page-4">
        <div class="page-4">
            <img src="WelcomeLogo.png" alt="logo">
            <br><br>
            <h1>Thank you for joining </h1>
            <h2>the {Company name} family!</h2>
            <br><br>
            <button onclick=""><h4>Start Exploring!</h4></button>
        </div>
    </section>
</body>
</html>

<!-- code for getting the String data

<% String username = request.getParameter("name"); -> write the parameter name as the input name

<h1>Hello, <%=username%></h1>


-->