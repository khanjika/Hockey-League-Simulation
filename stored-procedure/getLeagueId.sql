CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getLeagueId`(In leagueName varchar(100), OUT leagueId int)
BEGIN
select league_id into leagueId from leagues where league_name = leagueName;
END