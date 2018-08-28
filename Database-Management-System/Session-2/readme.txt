SCHEMA USED FOR DBMS ASSIGNMENT-2 IS:

product( product_id [primary_key], product_name, price, stock, description, date_added, last_updated ) 

category( category_id [primary_key], category_name, parent_category )

address( address_id [primary_key], user_id [foreign_key], street, city, state, country, zip, phone )

order_detail( detail_id [primary_key], order_id [foreign_key], product_id [foreign_key], quantity, price, status, last_updated )

product_category_relation( category_id [foreign_key], product_id [foreign_key] )

product_image( image_id [primary_key], image_name, image_url, product_id [foreign_key] )

product_order( order_id [primary_key], address_id [foreign_key], date )

user( user_id [primary_key], name, type, registration_date)
