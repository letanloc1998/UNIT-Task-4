package vn.com.unit.service;

import java.util.List;

import vn.com.unit.entity.CartItem;

public interface CartService {

	public List<CartItem> findAllCartItemByCurrentAccount();
	
	public List<CartItem> findAllCartItemByAccountId(Long account_id);

}
