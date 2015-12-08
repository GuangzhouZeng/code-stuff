/*
>@G:\MasterDegreeInUSC\MS_15Fall\CS585\HW\HW5\drop.sql
*/
-------------------------drop------------------
DROP INDEX ambulance_spatial_idx;
DROP INDEX lion_spatial_idx;
DROP INDEX pond_spatial_idx;
DROP INDEX region_spatial_idx;

DROP TABLE lion;
DROP TABLE region;
DROP TABLE pond;
DROP TABLE ambulance;

DELETE FROM user_sdo_geom_metadata WHERE TABLE_NAME='AMBULANCE';
DELETE FROM user_sdo_geom_metadata WHERE TABLE_NAME='LION';
DELETE FROM user_sdo_geom_metadata WHERE TABLE_NAME='POND';
DELETE FROM user_sdo_geom_metadata WHERE TABLE_NAME='REGION';