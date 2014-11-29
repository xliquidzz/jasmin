CREATE TABLE `sprint` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT,
 `title` varchar(100) NOT NULL,
 `start` date NOT NULL,
 `end` date NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8

CREATE TABLE `team` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT,
 `name` varchar(100) NOT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8

CREATE TABLE `backlog_item` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT,
 `title` varchar(100) NOT NULL,
 `team_id` bigint(20) NOT NULL,
 `sprint_id` bigint(20) NOT NULL,
 PRIMARY KEY (`id`),
 KEY `team_id` (`team_id`),
 KEY `sprnt_id` (`sprnt_id`),
 CONSTRAINT `backlog_item_team` FOREIGN KEY (`team_id`) REFERENCES `team` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8