package model;

public class TrialDatabase {
    
    private static Staff[] staffList = {
        new Staff("Michael", "Scott", "michael.scott@iotbay.com", "0400000000", "12345"),
        new Staff("Jim", "Halpert", "jim.halpert@iotbay.com", "0411111111", "12345"),
        new Staff("Dwight", "Schrute", "dwight.schrute@iotbay.com", "0433333333", "12345")
    };

    public static Staff findStaff(String email, String password) {
        for (Staff s : staffList) {
            if (s.getEmail().equals(email) && s.getPassword().equals(password)) {
                return s;
            }
        }
        return null;
    }

    // ==== CUSTOMER ====
    private static Customer[] customerList = {
        new Customer("Jim", "Halpert", "jimhalpert@dundermifflin.com", "0421111111", "12345"),
        new Customer("Pam", "Beesly", "pambeesly@dundermifflin.com", "0421111111", "12345")
    };

    public static Customer findCustomer(String email, String password) {
        for (Customer c : customerList) {
            if (c.getEmail().equals(email) && c.getPassword().equals(password)) {
                return c;
            }
        }
        return null;
    }

    // ==== PRODUCT ====
    private static Product[] productList = {
        new Product("196163505886", "PoE Mini-Computer",  159.00, "Waveshare", "Black", "128GB", "https://www.iot-store.com.au/cdn/shop/products/waveshare-iot-board-poe-mini-computer-based-on-raspberry-pi-compute-module-4-with-fan-29394612486329.jpg?height=720&v=1624966878", 25, "Based on Raspberry Pi Compute Module 4 (with Fan)"),

        new Product("196237764294", "reTerminal Device Manager", 699.00, "Seeed Studio",  "White", "10.5 inches ", "https://www.iot-store.com.au/cdn/shop/files/seeed-studio-mini-pc-reterminal-dm-raspberry-pi-cm4-10-1-panel-pc-all-in-one-node-red-39054897348844.png?height=720&v=1687926281", 25, "Raspberry Pi CM4 8GB 10.1 Panel PC All-in-one, Node-RED"),

        new Product("196163749051", "SenseCAP Card Tracker T1000-E", 108.95,"Seeed Studio", "Grey", "85mm","https://www.iot-store.com.au/cdn/shop/files/seeed-studio-lora-iot-sensecap-card-tracker-t1000-e-for-meshtastic-42041235210476.png?height=1280&v=1732048600", 25, "for Meshtastic - designed to create a mesh network-based communication system using low-power, long-range radio like LoRa"),

        new Product("196237161611", "Jetson AGX Orin", 4198.95,"NVIDIA", "Grey", "64GB","https://www.iot-store.com.au/cdn/shop/products/seeed-studio-iot-board-nvidia-jetson-agx-orin-developer-kit-smallest-and-most-powerful-ai-edge-computer-37683726221548.jpg?height=720&v=1662190076", 25, "Smallest and most Powerful AI Edge Computer - provides a giant leap forward for Robotics and Edge AI"),

        new Product("196237773432", "Industrial Remote IO Edge Gateway Data Logger", 448.95,"USR IOT", "White", "4G","https://www.iot-store.com.au/cdn/shop/files/usr-iot-edge-gateway-remote-io-edge-gateway-usr-m300-40113708302572.png?height=533&v=1711200281", 25, "USR-M300 - integrates edge collection, data calculation, data reading and writing, active reporting, linkage control, IO collection and control and other functions"),

        new Product("196163517001", "Milesight Field Tester FT101", 948.95,"Milesight IOT", "Black", "5.72 inch","https://www.iot-store.com.au/cdn/shop/files/milesight-iot-ursalink-field-tester-milesight-field-tester-ft101-ultimate-lorawan-plug-play-analyser-41721931071724.jpg?height=1280&v=1727556162", 25, "Plug&Play Analyser - featuring a 5.72-inch HD touch screen, it provides real-time network signal testing and analysis at your fingertips, making it easier to deploy and manage LoRaWAN® devices"),

        new Product("196163517002", "Chroma Servo Board V3", 29.95,"Itead Studio", "No Colour", "39.6mm","https://www.iot-store.com.au/cdn/shop/products/itead-studio-raspberry-pi-chroma-servo-board-v3-for-raspberry-pi-25635472327.jpg?height=940&v=1550491354", 25, "A small board that connects to a Raspberry Pi and allows you to control up to eight RC servos (or ESCs) via the serial port in the GPIO port of the Raspberry Pi"),

        new Product("196163740799", "RAK2171 WisNode TrackIt GPS Tracker", 159.95, "RAK Wireless", "White", "No Size", "https://www.iot-store.com.au/cdn/shop/products/rak-wireless-lora-iot-rak2171-wisnode-trackit-lorawan-gps-tracker-37087966494956.gif?height=720&v=1724589254", 25, "WisNode TrackIt is RAKwireless latest LoRaWAN GPS tracking device. It comes in a small form factor with a rechargeable battery and tracking and configuration application")
    };

    public static Product[] getAllProducts() {
        return productList;
    }

    public static Product findProduct(String upc) {
        for (Product p : productList) {
            if (p.getUPC().equals(upc)) {
                return p;
            }
        }
        return null;
    }

    // ==== Test Main ====
    public static void main(String[] args) {
        Staff s = findStaff("michael.scott@iotbay.com", "12345");
        System.out.println(s != null ? "Staff logged in: " + s : "Staff login failed.");

        Customer c = findCustomer("pambeesly@dundermifflin.com", "12345");
        System.out.println(c != null ? "Customer logged in: " + c : "Customer login failed.");

        System.out.println("All products:");
        for (Product p : getAllProducts()) {
            System.out.println(p);
        }
    }



}
