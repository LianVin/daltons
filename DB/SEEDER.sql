USE DALTONS;

INSERT INTO `daltons`.`role` (`ROLE_ID`, `ROLE`) VALUES ('1', 'Admin');
INSERT INTO `daltons`.`role` (`ROLE_ID`, `ROLE`) VALUES ('2', 'User');

INSERT INTO `daltons`.`user` (`USER_ID`, `USERNAME`, `FIRST_NAME`, `LAST_NAME`, `EMAIL`, `PASSWORD`, `ROLE_ID`) VALUES ('1', 'Lesmo', 'Lian', 'Vinkovic', 'lian@vinkovic.ch', 'testpw', '1');
INSERT INTO `daltons`.`user` (`USER_ID`, `USERNAME`, `FIRST_NAME`, `LAST_NAME`, `EMAIL`, `PASSWORD`, `ROLE_ID`) VALUES ('2', 'golden Stink', 'Leo', 'Stucki', 'leo.stucki@hotmail.com', '12345', '2');
INSERT INTO `daltons`.`user` (`USER_ID`, `USERNAME`, `FIRST_NAME`, `LAST_NAME`, `EMAIL`, `PASSWORD`, `ROLE_ID`) VALUES ('3', 'Sommer', 'Yann', 'Sommer', 'yan@legend.com', 'undelinks', '1');

INSERT INTO `daltons`.`post` (`POST_ID`, `TITLE`, `TEXT`, `IS_CONCERT`, `USER_ID`) VALUES ('1', 'TITLE NUMERO 1', 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.', true, '1');
INSERT INTO `daltons`.`post` (`POST_ID`, `TITLE`, `TEXT`, `IS_CONCERT`, `USER_ID`) VALUES ('2', 'TITLE NUMERO 2', 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.', true, '1');
INSERT INTO `daltons`.`post` (`POST_ID`, `TITLE`, `TEXT`, `IS_CONCERT`, `USER_ID`) VALUES ('3', 'TITLE NUMERO 3', 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.', false, '3');
INSERT INTO `daltons`.`post` (`POST_ID`, `TITLE`, `TEXT`, `IS_CONCERT`, `USER_ID`) VALUES ('4', 'TITLE NUMERO 4','Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.', false, '3');
INSERT INTO `daltons`.`post` (`POST_ID`, `TITLE`, `TEXT`, `IS_CONCERT`, `USER_ID`) VALUES ('5', 'TITEL NUMERO 5', 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.', true, '3');
INSERT INTO `daltons`.`post` (`POST_ID`, `TITLE`, `TEXT`, `IS_CONCERT`, `USER_ID`) VALUES ('6', 'TITEL NUMERO 6', 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.', false, '3');

INSERT INTO `daltons`.`picture` (`PICTURE_ID`, `URL`, `POST_ID`) VALUES ('1', '1/picture1', '1');
INSERT INTO `daltons`.`picture` (`PICTURE_ID`, `URL`, `POST_ID`) VALUES ('2', '1/picture2', '1');
INSERT INTO `daltons`.`picture` (`PICTURE_ID`, `URL`, `POST_ID`) VALUES ('3', '1/picture3', '1');
INSERT INTO `daltons`.`picture` (`PICTURE_ID`, `URL`, `POST_ID`) VALUES ('4', '2/picture1', '2');
INSERT INTO `daltons`.`picture` (`PICTURE_ID`, `URL`, `POST_ID`) VALUES ('5', '2/picture', '2');
INSERT INTO `daltons`.`picture` (`PICTURE_ID`, `URL`, `POST_ID`) VALUES ('6', '4/picture1', '4');
INSERT INTO `daltons`.`picture` (`PICTURE_ID`, `URL`, `POST_ID`) VALUES ('7', '4/picture2', '4');
INSERT INTO `daltons`.`picture` (`PICTURE_ID`, `URL`, `POST_ID`) VALUES ('8', '6/picture1', '6');

INSERT INTO `daltons`.`comment` (`COMMENT_ID`, `TEXT`, `POST_ID`, `USER_ID`) VALUES ('1', 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et', '1', '1');
INSERT INTO `daltons`.`comment` (`COMMENT_ID`, `TEXT`, `POST_ID`, `USER_ID`) VALUES ('2', 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et', '1', '1');
INSERT INTO `daltons`.`comment` (`COMMENT_ID`, `TEXT`, `POST_ID`, `USER_ID`) VALUES ('3', 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et', '1', '2');
INSERT INTO `daltons`.`comment` (`COMMENT_ID`, `TEXT`, `POST_ID`, `USER_ID`) VALUES ('4', 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et', '3', '2');
INSERT INTO `daltons`.`comment` (`COMMENT_ID`, `TEXT`, `POST_ID`, `USER_ID`) VALUES ('5', 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et', '5', '2');
INSERT INTO `daltons`.`comment` (`COMMENT_ID`, `TEXT`, `POST_ID`, `USER_ID`) VALUES ('6', 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et', '5', '3');
INSERT INTO `daltons`.`comment` (`COMMENT_ID`, `TEXT`, `POST_ID`, `USER_ID`) VALUES ('7', 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et', '5', '3');
INSERT INTO `daltons`.`comment` (`COMMENT_ID`, `TEXT`, `POST_ID`, `USER_ID`) VALUES ('8', 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et', '5', '3');
INSERT INTO `daltons`.`comment` (`COMMENT_ID`, `TEXT`, `POST_ID`, `USER_ID`) VALUES ('9', 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et', '6', '3');
INSERT INTO `daltons`.`comment` (`COMMENT_ID`, `TEXT`, `POST_ID`, `USER_ID`) VALUES ('10', 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et', '6', '3');
