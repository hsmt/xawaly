CREATE TABLE sessions (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    device VARCHAR(50),
    os VARCHAR(50),
    name VARCHAR(50),
    action TEXT,
    start_datetime DATETIME DEFAULT NULL,
    end_datetime DATETIME DEFAULT NULL,
    created DATETIME DEFAULT NULL,
    modified DATETIME DEFAULT NULL
);
