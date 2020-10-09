CREATE DEFINER=`CSCI5308_9_DEVINT_USER`@`%` PROCEDURE `storeGeneralManagerInformation`( In managerName varchar(100), Out managerId int)
BEGIN
INSERT INTO `CSCI5308_9_DEVINT`.`general_manager`
(`general_manager_name`)
VALUES
(managerName);
select last_insert_id() into managerId from `CSCI5308_9_DEVINT`.`general_manager` limit 1;
END