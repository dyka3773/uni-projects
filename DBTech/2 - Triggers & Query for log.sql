drop table res_Logs;

CREATE TABLE `res_logs` (
  -- `ID` int NOT NULL AUTO_INCREMENT,
  `Command` varchar(10) NOT NULL,
  -- `OldCID` int NOT NULL,
  -- `OldBID` int NOT NULL,
  -- `OldSID` int NOT NULL,
  `CID` int NOT NULL,
  `BID` int NOT NULL,
  `SID` int NOT NULL,
  Exp_date timestamp NOT NULL,
  `StartDate` datetime NOT NULL -- DEFAULT CURRENT_TIMESTAMP
  ,
  `EndDate` datetime,
  PRIMARY KEY (`CID`,`BID`,`Exp_date`,`StartDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



DELIMITER $$

/* Trigger  for INSERT */
CREATE TRIGGER HistoryTableInsert AFTER INSERT ON reservations FOR EACH ROW BEGIN
   DECLARE N DATETIME;
   SET N = now();
    
   INSERT INTO res_logs
   VALUES ('Inserted',New.CID, New.BID, New.SID, New.Exp_date, N, NULL);
END;

/* Trigger for DELETE */
CREATE TRIGGER HistoryTableDelete AFTER DELETE ON reservations FOR EACH ROW BEGIN
   DECLARE N DATETIME;
   SET N = now();
    
   UPDATE res_logs
      SET EndDate = N, Command = 'Deleted'
    WHERE CID = OLD.CID and BID = OLD.BID and SID = OLD.SID
      AND EndDate IS NULL;
END;

/* Trigger for UPDATE */
CREATE TRIGGER HistoryTableUpdate AFTER UPDATE ON reservations FOR EACH ROW BEGIN
   DECLARE N DATETIME;
   SET N = now();

   UPDATE res_logs
      SET EndDate = N
    WHERE CID = OLD.CID and BID = OLD.BID and SID = OLD.SID
      AND EndDate IS NULL;

   INSERT INTO res_logs
   VALUES ('Updated',New.CID, New.BID, New.SID, New.Exp_date, N, NULL);
END;
