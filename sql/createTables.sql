CREATE TABLE `sprint` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT,
 `title` varchar(100) NOT NULL,
 `start` date NOT NULL,
 `end` date NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8