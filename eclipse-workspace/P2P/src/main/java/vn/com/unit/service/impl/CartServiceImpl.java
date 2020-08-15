package vn.com.unit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.unit.entity.CartItem;
import vn.com.unit.repository.CartRepository;
import vn.com.unit.service.AccountService;
import vn.com.unit.service.CartService;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	AccountService accountService;
	
	@Autowired
	CartRepository cartRepository;

	@Override
	public List<CartItem> findAllCartItemByCurrentAccount() {

		Long curent_account_id = accountService.findCurrentAccount().getId();

		return this.findAllCartItemByAccountId(curent_account_id);
	}

	@Override
	public List<CartItem> findAllCartItemByAccountId(Long account_id) {
	
		return cartRepository.findAllCartItemByAccountId(account_id);
	}

}
