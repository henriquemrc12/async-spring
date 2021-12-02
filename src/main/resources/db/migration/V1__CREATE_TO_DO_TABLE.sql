CREATE TABLE IF NOT EXISTS `TB_TASKS` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `description` VARCHAR(100) NULL,
    `task_status` VARCHAR(10) NOT NULL,
    `end_date` DATE NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;