CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `getTeamInformation`(In teamName varchar(100), In divisionId int)
BEGIN
select team_id, (select general_manager_name from general_manager where general_manager_id =t.general_manager_id ) as general_manager_name , (select head_coach_name from head_coach where head_coach_id =t.head_coach_id ) as head_coach_name, division_id  from teams t where  team_name= teamName and division_Id = divisionId;
END