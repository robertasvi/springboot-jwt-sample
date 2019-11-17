INSERT INTO file (id, name, type, url, uploaded) VALUES (1,'Image','jpg','assets/img/avatars/9.png',0);
INSERT INTO custom_group (id, name, created) VALUES (1,'Default',0);
INSERT INTO role (id, name, created) VALUES (1,'Default',0);
INSERT INTO country (id, code, name) VALUES (1,'LT','Lithuania');
INSERT INTO language (id, code, name) VALUES (1,'LT','Lietuviu');
INSERT INTO company (id, address, created, email, name, phone, web) VALUES (0,'',0,"info@info.com",'Demo Co.','','');
INSERT INTO user (id, about, address, created, email, firstname, birthday, logged, password, phone, surname, title, username, country_id, company_id, language_id, group_id, role_id, file_id) VALUES (1, '','',0,'admin@admin.com','admin', 0, 0,'password','','admin','mr','admin',1,1,1,1,1,1);
INSERT INTO user (id, about, address, created, email, firstname, birthday, logged, password, phone, surname, title, username, country_id, company_id, language_id, group_id, role_id, file_id) VALUES (2, '','',0,'user@user.com','user',0,0,'password','','user','mr','user',1,1,1,1,1,1);