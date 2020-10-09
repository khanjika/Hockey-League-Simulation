CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `storeNewDivisionInformation`( IN divisionName varchar(100), IN conferenceId int, OUT divisionId int)
BEGIN
INSERT INTO `CSCI5308_9_DEVINT`.`divisions`
(`division_name`,`conference_id`)
VALUES
(divisionName, conferenceId);
select last_insert_id() into divisionId from `CSCI5308_9_DEVINT`.`divisions` limit 1;
END