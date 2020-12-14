CREATE DATABASE IF NOT EXISTS cinemaDB

USE cinemaDB

CREATE TABLE IF NOT EXISTS movies (
	movieName VARCHAR(50),
	movieDate VARCHAR(50),
	movieTime VARCHAR(50),
	moviePrice DOUBLE,
	PRIMARY KEY (movieName)
);
	
	
CREATE TABLE IF NOT EXISTS booking (
	bookingID VARCHAR(50),
	bookingUser VARCHAR(50),
	movieBooked VARCHAR(50),
	timeOfBooking VARCHAR(50),
	dateOfBooking VARCHAR(50),
	meal VARCHAR(250),
	price DOUBLE,
	
	PRIMARY KEY (bookingID)
);



CREATE TABLE IF NOT EXISTS accountDeatails(
	username VARCHAR(50),
	password VARCHAR(50),
	PRIMARY KEY (username)

);

	 
	 
CREATE TABLE IF NOT EXISTS DISCOUNTS(
	discountName VARCHAR(50),
	discountValue DOUBLE,
	PRIMARY KEY (discountName)

);



mysqld --console

mysql -u root -p
notAgenericPassword




	