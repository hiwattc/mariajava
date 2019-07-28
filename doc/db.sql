CREATE DATABASE `loadtest` /*!40100 DEFAULT CHARACTER SET utf8 */;


CREATE TABLE `TESTLOADTABLE` (
  `id` int(11) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


SELECT * 
  FROM loadtest.TESTLOADTABLE a
       left join loadtest.TESTLOADTABLE b on b.id = a.id
 where a.text like 'test9%';