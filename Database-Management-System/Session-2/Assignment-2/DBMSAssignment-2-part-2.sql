/*
Loading data into the tables
*/

/*
loading data into user table
*/

LOAD DATA LOCAL INFILE 'D:/DBMSAssignment/Data/user_details.tsv' INTO TABLE user(name, type, registration_date);

/*
loading data into address table
*/

LOAD DATA LOCAL INFILE 'D:/DBMSAssignment/Data/address_details.tsv' INTO TABLE address(user_id, street, city, state, country, zip, phone);

/*
loading data into category table
*/

LOAD DATA LOCAL INFILE 'D:/DBMSAssignment/Data/category_details.tsv' INTO TABLE category(category_id, category_name, parent_category);


/*
loading data into product table
*/

LOAD DATA LOCAL INFILE 'D:/DBMSAssignment/Data/product_details.tsv' INTO TABLE product(product_name, price, stock, description, date_added, last_updated);


/*
loading data into product category relation table
*/

LOAD DATA LOCAL INFILE 'D:/DBMSAssignment/Data/product_category_details.tsv' INTO TABLE product_category_relation(product_id, category_id);

/*
loading data into product image table
*/

LOAD DATA LOCAL INFILE 'D:/DBMSAssignment/Data/product_image_details.tsv' INTO TABLE product_image(image_name, image_url, product_id);

/*
loading data into product order table
*/

LOAD DATA LOCAL INFILE 'D:/DBMSAssignment/Data/product_order_details.tsv' INTO TABLE product_order(address_id, date);

/*
loading data into product order details table
*/

LOAD DATA LOCAL INFILE 'D:/DBMSAssignment/Data/order_details.tsv' INTO TABLE order_detail(order_id, price, status, last_updated, product_id, quantity);


/*
Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top.
*/

SELECT 
    P.product_id as ID,
    P.product_name as Title,
    Cat.category_name as CategoryTitle,
    P.price as Price
FROM
    product P
        JOIN
    (Select 
        PCR.product_id, PCR.category_id, PC.category_name
    from
        product_category_relation PCR
    Join category PC ON PCR.category_id = PC.category_id) Cat ON P.product_id = Cat.product_id
WHERE
    P.stock > 0
ORDER BY last_updated DESC;


/*
Display the list of products which don't have any images.
*/

SELECT 
    p.product_id, p.product_name
FROM
    product p
WHERE
    p.product_id NOT IN (SELECT 
        product_id
    from
        product_image);
        
/*
Display all Id, Title and Parent Category Title for all the Categories listed, 
sorted by Parent Category Title and then Category Title. (If Category is top category 
then Parent Category Title column should display “Top Category” as value.)
*/

SELECT 
    a.category_id AS ID,
    a.category_name AS 'Parent Category',
    b.category_name AS 'Category Title'
FROM
    category a
        INNER JOIN
    category b ON a.category_id = b.parent_category
ORDER BY a.category_name,b.category_name;

/*
Display Id, Title, Parent Category Title of all the leaf Categories 
(categories which are not parent of any other category)
*/

SELECT 
    a.category_id AS ID,
    a.category_name As Title,
    b.category_name As Parent
FROM
    category a
        LEFT JOIN
    category b ON a.parent_category = b.category_id
WHERE
    a.parent_category != 0;
    
/*need attention
Display Product Title, Price & Description which falls 
into particular category Title (i.e. “Mobile”) 
*/

SELECT 
    product.product_name,
    product.product_id,
    product.description
FROM
    product
        LEFT JOIN
    category ON Product.Product_id = category.category_id
        LEFT JOIN
    product_category_relation ON product_category_relation.Category_id = product_category_relation.Category_id
WHERE
    Category.Category_name = 'MOBILE';

/*
Display the list of Products whose Quantity on hand (Inventory) is under 50
*/

SELECT 
    product_name AS Product
FROM
    product
where
    stock < 50;
    
/*
Increase the Inventory of all the products by 100
*/
UPDATE product SET stock = stock + 100;