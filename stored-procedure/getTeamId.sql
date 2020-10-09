CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getTeamId`(In teamName varchar(100), In divisionId int, OUT teamId int)
BEGIN
select team_id into teamId from teams where division_id = divisionId and team_name = teamName;
END