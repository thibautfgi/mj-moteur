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

CREATE TABLE IF NOT EXISTS image (
    Image_Id        SERIAL       NOT NULL,
    Image_Name      VARCHAR(255) NOT NULL,
    Image_Data      BYTEA        NOT NULL,
    PRIMARY KEY (Image_Id)
);

CREATE TABLE IF NOT EXISTS map (
    Map_Id             SERIAL       NOT NULL,
    User_Id            INTEGER      NOT NULL,
    Image_Id           INTEGER      NOT NULL,
    Map_Name           VARCHAR(255) NOT NULL,
    Map_Description    TEXT,
    Map_Rating         INTEGER,
    Map_TotalDistance  INTEGER,
    Map_DateCreation   TIMESTAMP    NOT NULL,
    PRIMARY KEY (Map_Id),
    CONSTRAINT fk_map_user FOREIGN KEY (User_Id)
        REFERENCES users (User_Id)
        ON DELETE CASCADE,
    CONSTRAINT fk_map_image FOREIGN KEY (Image_Id)
        REFERENCES image (Image_Id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS gpx (
    Gpx_Id       SERIAL       NOT NULL,
    Map_Id       INTEGER      NOT NULL,
    Gpx_Name     VARCHAR(255) NOT NULL,
    Gpx_Content  TEXT         NOT NULL,
    PRIMARY KEY (Gpx_Id),
    CONSTRAINT fk_gpx_map FOREIGN KEY (Map_Id)
        REFERENCES map (Map_Id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS mark (
    Mark_Id   SERIAL       NOT NULL,
    Map_Id    INTEGER      NOT NULL,
    Mark_Name VARCHAR(255) NOT NULL,
    Mark_Lat  VARCHAR(255) NOT NULL,
    Mark_Lon  VARCHAR(255) NOT NULL,
    Mark_ele  VARCHAR(255),
    PRIMARY KEY (Mark_Id),
    CONSTRAINT fk_mark_map FOREIGN KEY (Map_Id)
        REFERENCES map (Map_Id)
        ON DELETE CASCADE
);
