CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `storeNewLeagueInformation`( IN leagueName varchar(100), OUT leagueId int)
BEGIN
INSERT INTO `CSCI5308_9_DEVINT`.`leagues`
(`league_name`)
VALUES
(leagueName);
select last_insert_id() into leagueId from `CSCI5308_9_DEVINT`.`leagues` limit 1;
END