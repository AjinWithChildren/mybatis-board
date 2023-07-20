DROP TABLE IF EXISTS `User`;

CREATE TABLE `User` (
                        `user_no`	int	NOT NULL AUTO_INCREMENT PRIMARY KEY,
                        `user_id`	varchar(50)	NOT NULL,
                        `user_pwd`	varchar(50)	NOT NULL,
                        `blocked`	tinyint(1)	NOT NULL	DEFAULT 0
);

DROP TABLE IF EXISTS `Board`;

CREATE TABLE `Board` (
                         `board_no`	int	NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         `user_no`	int	NOT NULL,
                         `user_id` varchar(255) NOT NULL,
                         `parent_board_no`	int	NULL,
                         `board_title`	VARCHAR(255)	NOT NULL,
                         `board_content`	TEXT	NOT NULL,
                         `created_at`	DATETIME	NOT NULL	DEFAULT now(),
                         `update_at`	DATETIME NULL,
                         `deleted_at`	DATETIME	NULL,
                         `deleted`	TINYINT(1)	NOT NULL	DEFAULT 0,
                         `board_depth`	INT	NULL
);

DROP TABLE IF EXISTS `Comment`;

CREATE TABLE `Comment` (
                           `comment_no`	int	NOT NULL AUTO_INCREMENT PRIMARY KEY,
                           `board_no`	int	NOT NULL,
                           `user_no`	int	NOT NULL,
                           `user_id` VARCHAR(255) NOT NULL,
                           `parent_comment_no`	int	NULL,
                           `comment_content`	varchar(500)	NOT NULL,
                           `comment_write_time`	DATETIME	NOT NULL	DEFAULT now(),
                           `comment_depth`	int	NULL,
                           `deleted`	TINYINT(1)	NOT NULL	DEFAULT 0
);

DROP TABLE IF EXISTS `Like`;

CREATE TABLE `Like` (
                        `user_no`	int	NOT NULL,
                        `board_no`	int	NOT NULL
);

DROP TABLE IF EXISTS `Dislike`;

CREATE TABLE `Dislike` (
                           `user_no`	int	NOT NULL,
                           `board_no`	int	NOT NULL
);

DROP TABLE IF EXISTS `Auth`;

CREATE TABLE `Auth`
(
    `auth_no`   int         NOT NULL primary key auto_increment,
    `auth_name` varchar(50) NOT NULL unique key
);

DROP TABLE IF EXISTS `User_Auth`;

CREATE TABLE `User_Auth`
(
    `auth_no` int NOT NULL,
    `user_no` int NOT NULL
);

ALTER TABLE bipa.`User_Auth`
    ADD PRIMARY KEY (
                     `auth_no`, `user_no`);

ALTER TABLE `User_Auth`
    ADD CONSTRAINT `FK_Auth_TO_User_Auth_1` FOREIGN KEY (
                                                         `auth_no`
        )
        REFERENCES `Auth` (
                           `auth_no`
            );

ALTER TABLE `User_Auth`
    ADD CONSTRAINT `FK_User_TO_User_Auth_1` FOREIGN KEY (
                                                         `user_no`
        )
        REFERENCES `User` (
                           `user_no`
            );

ALTER TABLE `User` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
                                                         `user_no`
    );

ALTER TABLE `Board` ADD CONSTRAINT `PK_BOARD` PRIMARY KEY (
                                                           `board_no`
    );

ALTER TABLE `Comment` ADD CONSTRAINT `PK_COMMENT` PRIMARY KEY (
                                                               `comment_no`
    );

ALTER TABLE `Like` ADD CONSTRAINT `PK_LIKE` PRIMARY KEY (
                                                         `user_no`,
                                                         `board_no`
    );

ALTER TABLE `Dislike` ADD CONSTRAINT `PK_DISLIKE` PRIMARY KEY (
                                                               `user_no`,
                                                               `board_no`
    );

ALTER TABLE `User_Auth` ADD CONSTRAINT `PK_USER_AUTH` PRIMARY KEY (
                                                                   `user_auth_no`
    );

ALTER TABLE `Board` ADD CONSTRAINT `FK_User_TO_Board_1` FOREIGN KEY (
                                                                     `user_no`
    )
    REFERENCES `User` (
                       `user_no`
        );

ALTER TABLE `Board` ADD CONSTRAINT `FK_Board_TO_Board_1` FOREIGN KEY (
                                                                      `parent_board_no`
    )
    REFERENCES `Board` (
                        `board_no`
        );

ALTER TABLE `Comment` ADD CONSTRAINT `FK_Board_TO_Comment_1` FOREIGN KEY (
                                                                          `board_no`
    )
    REFERENCES `Board` (
                        `board_no`
        );

ALTER TABLE `Comment` ADD CONSTRAINT `FK_User_TO_Comment_1` FOREIGN KEY (
                                                                         `user_no`
    )
    REFERENCES `User` (
                       `user_no`
        );

ALTER TABLE `Comment` ADD CONSTRAINT `FK_Comment_TO_Comment_1` FOREIGN KEY (
                                                                            `parent_comment_no`
    )
    REFERENCES `Comment` (
                          `comment_no`
        );

ALTER TABLE `Like` ADD CONSTRAINT `FK_User_TO_Like_1` FOREIGN KEY (
                                                                   `user_no`
    )
    REFERENCES `User` (
                       `user_no`
        );

ALTER TABLE `Like` ADD CONSTRAINT `FK_Board_TO_Like_1` FOREIGN KEY (
                                                                    `board_no`
    )
    REFERENCES `Board` (
                        `board_no`
        );

ALTER TABLE `Dislike` ADD CONSTRAINT `FK_User_TO_Dislike_1` FOREIGN KEY (
                                                                         `user_no`
    )
    REFERENCES `User` (
                       `user_no`
        );

ALTER TABLE `Dislike` ADD CONSTRAINT `FK_Board_TO_Dislike_1` FOREIGN KEY (
                                                                          `board_no`
    )
    REFERENCES `Board` (
                        `board_no`
        );

ALTER TABLE `User_Auth` ADD CONSTRAINT `FK_User_TO_User_Auth_1` FOREIGN KEY (
                                                                             `user_no`
    )
    REFERENCES `User` (
                       `user_no`
        );

DROP TABLE IF EXISTS `Upload_File`;

CREATE TABLE `Upload_File` (
                               `upload_file_no`	int	NOT NULL PRIMARY KEY AUTO_INCREMENT,
                               `board_no`	int	NOT NULL,
                               `origin_file_name`	VARCHAR(500)	NOT NULL,
                               `uuid_file_name`	VARCHAR(500)	NOT NULL,
                               `file_ extension`	VARCHAR(50)	NOT NULL
);

ALTER TABLE `Upload_File` ADD CONSTRAINT `FK_Board_TO_Upload_File_1` FOREIGN KEY (
                                                                                  `board_no`
    )
    REFERENCES `Board` (
                        `board_no`
        );
