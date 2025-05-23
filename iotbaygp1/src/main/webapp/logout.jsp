<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Company name - Log Out</title>

    <!-- Style overloading -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sriracha&display=swap" rel="stylesheet">
    <script src="script.js"></script>
    
    <link rel="stylesheet" href="style.css">
</head>
<body onload="continuePage(2)">
    <section class="logOut" id="page-1">
        <div class="page-1">
            <img src="WelcomeLogo.png" alt="logo" id="smallerPng">
            <br><br><br>
            <h2>Logging out will terminate your session</h2>
            <h2>and you will not be able to manage</h2>
            <h2>your order, continue?</h2>
            <br>
            <div class="buttons">
                <button onclick="" id="leftButton"><h4>No</h4></button>
                <button onclick="continuePage(2)" id="rightButton"><h4>Yes</h4></button>
            </div>
        </div> 
    </section>

    <section class="logOut" id="page-2">
        <div class="page-2">
            <img src="WelcomeLogo.png" alt="logo">
            <br><br>
            <div class="text-only">
                <h1>Log out succesfull</h1>
                <img src="okaySym.svg" alt="symbol" id="okay">
            </div>
            <br><br>
            <button onclick=""><h4>Continue</h4></button>
        </div>
    </section>
</body>
</html>