-- DROP TABLE IF EXISTS Staff;
-- DROP TABLE IF EXISTS Customers;
-- DROP TABLE IF EXISTS Products;

CREATE TABLE Staff (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    firstName TEXT NOT NULL,
    lastName TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    phoneNum TEXT NOT NULL,
    password TEXT NOT NULL
    );

CREATE TABLE Customers (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    firstName TEXT NOT NULL,
    lastName TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    phoneNum TEXT NOT NULL,
    password TEXT NOT NULL,
    address TEXT DEFAULT 'None');

CREATE TABLE Products (
    upc TEXT PRIMARY KEY,
    name TEXT NOT NULL,
    price REAL NOT NULL,
    brand TEXT NOT NULL,
    colour TEXT NOT NULL,
    size TEXT NOT NULL,
    image TEXT NOT NULL,
    quantity INTEGER NOT NULL,
    category TEXT DEFAULT 'None',
    description TEXT DEFAULT 'None');

CREATE TABLE Orders (
    code TEXT PRIMARY KEY,
    name TEXT NOT NULL,
    orderList TEXT NOT NULL,
    cost FLOAT NOT NULL,
    status TEXT NOT NULL);

INSERT INTO Orders (code, name, orderList, cost, status) VALUES ('123456789', 'Wilson', 'Wifi, Battery, etc', 120.0, 'Received');

INSERT INTO Products (upc, name, price, brand, colour, size, image, quantity, description) VALUES
('196163505886', 'PoE Mini-Computer ', 159.00, 'Waveshare', 'Black', '128GB', 'product_img/iot-boardcm4.jpg' ,25, 'Based on Raspberry Pi Compute Module 4 (with Fan)'),

('196237764294', 'reTerminal Device Manager', 699.00, 'Seeed Studio','White','10.5"', 'product_img/reterminal-dm.png', 25, 'Raspberry Pi CM4 8GB 10.1 Panel PC All-in-one, Node-RED'),

('196163740799', 'RAK2171 WisNode TrackIt GPS Tracker', 159.95, 'RAK Wireless','White','No Size','product_img/wisnode-trackit.jpg', 25, 'WisNode TrackIt is RAKwireless latest LoRaWAN GPS tracking device. It comes in a small form factor with a rechargeable battery and tracking and configuration application'),

('196163749051', 'SenseCAP Card Tracker T1000-E', 108.95, 'Seeed Studio','Grey','85mm', 'product_img/sensecap-t1000.png', 25, 'for Meshtastic - designed to create a mesh network-based communication system using low-power, long-range radio like LoRa'),

('196237161611', 'Jetson AGX Orin', 4198.95, 'NVIDIA','Grey','64GB', 'product_img/nvidia-jetson.jpg', 25, 'Smallest and most Powerful AI Edge Computer - provides a giant leap forward for Robotics and Edge AI'),

('196237773432', 'Industrial Remote IO Edge Gateway Data Logger', 448.95, 'USR IOT','White','4G', 'product_img/usr-m300.png', 25, 'USR-M300 - integrates edge collection, data calculation, data reading and writing, active reporting, linkage control, IO collection and control and other functions'),

('196163517001', 'Milesight Field Tester FT101', 948.95, 'Milesight IOT','Black','5.72"', 'product_img/milesight-ft101.png', 25, 'Plug&Play Analyser - featuring a 5.72-inch HD touch screen, it provides real-time network signal testing and analysis at your fingertips, making it easier to deploy and manage LoRaWAN® devices'),

('196163517002', 'Chroma Servo Board V3', 29.95, 'Itead Studio','No Colour','39.6mm', '/product_img/chroma-v3.jpg', 25, 'A small board that connects to a Raspberry Pi and allows you to control up to eight RC servos (or ESCs) via the serial port in the GPIO port of the Raspberry Pi');

INSERT INTO Staff (firstName, lastName, email, phoneNum, password) VALUES
('Michael', 'Scott', 'michael.scott@iotbay.com', '0400000000', '12345'),
('Jim', 'Halpert', 'jim.halpert@iotbay.com', '0411111111', '12345'),
('Dwight', 'Schrute', 'dwight.schrute@iotbay.com', '0433333333', '12345'),
('Pam', 'Beasley', 'pam.beasley@iotbay.com', '0444444444', '12345'),
('Kevin', 'Malone', 'kevin.malone@iotbay.com', '0455555555', '12345');

INSERT INTO Customers (firstName, lastName, email, phoneNum, password) VALUES
('Michael', 'Scott', 'michael.scott@dundermifflin.com', '0410000000', '12345'),
('Jim', 'Halpert', 'jim.halpert@dundermifflin.com', '0421111111', '12345'),
('Dwight', 'Schrute', 'dwight.schrute@dundermifflin.com', '0443333333', '12345'),
('Pam', 'Beasley', 'pam.beasley@dundermifflin.com', '0454444444', '12345'),
('Kevin', 'Malone', 'kevin.malone@dundermifflin.com', '0465555555', '12345');