DROP TABLE IF EXISTS Payments;





CREATE TABLE Payments (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    customerID INTEGER NOT NULL,
    name TEXT NOT NULL,
    cardNumber TEXT NOT NULL,
    type TEXT NOT NULL,
    amount REAL NOT NULL,
    date TEXT NOT NULL,
    FOREIGN KEY (customerID) REFERENCES Customers(id));

INSERT INTO Payments (customerID, name, cardNumber, type, amount, date)
VALUES (7, 'Bob Customer', '1234567890123456', 'Visa', 79.95, '2025-05-17 Sat 00:44:00');


