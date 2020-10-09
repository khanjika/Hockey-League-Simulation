CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `storeNewFreeAgentInformation`( agentName varchar(100), agentPosition varchar(100), agentCaption varchar(45), leagueId int)
BEGIN
INSERT INTO `CSCI5308_9_DEVINT`.`free_agents_info`
(`free_agent_name`,`free_agent_position_id`,`free_agent_captain`,`league_id`)
select
agentName, position_id, agentCaption, leagueId
from player_positions where position_name = agentPosition;
SELECT LAST_INSERT_ID();
END