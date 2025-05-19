
DROP TABLE IF EXISTS StorePurchases;
DROP TABLE IF EXISTS StorePurchaseItems;


CREATE TABLE StorePurchases (
    purchaseID INTEGER PRIMARY KEY AUTOINCREMENT,
    customerID INTEGER DEFAULT 0,
    salespersonID INTEGER,
    purchaseDate DATE,
    transType TEXT DEFAULT 'Purchase',
    totalCost FLOAT,
    FOREIGN KEY (customerID) REFERENCES Customers(id),
    FOREIGN KEY (salespersonID) REFERENCES Staff(id)
    );


CREATE TABLE StorePurchaseItems (
    storePurchaseItemID INTEGER PRIMARY KEY AUTOINCREMENT,
    purchaseID INTEGER,
    upc TEXT,
    quantity INTEGER,
    FOREIGN KEY (purchaseID) REFERENCES StorePurchase(purchaseID),
    FOREIGN KEY (upc) REFERENCES Products(upc)
);


INSERT INTO StorePurchases (customerID, salespersonID, purchaseDate, totalCost) VALUES (3, 2, CURRENT_TIMESTAMP, 1706.7);
INSERT INTO StorePurchaseItems (purchaseID, upc, quantity) VALUES
(1, 197853464414, 3),
(1, 197853116382, 2),
(1, 196237773777, 1);

INSERT INTO StorePurchases (customerID, salespersonID, purchaseDate, totalCost) VALUES (5, 2, CURRENT_TIMESTAMP, 4357.95);
INSERT INTO StorePurchaseItems (purchaseID, upc, quantity) VALUES
(2, 196237161611, 1),
(2, 197853116245, 1);

INSERT INTO StorePurchases (customerID, salespersonID, purchaseDate, totalCost) VALUES (1, 2, CURRENT_TIMESTAMP, 99.95);
INSERT INTO StorePurchaseItems (purchaseID, upc, quantity) VALUES
(3, 197853116382, 1);

INSERT INTO StorePurchases (customerID, salespersonID, purchaseDate, totalCost) VALUES (8, 2, CURRENT_TIMESTAMP, 399.95);
INSERT INTO StorePurchaseItems (purchaseID, upc, quantity) VALUES
(4, 196237510433, 1);

INSERT INTO StorePurchases (salespersonID, purchaseDate, totalCost) VALUES (2, CURRENT_TIMESTAMP, 459);
INSERT INTO StorePurchaseItems (purchaseID, upc, quantity) VALUES
(5, 196163740775, 1);

INSERT INTO StorePurchases (salespersonID, purchaseDate, totalCost) VALUES (2, CURRENT_TIMESTAMP, 59.90);
INSERT INTO StorePurchaseItems (purchaseID, upc, quantity) VALUES
(6, 196163517002, 2);

INSERT INTO StorePurchases (customerID, salespersonID, purchaseDate, totalCost) VALUES (5, 2, CURRENT_TIMESTAMP, 509.85);
INSERT INTO StorePurchaseItems (purchaseID, upc, quantity) VALUES
(7, 197853467545, 3);


INSERT INTO StorePurchases (customerID, salespersonID, purchaseDate, totalCost) VALUES (3, 2, CURRENT_TIMESTAMP, 477);
INSERT INTO StorePurchaseItems (purchaseID, upc, quantity) VALUES
(8, 197853116245, 3);


INSERT INTO StorePurchases (salespersonID, purchaseDate, totalCost) VALUES (2, CURRENT_TIMESTAMP, 319.90);
INSERT INTO StorePurchaseItems (purchaseID, upc, quantity) VALUES
(9, 196163740799, 2);
