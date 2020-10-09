CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getLeagueInfo`(In leagueId int, out leagueName varchar(100))
BEGIN
select league_name into leagueName from leagues where league_id=leagueId;
END