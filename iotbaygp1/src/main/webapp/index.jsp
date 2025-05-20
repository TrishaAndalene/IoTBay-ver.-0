<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iot Bay - Home Page</title>

    <!-- Style overloading -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sriracha&display=swap" rel="stylesheet">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
    
    <link rel="stylesheet" href="css/Landing.css">
    <link rel="stylesheet" href="css/Header.css">
    <link rel="stylesheet" href="css/Footer.css">

</head>
<body>
    <jsp:include page="/ConnServlet" flush="true"/>

    <%@ include file="/Header.jsp" %>
    

    <!-- main screen -->
    <div id="main_screen">
        <p id="promotion_title">IoT Bay</p>
        <p id="promotion_line">A very good store!</p>
        <div id="order_btn"><a href="BrowseItemsServlet">Shop Now</a></div>
    </div>

    <!-- Second -->
    <div id="second_screen">
        <!-- Second Screen Text -->
        <div id="second_screen_context">
            <p>SHOP OUR CATEGORIES</p>
        </div>
        <!-- split line -->
        <div id="split_line"></div>
        <!-- frame1 -->
        <div class="category-frame">
            <button>
                <img class="arrow" id="arrow_left" src="img/left.png">
            </button>
            <div class="frame_2nd">
                <img id="frame_2nd_img1" src="img/diamond.jpg">
                <p class="product_name">NAME</p>
            </div>
        <!-- frame2 -->
            <div class="frame_2nd">
                <img id="frame_2nd_img2" src="img/diamond.jpg">
                <p class="product_name">NAME</p>
            </div>
        <!-- frame3 -->
            <div class="frame_2nd">
                <img id="frame_2nd_img3" src="img/diamond.jpg">
                <p class="product_name">NAME</p>
            </div>

            <button>
                <img class="arrow" id="arrow_right" src="img/right.png">
            </button>
        </div>
        <!-- Arrow Sign -->
        <div class="slideshow">
            <img src="img/circle_blue.png">
            <img src="img/circle_grey.png">
            <img src="img/circle_grey.png">
            <img src="img/circle_grey.png">
            <img src="img/circle_grey.png">
        </div>

        <!-- slideshow -->
        
    </div>

    <!-- Customer Favourite -->
    <div id="customer_favourite">
        <!-- Customer Favourite Text -->
        <div id="customer_favourite_context">
            <p>CUSTOMER FAVOURITES</p>
        </div>
        <!-- Search bar -->
        <div id="search_bar">
            <input type="text" placeholder="Type to search" id="search_text">
            <button><img id="search_icon" src="img/search_icon.png"></button>
        </div>

        <!-- frame1 -->
         <div class="customer_fav_frame">
        <div class="frame_3rd">
            <img id="frame_3rd_img1" src="img/stair.jpg">
            <p class="price">$17.99 AUD</p>
            <button class="order_btn">ORDER NOW</button>
        </div>
        <!-- frame2 -->
        <div class="frame_3rd">
            <img id="frame_3rd_img2" src="img/stair.jpg">
            <p class="price">$17.99 AUD</p>
            <button class="order_btn">ORDER NOW</button>
        </div>
        <!-- frame3 -->
        <div class="frame_3rd">
            <img id="frame_3rd_img3" src="img/stair.jpg">
            <p class="price">$17.99 AUD</p>
            <button class="order_btn">ORDER NOW</button>
        </div>
        </div>
    </div>

    <!-- LATEST REVIEWS -->
    <div id="latest_reviews">

        <!-- Latest review context -->
        <div id="latest_reveiw_context">
            <p>LATEST REVEIWS</p>
        </div>

        <!-- Review Section -->
         <div class="review_container">
            <button>
                <img class="arrow" src="img/left.png">
            </button>
            <div id="review_section">
                <div>
                    <!-- img -->
                    <img id="review_img" src="img/diamond.jpg">
                </div>
            </div>
            <div class="wall"></div>
            <button>
                <img class="arrow" src="img/right.png">
            </button>
        </div>
    </div>

    <!-- Want to know about us -->
    <div id="company_detail">
        <!-- Want to know context -->
        <div id="company_context">
            <p>WANT TO KNOW ABOUT US?</p>
        </div>
        <!-- IMG Stack -->
         <div class="about-stack">

        <div class="image-stack" style="position: relative;">
            <img src="img/diamond.jpg" class="stacked-img">
            <img src="img/diamond.jpg" class="stacked-img">
            <img src="img/diamond.jpg" class="stacked-img">
            <img src="img/diamond.jpg" class="stacked-img">
        </div>
        <!-- company text -->
        <div id="company_text">
            <p>Welcome to IoT Bay!</p><br/>
            <p>We are an independant retailer specialising in IoT technologies for personal and business use.</p><br/>
            <p>Visit us in Sydney, or shop with us here online</p><br/>
            <p>- the IoT Bay family x</p>
        </div>
        </div>
    </div>

    <!-- FREQUENT FAQs -->
    <div id="frequent_faq">
        <!-- faq context -->
        <div id="frequent_context">
            <p>FAQs</p>
        </div>

        <!-- faq section -->
        <div class="faq_container">
            <div class="faq_section">
                <p id="faq_section_text">What are the shipping options?</p>
                <button>
                    <img id="plus" src="img/plus.png">
                </button>
            </div>
            <div class="faq_section">
                <p id="faq_section_text">Do you do refunds for online orders?</p>
                <button>
                    <img id="plus" src="img/plus.png">
                </button>
            </div>
            <div class="faq_section">
                <p id="faq_section_text">Do you have a store I can visit in person?</p>
                <button>
                    <img id="plus" src="img/plus.png">
                </button>
            </div>
            <div class="faq_section">
                <p id="faq_section_text">Can I get IoT advice from an expert?</p>
                <button>
                    <img id="plus" src="img/plus.png">
                </button>
            </div>
        </div>
    </>
    <!-- footer -->
    <%@ include file="/Footer.jsp" %>

</body>
</html>