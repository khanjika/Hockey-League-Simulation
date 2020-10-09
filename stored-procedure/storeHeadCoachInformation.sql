CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `storeHeadCoackInformation`( IN coachName varchar(100), OUT coachId int)
BEGIN
INSERT INTO `CSCI5308_9_DEVINT`.`head_coach`
(`head_coach_name`)
VALUES
(coachName);
select last_insert_id() into coachId from `CSCI5308_9_DEVINT`.`head_coach` limit 1;
END