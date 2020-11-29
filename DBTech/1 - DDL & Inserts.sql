drop table if exists reservations;
drop table if exists books ;
drop table if exists customers;
drop table if exists staff;
drop table if exists subscriptions;

CREATE TABLE if not exists books (
  Name varchar(45) NOT NULL,
  BID int(11) NOT NULL,
  Genre varchar(45) NOT NULL,
  Publisher varchar(45),
  Writer varchar(45),
  Quantity int(11) CHECK (Quantity > 0),
  PRIMARY KEY (`BID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE if not exists `subscriptions` (
  `Type` varchar(45) NOT NULL,
  `Duration` int(11) NOT NULL,
  `Price` double NOT NULL,
  `Sub_ID` int(11) NOT NULL,
  PRIMARY KEY (`Sub_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE if not exists customers (
  Name varchar(45) NOT NULL,
  CID int(11) NOT NULL,
  Contacs varchar(45) DEFAULT NULL,
  DOB year(4) DEFAULT NULL,
  Sub_ID int(11) NOT NULL,
  PRIMARY KEY (`CID`),
  Foreign key (Sub_ID)
	references subscriptions (Sub_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE if not exists `staff` (
  `Name` varchar(45) NOT NULL,
  `SID` int(11) NOT NULL,
  `Job` varchar(45) NOT NULL,
  `Contacts` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`SID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE if not exists reservations  (
  CID int NOT NULL,
  BID int NOT NULL,
  SID int NOT NULL,
  Exp_date timestamp NOT NULL,
  PRIMARY KEY (`CID`,`BID`,`Exp_date`),
	Foreign key (CID)
		references customers (CID) ON DELETE CASCADE, 
	Foreign key (BID)
		references books (BID) ON DELETE CASCADE,
	Foreign key (SID)
		references staff (SID) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



INSERT INTO `library`.`books`
(`Name`,
`BID`,
`Genre`,
`Publisher`,
`Writer`,
`Quantity`)
VALUES
("Μια νύχτα στην Mordor", 568489, "Μυθιστόρημα", "House of Rads" , "George G. G. Fartin" , 30),
("Το μονοπάτι με τις λεύκες", 489684, "Τρόμου", "Lone Walk" , "Jason Krueger" , 10),
("Βλέποντας τον χορό του άλλου", 425868, "Ρομαντισμός", "Theory of Love" , "Natasha Catzenkovic" , 80),
("Ο κυνηγός μου", 399458, "Αστυνομικό Θρίλερ", "Lone Walk" , "Freddy Voorhees" , 50),
("Ρομάντζο στην Μολδαβία", 785145, "Ρομαντισμός", "Romance Police" , "Shayna Rousey" , 5);

INSERT INTO `library`.`subscriptions`
(`Type`,
`Duration`,
`Price`,
`Sub_ID`)
VALUES
("Μηνιαία", 1, 12, 319),
("3-μηνο", 3, 30, 558),
("6-μηνο", 6, 50, 448),
("Ετήσια", 12, 80, 286),
("Ειδική", 6, 25, 302);

INSERT INTO `library`.`customers`
(`Name`,
`CID`,
`Contacs`,
`DOB`,
`Sub_ID`)
VALUES
("Δημοσθένης Γκαΐζος", 31879, "doomguy@hellmail.gr", 1993-12-10, 319),
("Ευγενία Τριβίδα", 31865, "nottrivizas@somemail.gr", 1998-11-3, 286),
("Αντώνιος Ευστάτογλου", 31786, "eystath@somemail.gr", 1999-8-15, 302),
("Σάββας Κωφίδης", 31900, "kof@othermail.gr", 1990-5-4, 448),
("Νικόλαος Εύλογος", 31798, "eylogy@somemail.gr", 1989-4-5, 558);


INSERT INTO `library`.`staff`
(`Name`,
`SID`,
`Job`,
`Contacts`)
VALUES
("Εμμανουήλ Βέζος", 3568, "Βιβλιοθηκάριος", "mbezos@somemail.gr"),
("Σταυρούλα Μανωλίδου", 3459, "Καθαρίστρια", "stauman@othermail.gr"),
("Ιωάννης Πέλογλου", 3846, "Αποθηκάριος", "peloio@somemail.gr"),
("Κωσταντίνος Φεσάτογλου", 3541, "Βιβλιοθηκάριος", "fesato@somemail.gr"),
("Αντωνία Πούνταρη", 3645, "Υπεύθηνη", "poyntarh@othermail.gr");

INSERT INTO `library`.`reservations`
(`CID`,
`BID`,
`SID`,
`Exp_date`)
VALUES
(31879, 568489, 3568, '2021-01-08 10:10:10'),
(31865, 489684, 3459, '2021-04-03 10:10:10'),
(31786, 425868, 3846, '2021-02-09 10:10:10'),
(31900, 399458, 3541, '2021-01-06 10:10:10'),
(31798, 785145, 3645, '2021-01-06 10:10:10');








