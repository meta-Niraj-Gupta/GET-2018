USE storefront;


-- Create a function to calculate number of orders in a month. Month and year will be input parameter to function
DROP FUNCTION IF EXISTS no_of_orders_in_month;
DROP FUNCTION IF EXISTS max_order_month;

DELIMITER |
CREATE FUNCTION no_of_orders_in_month(month INT, year INT) RETURNS INT 
    DETERMINISTIC
        BEGIN
            DECLARE order_count INT;
                    SELECT COUNT(*) INTO order_count FROM product_order
                    WHERE EXTRACT(MONTH FROM date) = month AND EXTRACT(YEAR FROM date) = year;
        RETURN order_count;
    END |
    
-- Calling function no_of_orders_in_month
SELECT no_of_orders_in_month(7, 2018);

-- Create a function to return month in a year having maximum orders. Year will be input parameter.

DELIMITER |
CREATE FUNCTION max_order_month(in_year INT) RETURNS INT 
    DETERMINISTIC
        BEGIN
            DECLARE max_order_month INT;
                    SELECT MONTH(date) INTO max_order_month
                    FROM product_order
                    WHERE YEAR(date) IN (in_year)
                    GROUP BY MONTH(date)
                    ORDER BY COUNT(*) DESC
                    LIMIT 1;
        RETURN max_order_month;
    END |


-- Calling function max_order_month
SELECT max_order_month(2018);
