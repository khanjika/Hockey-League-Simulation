CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getPlayerInformation`(In teamId int)
BEGIN
select player_id, player_name, (select position_name from player_positions where position_id=player_position_id) as player_position, player_captain from players where player_id In (select player_id from team_player where team_id=teamId);
END