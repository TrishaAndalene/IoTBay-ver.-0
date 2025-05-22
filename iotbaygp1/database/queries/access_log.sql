DROP TABLE IF EXISTS CustomerAccessLog;
DROP TABLE IF EXISTS StaffAccessLog;

CREATE TABLE CustomerAccessLog (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    customer_id INTEGER NOT NULL,
    customer_email TEXT NOT NULL,
    login DATETIME NOT NULL,
    logout DATETIME
);

CREATE TABLE StaffAccessLog (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    staff_id INTEGER NOT NULL,
    staff_email TEXT NOT NULL,
    login DATETIME NOT NULL,
    logout DATETIME
);