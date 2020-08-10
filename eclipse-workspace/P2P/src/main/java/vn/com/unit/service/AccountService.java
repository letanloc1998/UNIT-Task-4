package vn.com.unit.service;

import vn.com.unit.entity.Account;

public interface AccountService {
	
	public Account findByUsername(String username);
	
	public void updateAccountPassword(Long id, String password);
	
	public boolean checkLogin(Account account, String rawPassword);
}
