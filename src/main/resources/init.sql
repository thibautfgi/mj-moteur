CREATE TABLE IF NOT EXISTS users (
                                     User_Id        SERIAL       NOT NULL,
                                     User_FirstName VARCHAR(255) DEFAULT NULL,
    User_LastName  VARCHAR(255) DEFAULT NULL,
    User_Phone     VARCHAR(255) DEFAULT NULL,
    User_Email     VARCHAR(255) NOT NULL,
    User_Password  VARCHAR(255) NOT NULL,
    PRIMARY KEY (User_Id),
    UNIQUE (User_Email)
    );