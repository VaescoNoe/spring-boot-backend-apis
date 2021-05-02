insert into regiones (id,nombre) values (1,'Sudamérica');
insert into regiones (id,nombre) values (2,'Centroamérica');
insert into regiones (id,nombre) values (3,'Norteamérica');
insert into regiones (id,nombre) values (4,'Europa');
insert into clientes (nombre,apellido,email,create_at,region_id) values ('Diana','Vargas','vaescodiana@gmail.com',now(),2);
insert into clientes (nombre,apellido,email,create_at,region_id) values ('Noe','Vargas','vaesconoe@gmail.com',now(),1);
insert into clientes (nombre,apellido,email,create_at,region_id) values ('Hugo','Vargas','vaescohugo@gmail.com',now(),4);
insert into clientes (nombre,apellido,email,create_at,region_id) values ('Hilda','Vargas','vaescohilda@gmail.com',now(),3);
insert into clientes (nombre,apellido,email,create_at,region_id) values ('Cesar','Vargas','vaescocesar@gmail.com',now(),4);
/*Creamos usuarios*/
insert into `usuarios` (username,password,enabled) values ('andres','$2a$10$G65JrQrnCfyOBmuVwZO/UeiB85qJTc/bf2kE/RaKFGxp3SlNFfTKq',1);
insert into `usuarios` (username,password,enabled) values ('admin','$2a$10$jK3acpX7Y/jTsZ8152pf/.l.CX0YapcZvv/Oj0NkIlXgryYIASpCq',1);
insert into `roles` (nombre) values ('ROLE_USER');
insert into `roles` (nombre) values ('ROLE_ADMIN');
insert into `usuarios_roles` (usuario_id,rol_id) values (1,1);
insert into `usuarios_roles` (usuario_id,rol_id) values (2,2);
insert into `usuarios_roles` (usuario_id,rol_id) values (2,1);