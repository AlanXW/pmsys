/*
Navicat MySQL Data Transfer

Source Server         : team_10
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : pmsys

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2019-05-01 19:37:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for module
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `code` varchar(16) NOT NULL,
  `title` varchar(50) NOT NULL,
  `level` int(8) NOT NULL,
  `semester` varchar(50) NOT NULL,
  `coordinator` varchar(50) NOT NULL,
  `department` varchar(50) NOT NULL,
  `faculty` varchar(50) NOT NULL,
  `credit` int(8) NOT NULL,
  `assessment` varchar(255) NOT NULL,
  `dependency` varchar(255) DEFAULT NULL,
  `outcomes` varchar(255) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES ('COM1003', 'Java Programming', '1', 'Full Year', 'Dr Siobhán North', 'Computer Science', 'Computer Science', '20', 'Programming,Quiz', null, 'Object-Oriented Programming');
INSERT INTO `module` VALUES ('COM1005', 'Machines and Intelligence', '1', 'Full Year', 'Prof. Rob Gaizauskas', 'Computer Science', 'Computer Science', '20', 'Programming,Exam,Quiz', null, 'Applied Probability,Linear Algebra,Calculus');
INSERT INTO `module` VALUES ('COM1008', 'Web and Internet Technology', '1', 'Spring', 'Dr Emma Norling', 'Computer Science', 'Computer Science', '10', 'Programming,Quiz', null, 'Object-Oriented Programming,Web Development');
INSERT INTO `module` VALUES ('COM1009', 'Introduction to Algorithms and Data Structures', '1', 'Spring', 'Dr Dirk Sudholt', 'Computer Science', 'Computer Science', '10', 'Exam,Quiz', null, 'Data Structure,Algorithms');
INSERT INTO `module` VALUES ('COM2008', 'Systems Design and Security', '2', 'Autumn', 'Dr Anthony Simons', 'Computer Science', 'Computer Science', '20', 'Exam,Quiz,Report', null, 'Object-Oriented Programming,System Testing,Safe Verification');
INSERT INTO `module` VALUES ('COM2009', 'Human-Machine Interaction and Robotics', '2', 'Spring', 'Dr Michael Mangan', 'Computer Science', 'Computer Science', '20', 'Programming,Exam,Quiz', 'COM1005 Machines and Intelligence', 'Applied Probability,Linear Algebra,Calculus');
INSERT INTO `module` VALUES ('COM3110', 'Text Processing', '3', 'Autumn', 'Dr Mark Hepple', 'Computer Science', 'Computer Science', '10', 'Programming,Exam', 'COM1005 Machines and Intelligence', 'Cryptography');
INSERT INTO `module` VALUES ('COM3190', 'Theory of Distributed Systems', '3', 'Spring', 'Dr Ramsay Taylor', 'Computer Science', 'Computer Science', '10', 'Programming,Exam,Quiz', null, 'Distributed Development');
INSERT INTO `module` VALUES ('COM3502', 'Speech Processing', '3', 'Autumn', 'Prof. Roger Moore', 'Computer Science', 'Computer Science', '10', 'Programming,Report', 'COM1005 Machines and Intelligence', 'Phonetics');
INSERT INTO `module` VALUES ('COM3503', '3D Computer Graphics', '3', 'Autumn', 'Dr Steve Maddock', 'Computer Science', 'Computer Science', '10', 'Programming,Exam,Report', 'COM1003 Java Programming', 'Computer Graphics');
INSERT INTO `module` VALUES ('COM3504', 'The Intelligent Web', '3', 'Spring', 'Prof. Fabio Ciravegna', 'Computer Science', 'Computer Science', '10', 'Programming,Quiz', 'COM1008 Web and Internet Technology', 'Object-Oriented Programming,Web Development');
INSERT INTO `module` VALUES ('COM3527', 'Cybersecurity Team Project', '3', 'Autumn', 'Unknow', 'Computer Science', 'Computer Science', '10', 'Programming,Report,Presentation', 'COM1008 Web and Internet Technology,COM2008 Systems Design and Security', 'Project Management,Web Development,System Testing,Safe Verification');
INSERT INTO `module` VALUES ('COM4521', 'Parallel Computing with GPUs', '4', 'Spring', 'Dr Mozhgan Kabiri-Chimeh', 'Computer Science', 'Computer Science', '15', 'Programming,Quiz', 'COM3503 3D Computer Graphics', 'Parallel Computing,C Programming,Computer Graphics');

-- ----------------------------
-- Table structure for outcome
-- ----------------------------
DROP TABLE IF EXISTS `outcome`;
CREATE TABLE `outcome` (
  `id` varchar(32) NOT NULL DEFAULT '1',
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of outcome
-- ----------------------------
INSERT INTO `outcome` VALUES ('1cfa31ad6a3511e9a096b025aa28ec09', 'Parallel Computing');
INSERT INTO `outcome` VALUES ('1d6f847b68c711e9a096b025aa28ec09', 'Object-Oriented Programming');
INSERT INTO `outcome` VALUES ('2ef71d366a3611e9a096b025aa28ec09', 'Phonetics');
INSERT INTO `outcome` VALUES ('35a03cc46a3611e9a096b025aa28ec09', 'Data Structure');
INSERT INTO `outcome` VALUES ('570b90106a3511e9a096b025aa28ec09', 'Applied Probability');
INSERT INTO `outcome` VALUES ('674673656a3511e9a096b025aa28ec09', 'Linear Algebra');
INSERT INTO `outcome` VALUES ('6cae81e36a3511e9a096b025aa28ec09', 'C Programming');
INSERT INTO `outcome` VALUES ('732a10776a3611e9a096b025aa28ec09', 'Cryptography');
INSERT INTO `outcome` VALUES ('8cd0f82f6a3511e9a096b025aa28ec09', 'Project Management');
INSERT INTO `outcome` VALUES ('90f9be7c6a3611e9a096b025aa28ec09', 'Web Development');
INSERT INTO `outcome` VALUES ('9a152f346a3611e9a096b025aa28ec09', 'Distributed Development');
INSERT INTO `outcome` VALUES ('9b9e11bd6a3511e9a096b025aa28ec09', 'Calculus');
INSERT INTO `outcome` VALUES ('ccfe1dc66a3511e9a096b025aa28ec09', 'System Testing');
INSERT INTO `outcome` VALUES ('ce5b00ef6c3811e9a096b025aa28ec09', 'Algorithms');
INSERT INTO `outcome` VALUES ('dc849b726a3511e9a096b025aa28ec09', 'Safe Verification');
INSERT INTO `outcome` VALUES ('ed98ae876a3511e9a096b025aa28ec09', 'Computer Graphics');

-- ----------------------------
-- Table structure for programme
-- ----------------------------
DROP TABLE IF EXISTS `programme`;
CREATE TABLE `programme` (
  `id` varchar(32) NOT NULL DEFAULT '1',
  `title` varchar(50) NOT NULL,
  `proposer` varchar(255) NOT NULL,
  `level` int(16) NOT NULL,
  `type` varchar(16) NOT NULL,
  `admin` varchar(32) NOT NULL,
  `department` varchar(50) NOT NULL,
  `faculty` varchar(50) NOT NULL,
  `requirements` varchar(255) NOT NULL,
  `outcomes` varchar(5000) NOT NULL,
  `core_modules` varchar(5000) NOT NULL,
  `optional_modules` varchar(5000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of programme
-- ----------------------------
INSERT INTO `programme` VALUES ('4a97cd986c3e11e9a096b025aa28ec09', 'Computer Science', 'Unknow', '4', 'Bsc', 'Unknow', 'Computer Science', 'Computer Science', 'AAA', 'Parallel Computing,Object-Oriented Programming,Phonetics,Data Structure,Applied Probability,Linear Algebra,C Programming,Cryptography,Project Management,Web Development,Distributed Development,Calculus,System Testing,Algorithms,Safe Verification,Computer Graphics', 'COM1003 Java Programming,COM1005 Machines and Intelligence,COM1008 Web and Internet Technology,COM1009 Introduction to Algorithms and Data Structures,COM2008 Systems Design and Security,COM2009 Human-Machine Interaction and Robotics,COM4521 Parallel Computing with GPUs', 'COM3110 Text Processing,COM3190 Theory of Distributed Systems,COM3502 Speech Processing,COM3503 3D Computer Graphics,COM3504 The Intelligent Web,COM3527 Cybersecurity Team Project');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` varchar(32) NOT NULL DEFAULT '1',
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `surname` varchar(16) NOT NULL,
  `firstname` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('3bbbcccf401911e9b3f5b025aa28ec09', 'Robert', '123456', 'Chisholm', 'Robert');
INSERT INTO `staff` VALUES ('550abc5d6a3411e9a096b025aa28ec09', 'Xin', '123456', 'Wang', 'Xin');
INSERT INTO `staff` VALUES ('5976d7eb6a3311e9a096b025aa28ec09', 'David', '123456', 'Paterson', 'David');
INSERT INTO `staff` VALUES ('71012d626a3411e9a096b025aa28ec09', 'Yu-Chen', '123456', 'Hung', 'Yu-Chen');
INSERT INTO `staff` VALUES ('7e2a43de6a3411e9a096b025aa28ec09', 'Asad', '123456', 'Masood', 'Asad');
INSERT INTO `staff` VALUES ('7ffe59616a3311e9a096b025aa28ec09', 'Fariba', '123456', 'Yousefi', 'Fariba');
INSERT INTO `staff` VALUES ('84193a4e6a3411e9a096b025aa28ec09', 'Jing', '123456', 'Liu', 'Jing');
INSERT INTO `staff` VALUES ('b26b5efa6a3311e9a096b025aa28ec09', 'Mike', '123456', 'Stannett', 'Mike');
INSERT INTO `staff` VALUES ('d38e9bf56a3311e9a096b025aa28ec09', 'Ola', '123456', 'Olayinka', 'Ola');
INSERT INTO `staff` VALUES ('e2c66e036a3311e9a096b025aa28ec09', 'Lei', '123456', 'Zhao', 'Lei');
INSERT INTO `staff` VALUES ('eed73c676a3311e9a096b025aa28ec09', 'Sirui', '123456', 'Chen', 'Sirui');

-- ----------------------------
-- Table structure for transaction
-- ----------------------------
DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `staff` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `state` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transaction
-- ----------------------------
INSERT INTO `transaction` VALUES ('1', '2019-05-01', 'Xin', 'Xin add a module called Java Programming', 'successful');
INSERT INTO `transaction` VALUES ('2', '2019-05-01', 'Xin', 'Xin add a module called Machines and Intelligence', 'successful');
INSERT INTO `transaction` VALUES ('3', '2019-05-01', 'Xin', 'Xin add a module called Web and Internet Technology', 'successful');
INSERT INTO `transaction` VALUES ('4', '2019-05-01', 'Xin', 'Xin add a module called Introduction to Algorithms and Data Structures', 'successful');
INSERT INTO `transaction` VALUES ('5', '2019-05-01', 'Xin', 'Xin add a module called Human-Machine Interaction and Robotics', 'successful');
INSERT INTO `transaction` VALUES ('6', '2019-05-01', 'Xin', 'Xin add a module called Systems Design and Security', 'successful');
INSERT INTO `transaction` VALUES ('7', '2019-05-01', 'Xin', 'Xin add a module called Speech Processing', 'successful');
INSERT INTO `transaction` VALUES ('8', '2019-05-01', 'Xin', 'Xin add a module called 3D Computer Graphics', 'successful');
INSERT INTO `transaction` VALUES ('9', '2019-05-01', 'Xin', 'Xin add a module called Theory of Distributed Systems', 'successful');
INSERT INTO `transaction` VALUES ('10', '2019-05-01', 'Xin', 'Xin add a module called The Intelligent Web', 'successful');
INSERT INTO `transaction` VALUES ('11', '2019-05-01', 'Xin', 'Xin add a module called Parallel Computing with GPUs', 'successful');
INSERT INTO `transaction` VALUES ('12', '2019-05-01', 'Xin', 'Xin add a programme called Computer Science', 'successful');
DROP TRIGGER IF EXISTS `id_auto_outcome`;
DELIMITER ;;
CREATE TRIGGER `id_auto_outcome` BEFORE INSERT ON `outcome` FOR EACH ROW BEGIN
 if new.id = '1' THEN set new.id = (select REPLACE(uuid(), '-', ''));
 end if;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `id_auto_programme`;
DELIMITER ;;
CREATE TRIGGER `id_auto_programme` BEFORE INSERT ON `programme` FOR EACH ROW BEGIN
 if new.id = '1' THEN set new.id = (select REPLACE(uuid(), '-', ''));
 end if;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `id_auto_staff`;
DELIMITER ;;
CREATE TRIGGER `id_auto_staff` BEFORE INSERT ON `staff` FOR EACH ROW BEGIN
 if new.id = '1' THEN set new.id = (select REPLACE(uuid(), '-', ''));
 end if;
END
;;
DELIMITER ;
