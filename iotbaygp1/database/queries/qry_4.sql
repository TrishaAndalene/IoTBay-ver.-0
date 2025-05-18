DROP TABLE IF EXISTS Carts;
DROP TABLE IF EXISTS CartItems;

DROP TABLE IF EXISTS Orders;

DROP TABLE IF EXISTS OrderItems;


CREATE TABLE Carts (
    cartID INTEGER PRIMARY KEY AUTOINCREMENT,
    userID INTEGER,
    FOREIGN KEY (userID) REFERENCES Customers(id));


CREATE TABLE CartItems (
    cartItemID INTEGER PRIMARY KEY AUTOINCREMENT,
    cartID INTEGER,
    upc TEXT,
    quantity INTEGER,
    FOREIGN KEY (cartID) REFERENCES Carts(cartID),
    FOREIGN KEY (upc) REFERENCES Products(upc)
);

CREATE TABLE Orders(
    orderID TEXT PRIMARY KEY,
    userID INTEGER,
    datePlaced TEXT NOT NULL,
    totalCost DOUBLE,
    status TEXT NOT NULL,
    FOREIGN KEY (userID) REFERENCES Customers(id)
);

CREATE TABLE OrderItems(
    orderItemID INTEGER PRIMARY KEY AUTOINCREMENT,
    orderID TEXT NOT NULL,
    upc TEXT,
    quantity INTEGER,
    FOREIGN KEY (orderID) REFERENCES Orders(orderID),
    FOREIGN KEY (upc) REFERENCES Products(upc)
);


INSERT INTO Carts (userID) VALUES (1);
INSERT INTO CartItems (cartID, upc, quantity) VALUES
(1, 197853464414, 2),
(1, 197853116382, 1),
(1, 196237773777, 3);



SELECT * FROM Customers;
SELECT * FROM Staff;
SELECT * FROM Products;
SELECT * FROM Carts;
SELECT * FROM CartItems;


