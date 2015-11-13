/* CS585	HW2	queries.sql	Guangzhou Zeng	9143776451*/

--Q1:
SELECT strftime('%Y',dob) AS birthYear, COUNT(username) AS count
FROM Users
GROUP BY birthYear
HAVING birthYear>='1970'
ORDER BY birthYear; 


--Q2:
CREATE VIEW hourCount AS
	SELECT strftime('%H',post_date) as hour, COUNT(ad_id) as count
	FROM Ads
	GROUP BY hour
	ORDER BY count DESC;
	
SELECT hour, count
FROM hourCount
WHERE count=(SELECT count 
					FROM hourCount
					LIMIT 1);

DROP VIEW hourCount;



--Q3. How many ads were posted to category ‘250’ after user ‘lhartj’ logged out?
SELECT Ads.category_id, COUNT(ad_id) AS Count
FROM Ads
WHERE category_id='250'
	AND post_date>(SELECT last_logout
						FROM Users
						WHERE username='lhartj');

												
--Q4. What city has the largest number of regions?  NOTE: If tie, should display all.
CREATE VIEW city_count AS
	SELECT city_id, COUNT(city_id) as count
	FROM Regions
	GROUP BY city_id
	ORDER BY count DESC;

SELECT Cities.city_id, Cities.name, city_count.count AS RegionCount
FROM Cities INNER JOIN city_count ON Cities.city_id=city_count.city_id
WHERE city_count.count=(SELECT count FROM city_count LIMIT 1);

DROP VIEW city_count;


--Q5. What is the name of the user whose ad has been liked the most
CREATE VIEW ad_count AS
	SELECT ad_id, COUNT(ad_id) as count
	FROM Likes
	GROUP BY ad_id
	ORDER BY count DESC;

SELECT Users.name, Ads.ad_id, ad_count.count AS likeCount
FROM Ads INNER JOIN ad_count ON Ads.ad_id=ad_count.ad_id
		INNER JOIN Users ON Ads.creator=Users.username
WHERE Ads.ad_id=(SELECT ad_id
				   FROM ad_count
				   LIMIT 1);
				   
DROP VIEW ad_count;


--Q6. Mandy’sList popularity: What is the region where the largest  number of ads have been posted in?
CREATE VIEW region_count AS
	SELECT region_id, COUNT(region_id) AS count
	FROM Ads
	GROUP BY region_id
	ORDER BY count DESC;
	
SELECT Regions.region_id, Regions.name, region_count.count
FROM Regions INNER JOIN region_count ON Regions.region_id=region_count.region_id
WHERE Regions.region_id=(SELECT region_count.region_id FROM region_count LIMIT 1);

DROP VIEW region_count;



--Q7. Frequent posters: list top three users who have posted the largest number of times during 2015.
SELECT Users.name, Ads.creator,Count(Users.name) AS count
FROM Users INNER JOIN Ads ON Users.username=Ads.creator
WHERE strftime('%Y',Ads.post_date)='2015'
GROUP BY Users.name
ORDER BY count DESC
LIMIT 3;


--Q8. What is the title and price of the most recent ad created by user ‘bnguyen50’
SELECT creator, title, price, post_date
FROM Ads
WHERE creator='bnguyen50'
ORDER BY post_date DESC
LIMIT 1;
