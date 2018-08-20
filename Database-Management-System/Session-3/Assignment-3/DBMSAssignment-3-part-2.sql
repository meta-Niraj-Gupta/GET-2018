/*
Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
*/

SELECT 
    product.product_id, product_name
FROM
    product
        JOIN
    (SELECT 
        pcr.product_id, COUNT(category_id) AS categoryCount
    FROM
        product_category_relation pcr
    GROUP BY product_id) pcc ON product.product_id = pcc.product_id
WHERE
    pcc.categoryCount > 1;
    

/*
Display Count of products as per below price range:

Range in Rs.    Count
0 - 100
101 - 500
Above 500
*/

SELECT 
    '0 - 1000' AS 'Range in Rs',
    COUNT(product_id) AS productCount
FROM
    product
WHERE
    price BETWEEN 0 AND 1000 
UNION 
SELECT 
    '1001 - 20000' AS 'Range in Rs',
    COUNT(product_id) AS productCount
FROM
    product
WHERE
    price BETWEEN 1001 AND 20000 
UNION 
SELECT 
    'Above 20000' AS 'Range in Rs',
    COUNT(product_id) AS productCount
FROM
    product
WHERE
    price > 20000;
    

/*
Display the Categories along with number of products under each category.
*/

SELECT 
    category_name, COUNT(product_id)
FROM
    product_category_relation JOIN category ON product_category_relation.category_id = category.category_id
GROUP BY category_name;