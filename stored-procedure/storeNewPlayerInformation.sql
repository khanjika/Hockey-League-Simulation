CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `storeNewPlayerInformation`( playerName varchar(100), playerPosition varchar(100), playerCaption varchar(45), teamId int)
BEGIN
INSERT INTO `CSCI5308_9_DEVINT`.`players`
(`player_name`,`player_position_id`,`player_captain`)
select
playerName, position_id, playerCaption
from player_positions where position_name = playerPosition;
SET @player_id = LAST_INSERT_ID();
insert into `CSCI5308_9_DEVINT`.`team_player`
(`player_id`,`team_id`)
values(@player_id,teamId);
END