-- ================================================================
-- Init Script for mj_data_db
-- Engine Service Database - Maps, Sentiers & Geodata
-- ================================================================

-- Create image table (no changes)
CREATE TABLE IF NOT EXISTS image (
    Image_Id        SERIAL       NOT NULL,
    Image_Name      VARCHAR(255) NOT NULL,
    Image_Data      BYTEA        NOT NULL,
    PRIMARY KEY (Image_Id)
);

-- Create map table (User_Id as simple column, no FK to auth DB)
CREATE TABLE IF NOT EXISTS map (
    Map_Id             SERIAL       NOT NULL,
    User_Id            INTEGER      NOT NULL,
    Image_Id           INTEGER,
    Map_Name           VARCHAR(255) NOT NULL,
    Map_Description    TEXT,
    Map_Rating         INTEGER,
    Map_TotalDistance  INTEGER,
    Map_DateCreation   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (Map_Id),
    CONSTRAINT fk_map_image FOREIGN KEY (Image_Id)
        REFERENCES image (Image_Id)
        ON DELETE SET NULL
);

-- Create gpx table
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

-- Create mark table
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

-- Create indexes for performance
CREATE INDEX IF NOT EXISTS idx_map_user_id ON map(User_Id);
CREATE INDEX IF NOT EXISTS idx_map_image_id ON map(Image_Id);
CREATE INDEX IF NOT EXISTS idx_gpx_map_id ON gpx(Map_Id);
CREATE INDEX IF NOT EXISTS idx_mark_map_id ON mark(Map_Id);

-- ================================================================
-- Notes
-- ================================================================
-- User_Id in map table is a simple INTEGER reference to mj_auth_db.users.User_Id
-- This allows the data to be independent from the auth database
-- If a user is deleted in mj_auth_db, their maps remain in mj_data_db
-- (This is intentional - preserves data integrity)
