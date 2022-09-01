select * from mysql.user;
CREATE USER 'capdaa'@'localhost' IDENTIFIED BY 'rexMang55$';
GRANT ALL PRIVILEGES ON * . * TO 'capdaa'@'localhost';
FLUSH PRIVILEGES;

