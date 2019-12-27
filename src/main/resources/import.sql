INSERT INTO custom_group (id, name, created) VALUES (1,'Default',0);
INSERT INTO role (id, name, created) VALUES (1,'Default',0);
INSERT INTO country (id, code, name) VALUES (1,'LT','Lithuania');
INSERT INTO language (id, code, name) VALUES (1,'LT','Lietuviu');

INSERT INTO user (id, about, address, created, photo, email, firstname, logged, password, phone, surname, title, username, group_id, role_id) VALUES (1, '','',0,'assets/img/avatars/9.png','admin@admin.com','admin', 0,'password','','admin','Mr','admin',1,1);
INSERT INTO user (id, about, address, created, photo, email, firstname, logged, password, phone, surname, title, username, group_id, role_id) VALUES (2, '','',0,'assets/img/avatars/9.png','user@user.com','user',0,'password','','user','Mr','user',1,1);
INSERT INTO user (id, about, address, created, photo, email, firstname, logged, password, phone, surname, title, username, group_id, role_id) VALUES (3, '','',0,'assets/img/avatars/9.png','audit@audit.com','audit', 0,'password','','audit','Mr','audit',1,1);
INSERT INTO user (id, about, address, created, photo, email, firstname, logged, password, phone, surname, title, username, group_id, role_id) VALUES (4, '','',0,'assets/img/avatars/9.png','system@system.com','system',0,'password','','system','Mr','system',1,1);
INSERT INTO user (id, about, address, created, photo, email, firstname, logged, password, phone, surname, title, username, group_id, role_id) VALUES (5, '','',0,'assets/img/avatars/9.png','angular@angular.com','angular',0,'password','','angular','Mr','client',1,1);

INSERT INTO course (id, author, cover, created, description, is_supported, name, price, rate, version) VALUES (1,'Sam Smith Jr.','http://',0,'Something to train and master',1,'Important Training',0,0,'1.0')
INSERT INTO quiz (id, created, description, name, rate, version, course_id) VALUES (1,0,'','Quiz 2020',0,'1.0',1);

INSERT INTO question (id, media, text) VALUES (1,'','What is Avialearn?');
INSERT INTO quiz_questions (quiz_id, questions_id) VALUES (1,1);
INSERT INTO answer (id, is_correct, text) VALUES (1,0,'I don\'t know');
INSERT INTO answer (id, is_correct, text) VALUES (2,0,'Computer based learning system');
INSERT INTO answer (id, is_correct, text) VALUES (3,0,'Learning management system');
INSERT INTO answer (id, is_correct, text) VALUES (4,0,'Platform-as-a-Service (PaaS)');
INSERT INTO question_answers (question_id, answers_id) VALUES (1,1);
INSERT INTO question_answers (question_id, answers_id) VALUES (1,2);
INSERT INTO question_answers (question_id, answers_id) VALUES (1,3);
INSERT INTO question_answers (question_id, answers_id) VALUES (1,4);

INSERT INTO question (id, media, text) VALUES (2,'','What is PaaS?');
INSERT INTO quiz_questions (quiz_id, questions_id) VALUES (1,2);
INSERT INTO answer (id, is_correct, text) VALUES (5,0,'Personal automated aviation System');
INSERT INTO answer (id, is_correct, text) VALUES (6,0,'Platform as a Service');
INSERT INTO question_answers (question_id, answers_id) VALUES (2,5);
INSERT INTO question_answers (question_id, answers_id) VALUES (2,6);

INSERT INTO tutorial (id, created, description, name, rate, version, course_id) VALUES (1,0,'','Tutorial 2020',0,'1.0',1);
INSERT INTO file (id, created, directory, name, size, type) VALUES (1, 0, 'video', '24.mp4', 120, 'video/mp4');
INSERT INTO file (id, created, directory, name, size, type) VALUES (2, 0, 'video', '24.mp4', 120, 'video/mp4');
INSERT INTO file (id, created, directory, name, size, type) VALUES (3, 0, 'video', '24.mp4', 120, 'video/mp4');
INSERT INTO tutorial_materials (materials_id, tutorial_id) VALUES (1,1);
INSERT INTO tutorial_materials (materials_id, tutorial_id) VALUES (2,1);
INSERT INTO tutorial_materials (materials_id, tutorial_id) VALUES (3,1);

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