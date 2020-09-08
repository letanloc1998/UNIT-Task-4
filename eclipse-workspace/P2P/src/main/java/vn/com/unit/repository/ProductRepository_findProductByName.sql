select *
from p2p_product
/*IF name != ''*/
where name like '%' + /*name*/ +'%'
/*END*/