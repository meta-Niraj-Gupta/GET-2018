/*
There is no need to create index in product and category relation as both 
the relation have primary key which are sufficient to uniquely identify 
a tuple so creating a new index on those table would make no sense
and it will create the copy of primary key.
*/


-- adding index to product_order_table

ALTER TABLE product_order ADD INDEX date_index (date);