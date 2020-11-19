/*
1. Queries in MySQL Workbench.
*/
-- write "USE sakila;" at the very first line.
USE sakila;
-- SELECT everything from the "actor" table.
SELECT * FROM actor;
-- SELECT everything from the "actor" table where the last_name is "CAGE"
SELECT * FROM actor WHERE last_name = "CAGE";
-- SELECT everything from the "actor" table where the first_name is not "ZERO" and not "NICK"
SELECT * FROM actor WHERE first_name != "ZERO" and last_name != "NICK";
-- SELECT everything from the "actor" table where the first_name is "NICK", "JOHNNY", "JAMES", "MORGAN", or "WHOOPI" (hint: use the "IN" keyword)
SELECT * FROM actor WHERE first_name IN ("NICK","JOHNNY","JAMES","MORGAN","WHOOPI");
-- SELECT all rows from the "actor" table with an actor id ranging from 50 to 150;
SELECT * FROM actor WHERE actor_id BETWEEN 50 AND 150;
-- SELECT all rows from the "actor" table where first_name starts with the letter "C" (HINT: LIKE)
SELECT * FROM actor WHERE first_name LIKE "C%";
-- Select all rows from the "actor" table, ordered by first_name
SELECT * FROM actor ORDER BY first_name;
-- Select all rows from the "actor" table, ordered by last_name descending
SELECT * FROM actor ORDER BY last_name DESC;
-- Get the count of rows in the "actor" table.
SELECT COUNT(*) FROM actor;
-- Get the count of rows in the "actor" table with distinct first_name
SELECT COUNT(DISTINCT first_name) FROM actor;
-- SELECT all the horror films using the IN keyword.
SELECT * FROM film_category WHERE category_id IN (11);
-- SELECT all the horror films using the AS keyword.
SELECT * FROM film AS fi JOIN film_category AS fC ON fi.film_id = fC.film_id 
WHERE fC.category_id = 11;

/*
2. More queries
*/
-- INSERT a row in the "actor" table, with your own first and last name.
/*
INSERT INTO actor (first_name, last_name) VALUES ("YOUNES", "KARIM");
*/
-- INSERT 5 rows in the "film_actor" table, with the actor_id given to you, along with 5 film_id's of your choosing
/*
INSERT INTO film_actor (actor_id, film_id) VALUES (201, 111);
INSERT INTO film_actor (actor_id, film_id) VALUES (201, 222);
INSERT INTO film_actor (actor_id, film_id) VALUES (201, 333);
INSERT INTO film_actor (actor_id, film_id) VALUES (201, 444);
INSERT INTO film_actor (actor_id, film_id) VALUES (201, 555);
*/
-- UPDATE the first_name and last_name of the row containing your name, and set it to your newfound stage name.
/*
UPDATE actor SET first_name = "YONAUS", last_name ="ZORRO" WHERE actor_id = 201;
*/
-- Delete the row containing your data, and give up your acting career.
/*
DELETE FROM film_actor WHERE actor_id = 201;
DELETE FROM actor WHERE actor_id = 201;
*/

/*
3. JOINS
*/
-- SELECT all rows from the category table. Note what id is "Horror"
SELECT * FROM category;
-- SELECT all rows from the film table and join the film_category table on film_id.
-- Then join the category table on the category ID and add a where clause to retrieve only films with the horror category_id.
SELECT * FROM film
JOIN film_category ON film.film_id = film_category.film_id 
JOIN category ON category.category_id = film_category.category_id WHERE film_category.category_id = 11;