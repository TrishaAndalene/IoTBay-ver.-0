
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
    id INTEGER PRIMARY KEY,
    upc TEXT NOT NULL UNIQUE,
    name TEXT NOT NULL,
    price REAL NOT NULL,
    brand TEXT NOT NULL,
    colour TEXT NOT NULL,
    size TEXT NOT NULL,
    quantity INTEGER NOT NULL,
    category TEXT DEFAULT 'None');

INSERT INTO Products (upc, name, price, brand, colour, size, quantity) VALUES
('196163505886', 'iPhone 15', 1299.00, 'Apple', 'Silver', '128GB', 25),
('196237764294', 'MicroSD', 69.95,'ComputerItems','Colbolt Blue','64GB', 25),
('196163740799', '27" Monitor',368.95,'Dell','Black','64GB', 25),
('196163749051', 'HDMI Cord', 29.95 ,'Name Brand','Grey','2m', 25),
('196237161611', 'Screen Wipes', 14.95,'Name Brand','No Colour','50', 25),
('196237773432','Keyboard',149.95,'Lenovo','Space Grey','Compact', 25),
('196163517001','Keyboard',249.95,'Lenovo','Space Grey','Standard', 25);

INSERT INTO Staff (firstName, lastName, email, phoneNum, password) VALUES
('Michael', 'Scott', 'michael.scott@iotbay.com', '0400000000', '12345'),
('Jim', 'Halpert', 'jim.halpert@iotbay.com', '0411111111', '12345'),
('Dwight', 'Schrute', 'dwight.schrute@iotbay.com', '0433333333', '12345'),
('Pam', 'Beasley', 'pam.beasley@iotbay.com', '0444444444', '12345'),
('Kevin', 'Malone', 'kevin.malone@iotbay.com', '0455555555', '12345');

INSERT INTO Customers (firstName, lastName, email, phoneNum, password) VALUES
('Michael', 'Scott', 'michael.scott@dundermifflin.com', '0400000000', '12345'),
('Jim', 'Halpert', 'jim.halpert@dundermifflin.com', '0411111111', '12345'),
('Dwight', 'Schrute', 'dwight.schrute@dundermifflin.com', '0433333333', '12345'),
('Pam', 'Beasley', 'pam.beasley@dundermifflin.com', '0444444444', '12345'),
('Kevin', 'Malone', 'kevin.malone@dundermifflin.com', '0455555555', '12345');


