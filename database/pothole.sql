DROP TABLE IF EXISTS pothole_user;
DROP TABLE IF EXISTS pothole;
DROP TABLE IF EXISTS app_user;


CREATE TABLE app_user
(
user_id SERIAL,
user_name varchar(32),
phone varchar(32),
email varchar(32),
password varchar(32),
is_employee boolean DEFAULT FALSE,
CONSTRAINT pk_app_user_user_id PRIMARY KEY (user_id)
);

CREATE TABLE pothole
(
pothole_id SERIAL,
user_id SERIAL,
street_Name VARCHAR(200),
street_Number INTEGER,
zip_Code INTEGER,
state VARCHAR(30),
city VARCHAR(20),
country VARCHAR(80),
status_Date timestamp DEFAULT now(),
status_Code VARCHAR(20) DEFAULT 'reported',
lat Varchar(16),
lng VArchar(16),
severity INTEGER DEFAULT 0,
report_Date timestamp DEFAULT now(),
repair_Date timestamp DEFAULT now(),
img_Url VARCHAR(200),

CONSTRAINT pk_pothole_id PRIMARY KEY (pothole_id),
CONSTRAINT fk_pothole_id_user_id FOREIGN KEY(user_id) REFERENCES app_user(user_id)
);

CREATE TABLE pothole_user (
user_id integer NOT NULL,
pothole_id integer NOT NULL,
--CONSTRAINT pk_pothole_user_user_id_pothole_Id PRIMARY KEY (user_id, pothole_Id)
--CONSTRAINT fk_pothole_Id_pothol_Id FOREIGN KEY(pothol_Id) REFERENCES pothole(pothole_Id)
--CONSTRAINT fk_pothole_Id_user_id FOREIGN KEY(user_id) REFERENCES app_user(user_id)
CONSTRAINT fk_pothole_user_pothole FOREIGN KEY (pothole_id) references pothole (pothole_id),
CONSTRAINT fk_pothole_user_user FOREIGN KEY (user_id) references app_user (user_id),
CONSTRAINT uq_pothole_user unique (user_id, pothole_id),
CONSTRAINT pk_pothole_user_user_id_pothole_id PRIMARY KEY (user_id, pothole_id)
);


INSERT INTO app_user (user_id,user_name,phone, email, password) VALUES (1,'ipp', '6126666000', 'ipp@gmail.com','ipp');
INSERT INTO app_user (user_id,user_name,phone, email, password, is_employee) VALUES (2,'Employee', '6127777000', 'emp@gmail.com','employee', true);
INSERT INTO app_user (user_id,user_name,phone,email, password, is_employee) VALUES (3,'kell', '6128888000', 'kell@gmail.com','kell', true);
INSERT INTO app_user (user_id,user_name,phone, email, password) VALUES (4,'loui', '6129999000', 'loui@gmail.com','loui');
INSERT INTO app_user (user_id,user_name,phone, email, password, is_employee) VALUES (5,'Aurt', '6121111000', 'aurt@gmail.com','aurt', true);

SELECT MAX(pothole_Id) FROM pothole;
SELECT nextval(pk_pothole_id);

INSERT INTO pothole(pothole_id, user_id, street_Name, street_Number, zip_Code, state, city, country, status_Date, status_Code, lat, lng, severity, report_Date, repair_Date, img_Url) VALUES (1,1, 'Pennsylvania',901, 15233, 'PA','Pittsburgh', 'USA', '10/15/2018', 'inspected', '40.456257', '-80.0189', 2, '10/12/2018', '10/12/2019','https://i.imgflip.com/2537yf.jpg' );
INSERT INTO pothole(pothole_id, user_id, street_Name, street_Number, zip_Code, state, city, country, status_Date, status_Code, lat, lng, severity, report_Date, repair_Date, img_Url) VALUES (2,2, 'Penn Ave',2801, 15222, 'PA','Pittsburgh','USA', '3/05/2019', 'reported', '40.457215', '-79.9756', 1, '03/05/2019','04/05/2019','https://i.pinimg.com/236x/b4/9e/3c/b49e3c4cb1f1cfd451abf9d7046e1d82--car-humor-car-memes.jpg' );
INSERT INTO pothole(pothole_id, user_id, street_Name, street_Number, zip_Code, state, city, country, status_Date, status_Code, lat, lng, severity, report_Date, repair_Date, img_Url) VALUES (3,3, 'Murray Ave',2112, 15217, 'PA','Pittsburgh', 'USA', '12/25/2018','repaired', '40.433946', '-79.9232', 3, '12/25/2018','12/25/2019','http://i.imgur.com/4jA5PpN.jpg');

UPDATE pothole SET status_code = 0, severity = 0
WHERE pothole_id = 10;

INSERT INTO pothole(pothole_id, user_id, street_Name, street_Number, zip_Code, state, city, country, status_Date, status_Code, lat, lng, severity, report_Date, repair_Date, img_Url) VALUES (4,4, 'Heber st',2801, 15222, 'PA','Pittsburgh','USA', '2/05/2019', 'reported', '40.457215', '-79.9756', 1, '04/05/2019','04/15/2019','https://i.pinimg.com/236x/b4/9e/3c/b49e3c4cb1f1cfd451abf9d7046e1d82--car-humor-car-memes.jpg' );
INSERT INTO pothole(pothole_id, user_id, street_Name, street_Number, zip_Code, state, city, country, status_Date, status_Code, lat, lng, severity, report_Date, repair_Date, img_Url) VALUES (5,5, 'Forbes Ave',2112, 15217, 'PA','Pittsburgh', 'USA', '1/25/2018','inspected', '40.433946', '-79.9232', 3, '12/20/2018','12/29/2019', 'http://i.imgur.com/4jA5PpN.jpg');

INSERT INTO pothole(pothole_id, user_id, street_Name, street_Number, zip_Code, state, city, country, status_Date, status_Code, lat, lng, severity, report_Date, repair_Date, img_Url) VALUES (6,5, 'Louis Ave',2112, 15217, 'PA','Pittsburgh', 'USA', '01/01/2018','inspected', '40.40','-79.92', 3, '2/2/2019','12/29/2019', 'http://i.imgur.com/4jA5PpN.jpg');

INSERT INTO pothole(street_number, street_name, city, state, zip_code, country, lat, lng, img_url) VALUES (3, 'Sheridan', 'Williamsport', 'PA', 17701, 'USA', 50, 50, 'fakeURL');

INSERT INTO pothole_user (user_id, pothole_id) VALUES (1, 1);
INSERT INTO pothole_user (user_id, pothole_id) VALUES (2, 2);
INSERT INTO pothole_user (user_id, pothole_id) VALUES (3, 3);
INSERT INTO pothole_user (user_id, pothole_id) VALUES (4, 4);
INSERT INTO pothole_user (user_id, pothole_id) VALUES (5, 5);

SELECT * FROM pothole;
SELECT * FROM app_user;

SELECT *
FROM app_user
WHERE user_name = 'ipp';

UPDATE pothole SET status_code = 'Inspected' , status_date = '12/25/2018', severity = 3 WHERE pothole_id = 12;
				