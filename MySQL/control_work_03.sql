
-- 7. В подключенном MySQL репозитории создать базу данных “Друзья
-- человека” (Human_friends)

CREATE DATABASE IF NOT EXISTS Human_friends;
USE  Human_friends;

-- /*/
-- 8. Создать таблицы с иерархией из диаграммы в БД
-- /*/

DROP TABLE IF EXISTS cats;
DROP TABLE IF EXISTS dogs;
DROP TABLE IF EXISTS hamsters;
DROP TABLE IF EXISTS horses;
DROP TABLE IF EXISTS camels;
DROP TABLE IF EXISTS donkeys;

CREATE TABLE IF NOT EXISTS cats (
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	animal_name VARCHAR(20),
    commands TEXT,
    birthday DATE
);

CREATE TABLE IF NOT EXISTS dogs (
	id INT UNSIGNED KEY AUTO_INCREMENT,
	animal_name VARCHAR(20),
    commands TEXT,
    birthday DATE
);

CREATE TABLE IF NOT EXISTS hamsters (
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	animal_name VARCHAR(20),
    commands TEXT,
    birthday DATE
);

CREATE TABLE IF NOT EXISTS horses (
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	animal_name VARCHAR(20),
    commands TEXT,
    birthday DATE
);

CREATE TABLE IF NOT EXISTS camels (
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	animal_name VARCHAR(20),
    commands TEXT,
    birthday DATE
);

CREATE TABLE IF NOT EXISTS donkeys (
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	animal_name VARCHAR(20),
    commands TEXT,
    birthday DATE
);

-- /*/
-- 9. Заполнить низкоуровневые таблицы именами(животных), командами
-- которые они выполняют и датами рождения
-- /*/

INSERT INTO cats (animal_name, commands, birthday) VALUES 
	('Barsik', 'sleep', '2013-01-01'),
    ('Vasya', 'run', '2022-02-02'),
    ('Begemot', 'eat', '2023-03-02');
   
INSERT INTO dogs (animal_name, commands,birthday) VALUES 
	('Dima', 'run', '2012-02-02'),
	('Rex', 'run', '2022-02-02'),
    ('Haric', 'sleep', '2023-02-02');
    
INSERT INTO hamsters (animal_name,commands, birthday) VALUES 
	('Sleepy', 'eat', '2012-02-02'),
	('Eater', 'eat', '2022-02-02'),
    ('Homa', 'sleep', '2023-02-02');
    
INSERT INTO horses (animal_name, commands, birthday) VALUES 
	('Spirit', 'run', '2012-02-02'),
	('Bella', 'eat', '2022-02-02'),
    ('Thunder', 'run', '2023-02-02');
    
INSERT INTO camels (animal_name, commands, birthday) VALUES 
	('Sahara', 'eat', '2012-02-02'),
	('Amirad', 'run', '2022-02-02'),
    ('Jamal', 'sleep', '2022-02-02');
    
INSERT INTO donkeys (animal_name, commands, birthday) VALUES 
	('Eeyore', 'sleep', '2022-02-02'),
	('Daisy', 'eat', '2022-02-02'),
    ('Charlie', 'run', '2022-02-02');

-- /*/
-- 10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
-- питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
-- /*/

TRUNCATE camels;

DROP TABLE IF EXISTS horses_and_donkeys;
CREATE TABLE IF NOT EXISTS horses_and_donkeys AS
SELECT * FROM horses
UNION ALL
SELECT * FROM donkeys; 

-- /*/
-- 11. Создать новую таблицу “молодые животные” в которую попадут все
-- животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
-- до месяца подсчитать возраст животных в новой таблице.
-- /*/

DROP TABLE IF EXISTS young_animals;
CREATE TABLE IF NOT EXISTS young_animals AS
SELECT *, TIMESTAMPDIFF(MONTH, birthday, CURDATE()) AS month_age
FROM (
    SELECT * FROM (
        SELECT * FROM cats
        UNION ALL
        SELECT * FROM dogs
        UNION ALL
        SELECT * FROM hamsters
		UNION ALL
        SELECT * FROM horses
        UNION ALL
        SELECT * FROM donkeys
		UNION ALL
        SELECT * FROM camels
        ) AS animals
    WHERE birthday > DATE_SUB(CURDATE(), INTERVAL 3 YEAR) AND birthday < DATE_SUB(CURDATE(), INTERVAL 1 YEAR)
    ) AS young_animals;
    
-- /*/
-- 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
-- прошлую принадлежность к старым таблицам.
-- /*/

ALTER TABLE cats
ADD `class` VARCHAR(20) NOT NULL DEFAULT 'cats';
ALTER TABLE dogs
ADD `class` VARCHAR(20) NOT NULL DEFAULT 'dogs';
ALTER TABLE hamsters
ADD `class` VARCHAR(20) NOT NULL DEFAULT 'hamsters';
ALTER TABLE donkeys
ADD `class` VARCHAR(20) NOT NULL DEFAULT 'donkeys';
ALTER TABLE horses
ADD `class` VARCHAR(20) NOT NULL DEFAULT 'horses';
ALTER TABLE camels
ADD `class` VARCHAR(20) NOT NULL DEFAULT 'camels';

DROP TABLE IF EXISTS all_animals;
CREATE TABLE IF NOT EXISTS all_animals AS
SELECT * FROM (
        SELECT * FROM cats
        UNION ALL
        SELECT * FROM dogs
        UNION ALL
        SELECT * FROM hamsters
		UNION ALL
        SELECT * FROM horses
        UNION ALL
        SELECT * FROM donkeys
		UNION ALL
        SELECT * FROM camels
        ) AS all_animals
