select P.id,P.shop,P.name,P.price,P.detail,P.img,P.disable,P.quantity,P.create_at,C.name category,B.name brand
FROM p2p_product P
INNER JOIN p2p_category C 
	ON P.category = C.id 
INNER JOIN p2p_brand B 
	ON P.brand = B.id
where shop = /*shop_id*/