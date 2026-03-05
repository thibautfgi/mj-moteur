CREATE DATABASE IF NOT EXISTS mountain_journey CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS users (
    User_Id       INT          NOT NULL AUTO_INCREMENT,
    User_FirstName VARCHAR(255) DEFAULT NULL,
    User_LastName  VARCHAR(255) DEFAULT NULL,
    User_Phone     VARCHAR(255) DEFAULT NULL,
    User_Email     VARCHAR(255) NOT NULL,
    User_Password  VARCHAR(255) NOT NULL,
    PRIMARY KEY (User_Id),
    UNIQUE KEY UK_users_email (User_Email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

