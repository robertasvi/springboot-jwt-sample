INSERT INTO custom_group (id, name, created) VALUES (1,'Default',0);
INSERT INTO role (id, name, created) VALUES (1,'Default',0);
INSERT INTO country (id, code, name) VALUES (1,'LT','Lithuania');
INSERT INTO language (id, code, name) VALUES (1,'LT','Lietuviu');
INSERT INTO company (id, address, created, email, name, phone, web) VALUES (0,'',0,"info@info.com",'Demo Co.','','');

INSERT INTO user (id, about, address, created, photo, email, firstname, birthday, logged, password, phone, surname, title, username, country_id, company_id, language_id, group_id, role_id) VALUES (1, '','',0,'assets/img/avatars/9.png','admin@admin.com','admin', 0, 0,'password','','admin','mr','admin',1,1,1,1,1);
INSERT INTO user (id, about, address, created, photo, email, firstname, birthday, logged, password, phone, surname, title, username, country_id, company_id, language_id, group_id, role_id) VALUES (2, '','',0,'assets/img/avatars/9.png','user@user.com','user',0,0,'password','','user','mr','user',1,1,1,1,1);

INSERT INTO course (id, author, cover, created, description, is_supported, name, price, rate, version) VALUES (1,'Sam Smith Jr.','http://',0,'Something to train and master',1,'Important Training',0,0,'1.0')
INSERT INTO quiz (id, created, description, name, rate, version, course_id) VALUES (1,0,'','Quiz 2020',0,'1.0',1);
INSERT INTO tutorial (id, created, description, name, rate, version, course_id) VALUES (1,0,'','Quiz 2020',0,'1.0',1);

INSERT INTO material (id, created, media, name, size, type) VALUES (1,0,'http://','Video material 2020',200,'.mpg');
INSERT INTO episode (time, material_id) VALUES (30,1);
INSERT INTO episode (time, material_id) VALUES (180,1);
INSERT INTO episode (time, material_id) VALUES (360,1);
INSERT INTO episode (time, material_id) VALUES (780,1);
INSERT INTO episode (time, material_id) VALUES (920,1);

INSERT INTO tutorial_materials (tutorial_id, materials_id) VALUES (1,1);

INSERT INTO assignment (id, duration, start, end) VALUES (1,0,0,0);
INSERT INTO assignment (id, duration, start, end) VALUES (2,0,0,0);

INSERT INTO classroom (id, created, description, name, rate, score) VALUES (1,0,'Something to learn','Super class',0,80);
INSERT INTO classroom (id, created, description, name, rate, score) VALUES (2,0,'This is what you search for','Moon light',0,80);

INSERT INTO classroom_assignments (classroom_id, assignments_id) VALUES (1,1);
INSERT INTO classroom_assignments (classroom_id, assignments_id) VALUES (2,2);

INSERT INTO enrolled(id, created, classroom_id) VALUES (1,0,1);
INSERT INTO enrolled(id, created, classroom_id) VALUES (2,0,2);

INSERT INTO enrolled_users(enrolled_id, users_id) VALUES (1,1);
INSERT INTO enrolled_users(enrolled_id, users_id) VALUES (1,2);