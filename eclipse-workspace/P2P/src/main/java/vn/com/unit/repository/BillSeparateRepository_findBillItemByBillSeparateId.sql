/****** Script for SelectTopNRows command from SSMS  ******/
SELECT 
	item.id 					as id,
	item.quantity 				as quantity,
	item.product 				as product,
	product.name 				as product_name,
	product.img 				as img,
	product.price 				as price,
	product.category 			as category,
	cate.name 					as category_name,
	product.brand 				as brand,
	brand.name 					as brand_name,
	(item.quantity*product.price) as item_bill_price

  FROM p2p_bill_item item 
  join p2p_product product on item.product=product.id
  join p2p_category cate on cate.id = product.category
  join p2p_brand brand on brand.id=product.brand
    join p2p_bill bill on bill.id=item.id

	where item.id=/*bill_separate_id*/ and  bill.account = /*account*/
	