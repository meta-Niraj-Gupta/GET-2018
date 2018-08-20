USE storefront;

/*
Adding email column into user table
*/

ALTER TABLE user
ADD COLUMN email VARCHAR(50) NOT NULL;

/*
Adding user_id column in product_order
*/

ALTER TABLE product_order
ADD COLUMN user_id INT NOT NULL;

/*
Making user_id in product_order as a foreign key
*/

ALTER TABLE product_order
ADD FOREIGN KEY(user_id) REFERENCES user(user_id);


/*
Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) with latest ordered items should be displayed first for last 60 days.
*/

CREATE VIEW order_information
AS
SELECT o.order_id AS 'Id', p.product_name as 'Title', p.price AS 'Price', 
      u.name as 'Shopper_Name', /*u.email as 'E-Mail',*/ o.date AS 'Order_Date', opr.status as 'Status'
FROM product_order AS o
LEFT JOIN order_detail AS opr ON o.order_id = opr.order_id
LEFT JOIN product AS p ON opr.product_id = p.product_id
LEFT JOIN user AS u ON o.user_id = u.user_id
WHERE o.date > DATE_SUB(CURDATE(), INTERVAL 60 DAY)
ORDER BY o.date DESC;


/*
Use the above view to display the Products(Items) which are in ‘shipped’ state.
*/

SELECT 
    Title
FROM
    order_information
WHERE
    Status = 'SHIPPED';

/*
Use the above view to display the top 5 most selling products.
*/
SELECT
    Title
FROM
    order_information
ORDER BY price DESC
LIMIT 5;