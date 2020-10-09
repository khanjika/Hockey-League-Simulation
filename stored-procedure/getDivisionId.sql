CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getDivisionId`(In divisionName varchar(100), In conferenceId int, Out divisionId int)
BEGIN
select division_id into divisionId from divisions where conference_id = conferenceId and division_name = divisionName;
END