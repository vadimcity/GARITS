#CREATE DATABASE t18database;

CREATE TABLE useraccounts(
    username VARCHAR(50),
    firstname VARCHAR(50),
    surname VARCHAR(50),
    user_password VARCHAR(50),
    email VARCHAR (50),
    user_role VARCHAR(50)
);
CREATE TABLE customermemberlist(
    ID INT(12),
    firstname VARCHAR(50),
    surname VARCHAR(50),
    discountplan VARCHAR(50)
);
CREATE TABLE pendingjoblist(
    jobID INT(12),
    CustomerID INT(12),
    details VARCHAR(50) NULL
);
CREATE TABLE activejoblist(
    jobID INT(12),
    CustomerID INT(12),
    duration INT(12),
    mechanic VARCHAR(50),
    details VARCHAR(50) NULL
);


INSERT INTO useraccounts
(username, firstname, surname, user_password, email, user_role) VALUES
('Jade1','Jade','Rice','password','JadeRice@gmail.com','Admin'),
('Mia1','Mia','Kemp','password','MiaKemp@gmail.com','Admin'),
('Patrick1','Patrick','Booth','password','PatrickBooth@gmail.com','Admin'),
('Charles1','Charles','Simmons','password','CharlesSimmons@gmail.com','Admin'),
('Taylor1','Taylor','Stone','password','TaylorStone@gmail.com','Admin'),
('Ryan1','Ryan','Bibi','password','RyanBibi@gmail.com','Admin'),
('Ewan1','Ewan','Chandler','password','EwanChandler@gmail.com','Admin');
