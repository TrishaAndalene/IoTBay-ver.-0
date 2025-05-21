DROP TABLE IF EXISTS SavedPayments;
DROP TABLE IF EXISTS Payments;
DROP TABLE IF EXISTS ConfirmedPayments;
DROP TABLE IF EXISTS ShipmentAddress;
DROP TABLE IF EXISTS SavedAddresses;

DROP TABLE IF EXISTS Orders;

DROP TABLE IF EXISTS OrderItems;

CREATE TABLE Orders(
    orderID TEXT PRIMARY KEY,
    userID INTEGER,
    datePlaced DATE,
    totalCost DOUBLE,
    status TEXT NOT NULL,
    FOREIGN KEY (userID) REFERENCES Customers(id));

CREATE TABLE OrderItems(
    orderItemID INTEGER PRIMARY KEY AUTOINCREMENT,
    orderID TEXT NOT NULL,
    upc TEXT,
    quantity INTEGER,
    FOREIGN KEY (orderID) REFERENCES Orders(orderID),
    FOREIGN KEY (upc) REFERENCES Products(upc)
);


CREATE TABLE Payments (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    customerID INTEGER NOT NULL,
    name TEXT NOT NULL,
    cardNumber TEXT NOT NULL,
    type TEXT NOT NULL,
    FOREIGN KEY (customerID) REFERENCES Customers(id));

INSERT INTO Payments (customerID, name, cardNumber, type)
VALUES (7, 'Bob Customer', '1234567890123456', 'Visa');

CREATE TABLE ConfirmedPayments (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    orderID STRING NOT NULL,
    customerID INTEGER NOT NULL,
    name TEXT NOT NULL,
    cardNumber TEXT NOT NULL,
    type TEXT NOT NULL,
    amount REAL NOT NULL,
    purchaseDate DATE,
    FOREIGN KEY (customerID) REFERENCES Customers(id),
    FOREIGN KEY (orderID) REFERENCES Orders(orderID));

CREATE TABLE SavedPayments (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    customerID INTEGER NOT NULL,
    name TEXT NOT NULL,
    cardNumber TEXT NOT NULL,
    type TEXT NOT NULL,
    FOREIGN KEY (customerID) REFERENCES Customers(id));

INSERT INTO SavedPayments (customerID, name, cardNumber, type)
VALUES (7, 'Bob Customer', '1234567890123456', 'Visa'),
(1, 'John Smith', '5416223048692311', 'Mastercard'),
(10, 'Trisha Customer', '0400234421459121', 'Visa');


CREATE TABLE ShipmentAddress (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    orderID INTEGER NOT NULL,
    customerID INTEGER NOT NULL,
    custName TEXT NOT NULL,
    streetNum TEXT NOT NULL,
    street TEXT NOT NULL,
    suburb TEXT NOT NULL,
    state TEXT NOT NULL,
    postcode TEXT NOT NULL,
    FOREIGN KEY (customerID) REFERENCES Customers(id),
    FOREIGN KEY (orderID) REFERENCES Orders(orderID));

CREATE TABLE SavedAddresses (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    customerID INTEGER NOT NULL,
    streetNum TEXT NOT NULL,
    street TEXT NOT NULL,
    suburb TEXT NOT NULL,
    state TEXT NOT NULL,
    postcode TEXT NOT NULL,
    FOREIGN KEY (customerID) REFERENCES Customers(id));

INSERT INTO SavedAddresses (customerID, streetNum, street, suburb, state, postcode)
VALUES (1, '123', 'Fake St', 'Sydney', 'NSW', '2000'),
(7,'42', 'Party St', 'Newtown', 'NSW', '2042'),
(10, '1', 'Cool St', 'Sydney', 'NSW', '2000');

DELETE 