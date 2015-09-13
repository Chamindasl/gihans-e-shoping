# gihans-e-shoping

all comments i will post in this file

sqls
ALTER TABLE `gs`.`brand` ADD COLUMN `active` BOOLEAN NULL AFTER `name`;
ALTER TABLE `gs`.`category` ADD COLUMN `active` BOOLEAN NULL AFTER `parent`; 
UPDATE category SET active=TRUE;
UPDATE brand SET active=TRUE;