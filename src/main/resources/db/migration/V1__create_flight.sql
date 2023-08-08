CREATE DATABASE IF NOT EXISTS flight_booking;

CREATE TABLE IF NOT exists users (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    mobile_number VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT exists airline (
    id INT NOT NULL AUTO_INCREMENT,
    airline_name VARCHAR(50) NOT NULL,
    airline_code VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT exists days (
    id INT NOT NULL AUTO_INCREMENT,
    flight_no VARCHAR(20) NOT NULL,
    sun BOOLEAN,
    mon BOOLEAN,
    tue BOOLEAN,
    wed BOOLEAN,
    thu BOOLEAN,
    fri BOOLEAN,
    sat BOOLEAN,
    PRIMARY KEY (id)
 
);

CREATE TABLE IF NOT exists price (
    id INT NOT NULL AUTO_INCREMENT,
    start_date DATE,
    end_date DATE,
    flight_id VARCHAR(20),
    price DECIMAL(10, 2),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT exists flight (
    id INT NOT NULL AUTO_INCREMENT,
    src VARCHAR(50) NOT NULL,
    destination VARCHAR(50) NOT NULL,
    airline_code VARCHAR(20) NOT NULL,
    flight_no VARCHAR(20) NOT NULL,
    day_id INT NOT NULL,
    FOREIGN KEY (day_id) REFERENCES days(id),
    flight_status BOOLEAN,
    flight_time TIME,
    no_of_seats VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT exists tickets (
    id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    flight_id int NOT NULL,
    FOREIGN KEY (flight_id) REFERENCES flight(id),
    created_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    price_id INT NOT NULL,
    FOREIGN KEY (price_id) REFERENCES price(id),
    travel_date DATE,
    PRIMARY KEY (id)
);


INSERT INTO users (first_name, last_name, mobile_number, email)
VALUES
    ('John', 'Doe', '1234567890', 'john.doe@example.com'),
    ('Jane', 'Smith', '9876543210', 'jane.smith@example.com');

INSERT INTO airline (airline_name, airline_code)
VALUES
    ('Delta Airlines', 'DL'),
    ('United Airlines', 'UA');

INSERT INTO days (flight_no, sun, mon, tue, wed, thu, fri, sat)
VALUES
    ('DL101', 1, 0, 1, 0, 0, 1, 0),
    ('UA202', 0, 1, 0, 1, 0, 0, 1);


INSERT INTO price (start_date, end_date, flight_id, price)
VALUES
    ('2023-08-15', '2023-08-30', 'DL101', 250.00),
    ('2023-09-01', '2023-09-15', 'UA202', 180.50);

INSERT INTO flight (src, destination, airline_code, flight_no, day_id, flight_status, flight_time, no_of_seats)
VALUES
    ('New York', 'Los Angeles', 'DL', 'DL101', 1, 1, '08:00:00', '200'),
    ('Los Angeles', 'Chicago', 'UA', 'UA202', 2, 1, '09:30:00', '180');


INSERT INTO tickets (user_id, flight_id, price_id, travel_date)
VALUES
    (1, 1, 1, '2023-08-20'),
    (2, 2, 2, '2023-09-05');
    
    select* from airline;
