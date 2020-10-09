CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `isTeamNameAlreadyExist`(In teamName varchar(100), In divisionId int, Out teamId int)
BEGIN
(select team_id into teamId from teams where team_name = teamName and division_id = divisionId);
END