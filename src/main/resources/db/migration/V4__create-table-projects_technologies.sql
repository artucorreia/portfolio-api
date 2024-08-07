CREATE TABLE IF NOT EXISTS `PROJECTS_TECHNOLOGIES`(
    `PROJECT_ID` BIGINT NOT NULL,
    `TECHNOLOGY_ID` BIGINT NOT NULL,
    PRIMARY KEY (`PROJECT_ID`, `TECHNOLOGY_ID`),
    FOREIGN KEY (`PROJECT_ID`) REFERENCES PROJECTS(ID),
    FOREIGN KEY (`TECHNOLOGY_ID`) REFERENCES TECHNOLOGIES(ID)
);