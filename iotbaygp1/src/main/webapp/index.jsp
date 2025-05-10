<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iot Bay</title>

    <!-- Style overloading -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sriracha&display=swap" rel="stylesheet">
    
    <link rel="stylesheet" href="css/Landing.css">

</head>
<body>
    <jsp:include page="/ConnServlet" flush="true"/>

    <header>
        <!-- main company logo -->
        <img id="company_logo" src="img/company_logo.png">
        <!-- compnay name -->
        <h1 id="company_name">IoTBay</h1>
    </header>
    <!-- navigation bar -->
    <nav>
        <a href="" id="menu_home"><h1>Home</h1></a>
        <a href="BrowseItemsServlet" id="menu_browse"><h1>Browse</h1></a>
        <a href="" id="menu_about"><h1>About</h1></a>

        <button id="login_btn"><a href="Login.jsp">LOGIN</a></button>
        <button id="signup_btn"><a href="Signup.jsp">SIGN UP</a></button>
        <button id="signup_btn"><a href="StaffLogin.jsp">Staff</a></button>
    </nav>

    <!-- main screen -->
    <div id="main_screen">
        <img id="main_background" src="img/main_image.png">
        <p id="promotion_title">Promotion Title</p>
        <p id="promotion_line">Promotion line</p>
        <div id="order_btn"><a href="Order.jsp">ORDER NOW</a></div>
    </div>

    <!-- Second -->
    <div id="second_screen">
        <!-- Second Screen Text -->
        <div id="second_screen_context">
            <p>SHOP FROM 15 CATEGORIES</p>
        </div>
        <!-- split line -->
        <div id="split_line"></div>
        <!-- frame1 -->
        <div class="frame_2nd" id="frame1_2">
            <img class="frame_2nd_img" id="frame_2nd_img1" src="img/diamond.jpg">
            <p class="product_name">NAME</p>
        </div>
        <!-- frame2 -->
        <div class="frame_2nd" id="frame2_2">
            <img class="frame_2nd_img" id="frame_2nd_img2" src="img/diamond.jpg">
            <p class="product_name">NAME</p>
        </div>
        <!-- frame3 -->
        <div class="frame_2nd" id="frame3_2">
            <img class="frame_2nd_img" id="frame_2nd_img3" src="img/diamond.jpg">
            <p class="product_name">NAME</p>
        </div>
        <!-- Arrow Sign -->
        <button>
            <img class="arrow" id="arrow_left" src="img/left.png">
        </button>
        <button>
            <img class="arrow" id="arrow_right" src="img/right.png">
        </button>
        <!-- slideshow -->
        <img class="slideshow" id="slideshow1" src="img/circle_blue.png">
        <img class="slideshow" id="slideshow2" src="img/circle_grey.png">
        <img class="slideshow" id="slideshow3" src="img/circle_grey.png">
        <img class="slideshow" id="slideshow4" src="img/circle_grey.png">
        <img class="slideshow" id="slideshow5" src="img/circle_grey.png">
    </div>

    <!-- Customer Favourite -->
    <div id="customer_favourite">
        <!-- Customer Favourite Text -->
        <div id="customer_favourite_context">
            <p>CUSTOMER FAVOURITE</p>
        </div>
        <!-- Search bar -->
        <div id="search_bar">
            <input type="text" placeholder="Type to search" id="search_text">
            <button><img id="search_icon" src="img/search_icon.png"></button>
        </div>

        <!-- frame1 -->
        <div class="frame_3rd" id="frame1_3">
            <img class="frame_3rd_img" id="frame_3rd_img1" src="img/stair.jpg">
            <p class="price">$17.99 AUD</p>
            <button class="order_btn">ORDER NOW</button>
        </div>
        <!-- frame2 -->
        <div class="frame_3rd" id="frame2_3">
            <img class="frame_3rd_img" id="frame_3rd_img2" src="img/stair.jpg">
            <p class="price">$17.99 AUD</p>
            <button class="order_btn">ORDER NOW</button>
        </div>
        <!-- frame3 -->
        <div class="frame_3rd" id="frame3_3">
            <img class="frame_3rd_img" id="frame_3rd_img3" src="img/stair.jpg">
            <p class="price">$17.99 AUD</p>
            <button class="order_btn">ORDER NOW</button>
        </div>
    </div>

    <!-- LATEST REVIEWS -->
    <div id="latest_reviews">
        <!-- Latest review context -->
        <div id="latest_reveiw_context">
            <p>LATEST REVEIWS</p>
        </div>

        <!-- Review Section -->
        <div id="review_section">
            <div>
                <!-- img -->
                <img id="review_img" src="img/diamond.jpg">
            </div>
            <div id="wall"></div>
        </div>.
        <!-- Arrow Sign -->
        <button>
            <img class="arrow" id="arrow_left2" src="img/left.png">
        </button>
        <button>
            <img class="arrow" id="arrow_right2" src="img/right.png">
        </button>
    </div>

    <!-- Want to know about us -->
    <div id="company_detail">
        <!-- Want to know context -->
        <div id="company_context">
            <p>WANT TO KNOW ABOUT US?</p>
        </div>
        <!-- IMG Stack -->
        <div class="image-stack">
            <img src="img/diamond.jpg" class="stacked-img" style="z-index: 4;">
            <img src="img/diamond.jpg" class="stacked-img" style="z-index: 1;">
            <img src="img/diamond.jpg" class="stacked-img" style="z-index: 2;">
            <img src="img/diamond.jpg" class="stacked-img" style="z-index: 3;">
        </div>
        <!-- company text -->
        <div id="company_text">
            <p>Lorem ipsum dolor sit amet,</p><br/>
            <p>consectetur adipiscing elit. Phasellus</p><br/>
            <p>vulputate felis sit amet laoreet</p><br/>
            <p>varius. Curabitur tempor diam vel</p><br/>
            <p>lorem.</p>
        </div>
    </div>

    <!-- FREQUENT FAQs -->
    <div id="frequent_faq">
        <!-- faq context -->
        <div id="frequent_context">
            <p>FREQUENT FAQs</p>
        </div>

        <!-- faq section -->
        <div class="faq_section" id="faq1">
            <p id="faq_section_text">LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISCING.</p>
            <button>
                <img id="plus" src="img/plus.png">
            </button>
        </div>
        <div class="faq_section" id="faq2">
            <p id="faq_section_text">LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISCING.</p>
            <button>
                <img id="plus" src="img/plus.png">
            </button>
        </div>
        <div class="faq_section" id="faq3">
            <p id="faq_section_text">LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISCING.</p>
            <button>
                <img id="plus" src="img/plus.png">
            </button>
        </div>
        <div class="faq_section" id="faq4">
            <p id="faq_section_text">LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISCING.</p>
            <button>
                <img id="plus" src="img/plus.png">
            </button>
        </div>
    </div>
    <!-- footer -->
    <footer>
        <!-- main company logo -->
        <img id="company_logo2" src="img/company_logo.png">
        <!-- compnay name -->
        <h1 id="company_name2">IoTBay</h1>

        <!-- instagram -->
        <img id="instagram" src="img/insta.png">
        <p id="insta_address">@aaaaaaaa</p>

        <!-- Email -->
        <img id="email" src="img/email.png">
        <p id="email_address">aaaa@gmail.com</p>
    </footer>

</body>
</html>