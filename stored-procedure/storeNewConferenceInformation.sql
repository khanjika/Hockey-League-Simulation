CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `storeNewConferenceInformation`(IN conferenceName varchar(100) ,IN leagueId int, OUT conferenceId int)
BEGIN
INSERT INTO `CSCI5308_9_DEVINT`.`conferences`
(`conference_name`,`league_id`)
VALUES
(conferenceName, leagueId);
select last_insert_id() into conferenceId from `CSCI5308_9_DEVINT`.`conferences` limit 1;
END