INSERT INTO custom_group (id, name, created) VALUES (1,'Default',0);
INSERT INTO role (id, name, created) VALUES (1,'Default',0);
INSERT INTO country (id, code, name) VALUES (1,'LT','Lithuania');
INSERT INTO language (id, code, name) VALUES (1,'LT','Lietuviu');

INSERT INTO user (id, about, created, photo_id, email, firstname, logged, password, phone, surname, title, group_id, role_id, company_id, approved, sys_role) VALUES (1, '',0,null,'admin@admin.com','admin', 0,'{bcrypt}$2a$10$tDk/pDvQcXjN8qghkoV7bOEjLWmR/u8SKS8v36IaPBLdukgMLjmCm','','admin','Mr',1,1,null,1,'ADMIN');
INSERT INTO user (id, about, created, photo_id, email, firstname, logged, password, phone, surname, title, group_id, role_id, company_id, approved, sys_role) VALUES (2, '',0,null,'user@user.com','user',0,'password','','user','Mr',1,1,null,1,'USER');
INSERT INTO user (id, about, created, photo_id, email, firstname, logged, password, phone, surname, title, group_id, role_id, company_id, approved, sys_role) VALUES (3, '',0,null,'audit@audit.com','audit', 0,'password','','audit','Mr',1,1,null,0,'USER');
INSERT INTO user (id, about, created, photo_id, email, firstname, logged, password, phone, surname, title, group_id, role_id, company_id, approved, sys_role) VALUES (4, '',0,null,'system@system.com','system',0,'password','','system','Mr',1,1,null,0,'ADMIN');
INSERT INTO user (id, about, created, photo_id, email, firstname, logged, password, phone, surname, title, group_id, role_id, company_id, approved, sys_role) VALUES (5, '',0,null,'angular@angular.com','angular',0,'password','','angular','Mr',1,1,null,0,'USER');

INSERT INTO course (id, author, cover_id, created, description, is_supported, is_marketplaced, name, price, rate, version) VALUES (1,'Sam Smith Jr.',null,0,'Something to train and master',1,0,'Important Training',0,0,'1.0')
INSERT INTO quiz (id, created, description, name, rate, version, course_id) VALUES (1,0,'','Quiz 2020',0,'1.0',null);

INSERT INTO tutorial (id, created, description, name, rate, version, course_id) VALUES (1,0,'','Tutorial 2020',0,'1.0',null);
INSERT INTO file (id, created, directory, name, size, type) VALUES (1, 0, 'video', '24.mp4', 120, 'video/mp4');
INSERT INTO file (id, created, directory, name, size, type) VALUES (2, 0, 'video', '24.mp4', 120, 'video/mp4');
INSERT INTO file (id, created, directory, name, size, type) VALUES (3, 0, 'video', '24.mp4', 120, 'video/mp4');
INSERT INTO tutorial_materials (materials_id, tutorial_id) VALUES (1,1);
INSERT INTO tutorial_materials (materials_id, tutorial_id) VALUES (2,1);
INSERT INTO tutorial_materials (materials_id, tutorial_id) VALUES (3,1);


INSERT INTO file (id, created, directory, name, size, type) VALUES (4, 0, 'image', 'test.jpg', 120, 'image/jpeg');
INSERT INTO question (id, image_id, text) VALUES (1, 4, 'What is Avialearn?');
INSERT INTO quiz_questions (quiz_id, questions_id) VALUES (1,1);
INSERT INTO answer (id, is_correct, text) VALUES (1,0,'I don\'t know');
INSERT INTO answer (id, is_correct, text) VALUES (2,0,'Computer based learning system');
INSERT INTO answer (id, is_correct, text) VALUES (3,0,'Learning management system');
INSERT INTO answer (id, is_correct, text) VALUES (4,0,'Platform-as-a-Service (PaaS)');
INSERT INTO question_answers (question_id, answers_id) VALUES (1,1);
INSERT INTO question_answers (question_id, answers_id) VALUES (1,2);
INSERT INTO question_answers (question_id, answers_id) VALUES (1,3);
INSERT INTO question_answers (question_id, answers_id) VALUES (1,4);

INSERT INTO question (id, image_id, text) VALUES (2, null, 'What is PaaS?');
INSERT INTO quiz_questions (quiz_id, questions_id) VALUES (1,2);
INSERT INTO answer (id, is_correct, text) VALUES (5,0,'Personal automated aviation System');
INSERT INTO answer (id, is_correct, text) VALUES (6,0,'Platform as a Service');
INSERT INTO question_answers (question_id, answers_id) VALUES (2,5);
INSERT INTO question_answers (question_id, answers_id) VALUES (2,6);

INSERT INTO assignment (id, duration, score, start, end) VALUES (1,0,80,0,0);
INSERT INTO assignment (id, duration, score, start, end) VALUES (2,0,80,0,0);
INSERT INTO assignment (id, duration, score, start, end) VALUES (3,0,80,0,0);

INSERT INTO classroom (id, created, description, name, note, rate, course_id) VALUES (1,0,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi.','Super class','',0,1);
INSERT INTO classroom (id, created, description, name, note, rate) VALUES (2,0,'Sed ut nemo enim ipsam voluptatem.','Moon light','',0);

INSERT INTO classroom_assignments (classroom_id, assignments_id) VALUES (1,1);
INSERT INTO classroom_assignments (classroom_id, assignments_id) VALUES (2,2);
INSERT INTO classroom_assignments (classroom_id, assignments_id) VALUES (2,3);

INSERT INTO enrolled(id, created, classroom_id) VALUES (1,0,1);
INSERT INTO enrolled(id, created, classroom_id) VALUES (2,0,2);

INSERT INTO enrolled_users(enrolled_id, users_id) VALUES (1,1);
INSERT INTO enrolled_users(enrolled_id, users_id) VALUES (1,2);