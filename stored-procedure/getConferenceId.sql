CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getConferenceId`(In conferenceName varchar(100), In leagueId int, out conferenceId int)
BEGIN
select conference_id into conferenceId from conferences where league_id = leagueId and conference_name = conferenceName;
END