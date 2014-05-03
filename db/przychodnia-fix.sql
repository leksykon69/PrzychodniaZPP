ALTER TABLE `user` DROP INDEX `user_role_FK` ,
ADD KEY `user_role_FK` ( `role_id` );

ALTER TABLE `permission_role` DROP INDEX `permission_role_role_FK` ,
ADD KEY `permission_role_role_FK` ( `role_id` );

ALTER TABLE `permission_role` DROP INDEX `permission_role_permission_FK` ,
ADD KEY `permission_role_permission_FK` ( `permission_id` );
