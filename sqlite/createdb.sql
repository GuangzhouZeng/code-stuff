/* CS585	HW2	create.db.sql	Guangzhou Zeng	9143776451*/

CREATE TABLE "Users" (
	`username`	TEXT,
	`password`	TEXT NOT NULL,
	`name`	TEXT NOT NULL,
	`dob`	NUMERIC NOT NULL,
	`gender`	TEXT NOT NULL,
	`email`	TEXT NOT NULL,
	`last_logout`	NUMERIC,
	PRIMARY KEY(username)
);
INSERT INTO `Users` VALUES ('jcolemand','qvfJDJr6','Jacqueline Coleman','1988-07-22','Male','jcolemand@theglobeandmail.com','2015-01-28 01:31:49'),
 ('mholmesw','uhwnhKyi9Zsp','Martha Holmes','1975-05-14','Female','mholmesw@angelfire.com','2015-08-14 10:01:36'),
 ('dmartinezq','blWRcQUJZ','Doris Martinez','1985-01-03','Female','dmartinezq@about.com','2015-02-05 14:41:06'),
 ('mwashington2q','0Mg2jJPC','Maria Washington','1982-08-01','Male','mwashington2q@godaddy.com','2015-04-28 14:46:14'),
 ('drobinson7v','i4a8CGo5PS','Diana Robinson','2002-03-11','Female','drobinson7v@telegraph.co.uk','2015-04-04 08:09:26'),
 ('awilliams3t','qBMatx','Andrea Williams','1989-01-20','Male','awilliams3t@cornell.edu','2015-01-05 12:49:54'),
 ('bnguyen50','7Go0tfj2dGII','Brandon Nguyen','1978-03-10','Female','bnguyen50@dmoz.org','2015-07-31 17:42:46'),
 ('aadams29','3zS5Anw5I','Antonio Adams','2011-08-10','Male','aadams29@prlog.org','2015-07-12 09:09:08'),
 ('gferguson4m','pFOyMF8e801','Gloria Ferguson','1995-01-12','Female','gferguson4m@baidu.com','2015-05-15 17:06:32'),
 ('lruiz2y','x1wxIRi','Louis Ruiz','2011-03-30','Male','lruiz2y@google.it','2015-05-19 11:50:14'),
 ('cwarren3c','56nvB2g','Chris Warren','1967-11-23','Female','cwarren3c@qq.com','2015-05-11 02:59:43'),
 ('chernandez5i','CrBG3n3m','Catherine Hernandez','2010-09-03','Male','chernandez5i@artisteer.com','2015-04-10 21:30:15'),
 ('srose8a','abVx4OOfm28','Scott Rose','2004-05-26','Male','srose8a@mapquest.com','2015-07-27 13:24:49'),
 ('jhenderson7s','42KDQyOW','Joseph Henderson','1985-01-24','Female','jhenderson7s@sohu.com','2015-08-21 22:21:08'),
 ('amoore1p','sEOsokipzf','Antonio Moore','1998-07-16','Female','amoore1p@cnn.com','2015-04-14 12:29:39'),
 ('kcollins6w','IdF3FqA8a','Kathryn Collins','1980-04-07','Female','kcollins6w@zimbio.com','2014-12-07 13:20:11'),
 ('mmccoy6x','75OUMQjr','Marilyn Mccoy','2003-11-27','Male','mmccoy6x@ask.com','2015-02-12 22:00:38'),
 ('swebb59','QpDAHPDbzi1d','Sharon Webb','1986-02-07','Female','swebb59@reuters.com','2015-07-08 15:20:40'),
 ('epierce7f','0JQX6BKSay3v','Eugene Pierce','2003-10-08','Male','epierce7f@friendfeed.com','2015-05-03 05:30:22'),
 ('rcollins2j','0MrdDjSUai','Rose Collins','1971-09-20','Female','rcollins2j@msn.com','2015-08-02 15:32:54'),
 ('kporter26','5mhnTZHodR8','Kevin Porter','1985-07-27','Male','kporter26@forbes.com','2015-07-13 02:38:02'),
 ('bbishop71','o6NendM','Benjamin Bishop','2002-07-18','Male','bbishop71@edublogs.org','2015-03-14 12:30:22'),
 ('sburns7p','vL03Blb','Sandra Burns','1974-05-29','Female','sburns7p@1688.com','2015-05-05 19:23:41'),
 ('rray2n','rdNLjNmXx','Russell Ray','1981-12-21','Female','rray2n@house.gov','2015-04-24 02:24:38'),
 ('trivera5p','9N42677PJFu','Teresa Rivera','1982-10-19','Male','trivera5p@homestead.com','2015-07-23 23:05:46'),
 ('bmatthews1c','jTsGZU77','Barbara Matthews','2005-11-23','Female','bmatthews1c@netvibes.com','2015-02-16 22:07:38'),
 ('rknight4k','U7X1KYkcLxZR','Roy Knight','1985-03-02','Male','rknight4k@gmpg.org','2015-05-22 07:55:53'),
 ('bnguyen3n','M0Ur4gPBpaI','Brian Nguyen','1975-04-25','Female','bnguyen3n@shop-pro.jp','2015-04-09 18:51:19'),
 ('hpatterson1o','v1KDakid','Howard Patterson','1966-08-18','Female','hpatterson1o@mozilla.com','2015-08-12 04:49:49'),
 ('ccarra','Fy157WI','Craig Carr','1977-05-26','Female','ccarra@paypal.com','2015-05-16 18:00:31'),
 ('lkelley2m','yIXN8ChQ7LVL','Louise Kelley','1980-10-04','Male','lkelley2m@moonfruit.com','2015-08-29 17:25:25'),
 ('jperez3a','2EOupZm','Janice Perez','1969-10-21','Female','jperez3a@instagram.com','2015-03-26 21:06:36'),
 ('lhartj','IPSoQObQ8Bnf','Laura Hart','1982-04-08','Female','lhartj@biglobe.ne.jp','2015-01-12 20:47:05'),
 ('dstephens60','IQYGI2TD','Daniel Stephens','1966-09-25','Male','dstephens60@go.com','2015-04-01 10:08:21'),
 ('ahoward3f','6ZLbMg','Angela Howard','1998-04-06','Female','ahoward3f@prlog.org','2015-01-10 18:37:19'),
 ('sspencer42','PE0bS5H','Sharon Spencer','1975-03-06','Female','sspencer42@disqus.com','2014-10-03 14:45:39'),
 ('gcook2x','5HxYa1t5BB','Gary Cook','1981-12-20','Female','gcook2x@businesswire.com','2015-03-27 12:05:18'),
 ('bdaniels1g','qHP26hmIU','Brandon Daniels','2002-07-27','Female','bdaniels1g@altervista.org','2015-07-24 10:31:16'),
 ('bparker63','6f3A1znhdiI1','Bobby Parker','1999-01-29','Female','bparker63@webmd.com','2015-05-27 11:13:53'),
 ('hgarza4n','dtWZCIgF','Helen Garza','1996-03-29','Male','hgarza4n@cpanel.net','2014-11-09 15:38:58');
CREATE TABLE "Regions" (
	`region_id`	INTEGER,
	`name`	TEXT NOT NULL,
	`city_id`	INTEGER NOT NULL,
	PRIMARY KEY(region_id),
	FOREIGN KEY(`city_id`) REFERENCES Cities(city_id)
);
INSERT INTO `Regions` VALUES (11,'Downtown',64),
 (17,'West LA',5),
 (23,'East Omaha',67),
 (25,'Hazelwood',14),
 (27,'Downtown',54),
 (29,'Southeastern',81),
 (30,'Uptown',90),
 (31,'South Side',14),
 (32,'West End',64),
 (40,'University Park',62),
 (54,'Long Beach',5),
 (56,'Central/Eastern',81),
 (65,'Downtown',90),
 (67,'Viking',83),
 (94,'Stonybrook',95),
 (96,'Cana',83),
 (98,'West Topeka',95),
 (100,'Manhattan',2),
 (112,'Northwest',26),
 (124,'San Fernando Valley',5),
 (139,'North End',64),
 (149,'Central Dallas',99),
 (151,'East Dallas',99),
 (170,'South Omaha',67),
 (171,'Concord',10),
 (173,'North Side',89),
 (182,'Highland Square',62),
 (198,'United Northeast',10),
 (211,'Chapel Hill',62),
 (219,'West Side',89),
 (226,'West Omaha',67),
 (234,'Eastside',10),
 (235,'Downtown',10),
 (247,'North Side',81),
 (259,'Brooklyn',2),
 (298,'Lawrenceville',14),
 (299,'North Omaha',67),
 (301,'Staten Island',2),
 (306,'Downtown',89),
 (308,'Uptown',54),
 (318,'Southwest',26),
 (320,'Midtown',54),
 (321,'Antelope Valley',5),
 (326,'South End',64),
 (335,'Midtown',90),
 (340,'Queens',2),
 (360,'South Side',90),
 (361,'South Dallas',99),
 (366,'The Bronx',2),
 (367,'Northeast',26),
 (399,'South Side',89),
 (404,'Southwestern',81),
 (405,'Glenwood',95),
 (411,'Southeast',26),
 (420,'West End',14),
 (421,'United Northwest',10),
 (436,'Central LA',5),
 (464,'San Gabriel Valley',5),
 (467,'Sherwood Estates',95),
 (478,'North Side',14);
CREATE TABLE "Messages" (
	`msg_id`	INTEGER,
	`sender`	TEXT NOT NULL,
	`receiver`	TEXT NOT NULL,
	`topic`	TEXT NOT NULL,
	`body`	TEXT NOT NULL,
	PRIMARY KEY(msg_id),
	FOREIGN KEY(`sender`) REFERENCES Users ( username ),
	FOREIGN KEY(`receiver`) REFERENCES Users(username)
);
INSERT INTO `Messages` VALUES (51,'swebb59','epierce7f','rhoncus aliquet pulvinar sed nisl','Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.

Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi.'),
 (54,'hgarza4n','hpatterson1o','aliquet pulvinar','Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.

Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.'),
 (63,'cwarren3c','swebb59','a libero nam','Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.

Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.

Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.'),
 (130,'jperez3a','chernandez5i','est donec odio justo','Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.'),
 (135,'cwarren3c','srose8a','tempus vel pede morbi porttitor lorem','Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.

Phasellus in felis. Donec semper sapien a libero. Nam dui.'),
 (185,'swebb59','kcollins6w','nisl ut volutpat sapien arcu sed augue aliquam','Sed ante. Vivamus tortor. Duis mattis egestas metus.

Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.

Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.'),
 (231,'jcolemand','cwarren3c','metus vitae ipsum aliquam non mauris morbi','Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.

Sed ante. Vivamus tortor. Duis mattis egestas metus.'),
 (234,'bparker63','cwarren3c','nisl duis ac nibh fusce lacus purus','Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.

Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.'),
 (335,'jcolemand','bparker63','orci luctus','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus. Praesent lectus.

Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.'),
 (347,'hpatterson1o','sburns7p','sollicitudin mi sit amet','Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.'),
 (354,'ahoward3f','lkelley2m','sit amet','Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.

Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.'),
 (359,'gcook2x','amoore1p','curae mauris viverra diam','Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio.'),
 (424,'gferguson4m','mmccoy6x','cras non velit','Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.

Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.'),
 (482,'ahoward3f','swebb59','congue risus semper porta volutpat quam pede lobortis','Fusce consequat. Nulla nisl. Nunc nisl.

Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.

In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.'),
 (483,'lruiz2y','hpatterson1o','ipsum integer a nibh in quis justo','Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.

Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio.'),
 (489,'bmatthews1c','mwashington2q','dictumst maecenas ut massa','Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.

Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.

Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris.'),
 (571,'rcollins2j','gferguson4m','donec quis orci eget','Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.'),
 (623,'srose8a','bmatthews1c','ante ipsum primis in','Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.

In congue. Etiam justo. Etiam pretium iaculis justo.'),
 (646,'trivera5p','rcollins2j','ipsum dolor sit amet consectetuer adipiscing','Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.'),
 (651,'gferguson4m','srose8a','platea dictumst maecenas ut massa quis augue luctus','Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.

Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.'),
 (658,'gferguson4m','aadams29','pede ac diam cras pellentesque volutpat','Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.

Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.'),
 (751,'lkelley2m','rray2n','luctus tincidunt nulla mollis molestie lorem','Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.'),
 (791,'rcollins2j','swebb59','amet lobortis sapien sapien non mi','Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.

Sed ante. Vivamus tortor. Duis mattis egestas metus.'),
 (800,'srose8a','gcook2x','id sapien in sapien iaculis congue vivamus','Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.'),
 (846,'srose8a','bnguyen3n','tellus nisi eu','Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.

In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.

Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.'),
 (938,'mmccoy6x','ccarra','mi in porttitor pede justo eu massa','Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus.

Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.

Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.'),
 (1059,'jperez3a','rknight4k','purus phasellus in felis donec semper','Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.

Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum. Integer a nibh.'),
 (1079,'rknight4k','lhartj','dapibus augue vel accumsan tellus','Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.'),
 (1174,'hpatterson1o','kcollins6w','nam congue risus semper porta volutpat quam','Phasellus sit amet erat. Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.

Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.'),
 (1244,'jhenderson7s','chernandez5i','tincidunt nulla mollis molestie','Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.'),
 (1407,'hpatterson1o','gferguson4m','velit eu','Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.'),
 (1521,'kcollins6w','chernandez5i','accumsan odio curabitur convallis duis','Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.

Sed ante. Vivamus tortor. Duis mattis egestas metus.'),
 (1532,'gferguson4m','mwashington2q','donec semper sapien','Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.

Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.'),
 (1580,'epierce7f','bparker63','semper sapien a','In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.'),
 (1591,'rknight4k','drobinson7v','porttitor id','Fusce consequat. Nulla nisl. Nunc nisl.

Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.

In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.'),
 (1644,'hpatterson1o','epierce7f','pede malesuada','Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.

Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.

Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.'),
 (1717,'ahoward3f','gferguson4m','pulvinar lobortis est phasellus','Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.

In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.'),
 (1777,'trivera5p','bdaniels1g','suspendisse potenti cras in purus eu magna','Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.'),
 (1901,'jperez3a','rcollins2j','ac tellus semper interdum mauris ullamcorper purus sit','Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.

Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.'),
 (2033,'epierce7f','ccarra','posuere cubilia curae nulla dapibus dolor vel est','Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.');
CREATE TABLE "Likes" (
	`username`	TEXT,
	`ad_id`	INTEGER,
	PRIMARY KEY(username,ad_id),
	FOREIGN KEY(`username`) REFERENCES Users ( username ),
	FOREIGN KEY(`ad_id`) REFERENCES Ads(ad_id)
);
INSERT INTO `Likes` VALUES ('ahoward3f',1504),
 ('chernandez5i',932),
 ('jhenderson7s',1478),
 ('epierce7f',1378),
 ('ccarra',92),
 ('jperez3a',456),
 ('amoore1p',536),
 ('srose8a',1478),
 ('amoore1p',36),
 ('ccarra',286),
 ('dmartinezq',1199),
 ('aadams29',418),
 ('jcolemand',1608),
 ('sspencer42',2037),
 ('sburns7p',920),
 ('bmatthews1c',450),
 ('chernandez5i',1487),
 ('jcolemand',1885),
 ('bnguyen50',1199),
 ('lruiz2y',870),
 ('lhartj',1752),
 ('swebb59',1504),
 ('cwarren3c',1642),
 ('bmatthews1c',1100),
 ('ahoward3f',1199),
 ('lkelley2m',850),
 ('kcollins6w',1304),
 ('ahoward3f',1752),
 ('dmartinezq',1765),
 ('awilliams3t',1585),
 ('sburns7p',237),
 ('trivera5p',637),
 ('gcook2x',1478),
 ('drobinson7v',418),
 ('awilliams3t',1885),
 ('bnguyen3n',1608),
 ('cwarren3c',637),
 ('cwarren3c',716),
 ('lruiz2y',456),
 ('swebb59',1765),
 ('sburns7p',637),
 ('lruiz2y',1885),
 ('ccarra',850),
 ('mmccoy6x',920),
 ('hpatterson1o',2037),
 ('dmartinezq',1478),
 ('awilliams3t',135),
 ('mholmesw',1642),
 ('rray2n',1100),
 ('bdaniels1g',920);
CREATE TABLE "Follows" (
	`username`	TEXT,
	`category_id`	INTEGER,
	PRIMARY KEY(username,category_id),
	FOREIGN KEY(`username`) REFERENCES Users ( username ),
	FOREIGN KEY(`category_id`) REFERENCES Categories(category_id)
);
INSERT INTO `Follows` VALUES ('jhenderson7s',242),
 ('amoore1p',493),
 ('gferguson4m',497),
 ('rray2n',230),
 ('gcook2x',482),
 ('rray2n',250),
 ('dstephens60',261),
 ('ccarra',482),
 ('swebb59',277),
 ('hgarza4n',261),
 ('mmccoy6x',213),
 ('jperez3a',380),
 ('kcollins6w',120),
 ('rknight4k',63),
 ('rray2n',109),
 ('mmccoy6x',282),
 ('hpatterson1o',169),
 ('jperez3a',509),
 ('mmccoy6x',139),
 ('jhenderson7s',296),
 ('bparker63',139),
 ('bbishop71',509),
 ('ahoward3f',192),
 ('rray2n',170),
 ('aadams29',334),
 ('amoore1p',482),
 ('lhartj',109),
 ('aadams29',250),
 ('dstephens60',169),
 ('cwarren3c',89),
 ('sspencer42',465),
 ('epierce7f',261),
 ('bbishop71',243),
 ('hpatterson1o',334),
 ('gcook2x',465),
 ('hpatterson1o',230),
 ('jhenderson7s',277),
 ('aadams29',509),
 ('drobinson7v',139),
 ('mwashington2q',334),
 ('ahoward3f',272),
 ('gcook2x',243),
 ('ahoward3f',217),
 ('jcolemand',230),
 ('bnguyen50',192),
 ('chernandez5i',509),
 ('ccarra',192),
 ('lruiz2y',497),
 ('trivera5p',139),
 ('cwarren3c',282),
 ('swebb59',334),
 ('rknight4k',282),
 ('epierce7f',250),
 ('jcolemand',312),
 ('kporter26',170),
 ('lkelley2m',242),
 ('mholmesw',380),
 ('epierce7f',242),
 ('drobinson7v',243),
 ('hgarza4n',296),
 ('cwarren3c',493),
 ('awilliams3t',192),
 ('hgarza4n',497),
 ('lkelley2m',120),
 ('bdaniels1g',120),
 ('lhartj',272),
 ('dmartinezq',497),
 ('ahoward3f',89),
 ('mholmesw',230),
 ('swebb59',482),
 ('amoore1p',109),
 ('sspencer42',334),
 ('gcook2x',109),
 ('bbishop71',63),
 ('aadams29',282);
CREATE TABLE "Communities" (
	`community_id`	INTEGER,
	`name`	TEXT NOT NULL,
	`description`	TEXT NOT NULL,
	PRIMARY KEY(community_id)
);
INSERT INTO `Communities` VALUES (23,'nisl duis ac','Quisque ut erat.'),
 (47,'nisi volutpat eleifend donec','Maecenas pulvinar lobortis est.'),
 (49,'eu est congue elementum in','Mauris ullamcorper purus sit amet nulla. Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.'),
 (54,'tempus vel pede','Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.'),
 (55,'cubilia curae duis','Pellentesque at nulla.'),
 (59,'eget semper rutrum nulla','Nulla nisl.'),
 (70,'lobortis ligula sit','In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat.'),
 (81,'velit nec nisi vulputate','Morbi vel lectus in quam fringilla rhoncus.'),
 (85,'non sodales sed','Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi.'),
 (87,'suscipit a feugiat et eros','Etiam vel augue.'),
 (89,'lacinia sapien quis libero','Nunc purus. Phasellus in felis.'),
 (110,'nullam molestie nibh in','Proin risus.'),
 (113,'in leo maecenas pulvinar','Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.'),
 (133,'aenean sit amet justo morbi ut','Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc.'),
 (151,'habitasse platea ut','Duis at velit eu est congue elementum.'),
 (169,'fusce congue diam id ornare','Sed sagittis.'),
 (205,'ut at dolor','Duis consequat dui nec nisi volutpat eleifend.'),
 (216,'primis in faucibus et','In hac habitasse platea dictumst. Etiam faucibus cursus urna.'),
 (224,'eget eleifend luctus ultricies eu','Proin eu mi.'),
 (230,'at velit vivamus vel nulla','Nulla tellus. In sagittis dui vel nisl.');
CREATE TABLE "Cities" (
	`city_id`	INTEGER,
	`name`	TEXT NOT NULL,
	`state`	TEXT NOT NULL,
	`description`	TEXT NOT NULL,
	PRIMARY KEY(city_id)
);
INSERT INTO `Cities` VALUES (2,'New York City','NY','New York City is the most populous city in the United States and the center of the New York metropolitan area and one of the most populous urban agglomerations in the world'),
 (5,'Los Angeles','CA','Los Angeles is the second-largest city in the United States, the most populous city in the U.S. state of California, and the county seat of Los Angeles County.'),
 (10,'Indianapolis','IN','Indianapolis is the capital of the U.S. state of Indiana and the county seat of Marion County.'),
 (14,'Pittsburgh','PA','Pittsburgh is the second largest city in the Commonwealth of Pennsylvania with a population of 305,842 and the county seat of Allegheny County.'),
 (26,'Washington','DC','Washington, D.C., formally the District of Columbia is the capital of the United States.'),
 (54,'Oklahoma City','OK','Oklahoma City is the capital and largest city of the state of Oklahoma, ranking 27th among United States cities in population.'),
 (62,'Akron','OH','Akron is the fifth-largest city in the U.S. state of Ohio and is the seat of Summit County.'),
 (64,'New Bedford','MA','New Bedford is a city in Bristol County, Massachusetts, United States. It is the sixth-largest city in the state.'),
 (67,'Omaha','NE','Omaha is the largest city in the state of Nebraska, United States, and is the county seat of Douglas County.'),
 (81,'Sacramento','CA','Sacramento is the capital city of the U.S. state of California and the seat of government of Sacramento County.'),
 (83,'Fort Pierce','FL','Fort Pierce is a city in and the county seat of St. Lucie County, Florida, United States, and is also known as the Sunrise City.'),
 (89,'Miami','FL','Miami is a city located on the Atlantic coast in southeastern Florida and the county seat of Miami-Dade County.'),
 (90,'Houston','TX','Houston is the most populous city in Texas and the American South, and the fourth most populous city in the United States.'),
 (95,'Topeka','KS','Topeka is the capital city of the State of Kansas and the seat of Shawnee County.'),
 (99,'Dallas','TX','Dallas is a major city in Texas and is the largest urban center of the fourth most populous metropolitan area in the United States.');
CREATE TABLE "Categories" (
	`category_id`	INTEGER,
	`name`	TEXT NOT NULL,
	`community_id`	INTEGER NOT NULL,
	PRIMARY KEY(category_id),
	FOREIGN KEY(`community_id`) REFERENCES Communities(community_id)
);
INSERT INTO `Categories` VALUES (63,'computers',151),
 (89,'books',85),
 (109,'toys/games',87),
 (120,'housing swap',230),
 (139,'room for rent',89),
 (169,'parking',49),
 (170,'apt for rent',89),
 (192,'apartments',205),
 (213,'apartments',59),
 (216,'travel',169),
 (217,'shared rooms',113),
 (230,'electronics',54),
 (242,'books for sale',205),
 (243,'computers/electronics',85),
 (250,'books for sale',59),
 (260,'books for sale',81),
 (261,'furniture sale',70),
 (272,'car parts',216),
 (277,'computers',133),
 (282,'garage sale',70),
 (296,'computers/it',59),
 (312,'furniture sale',230),
 (334,'car for sale',110),
 (380,'car for sale',47),
 (450,'place for rent',81),
 (465,'tickets',110),
 (482,'cars',151),
 (493,'books for sale',133),
 (497,'car sharing',55),
 (509,'games',23);
CREATE TABLE "Ads" (
	`ad_id`	INTEGER,
	`creator`	TEXT NOT NULL,
	`title`	TEXT NOT NULL,
	`price`	REAL NOT NULL,
	`description`	TEXT NOT NULL,
	`post_date`	NUMERIC NOT NULL,
	`last_edited`	NUMERIC,
	`img_url`	TEXT,
	`category_id`	INTEGER NOT NULL,
	`region_id`	INTEGER NOT NULL,
	`status`	TEXT NOT NULL DEFAULT 'active',
	PRIMARY KEY(ad_id),
	FOREIGN KEY(`creator`) REFERENCES Users ( username ),
	FOREIGN KEY(`category_id`) REFERENCES Categories ( category_id ),
	FOREIGN KEY(`region_id`) REFERENCES Regions(region_id)
);
INSERT INTO `Ads` VALUES (36,'dmartinezq','cras mi pede malesuada in imperdiet et commodo vulputate justo',99.74,'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci.','2014-04-30 00:00:33','','',243,98,'expired'),
 (85,'bdaniels1g','magna at nunc commodo placerat praesent blandit',146.82,'Quisque ut erat. Curabitur gravida nisi at nibh.','2014-06-25 11:39:23','','',312,17,'expired'),
 (92,'lruiz2y','elementum nullam varius nulla facilisi cras',324.19,'Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est.','2014-07-12 20:28:19','','',192,306,'deleted'),
 (135,'jcolemand','magna vulputate luctus cum',486.77,'Morbi quis tortor id nulla ultrices aliquet.','2014-07-25 22:14:30','2014-07-25 22:14:33','http://s2.amazonaws.com/mjLeWYMCZlkTXS',465,478,'expired'),
 (176,'rknight4k','congue vivamus metus arcu adipiscing',198.97,'Nunc rhoncus dui vel sem.','2014-08-05 09:24:17','2014-08-05 09:24:18','',192,360,'expired'),
 (237,'drobinson7v','sagittis sapien cum sociis natoque penatibus et magnis dis parturient montes',317.85,'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante.','2014-08-18 00:34:22','2014-08-18 00:34:22','http://s6.amazonaws.com/sgWBNJVSwIRyPHi',192,170,'expired'),
 (286,'drobinson7v','id nisl venenatis lacinia aenean sit amet justo macbook ut odio',71.74,'Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.','2014-08-18 00:34:22','','http://s4.amazonaws.com/EKjTuPD',139,17,'expired'),
 (376,'bbishop71','elementum in hac habitasse platea dictumst macbook vestibulum velit id',53.82,'Proin at turpis a pede posuere nonummy.','2014-09-04 02:15:03','','http://s6.amazonaws.com/VOWMdyvQsf',482,171,'deleted'),
 (418,'jhenderson7s','vel sem sed sagittis nam congue risus semper',256.17,'Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum.','2014-09-04 16:02:03','','http://s3.amazonaws.com/lobhxyEdPaN',243,151,'expired'),
 (450,'bbishop71','dapibus duis at velit eu est',94.53,'Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante.','2014-09-20 01:54:23','2014-09-20 01:54:26','',465,411,'expired'),
 (456,'hgarza4n','nibh in hac habitasse platea',23.0,'Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.','2014-09-23 03:16:55','','',450,421,'deleted'),
 (536,'lkelley2m','odio donec vitae nisi nam ultrices libero non mattis',348.02,'Quisque ut erat. Curabitur gravida nisi at nibh.','2014-10-02 16:35:24','','',216,54,'expired'),
 (637,'rray2n','eu tincidunt in leo maecenas pulvinar lobortis est',253.57,'Curabitur convallis.','2014-10-07 09:07:44','','http://s5.amazonaws.com/minzjlHpCBNRoJ',250,420,'expired'),
 (716,'bnguyen50','sem mauris laoreet ut rhoncus aliquet pulvinar sed nisl nunc rhoncus',250.89,'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi.','2014-11-07 18:30:49','','http://s6.amazonaws.com/zvPmYVcCwJyrgu',213,27,'deleted'),
 (850,'kcollins6w','leo maecenas pulvinar pc lobortis est phasellus',53.78,'Praesent id massa id nisl venenatis lacinia.','2014-11-23 09:52:24','','http://s6.amazonaws.com/VhiFwQkBI',482,219,'expired'),
 (870,'ahoward3f','sem mauris laoreet ut pc',85.67,'Vestibulum sed magna at nunc commodo placerat.','2014-11-25 12:59:37','','',169,124,'expired'),
 (887,'ahoward3f','curabitur in libero ut pc',219.25,'Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.','2014-11-29 06:43:30','2014-11-29 06:43:34','',89,420,'expired'),
 (920,'lkelley2m','neque vestibulum eget vulputate ut ultrices vel augue',119.57,'Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo.','2014-12-02 06:30:38','','',260,306,'expired'),
 (932,'jhenderson7s','fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit',232.79,'Praesent id massa id nisl venenatis lacinia.','2014-12-30 03:36:51','','',509,478,'expired'),
 (1098,'mmccoy6x','fermentum donec ut pc mauris eget massa',287.87,'Phasellus in felis. Donec semper sapien a libero.','2015-01-03 22:58:32','2015-01-03 22:58:32','',89,259,'active'),
 (1100,'lruiz2y','quam pharetra magna ac',204.51,'Phasellus sit amet erat.','2015-01-11 19:58:42','','http://s3.amazonaws.com/gTwenDMu',250,367,'active'),
 (1199,'ahoward3f','et ultrices posuere cubilia macbook mauris viverra',70.2,'Nulla ac enim.','2015-01-18 07:31:41','','',465,17,'active'),
 (1296,'kporter26','non lectus aliquam sit amet diam in',103.43,'Cras in purus eu magna vulputate luctus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.','2015-01-24 00:15:15','2015-01-24 00:15:20','http://s7.amazonaws.com/aThFISN',277,17,'deleted'),
 (1300,'dstephens60','duis bibendum macbook non quam',336.69,'In quis justo.','2015-01-27 09:06:43','2015-01-27 09:06:47','http://s3.amazonaws.com/ECvsWgIXNDmaYhT',213,149,'active'),
 (1304,'aadams29','nulla suscipit ligula in lacus curabitur at ipsum ac tellus semper',9.9,'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem.','2015-02-26 00:00:17','2015-02-26 00:00:21','',250,67,'active'),
 (1370,'kporter26','libero non mattis pulvinar nulla pede ullamcorper',331.21,'Curabitur convallis.','2015-03-08 22:29:19','','',213,32,'active'),
 (1378,'gcook2x','in sagittis dui vel nisl',95.74,'In congue.','2015-03-15 01:40:45','','http://s1.amazonaws.com/NfvwoecLaQzY',63,96,'deleted'),
 (1463,'rknight4k','macbook non lectus aliquam sit amet diam in magna bibendum',140.45,'Vivamus vel nulla eget eros elementum pellentesque.','2015-03-16 02:06:49','','',63,170,'active'),
 (1478,'drobinson7v','tempor turpis nec macbook scelerisque quam turpis adipiscing lorem vitae',76.05,'Curabitur at ipsum ac tellus semper interdum.','2015-03-18 10:11:32','','http://s6.amazonaws.com/jwTVAxLEsc',482,361,'active'),
 (1487,'bnguyen50','at turpis donec posuere metus vitae ipsum aliquam',135.42,'Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum.','2015-03-23 19:44:30','','',509,478,'active'),
 (1504,'lhartj','integer ac leo pellentesque ultrices mattis odio donec vitae',48.76,'Duis mattis egestas metus.','2015-03-26 23:11:27','2015-03-26 23:11:29','',170,299,'active'),
 (1585,'cwarren3c','amet consectetuer adipiscing elit proin',397.37,'Duis ac nibh.','2015-03-30 00:34:01','','',120,478,'active'),
 (1608,'chernandez5i','tellus in sagittis dui vel nisl',460.83,'Praesent blandit.','2015-05-10 08:56:34','','http://s3.amazonaws.com/rKSONtZbwJv',250,298,'active'),
 (1642,'bnguyen50','ac lobortis vel dapibus at diam nam',143.87,'In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc.','2015-05-12 03:08:55','2015-05-12 03:08:58','',192,198,'active'),
 (1752,'gferguson4m','turpis integer aliquet massa id lobortis convallis',434.15,'Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum.','2015-06-04 23:17:27','2015-06-04 23:17:32','',89,54,'deleted'),
 (1758,'jhenderson7s','vestibulum ante ipsum primis in',6.66,'Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla.','2015-06-27 20:43:34','','http://s2.amazonaws.com/WILStsglUd',509,112,'active'),
 (1765,'bnguyen50','ipsum primis in faucibus orci luctus et',106.55,'Sed ante.','2015-07-17 21:40:39','','',63,298,'active'),
 (1885,'gcook2x','nunc nisl duis bibendum felis sed interdum venenatis turpis enim',488.28,'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat.','2015-07-27 22:29:30','','http://s5.amazonaws.com/DwNLiyR',217,335,'active'),
 (1960,'bbishop71','ut pc mauris eget massa tempor convallis nulla neque libero convallis',119.98,'Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.','2015-08-11 12:01:42','2015-08-11 12:01:46','',250,247,'active'),
 (2037,'amoore1p','macbook vestibulum velit id pretium iaculis diam erat fermentum justo nec',59.78,'In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.','2015-08-31 13:27:28','','http://s6.amazonaws.com/IhRzAcHQm',334,17,'active');

