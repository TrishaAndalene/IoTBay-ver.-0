
CREATE TABLE StoreCarts (
    cartID INTEGER PRIMARY KEY AUTOINCREMENT,
    staffID INTEGER,
    customerID INTEGER DEFAULT 0, 
    salespersonID INTEGER,
    FOREIGN KEY (staffID) REFERENCES Staff(id),
    FOREIGN KEY (customerID) REFERENCES Customers(id),
    FOREIGN KEY (salespersonID) REFERENCES Staff(id)
    );


CREATE TABLE StoreCartItems (
    cartItemID INTEGER PRIMARY KEY AUTOINCREMENT,
    cartID INTEGER,
    upc TEXT,
    quantity INTEGER,
    FOREIGN KEY (cartID) REFERENCES StoreCarts(cartID),
    FOREIGN KEY (upc) REFERENCES Products(upc)
);


INSERT INTO StoreCarts (staffID, salespersonID) VALUES (1, 1);
INSERT INTO StoreCartItems (cartID, upc, quantity) VALUES
(1, 197853464414, 2),
(1, 197853116382, 1),
(1, 196237773777, 3);


SELECT * FROM StoreCarts;
SELECT * FROM StoreCartItems;