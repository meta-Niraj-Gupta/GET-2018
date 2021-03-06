/*
Display Recent 50 Orders placed (Id, Order Date, Order Total).
*/

SELECT 
    po.order_id, DATE(PO.date), SUM(pod.price)
FROM
    product_order po
        JOIN
    order_detail pod ON po.order_id = pod.order_id
GROUP BY pod.order_id
ORDER BY po.date DESC
LIMIT 50;

/*
Display 10 most expensive Orders.
*/

SELECT 
    PO.order_id as Id, SUM(OT.price) as OrderTotal
FROM
    product_order PO
        JOIN
    order_detail OT ON PO.order_id = OT.order_id
GROUP BY Id
ORDER BY OrderTotal DESC
LIMIT 10;

/*
Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.
*/

SELECT 
    order_id
FROM
    product_order
WHERE
    order_id IN (SELECT 
        order_id
    FROM
        order_detail
    WHERE
        status <> 'shipped') AND DATEDIFF(Now(), date) > 10;

/*
Display list of shoppers which haven't ordered anything since last month.
*/

SELECT 
    user.user_id, name
FROM
    user
WHERE
    user_id NOT IN (SELECT 
        user_id
    FROM
        product_order
    WHERE
        DATEDIFF(Now(), product_order.date) > 30) AND user.type = 'S';

/*need attention
Display list of shopper along with orders placed by them in last 15 days. 
*/

SELECT 
    userId, id, order_item.order_id, product_id
FROM
    order_detail
        JOIN
    (SELECT 
        product_order.product_Id as order_id, date, userId
    FROM
        product_order
    JOIN address ON address.id = shipping_address_id) UserOrder ON order_item.order_id = UserOrder.order_id
WHERE
    DATEDIFF(Now(), order_time) < 15
Order BY userId;

/*
Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))
*/

SELECT
   detail_id, product_name
FROM
    order_detail JOIN product ON product.product_id = order_detail.product_id
WHERE
    order_id = 1 AND status = 'shipped';

/*
Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price
*/

SELECT 
     DISTINCT(Item.order_id), po.date
FROM
    order_detail Item
        JOIN
    product_order PO ON Item.order_id = PO.order_id
WHERE
    Item.price BETWEEN 100 AND 5000;

/*
Update first 20 Order items status to “Shipped” which are placed today
*/

UPDATE order_detail 
SET status = 'SHIPPED'
WHERE order_id IN (SELECT DISTINCT(order_id) FROM product_order WHERE DATE(date) = CURDATE())
LIMIT 20;
