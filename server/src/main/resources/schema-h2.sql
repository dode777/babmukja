CREATE TABLE `user`
(
    `user_id`       BIGINT       NOT NULL AUTO_INCREMENT,
    `email`         VARCHAR(50)  NOT NULL,
    `name`          VARCHAR(10)  NOT NULL,
    `nickname`      VARCHAR(10)  NULL DEFAULT NULL,
    `picture`       VARCHAR(200) NOT NULL,
    `gender`        VARCHAR(10)  NOT NULL,
    `age_range`     VARCHAR(10)  NOT NULL,
    `role`          VARCHAR(10)  NOT NULL,
    `last_login_at` DATETIME     NULL DEFAULT NULL,
    `created_date`  DATETIME     NULL DEFAULT CURRENT_TIMESTAMP(),
    `updated_date`  DATETIME     NULL DEFAULT CURRENT_TIMESTAMP()
);

CREATE TABLE `post`
(
    `post_id`       BIGINT       NOT NULL AUTO_INCREMENT,
    `date`          DATETIME     NOT NULL,
    `gender`        VARCHAR(10)  NOT NULL,
    `age_range`     VARCHAR(10)  NULL     DEFAULT NULL,
    `personnel`     INT          NOT NULL,
    `title`         VARCHAR(50)  NOT NULL,
    `content`       VARCHAR(500) NOT NULL,
    `expired`       TINYINT(1)   NOT NULL DEFAULT 0,
    `user_id`       BIGINT       NOT NULL,
    `restaurant_id` BIGINT       NOT NULL,
    `created_date`  DATETIME     NULL     DEFAULT CURRENT_TIMESTAMP(),
    `updated_date`  DATETIME     NULL     DEFAULT CURRENT_TIMESTAMP()
);

CREATE TABLE `menu`
(
    `menu_id`      BIGINT      NOT NULL AUTO_INCREMENT,
    `menu_name`    VARCHAR(10) NOT NULL,
    `menu_count`   INT         NOT NULL,
    `created_date` DATETIME    NULL DEFAULT CURRENT_TIMESTAMP(),
    `updated_date` DATETIME    NULL DEFAULT CURRENT_TIMESTAMP()
);

CREATE TABLE `restaurant`
(
    `restaurant_id`   BIGINT      NOT NULL AUTO_INCREMENT,
    `restaurant_name` VARCHAR(20) NOT NULL,
    `latitude`        DECIMAL     NOT NULL,
    `longitude`       DECIMAL     NOT NULL,
    `menu_id`         BIGINT      NOT NULL,
    `created_date`    DATETIME    NULL DEFAULT CURRENT_TIMESTAMP(),
    `updated_date`    DATETIME    NULL DEFAULT CURRENT_TIMESTAMP()
);

CREATE TABLE `comment`
(
    `comment_id`      BIGINT       NOT NULL AUTO_INCREMENT,
    `content`         VARCHAR(500) NOT NULL,
    `user_id`         BIGINT       NOT NULL,
    `request_post_id` BIGINT       NOT NULL,
    `created_date`    DATETIME     NULL DEFAULT CURRENT_TIMESTAMP(),
    `updated_date`    DATETIME     NULL DEFAULT CURRENT_TIMESTAMP()
);

CREATE TABLE `participant`
(
    `participant_id`  BIGINT   NOT NULL AUTO_INCREMENT,
    `user_id`         BIGINT   NOT NULL,
    `request_post_id` BIGINT   NOT NULL,
    `created_date`    DATETIME NULL DEFAULT CURRENT_TIMESTAMP(),
    `updated_date`    DATETIME NULL DEFAULT CURRENT_TIMESTAMP()
);

CREATE TABLE `notice`
(
    `notice_id`    BIGINT       NOT NULL AUTO_INCREMENT,
    `content`      VARCHAR(500) NOT NULL,
    `created_date` DATETIME     NULL DEFAULT CURRENT_TIMESTAMP(),
    `updated_date` DATETIME     NULL DEFAULT CURRENT_TIMESTAMP()
);

CREATE TABLE `user_menu`
(
    `user_menu_id` BIGINT   NOT NULL AUTO_INCREMENT,
    `user_id`      BIGINT   NOT NULL,
    `menu_id2`     BIGINT   NOT NULL,
    `created_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP(),
    `updated_date` DATETIME NULL DEFAULT CURRENT_TIMESTAMP()
);

CREATE TABLE `area`
(
    `area_id`      BIGINT      NOT NULL AUTO_INCREMENT,
    `user_id`      BIGINT      NOT NULL,
    `area_name`    VARCHAR(50) NOT NULL,
    `created_date` DATETIME    NULL DEFAULT CURRENT_TIMESTAMP(),
    `updated_date` DATETIME    NULL DEFAULT CURRENT_TIMESTAMP()
);

CREATE TABLE `notification`
(
    `notification_id` BIGINT       NOT NULL AUTO_INCREMENT,
    `user_id`         BIGINT       NOT NULL,
    `token`           VARCHAR(200) NOT NULL,
    `created_date`    DATETIME     NULL DEFAULT CURRENT_TIMESTAMP(),
    `updated_date`    DATETIME     NULL DEFAULT CURRENT_TIMESTAMP()
);

ALTER TABLE `user`
    ADD CONSTRAINT `PK_USER` PRIMARY KEY (
                                          `user_id`
        );

ALTER TABLE `post`
    ADD CONSTRAINT `PK_POST` PRIMARY KEY (
                                          `post_id`
        );

ALTER TABLE `menu`
    ADD CONSTRAINT `PK_MENU` PRIMARY KEY (
                                          `menu_id`
        );

ALTER TABLE `restaurant`
    ADD CONSTRAINT `PK_RESTAURANT` PRIMARY KEY (
                                                `restaurant_id`
        );

ALTER TABLE `comment`
    ADD CONSTRAINT `PK_COMMENT` PRIMARY KEY (
                                             `comment_id`
        );

ALTER TABLE `participant`
    ADD CONSTRAINT `PK_PARTICIPANT` PRIMARY KEY (
                                                 `participant_id`,
                                                 `user_id`,
                                                 `request_post_id`
        );

ALTER TABLE `notice`
    ADD CONSTRAINT `PK_NOTICE` PRIMARY KEY (
                                            `notice_id`
        );

ALTER TABLE `user_menu`
    ADD CONSTRAINT `PK_USER_MENU` PRIMARY KEY (
                                               `user_menu_id`,
                                               `user_id`,
                                               `menu_id2`
        );

ALTER TABLE `area`
    ADD CONSTRAINT `PK_AREA` PRIMARY KEY (
                                          `area_id`,
                                          `user_id`
        );

ALTER TABLE `notification`
    ADD CONSTRAINT `PK_NOTIFICATION` PRIMARY KEY (
                                                  `notification_id`
        );

ALTER TABLE `participant`
    ADD CONSTRAINT `FK_user_TO_participant_1` FOREIGN KEY (
                                                           `user_id`
        )
        REFERENCES `user` (
                           `user_id`
            );

ALTER TABLE `participant`
    ADD CONSTRAINT `FK_post_TO_participant_1` FOREIGN KEY (
                                                           `request_post_id`
        )
        REFERENCES `post` (
                           `post_id`
            );

ALTER TABLE `user_menu`
    ADD CONSTRAINT `FK_user_TO_user_menu_1` FOREIGN KEY (
                                                         `user_id`
        )
        REFERENCES `user` (
                           `user_id`
            );

ALTER TABLE `user_menu`
    ADD CONSTRAINT `FK_menu_TO_user_menu_1` FOREIGN KEY (
                                                         `menu_id2`
        )
        REFERENCES `menu` (
                           `menu_id`
            );

ALTER TABLE `area`
    ADD CONSTRAINT `FK_user_TO_area_1` FOREIGN KEY (
                                                    `user_id`
        )
        REFERENCES `user` (
                           `user_id`
            );
