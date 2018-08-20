use storefront;

/*Display Shopper’s information along with number of orders he/she placed during last 30 days.*/

SELECT 
    u.name,
    u.email,
    COUNT(o.order_id) AS 'Total Orders'
FROM
    user u
        INNER JOIN
    product_order o ON u.user_id = o.user_id
WHERE
    o.date > DATE_SUB(NOW(), INTERVAL 30 DAY)
GROUP BY o.user_id;

/*Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.*/

SELECT 
    u.name,
    u.email,
    SUM(p.price) as 'Total_Purchase'
FROM
    user u
        LEFT JOIN
    product_order po ON u.user_id = po.user_id
        LEFT JOIN
    order_detail pod ON po.order_id = pod.order_id
        LEFT JOIN
    product p ON pod.product_id = p.product_id
WHERE
    po.date > DATE_SUB(NOW(), INTERVAL 30 DAY)
GROUP BY u.user_id
ORDER BY 'Total_Purchase'
LIMIT 10;


/*Display top 20 Products which are ordered most in last 60 days along with numbers.*/

SELECT 
    p.product_name, COUNT(pod.product_id) AS 'Product_Count'
FROM
    product p
        INNER JOIN
    order_detail pod ON p.product_id = pod.product_id
        INNER JOIN
    product_order po ON pod.order_id = po.order_id
WHERE
    po.date > DATE_SUB(NOW(), INTERVAL 60 DAY)
GROUP BY p.product_id
ORDER BY 'Product_Count'
LIMIT 20;

/*Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.*/

SELECT 
    MONTHNAME(po.date) AS 'MONTH',
    SUM(pod.price) AS 'Total_Amount'
FROM    product_order po
        INNER JOIN
    order_detail pod ON pod.order_id = po.order_id
GROUP BY MONTH(po.date);

/*Mark the products as Inactive which are not ordered in last 90 days.*/

ALTER TABLE product 
ADD is_active tinyint(1) DEFAULT 1 after description;

UPDATE product p
LEFT JOIN order_detail pod ON p.product_id = pod.product_id
LEFT JOIN product_order po ON pod.order_id = po.order_id
SET p.is_active = 0
WHERE po.date < DATE_SUB(NOW(), INTERVAL 60 DAY)
AND p.product_id NOT IN
(Select product_id
FROM order_detail pod
LEFT JOIN product_order po ON pod.order_id = po.order_id
where po.date>=DATE_SUB(NOW(), INTERVAL 90 DAY));

/*Given a category search keyword, display all the Products present in this category.*/

SELECT 
   p.product_name
FROM
   product p
       INNER JOIN
   product_category_relation pcr ON p.product_id = pcr.product_id
       INNER JOIN
   category c ON  c.category_id = pcr.category_id 
where
   c.category_name LIKE 'Mobile';
   
/*Display top 10 Items which were cancelled most.*/

SELECT 
   p.product_name, count(pod.status) AS 'cancelled_count'
FROM
   product p
       INNER JOIN
   order_detail pod ON pod.product_id = p.product_id
WHERE
   pod.status = 'CANCELLED'
GROUP BY p.product_name
ORDER BY cancelled_count
LIMIT 10;