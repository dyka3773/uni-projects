drop procedure if exists get_Staff;
drop procedure if exists get_Customers;
drop procedure if exists get_Books; 
drop procedure if exists get_Reservations;
drop procedure if exists get_StaffWithNameLike;
drop procedure if exists get_CustomersWithNameLike;
drop procedure if exists get_BooksWithNameLike;
drop procedure if exists get_BooksReserevedByThisCustomer;
drop procedure if exists count_BooksReserevedByThisCustomer;
drop procedure if exists count_BooksReserevedWithNamesLike;

DELIMITER $$
create procedure count_BooksReserevedWithNamesLike(
in onoma varchar(45)
)
begin
	SELECT COUNT(B.name)
   FROM Books B JOIN Reservations R on (B.bid=R.bid)
   WHERE B.name = onoma;
end$$

create procedure get_BooksReserevedByThisCustomer(
in onoma varchar(45)
)
begin
	SELECT DISTINCT B.name
   FROM Books B JOIN Reservations R on (B.bid=R.bid)
	JOIN Customers C on (C.cid=R.cid)
   WHERE C.name = onoma;
end$$

create procedure count_BooksReserevedByThisCustomer(
in onoma varchar(45)
)
begin
	SELECT COUNT(B.name)
   FROM Books B JOIN Reservations R on (B.bid=R.bid)
	JOIN Customers C on (C.cid=R.cid)
   WHERE C.name = onoma;
end$$

CREATE procedure get_Staff()
begin
	SELECT *
    FROM Staff S;
end$$

create procedure get_Customers()
begin
	SELECT *
    FROM Customers C;
end$$

create procedure get_Books()
begin
	SELECT *
    FROM Books B;
end$$

create procedure get_Reservations()
begin
	SELECT *
    FROM Reservations R;
end$$

CREATE procedure get_StaffWithNameLike(
in onoma varchar(45)
)
begin
	SELECT *
    FROM Staff S
    WHERE S.name= onoma;
end$$

CREATE procedure get_CustomersWithNameLike(
in onoma varchar(45)
)
begin
	SELECT *
    FROM Customers C
    WHERE C.name= onoma;
end$$

CREATE procedure get_BooksWithNameLike(
in onoma varchar(45)
)
begin
	SELECT *
    FROM Books B
    WHERE B.name= onoma;
end$$
delimiter ;