/*
Updating order_id in product_order table
*/

UPDATE product_order
   SET user_id = CASE order_id
    WHEN 1 THEN 11
    WHEN 2 THEN 21
    WHEN 3 THEN 31
    WHEN 4 THEN 22
    WHEN 5 THEN 5
    WHEN 6 THEN 10
    WHEN 7 THEN 33
    WHEN 8 THEN 1
    WHEN 9 THEN 6
    WHEN 10 THEN 33
 END
 WHERE order_id BETWEEN 1 AND 10;
