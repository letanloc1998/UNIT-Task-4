select *
from p2po_role
where id
in (select role
	from p2po_account_role
	where account = /*account_id*/)