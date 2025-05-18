<%@ page import="model.Order" %>
<%@ page import="dao.OrderDAO" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Order</title>

    <!-- Style overloading -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Sriracha&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="css/OrderStyle.css">
    <link rel="stylesheet" href="css/Header.css">
    <link rel="stylesheet" href="css/Footer.css">

</head>
<body>
    <section>
        <!-- Navigation bar only to go back to the store -->
        <div class="title">
            <h1>IoTBay</h1>
        </div>

        <section class="content">
            <!-- Navigation bar on the left -->
            <div class="left-nav">
                <ul>
                    <li>View Order</li>
                    <li>Track Order</li>
                    <li>View Previous Purchases</li>
                    <li>Update Order Details</li>
                    <li>Cancel Order</li>
                </ul>
            </div>

            <!-- Content page -->
            <div class="right-content">
                <div class="top">
                    <h1>My Order</h1>
                    <div class="button-bar">
                        <button>Current Order</button>
                        <button>Previous Order</button>
                    </div>
                </div>
                <!-- Order Table Content -->
                 <table>
                    <tr>
                        <th>Order Number</th>
                        <th>Items</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Status</th>
                    </tr>
                 </table>
            </div>
        </section>
        
    </section>
</body>
</html>