package model;

public class TrialDatabase {
    
    private static Staff[] staffList = {
        new Staff("Michael", "Scott", "michael.scott@iotbay.com", "0400000000", "12345"),
        new Staff("Jim", "Halpert", "jim.halpert@iotbay.com", "0411111111", "12345"),
        new Staff("Dwight", "Schrute", "dwight.schrute@iotbay.com", "0433333333", "12345"),
        new Staff("Staff", "Member", "staff@iotbay.com", "0440000000", "12345")
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
        new Product("196163505886", "PoE Mini-Computer",  159.00, "Waveshare", "Black", "128GB", "https://www.iot-store.com.au/cdn/shop/products/waveshare-iot-board-poe-mini-computer-based-on-raspberry-pi-compute-module-4-with-fan-29394612486329.jpg?height=720&v=1624966878", 13, "Based on Raspberry Pi Compute Module 4 (with Fan)", "MINI_PC"),

        new Product("196237764294", "reTerminal Device Manager", 699.00, "Seeed Studio",  "White", "10.5 inches ", "https://www.iot-store.com.au/cdn/shop/files/seeed-studio-mini-pc-reterminal-dm-raspberry-pi-cm4-10-1-panel-pc-all-in-one-node-red-39054897348844.png?height=720&v=1687926281", 5, "Raspberry Pi CM4 8GB 10.1 Panel PC All-in-one, Node-RED", "AMBIENT_IOT"),

        new Product("196163749051", "SenseCAP Card Tracker T1000-E", 108.95,"Seeed Studio", "Grey", "85mm","https://www.iot-store.com.au/cdn/shop/files/seeed-studio-lora-iot-sensecap-card-tracker-t1000-e-for-meshtastic-42041235210476.png?height=1280&v=1732048600", 17, "for Meshtastic - designed to create a mesh network-based communication system using low-power, long-range radio like LoRa", "ACTIVITY_TRACKER"),

        new Product("196237161611", "Jetson AGX Orin", 4198.95,"NVIDIA", "Grey", "64GB","https://www.iot-store.com.au/cdn/shop/products/seeed-studio-iot-board-nvidia-jetson-agx-orin-developer-kit-smallest-and-most-powerful-ai-edge-computer-37683726221548.jpg?height=720&v=1662190076", 27, "Smallest and most Powerful AI Edge Computer - provides a giant leap forward for Robotics and Edge AI", "MINI_PC"),

        new Product("196237773432", "Industrial Remote IO Edge Gateway Data Logger", 448.95,"USR IOT", "White", "4G","https://www.iot-store.com.au/cdn/shop/files/usr-iot-edge-gateway-remote-io-edge-gateway-usr-m300-40113708302572.png?height=533&v=1711200281", 4, "USR-M300 - integrates edge collection, data calculation, data reading and writing, active reporting, linkage control, IO collection and control and other functions", "AMBIENT_IOT"),

        new Product("196163517001", "Milesight Field Tester FT101", 948.95,"Milesight IOT", "Black", "5.72 inch","https://www.iot-store.com.au/cdn/shop/files/milesight-iot-ursalink-field-tester-milesight-field-tester-ft101-ultimate-lorawan-plug-play-analyser-41721931071724.jpg?height=1280&v=1727556162", 36, "Plug&Play Analyser - featuring a 5.72-inch HD touch screen, it provides real-time network signal testing and analysis at your fingertips, making it easier to deploy and manage LoRaWAN® devices", "AMBIENT_IOT"),

        new Product("196163517002", "Chroma Servo Board V3", 29.95,"Itead Studio", "No Colour", "39.6mm","https://www.iot-store.com.au/cdn/shop/products/itead-studio-raspberry-pi-chroma-servo-board-v3-for-raspberry-pi-25635472327.jpg?height=940&v=1550491354", 24, "A small board that connects to a Raspberry Pi and allows you to control up to eight RC servos (or ESCs) via the serial port in the GPIO port of the Raspberry Pi", "MINI_PC"),

        new Product("196163740799", "RAK2171 WisNode TrackIt GPS Tracker", 159.95, "RAK Wireless", "White", "No Size", "https://www.iot-store.com.au/cdn/shop/products/rak-wireless-lora-iot-rak2171-wisnode-trackit-lorawan-gps-tracker-37087966494956.gif?height=720&v=1724589254", 8, "WisNode TrackIt is RAKwireless latest LoRaWAN GPS tracking device. It comes in a small form factor with a rechargeable battery and tracking and configuration application", "ACTIVITY_TRACKER"),

        new Product("196237775375", "Mini Computer Router", 289.95, "Seeed Studio", "White", "No Size", "https://www.iot-store.com.au/cdn/shop/products/seeed-studio-mini-pc-mini-computer-router-with-raspberry-pi-cm4-dual-gigabit-ethernet-4gb-ram-32gb-emmc-30026244849849.png?height=940&v=1629516825", 2, "The Dual Gigabit Carrier Board powered by Raspberry Pi Compute Module 4 is equipped with dual Gigabit Ethernet ports and dual USB 3.0 ports, making it suitable for soft router applications, while keeping the hardware to a minimum", "MINI_PC"),

        new Product("197853464414", "reComputer R2130 High-Performance Edge AI Computer", 478.95, "Seeed Studio", "Silver", "8GB", "https://www.iot-store.com.au/cdn/shop/files/waveshare-touch-display-recomputer-raspberry-pi-high-ai-acceleration-module-1145503714.jpg?height=1280&v=1741427426", 21, "Powerful Cooling Capabilities: The compact design and optimized thermal architecture make it highly suitable for deployment in resource-constrained environments, providing excellent cooling performance. Powerful Performance: Powered by Raspberry Pi 5 with quad-core Cortex-A76 CPU, up to 8GB RAM.", "MINI_PC"),


        new Product("197853467545", "WisBlock Kit 2 LoRaWAN GPS Tracker", 169.95, "RAK Wireless", "Grey", "100mm", "https://www.iot-store.com.au/cdn/shop/files/rak-wireless-lora-iot-wisblock-kit-2-lorawan-gps-tracker-with-solar-panel-39079537803500.png?height=1280&v=1688783802", 15, "WisBlock Kit 2 LoRaWAN GPS Tracker with Solar Panel is a GPS tracker with a sensor to detect location change every set time interval. Optional battery backup with solar panel built-in on the enclosure is used for recharging to ensure uninterrupted data transmission.", "ACTIVITY_TRACKER"),


        new Product("196237348043", "LoRaWAN Asset GPS Tracker Accelerometer", 179.95, "Dragino", "Black", "No Size", "https://www.iot-store.com.au/cdn/shop/files/dragino-tracking-device-trackerd-ls-lorawan-asset-gps-tracker-accelerometer-39512874647788.png?height=720&v=1702187502", 3, "TrackerD-LS is an Open Source LoRaWAN Asset Tracker based on ESP32 MCU and Semtech LoRa Wireless Chip. It can get the location data via GPS and set it to IoT server via LoRaWAN network. TrackerD-LS supports Motion Detection, when there is motion, TrackerD-LS can send data more frequently and it will save power when no motion is detected.", "ACTIVITY_TRACKER"),


        new Product("197853116382", "External Siren", 99.95, "Home8", "White", "No Size", "https://www.iot-store.com.au/cdn/shop/products/home8-smart-home-external-siren-home8-161253294099.jpg?height=350&v=1550457232", 16, "An escalating 110db audible alarm to frighten intruders and alert others. Plug & play self-installable, it is added to the system by scanning the QR code. Maximum ease of use. 433 MHz Wireless with the gateway, range 15 m indoor. The notification system of the state-supervised AC / DC 5 V included. Internal battery, which is activated when there is a power failure", "HOME_SECURITY"),


        new Product("196237513274", "Security Alarm System Package", 99.95, "Home8", "White", "No Size", "https://www.iot-store.com.au/cdn/shop/products/home8-smart-home-security-alarm-system-package-home8-160394674195.png?height=533&v=1550436634", 19, "Home8 window and door sensors will help you sleep better at night; as soon as an intrusion into your home is detected, you are notified instantly via push notifications so that you are better poised to react to any imminent threat.", "HOME_SECURITY"),


        new Product("196237773777", "WiFi Range Extender Gateway", 69.95, "Home8", "White", "No Size", "https://www.iot-store.com.au/cdn/shop/products/home8-smart-home-wifi-range-extender-gateway-home8-161192607763.png?height=533&v=1550466597", 6, "Works with all Home8 systems. Extends the range of devices connecting to your Home8 Shuttle within a building environment. Suggested placement of your repeater is within 15 meters of the Home8 Shuttle (your usage will vary depending on environmental factors such as walls, metal radio interference and more)", "WIFI"),

        new Product("196237510433", "AP520X WiFi6 AX3000 WiFi Access Point", 399.95, "USR IOT", "White", "512MB", "https://www.iot-store.com.au/cdn/shop/files/usr-iot-wireless-access-point-ap520x-wifi6-ax3000-dual-band-outdoor-wifi-access-point-41400370823404.jpg?v=1726315073", 9, "AP520X is an outdoor WiFi6 dual-band AP that supports 5G NR. which is also called FWA (Fixed Wireless Access) AP. The product is based on the powerful Qualcomm core, with 27dBm TX power and external antennas. It supports the IEEE 802.11a/b/g/n/ac /ax protocols, the maximum WiFi access rate reaches 2975Mbps.", "WIFI"),

        new Product("196237346803", "MikroProg USB Programmer & Hardware Debugger", 79.95, "MikroElektronika", "White", "No Size", "https://www.iot-store.com.au/cdn/shop/products/mikroelektronika-programmers-debuggers-mikroprog-for-msp432-mikroelektronika-usb-programmer-hardware-debugger-2497529020503.jpg?height=1280&v=1550483359", 8, "mikroProg™ for MSP432 is a fast and reliable USB programmer and hardware debugger. This mikroProg supports the SimpleLink™ MSP432™ microcontroller family from Texas Instruments.", "AMBIENT_IOT"),

        new Product("197853116245", "LS-112P LoRaWAN Temperature & Humidity Sensor", 318.95, "Globalsat", "White", "No Size", "https://www.iot-store.com.au/cdn/shop/products/globalsat-lorawan-globalsat-ls-112p-lorawan-compliant-co-temperature-humidity-sensor-30958107603.png?height=720&v=1550441254", 22, "LS-112P is designed to measure Carbon Monoxide (CO), Temperature and Humidity by LoRaWAN long-range and low-power wireless connectivity. It is integrated LoRaWAN wireless technology, CO sensor know-how and high-performance MCU solution for various IoT markets usage. With calibrated CO sensor module and compensated Temperature/ Humidity sensor integration, the data is ready for use.", "AMBIENT_IOT")

    };

    public static void addProduct(String upc, String name, double price, String brand, String colour, String size, String img, int qty, String description){
        //productList.add(new Product(upc, name, price, brand, colour, size, img, qty));

    }

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
